package com.something.TestDataManagementTool.db;

import com.something.TestDataManagementTool.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
