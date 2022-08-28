/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.photoapp.api.albums.service;


import com.appsdeveloperblog.photoapp.api.albums.entity.AlbumEntity;

import java.util.List;

public interface GeneralAlbumsService {
    List<AlbumEntity> getAlbums(String userId);
}
