package org.example.calkulaterdima228;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    private boolean isResultShown = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private  Label display;

    @FXML
    public   void Clear(ActionEvent event) {
display.setText("");
    }
    @FXML
    public void Delenie(ActionEvent event) {
        if (isResultShown) {
            display.setText("");
            isResultShown = false;
            return;
        }
         String sumka = display.getText();
        if (!sumka.isEmpty() && !sumka.endsWith(" ")) {
             display.setText(sumka + " / ");
        }
    }
    @FXML
    public  void Delet1(ActionEvent event) {
        if (!display.getText().isEmpty())  {
            String s = display.getText();
             display.setText(s.substring(0, s.length() - 1));
        }
    }
    @FXML
    public  void Exit(ActionEvent event) {
        System.exit(0);

    }
    @FXML
    public void Minus(ActionEvent event) {
        String sumka = display. getText();
        if (!sumka.isEmpty() && !sumka.endsWith (" ")) {
            display.setText(sumka + " - ");
            isResultShown  = false;
        }
    }
    @FXML
    public void Numbers(ActionEvent event) {
        if (  isResultShown) {
            display.setText("");
            isResultShown =  false;
        }
        String b = ((Button)event.getSource()).getText();
        String currentText = display.getText();
        String[] parts = currentText.split(" ");
        String lastPart = (parts.length > 0) ? parts[parts.length - 1] : "";
        if (lastPart.length() < 10) {
            if (lastPart.equals(  "0")) {
                display.setText(currentText.substring(0, currentText.length() - 1) + b);
            } else {
                display.setText(currentText + b);
            }}}
    @FXML
    public void PlMn(ActionEvent event) {
        String sumka = display.getText();
        if (sumka.isEmpty() ||    sumka.endsWith(" "))     return;
        String[] parts = sumka.split(" ");
        String lastNum = parts[parts.length - 1];
        String base = sumka.substring(0, sumka.length() -   lastNum.length());
        if (lastNum.startsWith("-")) {
            display.setText(base    + lastNum.substring(1));
        }else {
            display.setText(base +   "-" + lastNum);
        }}
    @FXML
    public  void Plus(ActionEvent event) {
        if (isResultShown) {
            display.setText("");
            isResultShown = false;
            return;
        }
        String sumka = display.getText();
        if (!sumka.isEmpty() && !sumka.endsWith(" ")) {
            display.setText(sumka + " + ");
        }}
    @FXML
    public void Ravno(ActionEvent event) {
        try {
            String text = display.getText().trim();
            if (text.isEmpty()) return;
           ArrayList<String> r = new ArrayList<>(Arrays.asList(text.split(" ")));
            for (int i = 0; i < r.size(); i++) {
                if (r.get(i).equals("*") || r.get(i).equals("/")) {
                    double n1 = Double.parseDouble(r.get(i - 1));
                    double n2 = Double.parseDouble(r.get(i + 1));
                    double tempRes = 0;
                    if (r.get(i).equals("*")) {
                        tempRes = n1 * n2;
                    } else {
                        if (n2 == 0) {
                            display.setText("Ошибка / 0");
                            isResultShown = true;
                            return;
                        }
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
                display.setText(String.format("%.2E", finalRes));
            } else {
                if (finalRes == (long) finalRes) {
                    display.setText(String.valueOf((long) finalRes));
                } else {
                    display.setText(String.valueOf(finalRes));
                }
            }
            isResultShown = true;

        } catch (Exception e) {
            display.setText("Ошибка");
            isResultShown = true;
        }
    }
    @FXML
    public   void Tochka(ActionEvent event) {
        if (isResultShown) { display.setText(""); isResultShown = false; return; }
        String s = display.getText();
        if ( s.endsWith(" ")) {
            display.setText(s + "0.");
            return;
        }
        String[] parts = s.split(" ");
        String lastPart = parts[parts.length - 1];
        if (!lastPart.contains(".")) {
            display.setText(s + ".");
        }}
    @FXML
    public   void Ymnoshit(ActionEvent event) {
        if (isResultShown) {
            display.setText(""); isResultShown = false;
            return;
        }
        String sumka = display.getText();
        if (!sumka.isEmpty() && !sumka.endsWith(" ")) {
            display.setText(sumka + " * ");
        }}
    @FXML
    public   void initialize() {
        assert display != null : "fx:id=\"display\" was not injected: check your FXML file 'hello-view.fxml'.";
    }}
