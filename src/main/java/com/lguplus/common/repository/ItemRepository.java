package com.lguplus.common.repository;

import com.lguplus.common.domain.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {

    List<Item> findByItemName(String itemName);
}
