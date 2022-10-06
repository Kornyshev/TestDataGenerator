package com.epam.TestDataManagementTool.models;

import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Customer")
@Table(name = "Customers")
public class Customer {

    private static final Faker FAKER = Faker.instance();

    @Id
    @Column(name = "customerNumber", nullable = false)
    public int customerNumber = 123;
    @Column(name = "customerName", nullable = false)
    @Builder.Default
    public String customerName = FAKER.name().firstName();
    @Column(name = "contactLastName", nullable = false)
    @Builder.Default
    public String contactLastName = FAKER.name().lastName();
    @Column(name = "contactFirstName", nullable = false)
    @Builder.Default
    public String contactFirstName = FAKER.name().firstName();
    @Column(name = "phone", nullable = false)
    @Builder.Default
    public String phone = FAKER.phoneNumber().cellPhone();
    @Column(name = "addressLine1", nullable = false)
    @Builder.Default
    public String addressLine1 = FAKER.address().fullAddress();
    @Column(name = "addressLine2")
    public String addressLine2;
    @Column(name = "city", nullable = false)
    @Builder.Default
    public String city = FAKER.address().city();
    @Column(name = "state")
    public String state;
    @Column(name = "postalCode")
    @Builder.Default
    public String postalCode = FAKER.address().zipCode();
    @Column(name = "country", nullable = false)
    @Builder.Default
    public String country = FAKER.address().country();
    @ManyToOne()
    @JoinColumn(name = "salesRepEmployeeNumber", referencedColumnName = "employeeNumber", foreignKey = @ForeignKey(name = "fk_customers_to_employee"))
    public Employee salesRepEmployeeNumber;
    @Column(name = "creditLimit")
    public BigDecimal creditLimit;

    @OneToMany(mappedBy = "customerNumber")
    public Set<Payment> payments = new HashSet<>();

    @OneToMany(mappedBy = "customerNumber")
    public Set<Order> orders = new HashSet<>();

}
