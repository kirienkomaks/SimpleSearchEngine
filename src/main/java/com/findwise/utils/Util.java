package com.findwise.utils;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static List<String> parseContent(String content) {
        return Arrays.asList(content.split(" "));
    }

    public static double tf(Integer wordsCount, Integer contentSize) {
        return (double) wordsCount / contentSize;
    }

    public static double idf(Integer documentsCount, Integer entriesCount) {
        return Math.log((double) documentsCount / (1 + entriesCount)) + 1;
    }

    public static double tfIdf(double tf, double idf) {
        return tf * idf;
    }
}
