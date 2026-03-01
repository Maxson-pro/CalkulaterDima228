package org.example.calkulaterdima228;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    private Calculater calc = new Calculater();
    private boolean isResultShown = false;

    @FXML
    private Label display;

    @FXML
    public void Numbers(ActionEvent event) {
        if (isResultShown) {
            display.setText("");
            isResultShown = false;
        }
           String b = ((Button)event.getSource()).getText();
             String currentText = display.getText();
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

    @FXML
    public void Plus(ActionEvent event) {
        if (isResultShown) {
            display.setText("");
            isResultShown = false;
        }
        if (MetodCalculater.canAddOperator(display.getText())) {
            display.setText(display.getText() + " + ");
        }
    }
    @FXML
     public void Ymnoshit(ActionEvent event) {
        if (isResultShown) {
            display.setText("");
            isResultShown = false;
        }
        if (MetodCalculater.canAddOperator(display.getText())) {
            display.setText(display.getText() + " * ");
        }
    }
    @FXML
    public void Delenie(ActionEvent event) {
        if (isResultShown) {
            display.setText("");
            isResultShown = false;
        }
        if (MetodCalculater.canAddOperator(display.getText())) {
            display.setText(display.getText() + " / ");
        }
    }

    @FXML
    public void Minus(ActionEvent event) {
        if (isResultShown) {
               display.setText("");
            isResultShown = false; }
               String s = display.getText();
        if (s.isEmpty() || s.endsWith(" ")) {
            display.setText(s + "-");
        }
        else if (s.endsWith("-")) {
               return;
            }
        else {
            display.setText(s + " - ");
        }
    }
    @FXML
    public void Tochka(ActionEvent event) {
          if (isResultShown) { display.setText(""); isResultShown = false; }
        String s = display.getText();
              if (s.isEmpty() || s.endsWith(" ") || s.endsWith("-")) {
            display.setText(s + "0.");
            return;
        }
             String[] parts = s.split(" ");
        String lastPart = parts[parts.length - 1];
              if (!lastPart.contains(".")) {
            display.setText(s + ".");
        }
    }

    @FXML
     public void Delet1(ActionEvent event) {
        if (isResultShown) { display.setText(""); isResultShown = false; return; }
          String s = display.getText();
             if (!s.isEmpty()) {
            if (s.endsWith(" ")) {
                display.setText(s.substring(0, s.length() - 3));
            } else {
                display.setText(s.substring(0, s.length() - 1));
            }
        }
    }
    @FXML
        public void Ravno(ActionEvent event) {
        String result = calc.calculate(display.getText());
             display.setText(result);
        isResultShown = true;
    }
    @FXML
    public void Clear(ActionEvent event) {
              display.setText("");
        isResultShown = false;
    }
    @FXML
        public void Exit(ActionEvent event) {
        System.exit(0);
    }
}