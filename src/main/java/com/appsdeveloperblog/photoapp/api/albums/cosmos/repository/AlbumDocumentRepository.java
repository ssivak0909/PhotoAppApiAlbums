package com.appsdeveloperblog.photoapp.api.albums.cosmos.repository;

import com.appsdeveloperblog.photoapp.api.albums.cosmos.entity.AlbumDocument;
import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumDocumentRepository extends CosmosRepository<AlbumDocument, String> {
}
