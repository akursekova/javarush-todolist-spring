package dev.akursekova.todolist.service;

import dev.akursekova.todolist.dao.TaskDao;
import dev.akursekova.todolist.domain.Status;
import dev.akursekova.todolist.domain.Task;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class TaskService {
    private final TaskDao taskDao;

    public TaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public List<Task> getAll(int offset, int limit) {
        //offset - это сколько мы пропускаем, limit - сколько отображаем.
        // Например, рещультат выдал 100 строк, я хочу видеть вторые 10 результатов.
        // Значит, offset = 10, limit = 10
        return taskDao.getAll(offset, limit);
    }

    public int getAllCount() {
        return taskDao.getAllCount();
    }

    public Task getById(int id) {
        return taskDao.getById(id);
    }

    @Transactional
    //todo controller advise to handle exception
    //ставим тут Transactional, потому что перед тем как изменить задачу нам нужно ее найти,
    // проверить что она не null, после этого отредактировать ее и сохранить.
    // Это должно пройти единой транзакией
    public Task edit(int id, String description, Status status) {
        Task task = getById(id);
        if (isNull(task)) {
            throw new RuntimeException("Task not found");
        }
        task.setDescription(description);
        task.setStatus(status);
        taskDao.saveOrUpdate(task);
        return task;
    }

    public Task create(String description, Status status) {
        Task task = new Task();
        task.setDescription(description);
        task.setStatus(status);
        taskDao.saveOrUpdate(task);
        return task;
    }

    @Transactional
    public void delete(int id) {
        Task task = getById(id);
        if (isNull(task)) {
            throw new RuntimeException("Task not found");
        } else {
            taskDao.delete(task);
        }
    }
}
