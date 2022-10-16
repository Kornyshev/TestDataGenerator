package com.something.TestDataManagementTool.models;

import com.something.TestDataManagementTool.models.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PaymentId implements Serializable {

    public Customer customerNumber;
    public int checkNumber;

}
