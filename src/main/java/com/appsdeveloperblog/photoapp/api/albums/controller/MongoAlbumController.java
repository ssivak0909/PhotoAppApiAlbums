package com.appsdeveloperblog.photoapp.api.albums.controller;

import com.appsdeveloperblog.photoapp.api.albums.mongo.entity.AlbumMongo;
import com.appsdeveloperblog.photoapp.api.albums.service.MongoAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mongo")
public class MongoAlbumController {

    @Autowired
    MongoAlbumService mongoAlbumService;

    @PostMapping("/albums")
    public Mono<AlbumMongo> addAlbum(@RequestBody AlbumMongo album) {
        return mongoAlbumService.saveAlbumDocs(album);
    }

    @GetMapping("/albums")
    public Flux<AlbumMongo> getAlbums() {
        return mongoAlbumService.getAlbums();
       // return Flux.range(1, 5).map(i -> AlbumMongo.builder().name("album " + i).build());
    }

    @GetMapping("/albums/{id}")
    public Mono<AlbumMongo> getAlbumById(@PathVariable String id) {
        return mongoAlbumService.getAlbum(id);
        // return Mono.just(AlbumMongo.builder().name("album " + id).build());
    }
}
