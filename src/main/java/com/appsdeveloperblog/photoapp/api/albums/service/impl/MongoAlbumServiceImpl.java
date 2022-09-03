/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.photoapp.api.albums.service.impl;

import com.appsdeveloperblog.photoapp.api.albums.mongo.entity.AlbumMongo;
import com.appsdeveloperblog.photoapp.api.albums.mongo.repository.MongoAlbumRepository;
import com.appsdeveloperblog.photoapp.api.albums.service.MongoAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class MongoAlbumServiceImpl implements MongoAlbumService {

    @Autowired
    MongoAlbumRepository albumRepository;

    @Override
    public Flux<AlbumMongo> getAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public Mono<AlbumMongo> getAlbum(String id) {
        return albumRepository.findById(id);
    }

    @Override
    public Mono<AlbumMongo> saveAlbumDocs(AlbumMongo albumMongo) {
        UUID uuid = UUID.randomUUID();
        albumMongo.setId(uuid.toString());
        return albumRepository.save(albumMongo);
    }

}
