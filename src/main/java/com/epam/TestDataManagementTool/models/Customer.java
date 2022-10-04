package com.epam.TestDataManagementTool.models;

import com.epam.TestDataManagementTool.DataUtils;
import jakarta.persistence.*;
import lombok.*;

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

    @Id
    @Column(name = "customerNumber", nullable = false)
    public int customerNumber = 123;
    @Column(name = "customerName", nullable = false)
    @Builder.Default
    public String customerName = "Name" + DataUtils.timestamp();
    @Column(name = "contactLastName", nullable = false)
    @Builder.Default
    public String contactLastName = "LastName" + DataUtils.timestamp();
    @Column(name = "contactFirstName", nullable = false)
    @Builder.Default
    public String contactFirstName = "ContactFirstName" + DataUtils.timestamp();
    @Column(name = "phone", nullable = false)
    @Builder.Default
    public String phone = "Phone" + DataUtils.timestamp();
    @Column(name = "addressLine1", nullable = false)
    @Builder.Default
    public String addressLine1 = "Address " + DataUtils.timestamp();
    @Column(name = "addressLine2")
    public String addressLine2;
    @Column(name = "city", nullable = false)
    @Builder.Default
    public String city = "City" + DataUtils.timestamp();
    @Column(name = "state")
    public String state;
    @Column(name = "postalCode")
    @Builder.Default
    public String postalCode = "PostalCode" + DataUtils.timestamp();
    @Column(name = "country", nullable = false)
    @Builder.Default
    public String country = "Country" + DataUtils.timestamp();
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
