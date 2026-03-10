package org.example.calkulaterdima228;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculater {
    public String calculate(String expression) {
        try {
               String text = expression.trim();
             if (text.isEmpty()) return "Пусто";
               while (text.contains("(")) {
                   int start = text.lastIndexOf("(");
                    int end = text.indexOf(")", start);
                if (end == -1) return "Ошибка скобки";
                  String innerResult = calculate(text.substring(start + 1, end).trim());
                   if (innerResult.contains("Ошибка")) return innerResult;

                       text = text.substring(0, start) + " " + innerResult + " " + text.substring(end + 1);
                text = text.trim();
                }
                       ArrayList<String> r = new ArrayList<>(Arrays.asList(text.split(" +")));
                 if (r.size() == 1) return r.get(0);
                       if (r.size() % 2 == 0) return "Неполный пример";
                for (int i = 0; i < r.size(); i++) {
                if (r.get(i).equals("*") || r.get(i).equals("/")) {
                    double n1 = Double.parseDouble(r.get(i - 1));
                             double n2 = Double.parseDouble(r.get(i + 1));
                    double tempRes = 0;
                    if (r.get(i).equals("*")) tempRes = n1 * n2;
                          else {
                        if (n2 == 0) return "Ошибка / 0";
                        tempRes = n1 / n2;
                    }
                    r.set(i - 1, String.valueOf(tempRes));
                          r.remove(i);
                       r.remove(i);
                    i--;
                }
            }
                  double finalRes = Double.parseDouble(r.get(0));
            for (int i = 1; i < r.size(); i += 2) {
                      String op = r.get(i);
                double nextNum = Double.parseDouble(r.get(i + 1));
                if (op.equals("+")) finalRes += nextNum;
                    else if (op.equals("-")) finalRes -= nextNum;
            }
            if (Double.isInfinite(finalRes)) return "Слишком большое";
            if (finalRes > 10000000 || finalRes < -10000000) {
                return String.format("%.2E", finalRes);
            } else {
                    if (finalRes == (long) finalRes) return String.valueOf((long) finalRes);
                else return String.valueOf(finalRes);
            }
             } catch (Exception e) {
            return "Ошибка ввода";
        }
    }
}