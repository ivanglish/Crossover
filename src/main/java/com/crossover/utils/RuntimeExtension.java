package com.crossover.utils;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class RuntimeExtension {
    public static final int KILOBYTE = 1024;

    public static Map<String, String> getMemoryInformation() {
        Map<String, String> values = new LinkedHashMap<>();
        Runtime runtime = Runtime.getRuntime();

        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        values.put("free", readableFileSize(freeMemory));
        values.put("allocated", readableFileSize(allocatedMemory));
        values.put("max", readableFileSize(maxMemory));
        values.put("totalFree", readableFileSize((freeMemory + (maxMemory - allocatedMemory))));

        return values;
    }

    private static String readableFileSize(long size) {
        if (size <= 0) {
            return "0";
        }

        final String[] units = new String[]{"B", "kB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(KILOBYTE));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(KILOBYTE, digitGroups)) + " " + units[digitGroups];
    }
}
