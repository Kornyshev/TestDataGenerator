package com.something.TestDataManagementTool.db;

import com.something.TestDataManagementTool.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Modifying
    @Query(value = "update Employees e set e.reportsTo = :reportsTo where e.employeeNumber = :employeeNumber", nativeQuery = true)
    void updateReportsTo(@Param(value = "employeeNumber") int employeeNumber, @Param(value = "reportsTo") int reportsTo);


}
