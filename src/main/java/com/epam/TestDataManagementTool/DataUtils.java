package com.epam.TestDataManagementTool;

import lombok.SneakyThrows;

public class DataUtils {

    @SneakyThrows
    public static synchronized long timestamp() {
        Thread.sleep(2);
        return System.currentTimeMillis();
    }

    @SneakyThrows
    public static int timestampInt() {
        return Math.abs((int) timestamp());
    }

}
