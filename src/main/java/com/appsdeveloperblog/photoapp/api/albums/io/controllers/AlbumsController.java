/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.photoapp.api.albums.io.controllers;

import com.appsdeveloperblog.photoapp.api.albums.data.AlbumEntity;
import com.appsdeveloperblog.photoapp.api.albums.repo.AlbumRepository;
import com.appsdeveloperblog.photoapp.api.albums.service.AlbumsService;
import com.appsdeveloperblog.photoapp.api.albums.ui.model.AlbumResponseModel;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/users")
public class AlbumsController {

    @Value("${env}")
    private String env;

    @GetMapping("/env")
    public String displayEnvVal() {
        return String.format("you are on %s environment", env);
    }

    @GetMapping("/ping/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return String.format("Hi %s, Good morning", name);
    }

    @GetMapping("/server/arth")
    public String throwErrorResponse() {
        return "will throw 500 error" + 10 / 0;
    }

    @GetMapping("/server/runtime")
    public String getRunTimeException() {
        throw new RuntimeException("my own runtime exception");
    }

    @Autowired
    AlbumsService albumsService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AlbumRepository albumRepository;

    @PostMapping("/albums")
    public AlbumEntity addAlbum(@RequestBody AlbumEntity album) {
        return albumRepository.save(album);
    }

    @GetMapping("/albums")
    public List<AlbumEntity> getAlbums() {
        return albumRepository.findAll();
    }

    @GetMapping(value = "/{id}/albums",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    public List<AlbumResponseModel> userAlbums(@PathVariable String id) {

        List<AlbumResponseModel> returnValue = new ArrayList<>();

        //  List<AlbumEntity> albumsEntities = albumsService.getAlbums(id);
        List<AlbumEntity> albumsEntities = albumRepository.findByUserId(id);

        if (albumsEntities == null || albumsEntities.isEmpty()) {
            return returnValue;
        }

        Type listType = new TypeToken<List<AlbumResponseModel>>() {
        }.getType();

        returnValue = new ModelMapper().map(albumsEntities, listType);
        logger.info("Returning " + returnValue.size() + " albums");
        return returnValue;
    }
}
