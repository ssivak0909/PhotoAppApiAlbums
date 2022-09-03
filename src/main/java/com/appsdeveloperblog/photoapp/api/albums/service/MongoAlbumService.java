/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.photoapp.api.albums.service;


import com.appsdeveloperblog.photoapp.api.albums.mongo.entity.AlbumMongo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MongoAlbumService {
    Flux<AlbumMongo> getAlbums();

    Mono<AlbumMongo> getAlbum(String id);

    Mono<AlbumMongo> saveAlbumDocs(AlbumMongo album);
}
