package com.epam.TestDataManagementTool.models;

import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Employee")
@Table(name = "Employees")
public class Employee {

    private static final Faker FAKER = Faker.instance();

    @Id
    @Column(name = "employeeNumber", nullable = false)
    public int employeeNumber;
    @Column(name = "lastName", nullable = false)
    @Builder.Default
    public String lastName = FAKER.name().lastName();
    @Column(name = "firstName", nullable = false)
    @Builder.Default
    public String firstName = FAKER.name().firstName();
    @Column(name = "extension", nullable = false)
    @Builder.Default
    public String extension = FAKER.lorem().fixedString(100);
    @Column(name = "email", nullable = false)
    @Builder.Default
    public String email = FAKER.internet().emailAddress();
    @ManyToOne()
    @JoinColumn(name = "officeCode", referencedColumnName = "officeCode", nullable = false, foreignKey = @ForeignKey(name = "fk_employees_to_office"))
    public Office officeCode;
    @ManyToOne()
    @JoinColumn(name = "reportsTo", referencedColumnName = "employeeNumber", foreignKey = @ForeignKey(name = "fk_employees_report_to_employee"))
    public Employee reportsTo;
    @Column(name = "jobTitle", nullable = false)
    @Builder.Default
    public String jobTitle = FAKER.job().title();

    @OneToMany(mappedBy = "salesRepEmployeeNumber")
    public Set<Customer> customers = new HashSet<>();

    @OneToMany(mappedBy = "reportsTo")
    public Set<Employee> employees = new HashSet<>();

}
