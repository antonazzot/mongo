package com.tsyrkunou.mongodb.mongotask.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class CassandraLogEntity {
    @PrimaryKey
    private UUID id;

    private String logInfo;
}
