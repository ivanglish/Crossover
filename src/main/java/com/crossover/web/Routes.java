package com.crossover.web;

import com.crossover.utils.StringExtension;
import spark.Spark;

public class Routes {
    public static void build() {
        Spark.setPort(getHttpPort());
        Spark.get(new HomeRoute());
    }

    private static int getHttpPort() {
        String value = System.getenv("PORT");

        if (StringExtension.isNullOrBlank(value)) {
            return 9090;
        } else {
            return Integer.valueOf(value);
        }
    }
}
