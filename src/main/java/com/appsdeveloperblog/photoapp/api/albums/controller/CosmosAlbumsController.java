/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.photoapp.api.albums.controller;

import com.appsdeveloperblog.photoapp.api.albums.cosmos.entity.AlbumDocument;
import com.appsdeveloperblog.photoapp.api.albums.service.CosmosAlbumsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cosmos")
@ConditionalOnProperty(prefix = "azure.cosmos",name = "enabled")
public class CosmosAlbumsController {
    @Autowired
    CosmosAlbumsService cosmosAlbumsService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/albums")
    public AlbumDocument addAlbum(@RequestBody AlbumDocument album) {
        return cosmosAlbumsService.saveAlbumDocs(album);
    }

    @GetMapping("/albums")
    public Iterable<AlbumDocument> getAlbums() {
        return cosmosAlbumsService.getAlbums();
    }

}
