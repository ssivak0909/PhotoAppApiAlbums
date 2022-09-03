package com.appsdeveloperblog.photoapp.api.albums.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Document
public class AlbumMongo {

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
