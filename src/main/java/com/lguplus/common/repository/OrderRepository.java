package com.lguplus.common.repository;

import com.lguplus.common.domain.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
