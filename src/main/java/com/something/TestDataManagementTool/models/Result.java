package com.something.TestDataManagementTool.models;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Result {

    public String tableName;
    public int amountOfRecords;

}
