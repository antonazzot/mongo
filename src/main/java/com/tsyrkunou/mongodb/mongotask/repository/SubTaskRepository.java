package com.tsyrkunou.mongodb.mongotask.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.tsyrkunou.mongodb.mongotask.model.SubTask;
import com.tsyrkunou.mongodb.mongotask.model.Task;

public interface SubTaskRepository extends MongoRepository <SubTask, String> {
    List<SubTask> findAllBy(TextCriteria criteria);
}
