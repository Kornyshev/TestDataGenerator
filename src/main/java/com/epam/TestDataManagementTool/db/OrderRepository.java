package com.epam.TestDataManagementTool.db;

import com.epam.TestDataManagementTool.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
