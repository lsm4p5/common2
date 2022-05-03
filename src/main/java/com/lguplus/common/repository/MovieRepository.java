package com.lguplus.common.repository;

import com.lguplus.common.domain.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
