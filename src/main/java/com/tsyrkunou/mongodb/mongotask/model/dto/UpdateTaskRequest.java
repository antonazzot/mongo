package com.tsyrkunou.mongodb.mongotask.model.dto;

import java.time.Instant;
import java.util.List;

import com.tsyrkunou.mongodb.mongotask.model.Category;
import com.tsyrkunou.mongodb.mongotask.model.SubTask;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTaskRequest {
    private Instant deadline;
    private String name;
    private String description;
    private Category category;
}
