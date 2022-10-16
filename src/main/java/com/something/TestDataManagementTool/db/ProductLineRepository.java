package com.something.TestDataManagementTool.db;

import com.something.TestDataManagementTool.models.entities.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLineRepository extends JpaRepository<ProductLine, Integer> {
}
