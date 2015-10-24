package com.crossover.utils;

public class StringExtension {
    public static boolean isNullOrBlank(String param) {
        return param == null || param.trim().length() == 0;
    }
}
