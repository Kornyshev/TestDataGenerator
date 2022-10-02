package com.epam.TestDataManagementTool.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Employee")
@Table(name = "Employees")
public class Employee {

    @Id
    @Column(name = "employeeNumber", nullable = false)
    private int employeeNumber;
    @Column(name = "lastName", nullable = false)
    public String lastName;
    @Column(name = "firstName", nullable = false)
    public String firstName;
    @Column(name = "extension", nullable = false)
    public String extension;
    @Column(name = "email", nullable = false)
    public String email;
    @Column(name = "officeCode", nullable = false)
    public Office officeCode;
    @Column(name = "reportsTo")
    public Employee reportsTo;
    @Column(name = "jobTitle", nullable = false)
    public String jobTitle;

}
