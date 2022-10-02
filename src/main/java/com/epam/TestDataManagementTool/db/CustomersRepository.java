package com.epam.TestDataManagementTool.db;

import com.epam.TestDataManagementTool.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customer, Integer> {

}
