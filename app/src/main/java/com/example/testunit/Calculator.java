package com.example.testunit;


import java.text.DecimalFormat;

public class Calculator {
    private final DecimalFormat format = new DecimalFormat("#.########");

    public String add(double a, double b) {
        return formatNumber(a + b);
    }

    public String subtract(double a, double b) {
        return formatNumber(a - b);
    }

    public String multiply(double a, double b) {
        return formatNumber(b*a);
    }

    public String divide(double a, double b) {
        if (b == 0) {
            return "0";
        }
        return formatNumber(a / b);
    }

    public String percentage(double value) {
        return formatNumber(value / 100);
    }

    public String changeSign(double value) {
        return formatNumber(value * -1);
    }

    public String formatNumber(double value) {
        String result = format.format(value);
        if (result.equals("-0")) {
            result = "0";
        }
        return result;
    }

    public double parseInput(String input) {
        return Double.parseDouble(input.replace(',', '.'));
    }

    public String calculate(double firstOperand, double secondOperand, String operator) {
        double result = 0;

        switch (operator) {
            case "+": result = firstOperand + secondOperand; break;
            case "−": result = firstOperand - secondOperand; break;
            case "×": result = firstOperand * secondOperand; break;
            case "÷":
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    return "0"; // xử lý chia cho 0
                }
                break;
        }

        return formatNumber(result);
    }
}