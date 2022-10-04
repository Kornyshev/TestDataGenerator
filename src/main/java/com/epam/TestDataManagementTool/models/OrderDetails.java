package com.epam.TestDataManagementTool.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "OrderDetails")
@Table(name = "OrderDetails")
@IdClass(OrderDetailsId.class)
public class OrderDetails {

    @Id
    @OneToOne()
    @JoinColumn(name = "orderNumber", referencedColumnName = "orderNumber", nullable = false, foreignKey = @ForeignKey(name = "fk_order_details_to_order"))
    public Order orderNumber;
    @Id
    @ManyToOne()
    @JoinColumn(name = "productCode", referencedColumnName = "productCode", nullable = false, foreignKey = @ForeignKey(name = "fk_order_details_to_products"))
    public Product productCode;
    @Column(name = "quantityOrdered", nullable = false)
    public int quantityOrdered;
    @Column(name = "priceEach", nullable = false)
    public BigDecimal priceEach;
    @Column(name = "orderLineNumber", nullable = false)
    public short orderLineNumber;

}
