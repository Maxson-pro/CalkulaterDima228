package org.example.calkulaterdima228;

public class MetodCalculater {
    public static boolean canAddOperator(String s) {
            if (s.isEmpty())
                return false;
          String trimmed = s.trim();
        if (trimmed.endsWith("-"))
            return false;
           if (Character.isDigit(trimmed.charAt(trimmed.length() - 1)))
               return true;
        if (trimmed.endsWith(")"))
            return true;

        return false;
    }

}
