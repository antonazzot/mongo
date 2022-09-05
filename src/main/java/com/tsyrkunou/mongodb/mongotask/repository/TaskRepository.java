package com.tsyrkunou.mongodb.mongotask.repository;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tsyrkunou.mongodb.mongotask.model.Category;
import com.tsyrkunou.mongodb.mongotask.model.Task;

public interface TaskRepository extends MongoRepository <Task, String> {

    @Query("{ 'deadline' : { $gt: ?0, $lt: ?1 } }")
    List<Task> findOverdue(ZonedDateTime dateFrom, ZonedDateTime dateTo);

    List<Task> findTaskByCategory(@Param("category") Category category);

    List<Task> findAllBy(TextCriteria criteria);
}
