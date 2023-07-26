package com.example.demo3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;

public class CalculateController {

    @FXML
    private Label secondText;
    @FXML
    private TextArea largeText;
    int resultValue = 0;
    @FXML
    private String textBox = "";
    ArrayList<Integer> resultArr = new ArrayList();
    ArrayList<String> operator = new ArrayList();

    @FXML
    protected void fuckButtonClick() {
        secondText.setText("Welcome to JavaFX Application!");
    }

    public void getterRequest() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection connection = null;
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk", "root", "");
            Statement stmt = connection.createStatement();
            String SQL = "SELECT * FROM request";
            ResultSet result = stmt.executeQuery(SQL);
            String value = "";
            String id = "";
            while (result.next()) {

                value += result.getString("name");
                id += result.getString("id_request");
//                System.out.println(value);
            }
            largeText.setText(value + value + value + value + value);
            largeText.setPrefColumnCount(55);
            largeText.setPrefRowCount(55);

        } catch (Exception ex) {
            System.out.println(ex);
        }


    }

    @FXML
    protected void NumberClick(MouseEvent event) {
        String text = ((Button) event.getSource()).getText();
        this.textBox += text;
        largeText.setText(this.textBox);
    }

    @FXML
    public void SymbolEqual(MouseEvent event) {
        System.out.println(largeText.getText());
        String parse = largeText.getText();
        String equal = "";
        for (int i = 0; i < parse.length(); i++) {

            if (parse.charAt(i) == '+') {
                int number = Integer.parseInt(equal);
                resultArr.add(number);
                operator.add("+");
                equal = "";

            } else if (parse.charAt(i) == '-') {
                int number = Integer.parseInt(equal);
                resultArr.add(number);
                operator.add("-");
                equal = "";
            } else if (parse.charAt(i) == '*') {
                int number = Integer.parseInt(equal);
                resultArr.add(number);
                operator.add("*");
                equal = "";
            } else if (parse.charAt(i) == '/') {
                int number = Integer.parseInt(equal);
                resultArr.add(number);
                operator.add("/");
                equal = "";
            } else {
                equal += parse.charAt(i);
            }


        }
        int number = Integer.parseInt(equal);
        resultArr.add(number);
        equal = "";
        if (resultValue == 0) {
            resultValue = resultArr.get(0);
        }

        for (int j = 0; j < operator.size(); j++) {
            if (operator.get(j) == "+") {
                resultValue += resultArr.get(j + 1);

            } else if (operator.get(j) == "-") {
                resultValue -= resultArr.get(j + 1);
            } else if (operator.get(j) == "*") {
                resultValue *= resultArr.get(j + 1);
            } else if (operator.get(j) == "/") {
                resultValue /= resultArr.get(j + 1);
            }

        }
        operator.clear();
        resultArr.clear();
        System.out.println(resultValue);
        largeText.setText(String.valueOf(resultValue));
        this.textBox = String.valueOf(resultValue);

    }

    @FXML
    public void SymbolClean(MouseEvent event) {
        String text = ((Button) event.getSource()).getText();
        largeText.setText("");
        this.textBox = "";
        resultArr.clear();
        operator.clear();
        resultValue = 0;


    }
}
