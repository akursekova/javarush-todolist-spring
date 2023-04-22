package dev.akursekova.todolist.dto;

import dev.akursekova.todolist.domain.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
    private String description;
    private Status status;
}
