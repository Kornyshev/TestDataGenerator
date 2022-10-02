package com.epam.TestDataManagementTool.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Order")
@Table(name = "Orders")
public class Order {

    @Id
    @Column(name = "orderNumber", nullable = false)
    private int orderNumber;
    @Column(name = "orderDate", nullable = false)
    public Date orderDate;
    @Column(name = "requiredDate", nullable = false)
    public Date requiredDate;
    @Column(name = "shippedDate")
    public Date shippedDate;
    @Column(name = "status", nullable = false)
    public String status;
    @Column(name = "comments", nullable = false)
    public String comments;
    @Column(name = "customerNumber", nullable = false)
    public Customer customerNumber;

}
