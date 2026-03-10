package org.example.calkulaterdima228;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    private Calculater calc = new Calculater();
    private boolean isResultShown = false;
    private int openBracketsCount = 0;
    @FXML
    private Label display;
    @FXML
    public void Numbers(ActionEvent event) {
           if (isResultShown) {
               display.setText("");
               isResultShown = false; }
           String b = ((Button)event.getSource()).getText();
             String currentText = display.getText();
        if (currentText.endsWith(") ")) {
            display.setText(currentText + "* " + b);
            return;
        }
              String[] parts = currentText.split(" ");
        String lastPart = (parts.length > 0) ? parts[parts.length - 1] : "";
        if (lastPart.length() < 10) {
            if (lastPart.equals("0")) {
                display.setText(currentText.substring(0, currentText.length() - 1) + b);
            } else {
                display.setText(currentText + b);
            }
        }
    }

    private void handleOperator(String op) {
        if (isResultShown) {
                isResultShown = false;
        }
        if (MetodCalculater.canAddOperator(display.getText())) {
            display.setText(display.getText() + op);
        }
    }

          @FXML public void Plus(ActionEvent event) {
        handleOperator(" + ");
    }
        @FXML public void Ymnoshit(ActionEvent event) {
        handleOperator(" * ");
    }
    @FXML public void Delenie(ActionEvent event) {
        handleOperator(" / ");
    }

    @FXML
    public void Minus(ActionEvent event) {
              if (isResultShown) isResultShown = false;
        String s = display.getText();
        if (s.isEmpty() || s.endsWith(" ")) display.setText(s + "-");
             else if (!s.endsWith("-")) display.setText(s + " - ");
    }

    @FXML
          public void bracketLe(ActionEvent actionEvent) {
               if (isResultShown) {
                   display.setText("");
                   isResultShown = false; }
        String s = display.getText();
        if (!s.isEmpty() && (Character.isDigit(s.charAt(s.length()-1)) || s.endsWith(") "))) {
            display.setText(s + " * ( ");
            } else {
            display.setText(s + "( ");
        }
        openBracketsCount++;
    }

    @FXML
    public void bracketPra(ActionEvent actionEvent) {
        if (isResultShown) {
            return;
        }
        String s = display.getText();
        if (openBracketsCount <= 0) {
            return;
        }
        if (s.isEmpty()) {
            return;
        }
        boolean EndsWithSpace = s.endsWith(" ");
        boolean EndOpenSpace = s.endsWith("( ");
        if (!EndsWithSpace && !EndOpenSpace) {
            display.setText(s + " ) ");
            openBracketsCount--;
        }
    }

    @FXML
    public void Ravno(ActionEvent event) {
              String s = display.getText();
        while (openBracketsCount > 0) {
            if (s.endsWith(" ")) s = s.trim();
            s += " ) ";
            openBracketsCount--;
              }
        display.setText(calc.calculate(s));
        isResultShown = true;
    }

    @FXML
    public void Delet1(ActionEvent event) {
                 if (isResultShown) {
                     Clear(null); return;
                 }
        String s = display.getText();
        if (s.isEmpty()) return;
              if (s.endsWith("( ")) openBracketsCount--;
        if (s.endsWith(") ")) openBracketsCount++;
              if (s.endsWith(" ")) display.setText(s.substring(0, s.length() - 3));
        else display.setText(s.substring(0, s.length() - 1));
    }
    @FXML public void Clear(ActionEvent event) {
        display.setText("");
              isResultShown = false;
        openBracketsCount = 0; }
    @FXML public void Exit(ActionEvent event) {
        System.exit(0); }
    @FXML
    public void Tochka(ActionEvent event) {
        if (isResultShown) { display.setText("0."); isResultShown = false; return; }
           String s = display.getText();
        if (s.isEmpty() || s.endsWith(" ") || s.endsWith("-") || s.endsWith(") ")) {
            display.setText(s + "0.");
        } else {
            String[] parts = s.split(" ");
            if (!parts[parts.length - 1].contains(".")) display.setText(s + ".");
        }
    }
}