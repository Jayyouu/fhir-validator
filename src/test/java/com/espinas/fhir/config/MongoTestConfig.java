package com.espinas.fhir.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@TestConfiguration
@EnableMongoAuditing
public class MongoTestConfig {
}
