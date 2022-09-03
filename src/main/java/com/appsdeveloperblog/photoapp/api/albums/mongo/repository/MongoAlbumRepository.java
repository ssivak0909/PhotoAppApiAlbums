package com.appsdeveloperblog.photoapp.api.albums.mongo.repository;

import com.appsdeveloperblog.photoapp.api.albums.mongo.entity.AlbumMongo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoAlbumRepository extends ReactiveMongoRepository<AlbumMongo, String> {
}
