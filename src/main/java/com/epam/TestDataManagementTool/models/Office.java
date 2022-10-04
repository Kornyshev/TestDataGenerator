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
@Entity(name = "Office")
@Table(name = "Offices")
public class Office {

    @Id
    @Column(name = "officeCode", nullable = false)
    public String officeCode;
    @Column(name = "city", nullable = false)
    public String city;
    @Column(name = "phone", nullable = false)
    public String phone;
    @Column(name = "addressLine1", nullable = false)
    public String addressLine1;
    @Column(name = "addressLine2")
    public String addressLine2;
    @Column(name = "state")
    public String state;
    @Column(name = "country", nullable = false)
    public String country;
    @Column(name = "postalCode", nullable = false)
    public String postalCode;
    @Column(name = "territory", nullable = false)
    public String territory;

    @OneToMany(mappedBy = "employeeNumber")
    public Set<Employee> employees = new HashSet<>();

}
