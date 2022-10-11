package com.epam.TestDataManagementTool.models;

import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Office")
@Table(name = "Offices")
public class Office {

    private static final Faker FAKER = Faker.instance();

    @Id
    @Column(name = "officeCode", nullable = false)
    public String officeCode;
    @Column(name = "city", nullable = false)
    @Builder.Default
    public String city = FAKER.address().city();
    @Column(name = "phone", nullable = false)
    @Builder.Default
    public String phone = FAKER.phoneNumber().phoneNumber();
    @Column(name = "addressLine1", nullable = false)
    @Builder.Default
    public String addressLine1 = FAKER.address().fullAddress();
    @Column(name = "addressLine2")
    public String addressLine2;
    @Column(name = "state")
    public String state;
    @Column(name = "country", nullable = false)
    @Builder.Default
    public String country = FAKER.address().country();
    @Column(name = "postalCode", nullable = false)
    @Builder.Default
    public String postalCode = FAKER.address().zipCode();
    @Column(name = "territory", nullable = false)
    @Builder.Default
    public String territory = FAKER.address().state();

    @OneToMany(mappedBy = "employeeNumber")
    public Set<Employee> employees = new HashSet<>();

}
