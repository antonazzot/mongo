package com.tsyrkunou.mongodb.mongotask.controller;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsyrkunou.mongodb.mongotask.converter.ApplicationConverter;
import com.tsyrkunou.mongodb.mongotask.model.CassandraLogEntity;
import com.tsyrkunou.mongodb.mongotask.model.Category;
import com.tsyrkunou.mongodb.mongotask.model.SubTask;
import com.tsyrkunou.mongodb.mongotask.model.Task;
import com.tsyrkunou.mongodb.mongotask.model.dto.CreateSubTaskRequest;
import com.tsyrkunou.mongodb.mongotask.model.dto.CreateTaskRequest;
import com.tsyrkunou.mongodb.mongotask.model.dto.OverdueParam;
import com.tsyrkunou.mongodb.mongotask.model.dto.UpdateTaskRequest;
import com.tsyrkunou.mongodb.mongotask.repository.LogCassandraRepo;
import com.tsyrkunou.mongodb.mongotask.repository.SubTaskRepository;
import com.tsyrkunou.mongodb.mongotask.repository.TaskRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/task")
@Slf4j
@RequiredArgsConstructor
public class TaskController {
    private final ApplicationConverter applicationConverter;
    private final TaskRepository taskRepository;
    private final SubTaskRepository subTaskRepository;
    private final LogCassandraRepo logCassandraRepo;

    @PostMapping("/create")
    public Task createTask(@RequestBody CreateTaskRequest createTaskRequest) {
        Task task = applicationConverter.convert(createTaskRequest);
        logCassandraRepo.save(CassandraLogEntity.builder().logInfo(task.getDescription()).build());
        return taskRepository.save(task);
    }

    @PutMapping("/update/{taskId}")
    public Task createTask(@PathVariable String taskId, @RequestBody UpdateTaskRequest updateTaskRequest) {
        Task taskForUpdate = taskRepository.findById(taskId).orElseThrow();
        Task task = applicationConverter.convert(updateTaskRequest, taskForUpdate);
        logCassandraRepo.save(CassandraLogEntity.builder().logInfo(task.getDescription()).build());
        return taskRepository.save(task);
    }

    @GetMapping("/get/{taskId}")
    public Task createTask(@PathVariable String taskId) {
        return taskRepository.findById(taskId).orElseThrow();
    }

    @GetMapping("/getoverdue")
    public List<Task> createTask(@RequestBody OverdueParam overdueParam) {
        return taskRepository.findOverdue(overdueParam.getDateFrom(), overdueParam.getDateTo());
    }

    @GetMapping("/getall")
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @GetMapping("/getByType")
    public List<Task> getByType(@RequestParam Category category) {
        return taskRepository.findTaskByCategory(category);
    }

    @GetMapping("/getByDescription")
    public List<Task> getByDescription(@RequestParam String descr) {
        TextCriteria criteria = TextCriteria.forDefaultLanguage()
                .matchingAny(descr);
        return taskRepository.findAllBy(criteria);
    }

    @DeleteMapping("/delete/{taskId}")
    public void deleteTask(@PathVariable String taskId) {
        taskRepository.deleteById(taskId);
    }

    @PostMapping("/add")
    public SubTask createSubTask(@RequestBody CreateSubTaskRequest createSubTaskRequest) {
        String subTaskId;
        if (createSubTaskRequest != null) {
            SubTask subTask = subTaskRepository.save(SubTask.builder()
                    .description(createSubTaskRequest.getDescription())
                    .name(createSubTaskRequest.getName())
                    .build());
            subTaskId = subTask.getId();
            if (createSubTaskRequest.getId() != null) {
                taskRepository.findById(createSubTaskRequest.getId()).ifPresent(
                        task -> {
                            task.getSubTasks().add(subTask);
                            taskRepository.save(task);
                        }
                );
            }
            return subTaskRepository.findById(subTaskId).orElseThrow();
        }
        return null;
    }

    @GetMapping("/getTask")
    public Task getTask(@RequestParam String id) {
        return taskRepository.findById(id).orElseThrow();
    }

    @GetMapping("/getSubTaskByTaskId")
    public List<SubTask> getSubTask(@RequestParam String id) {
        Task task = taskRepository.findById(id).orElseThrow();
        return task.getSubTasks();
    }

}
