package com.tsyrkunou.mongodb.mongotask.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

import com.tsyrkunou.mongodb.mongotask.model.Category;
import com.tsyrkunou.mongodb.mongotask.model.SubTask;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTaskRequest {
    private Instant deadline;
    private String name;
    private String description;
    private List<SubTask> subTasks;
    private Category category;
}
