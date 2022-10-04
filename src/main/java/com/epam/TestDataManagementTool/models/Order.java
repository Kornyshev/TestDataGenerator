package com.epam.TestDataManagementTool.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Order")
@Table(name = "Orders")
public class Order {

    @Id
    @Column(name = "orderNumber", nullable = false)
    public int orderNumber;
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
    @ManyToOne()
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", nullable = false, foreignKey = @ForeignKey(name = "fk_orders_to_customer"))
    public Customer customerNumber;

    @OneToOne(mappedBy = "orderNumber")
    public OrderDetails orderDetails;

}
