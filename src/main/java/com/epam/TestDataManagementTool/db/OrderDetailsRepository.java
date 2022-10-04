package com.epam.TestDataManagementTool.db;

import com.epam.TestDataManagementTool.models.OrderDetails;
import com.epam.TestDataManagementTool.models.OrderDetailsId;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, OrderDetailsId> {
}
