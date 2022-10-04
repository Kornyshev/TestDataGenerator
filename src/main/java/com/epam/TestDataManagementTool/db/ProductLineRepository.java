package com.epam.TestDataManagementTool.db;

import com.epam.TestDataManagementTool.models.ProductLine;
import org.springframework.data.repository.CrudRepository;

public interface ProductLineRepository extends CrudRepository<ProductLine, Integer> {
}
