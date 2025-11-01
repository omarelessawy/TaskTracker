package com.morr.TaskTracker.mappers.impl;

import com.morr.TaskTracker.domain.dto.TaskListDto;
import com.morr.TaskTracker.domain.entities.Task;
import com.morr.TaskTracker.domain.entities.TaskList;
import com.morr.TaskTracker.domain.entities.TaskStatus;
import com.morr.TaskTracker.mappers.TaskListMapper;
import com.morr.TaskTracker.mappers.TaskMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component 
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        return new TaskList(
                taskListDto.id(),
                taskListDto.title(),
                taskListDto.description(),
                Optional.ofNullable(taskListDto.tasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::fromDto)
                                .toList()
                        ).orElse(null),
                null,
                null
        );
    }

    @Override
    public TaskListDto toDto(TaskList tasklist) {
        return new TaskListDto(
                tasklist.getId(),
                tasklist.getTitle(),
                tasklist.getDescription(),
                Optional.ofNullable(tasklist.getTasks())
                        .map(List::size)
                        .orElse(0),
                calculateTaskListProgress(tasklist.getTasks()),
                Optional.ofNullable(tasklist.getTasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::toDto)
                                .toList()
                        ).orElse(null)

                
        );
    }

    private Double calculateTaskListProgress(List<Task> tasks) {
        if(null == tasks) {
            return null;
        }
        long closedTaskCount = tasks.stream().filter(task ->
                TaskStatus.CLOSED == task.getStatus()
        ).count();

        return (double) closedTaskCount / tasks.size();
    }
}