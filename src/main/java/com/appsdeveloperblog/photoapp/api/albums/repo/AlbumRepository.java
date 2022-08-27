package com.appsdeveloperblog.photoapp.api.albums.repo;

import com.appsdeveloperblog.photoapp.api.albums.data.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {
    public List<AlbumEntity> findByUserId(String userid);
}
