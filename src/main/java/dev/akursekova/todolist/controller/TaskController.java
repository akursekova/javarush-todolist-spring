package dev.akursekova.todolist.controller;

import dev.akursekova.todolist.domain.Task;
import dev.akursekova.todolist.dto.TaskDto;
import dev.akursekova.todolist.service.TaskService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@Controller
@RequestMapping("/")
public class TaskController {
    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    //в model складываем параметры, чтобы отобразить их во view
    //возвращаем String - название нашей view
    //возвращать List<Task> - это рестовый стиль
    public String tasks(Model model,
                            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
        List<Task> tasks = taskService.getAll((page - 1) * limit, limit);
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/{id}")
    //на сервисном уровне мы валидируем данные
    public String edit(Model model,
                     @PathVariable Integer id,
                     @RequestBody TaskDto taskDto) {
        if (isNull(id) || id <= 0) {
            throw new RuntimeException("Invalid id");
        }
        Task task = taskService.edit(id, taskDto.getDescription(), taskDto.getStatus());
        return tasks(model, 1, 10);
    }

    @PostMapping("/")
    public String add(Model model,
                    @RequestBody TaskDto taskDto){
        taskService.create(taskDto.getDescription(), taskDto.getStatus());
        return tasks(model, 1, 10);
    }

    @DeleteMapping("/{id}")
    public String delete(Model model, @PathVariable Integer id) {
        if (isNull(id) || id <= 0) {
            throw new RuntimeException("Invalid id");
        }
        taskService.delete(id);
        return tasks(model, 1, 10);
    }
}
