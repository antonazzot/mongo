package com.tsyrkunou.mongodb.mongotask.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "task")
public class Task {
    @Id
    private String id;
    @CreatedDate
    private Instant createdAt;
    private Instant deadline;
    private String name;
    @TextIndexed
    private String description;
    @DBRef(lazy = true)
    private List<SubTask> subTasks;
    private Category category;
}
