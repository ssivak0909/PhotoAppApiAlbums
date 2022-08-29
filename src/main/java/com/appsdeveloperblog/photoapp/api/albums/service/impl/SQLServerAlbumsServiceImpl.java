/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.photoapp.api.albums.service.impl;

import com.appsdeveloperblog.photoapp.api.albums.entity.AlbumEntity;
import com.appsdeveloperblog.photoapp.api.albums.repo.SQLServerAlbumsRepository;
import com.appsdeveloperblog.photoapp.api.albums.service.SQLServerAlbumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConditionalOnProperty(prefix = "azure.sqlserver",name = "enabled")
public class SQLServerAlbumsServiceImpl implements SQLServerAlbumsService {

    @Autowired
    SQLServerAlbumsRepository albumsRepository;

    @Override
    public List<AlbumEntity> getAlbums() {
        return albumsRepository.findAll();
    }

    @Override
    public AlbumEntity saveAlbumDocs(AlbumEntity album) {
        return albumsRepository.save(album);
    }

}
