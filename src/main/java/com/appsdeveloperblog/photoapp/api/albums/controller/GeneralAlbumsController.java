/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.photoapp.api.albums.controller;

import com.appsdeveloperblog.photoapp.api.albums.entity.AlbumEntity;
import com.appsdeveloperblog.photoapp.api.albums.service.GeneralAlbumsService;
import com.appsdeveloperblog.photoapp.api.albums.ui.model.AlbumResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class GeneralAlbumsController {
    @Value("${env}")
    private String env;

    @Autowired
    GeneralAlbumsService generalAlbumsService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/{id}/albums",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    public List<AlbumResponseModel> userAlbums(@PathVariable String id) {

        List<AlbumResponseModel> returnValue = new ArrayList<>();

        List<AlbumEntity> albumsEntities = generalAlbumsService.getAlbums(id);

        if (albumsEntities == null || albumsEntities.isEmpty()) {
            return returnValue;
        }

        Type listType = new TypeToken<List<AlbumResponseModel>>() {
        }.getType();

        returnValue = new ModelMapper().map(albumsEntities, listType);
        logger.info("Returning " + returnValue.size() + " albums");
        return returnValue;
    }


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

}
