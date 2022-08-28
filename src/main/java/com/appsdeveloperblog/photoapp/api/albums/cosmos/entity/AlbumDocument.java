package com.appsdeveloperblog.photoapp.api.albums.cosmos.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Container(containerName = "items")
@Data
@RequiredArgsConstructor
public class AlbumDocument {

    @Id
    @GeneratedValue
    private String id;
    @NotNull
    private String albumId;
    @NotNull
    private String userId;
    @NotNull
    private String name;
    @NotNull
    private String description;
}
