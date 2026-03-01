package org.example.calkulaterdima228;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculater {
       public String calculate(String expression) {
        try {
                String text = expression.trim();
            if (text.isEmpty())
                return "";
                  ArrayList<String> r = new ArrayList<>(Arrays.asList(text.split(" +")));
            if (r.size() < 3)
                   return text;
              for (int i = 0; i < r.size(); i++) {
                if (r.get(i).equals("*") || r.get(i).equals("/")) {
                     double n1 = Double.parseDouble(r.get(i - 1));
                          double n2 = Double.parseDouble(r.get(i + 1));
                    double tempRes = 0;
                    if (r.get(i).equals("*")) {
                        tempRes = n1 * n2;
                    } else {
                        if (n2 == 0)
                            return "Ошибка / 0";
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
            if (finalRes > 10000000 || finalRes < -10000000) {
                  return String.format("%.2E", finalRes);
              } else {
                if (finalRes == (long) finalRes) {
                    return String.valueOf((long) finalRes);
                    } else {
                    return String.valueOf(finalRes);
                   }
            }

         } catch (Exception e) {
               return "Ошибка";
        }
    }
}