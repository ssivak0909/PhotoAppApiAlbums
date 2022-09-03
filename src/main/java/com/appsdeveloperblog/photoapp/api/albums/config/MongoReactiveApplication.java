package com.appsdeveloperblog.photoapp.api.albums.config;

import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoReactiveAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = {"com.appsdeveloperblog.photoapp.api.albums.mongo.repository"})
@Import({MongoReactiveAutoConfiguration.class, MongoAutoConfiguration.class})
public class MongoReactiveApplication {
//
//    @Bean
//    public MongoClient mongoClient() {
//        return MongoClients.create();
//    }
//
//    @Override
//    protected String getDatabaseName() {
//        return "reactive";
//    }

}