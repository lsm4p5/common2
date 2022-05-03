package com.lguplus.common.repository;

import com.lguplus.common.domain.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
