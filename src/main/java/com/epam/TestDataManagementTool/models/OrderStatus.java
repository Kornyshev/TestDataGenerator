package com.epam.TestDataManagementTool.models;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum OrderStatus {

    DELIVERED(0, "DELIVERED"),
    ON_WAREHOUSE(1, "ON_WAREHOUSE"),
    DELIVERING(2, "DELIVERING");

    private final int id;
    private final String name;

    OrderStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static OrderStatus getOrderStatusById(int id) {
        return Arrays.stream(values()).filter(elem -> elem.getId() == id).findFirst().orElseThrow();
    }

}
