package com.something.TestDataManagementTool.models;

import com.something.TestDataManagementTool.models.entities.Order;
import com.something.TestDataManagementTool.models.entities.Product;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDetailsId implements Serializable {

    public Order orderNumber;
    public Product productCode;

}
