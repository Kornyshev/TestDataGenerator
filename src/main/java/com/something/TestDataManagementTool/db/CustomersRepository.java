package com.something.TestDataManagementTool.db;

import com.something.TestDataManagementTool.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customer, Integer> {
}
