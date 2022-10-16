package com.something.TestDataManagementTool.db;

import com.something.TestDataManagementTool.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
