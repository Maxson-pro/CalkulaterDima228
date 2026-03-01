package org.example.calkulaterdima228;

public class MetodCalculater {
    public static boolean canAddOperator(String s) {
        return !s.isEmpty() && !s.endsWith(" ") && !s.endsWith("-");
    }

}
