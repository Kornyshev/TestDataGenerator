package com.something.TestDataManagementTool.models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UiRequest {

    @Builder.Default
    private int customersAmount = 100;
    @Builder.Default
    private int employeesAmount = 100;
    @Builder.Default
    private int officesAmount = 10;
    @Builder.Default
    private int ordersAmount = 10000;
    @Builder.Default
    private int orderDetailsAmount = 10000;
    @Builder.Default
    private int paymentsAmount = 5000;
    @Builder.Default
    private int productsAmount = 200;
    @Builder.Default
    private int productLinesAmount = 40;

}
