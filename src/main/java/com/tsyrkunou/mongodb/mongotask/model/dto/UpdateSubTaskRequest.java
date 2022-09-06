package com.tsyrkunou.mongodb.mongotask.model.dto;

import java.time.Instant;

import com.tsyrkunou.mongodb.mongotask.model.Category;

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
public class UpdateSubTaskRequest {
    private String name;
    private String description;
}
