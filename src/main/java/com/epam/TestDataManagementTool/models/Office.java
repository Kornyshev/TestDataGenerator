package com.epam.TestDataManagementTool.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Office")
@Table(name = "Offices")
public class Office {

    @Id
    @Column(name = "officeCode", nullable = false)
    private String officeCode;
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

}
