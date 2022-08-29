/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.photoapp.api.albums.controller;

import com.appsdeveloperblog.photoapp.api.albums.entity.AlbumEntity;
import com.appsdeveloperblog.photoapp.api.albums.service.SQLServerAlbumsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sqlserver")
@ConditionalOnProperty(prefix = "azure.sqlserver",name = "enabled")
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
