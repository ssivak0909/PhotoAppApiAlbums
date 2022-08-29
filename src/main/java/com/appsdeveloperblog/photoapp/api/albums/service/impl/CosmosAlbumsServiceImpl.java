/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.photoapp.api.albums.service.impl;

import com.appsdeveloperblog.photoapp.api.albums.cosmos.entity.AlbumDocument;
import com.appsdeveloperblog.photoapp.api.albums.cosmos.repository.AlbumDocumentRepository;
import com.appsdeveloperblog.photoapp.api.albums.service.CosmosAlbumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@ConditionalOnProperty(prefix = "azure.cosmos",name = "enabled")
public class CosmosAlbumsServiceImpl implements CosmosAlbumsService {

    @Autowired
    @Qualifier("albumDocumentRepository")
    AlbumDocumentRepository albumDocumentRepository;

    @Override
    public Iterable<AlbumDocument> getAlbums() {
        List<AlbumDocument> albumDocuments = new ArrayList<>();
        albumDocumentRepository.findAll().forEach(albumDocuments::add);
        return albumDocuments;
    }

    @Override
    public AlbumDocument saveAlbumDocs(AlbumDocument albumDocument) {
        UUID uuid = UUID.randomUUID();
        albumDocument.setId(uuid.toString());
        return albumDocumentRepository.save(albumDocument);
    }

}
