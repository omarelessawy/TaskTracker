package com.morr.TaskTracker.mappers;

import com.morr.TaskTracker.domain.dto.TaskListDto;
import com.morr.TaskTracker.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList tasklist);

}
