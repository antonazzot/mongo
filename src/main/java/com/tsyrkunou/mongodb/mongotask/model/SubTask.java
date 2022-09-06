package com.tsyrkunou.mongodb.mongotask.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

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
@Document(collection = "subtask")
public class SubTask {
    @Id
    private String id;
    @TextIndexed
    private String name;
    private String description;
    @DocumentReference(lazy=true)
    private Task task;
}
