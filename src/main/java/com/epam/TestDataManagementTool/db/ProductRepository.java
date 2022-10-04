package com.epam.TestDataManagementTool.db;

import com.epam.TestDataManagementTool.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
