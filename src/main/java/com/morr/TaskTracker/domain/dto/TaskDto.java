package com.morr.TaskTracker.domain.dto;

import com.morr.TaskTracker.domain.entities.TaskPriority;
import com.morr.TaskTracker.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status

) {
}
