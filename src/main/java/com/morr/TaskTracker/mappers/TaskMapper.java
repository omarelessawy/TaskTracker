package com.morr.TaskTracker.mappers;

import com.morr.TaskTracker.domain.dto.TaskDto;
import com.morr.TaskTracker.domain.entities.Task;

public interface TaskMapper {

  Task fromDto(TaskDto taskDto);

  TaskDto toDto(Task task);
}
