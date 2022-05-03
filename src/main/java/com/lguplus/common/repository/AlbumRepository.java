package com.lguplus.common.repository;

import com.lguplus.common.domain.Entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Long> {
}
