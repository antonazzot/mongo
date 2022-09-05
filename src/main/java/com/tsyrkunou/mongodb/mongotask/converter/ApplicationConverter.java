package com.tsyrkunou.mongodb.mongotask.converter;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.tsyrkunou.mongodb.mongotask.model.Task;
import com.tsyrkunou.mongodb.mongotask.model.dto.CreateTaskRequest;
import com.tsyrkunou.mongodb.mongotask.model.dto.UpdateTaskRequest;

@Mapper(componentModel = "spring")
public interface ApplicationConverter {
    Task convert (CreateTaskRequest createTaskRequest);
    Task convert (UpdateTaskRequest updateTaskRequest, @MappingTarget Task taskForUpdate);
}
