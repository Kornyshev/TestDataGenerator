package com.something.TestDataManagementTool.db;

import com.something.TestDataManagementTool.models.entities.OrderDetails;
import com.something.TestDataManagementTool.models.OrderDetailsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetailsId> {
}
