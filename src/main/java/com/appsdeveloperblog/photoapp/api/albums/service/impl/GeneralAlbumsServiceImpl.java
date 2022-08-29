/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.photoapp.api.albums.service.impl;

import com.appsdeveloperblog.photoapp.api.albums.cosmos.repository.AlbumDocumentRepository;
import com.appsdeveloperblog.photoapp.api.albums.entity.AlbumEntity;
import com.appsdeveloperblog.photoapp.api.albums.service.GeneralAlbumsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeneralAlbumsServiceImpl implements GeneralAlbumsService {

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<AlbumEntity> getAlbums(String userId) {
        List<AlbumEntity> returnValue = new ArrayList<>();

        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setUserId(userId);
        albumEntity.setAlbumId("album1Id");
        albumEntity.setDescription("album 1 description");
        albumEntity.setId(1L);
        albumEntity.setName("album 1 name");

        AlbumEntity albumEntity2 = new AlbumEntity();
        albumEntity2.setUserId(userId);
        albumEntity2.setAlbumId("album2Id");
        albumEntity2.setDescription("album 2 description");
        albumEntity2.setId(2L);
        albumEntity2.setName("album 2 name");

        returnValue.add(albumEntity);
        returnValue.add(albumEntity2);

        return returnValue;
    }


}
