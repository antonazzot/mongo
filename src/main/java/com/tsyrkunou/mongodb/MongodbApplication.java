package com.tsyrkunou.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.tsyrkunou.mongodb.mongotask.repository.LogCassandraRepo;

@EnableAutoConfiguration
@EnableCassandraRepositories(basePackageClasses= LogCassandraRepo.class)
@SpringBootApplication
public class MongodbApplication {
	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}
}
