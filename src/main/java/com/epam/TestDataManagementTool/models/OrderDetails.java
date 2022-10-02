package com.epam.TestDataManagementTool.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "OrderDetails")
@Table(name = "OrderDetails")
public class OrderDetails {

    @Id
    @Column(name = "orderNumber", nullable = false)
    private Order orderNumber;
    @Id
    @Column(name = "productCode", nullable = false)
    private Product productCode;
    @Column(name = "quantityOrdered", nullable = false)
    public int quantityOrdered;
    @Column(name = "priceEach", nullable = false)
    public BigDecimal priceEach;
    @Column(name = "orderLineNumber", nullable = false)
    public short orderLineNumber;

}
