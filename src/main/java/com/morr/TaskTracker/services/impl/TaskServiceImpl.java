package com.morr.TaskTracker.services.impl;

import com.morr.TaskTracker.domain.entities.Task;
import com.morr.TaskTracker.domain.entities.TaskList;
import com.morr.TaskTracker.domain.entities.TaskPriority;
import com.morr.TaskTracker.domain.entities.TaskStatus;
import com.morr.TaskTracker.repositories.TaskListRepository;
import com.morr.TaskTracker.repositories.TaskRepository;
import com.morr.TaskTracker.services.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    public TaskServiceImpl(TaskRepository taskRepository, TaskListRepository taskListRepository) {
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<Task> listTasks(UUID taskListId) {
        return taskRepository.findByTaskListId(taskListId);
    }

    @Override
    public Task createTask(UUID taskListId, Task task) {
        if(null != task.getId()){
            throw new IllegalArgumentException("Task already has an ID");
        }
        if(null == task.getTitle() || task.getTitle().isBlank()) {
            throw new IllegalArgumentException("Task title have a title!");
        }
        TaskPriority taskPriority = Optional.ofNullable(task.getPriority())
                .orElse(TaskPriority.MEDIUM);
        TaskStatus taskStatus = TaskStatus.OPEN;

        TaskList taskList = taskListRepository.findById(taskListId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Task List ID Provided"));

        LocalDateTime now = LocalDateTime.now();

        Task taskToSave = new Task(
                null,
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                taskStatus,
                taskPriority,
                taskList,
                now,
                now
        );

        return taskRepository.save(taskToSave);
    }

    @Override
    public Optional<Task> getTask(UUID taskListId, UUID taskId) {
        if(!taskRepository.existsById(taskId)){
            throw new IllegalArgumentException("There is no task with this ID!");
        }
        return taskRepository.findByTaskListIdAndId(taskListId , taskId);
    }

    @Override
    public Task updateTask(UUID taskListId, UUID taskId, Task task) {
        if(null == task.getId()) {
            throw new IllegalArgumentException("Task must have an ID");
        }
        if(!Objects.equals(task.getId(), taskId)){
            throw new IllegalArgumentException("Task IDs do not match");
        }
        if(null == task.getPriority()) {
            throw new IllegalArgumentException("Task must have a valid priority");
        }
        if(null == task.getStatus()) {
            throw new IllegalArgumentException("Task must have a valid status");
        }

        Task existingTask = taskRepository.findByTaskListIdAndId(taskListId, taskId)
                        .orElseThrow(() -> new IllegalArgumentException("Task not found"));

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setDueDate(task.getDueDate());
        existingTask.setPriority(task.getPriority());
        existingTask.setStatus(task.getStatus());

       return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(UUID taskListId, UUID taskId) {
        if(!taskRepository.existsById(taskId)){
            throw new IllegalArgumentException("ID does not exist!");
        }
        taskRepository.deleteById(taskId);
    }

}
