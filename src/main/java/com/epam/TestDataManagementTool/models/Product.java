package com.epam.TestDataManagementTool.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Product")
@Table(name = "Products")
public class Product {

    @Id
    @Column(name = "productCode", nullable = false)
    private int productCode;
    @Column(name = "productName", nullable = false)
    public String productName;
    @Column(name = "productLine", nullable = false)
    public ProductLine productLine;
    @Column(name = "productScale", nullable = false)
    public String productScale;
    @Column(name = "productVendor", nullable = false)
    public String productVendor;
    @Column(name = "productDescription", nullable = false)
    public String productDescription;
    @Column(name = "quantityInStock", nullable = false)
    public short quantityInStock;
    @Column(name = "buyPrice", nullable = false)
    public BigDecimal buyPrice;
    @Column(name = "MSRP", nullable = false)
    public BigDecimal MSRP;

}
