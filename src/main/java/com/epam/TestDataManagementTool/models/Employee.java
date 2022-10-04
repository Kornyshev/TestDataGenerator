package com.epam.TestDataManagementTool.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Employee")
@Table(name = "Employees")
public class Employee {

    @Id
    @Column(name = "employeeNumber", nullable = false)
    public int employeeNumber;
    @Column(name = "lastName", nullable = false)
    public String lastName;
    @Column(name = "firstName", nullable = false)
    public String firstName;
    @Column(name = "extension", nullable = false)
    public String extension;
    @Column(name = "email", nullable = false)
    public String email;
    @ManyToOne()
    @JoinColumn(name = "officeCode", referencedColumnName = "officeCode", nullable = false, foreignKey = @ForeignKey(name = "fk_employees_to_office"))
    public Office officeCode;
    @ManyToOne()
    @JoinColumn(name = "reportsTo", referencedColumnName = "employeeNumber", foreignKey = @ForeignKey(name = "fk_employees_report_to_employee"))
    public Employee reportsTo;
    @Column(name = "jobTitle", nullable = false)
    public String jobTitle;

    @OneToMany(mappedBy = "salesRepEmployeeNumber")
    public Set<Customer> customers = new HashSet<>();

    @OneToMany(mappedBy = "reportsTo")
    public Set<Employee> employees = new HashSet<>();

}
