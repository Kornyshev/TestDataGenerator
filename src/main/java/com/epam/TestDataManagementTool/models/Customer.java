package com.epam.TestDataManagementTool.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Customer")
@Table(name = "Customers")
public class Customer {

    @Id
    @Column(name = "customerNumber", nullable = false)
    private int customerNumber;
    @Column(name = "customerName", nullable = false)
    public String customerName;
    @Column(name = "contactLastName", nullable = false)
    public String contactLastName;
    @Column(name = "contactFirstName", nullable = false)
    public String contactFirstName;
    @Column(name = "phone", nullable = false)
    public String phone;
    @Column(name = "addressLine1", nullable = false)
    public String addressLine1;
    @Column(name = "addressLine2")
    public String addressLine2;
    @Column(name = "city", nullable = false)
    public String city;
    @Column(name = "state")
    public String state;
    @Column(name = "postalCode")
    public String postalCode;
    @Column(name = "country", nullable = false)
    public String country;
    @Column(name = "salesRepEmployeeNumber")
    public Employee salesRepEmployeeNumber;
    @Column(name = "creditLimit")
    public BigDecimal creditLimit;

}
