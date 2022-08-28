/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.photoapp.api.albums.io.controllers;

import com.appsdeveloperblog.photoapp.api.albums.entity.AlbumEntity;
import com.appsdeveloperblog.photoapp.api.albums.repo.SQLServerAlbumsRepository;
import com.appsdeveloperblog.photoapp.api.albums.service.GeneralAlbumsService;
import com.appsdeveloperblog.photoapp.api.albums.service.SQLServerAlbumsService;
import com.appsdeveloperblog.photoapp.api.albums.ui.model.AlbumResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users/sql")
public class SQLServerAlbumsController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SQLServerAlbumsService sqlServerAlbumsService;

    @PostMapping("/albums")
    public AlbumEntity addAlbum(@RequestBody AlbumEntity album) {
        return sqlServerAlbumsService.saveAlbumDocs(album);
    }

    @GetMapping("/albums")
    public List<AlbumEntity> getAlbums() {
        return sqlServerAlbumsService.getAlbums();
    }

}
