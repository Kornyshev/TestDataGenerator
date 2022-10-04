package com.epam.TestDataManagementTool;

import com.epam.TestDataManagementTool.db.*;
import com.epam.TestDataManagementTool.models.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TestDataManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestDataManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            CustomersRepository customersRepository,
            EmployeeRepository employeeRepository,
            OfficeRepository officeRepository,
            OrderDetailsRepository orderDetailsRepository,
            OrderRepository orderRepository,
            PaymentRepository paymentRepository,
            ProductLineRepository productLineRepository,
            ProductRepository productRepository
    ) {
        return args -> {
            List<Employee> serverList = List.of();
            employeeRepository.saveAll(serverList);
        };
    }

}
