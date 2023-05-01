package dev.akursekova.todolist.integration;

import dev.akursekova.todolist.config.AppConfig;
import dev.akursekova.todolist.config.WebConfig;
import dev.akursekova.todolist.domain.Status;
import dev.akursekova.todolist.domain.Task;
import dev.akursekova.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@IT
@RequiredArgsConstructor
public class TaskServiceIT {

    private final TaskService taskService;

    @Test
    void should_save_task() {

        Task expected = taskService.create( "test descr", Status.IN_PROGRESS);
        assertNotNull(expected);
    }
}
