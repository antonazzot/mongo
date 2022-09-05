package com.tsyrkunou.mongodb.mongotask.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.tsyrkunou.mongodb.mongotask.model.CassandraLogEntity;

public interface LogCassandraRepo extends CrudRepository<CassandraLogEntity, UUID> {
}
