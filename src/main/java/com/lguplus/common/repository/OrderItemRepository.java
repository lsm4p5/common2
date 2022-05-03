package com.lguplus.common.repository;

import com.lguplus.common.domain.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}
