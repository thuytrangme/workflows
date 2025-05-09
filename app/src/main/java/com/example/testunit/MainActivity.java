package com.example.testunit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    private String currentInput = "";
    private double firstOperand = 0;
    private String operator = "";
    private Calculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = findViewById(R.id.txtResult);

        int[] buttonIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btnAC, R.id.btnDel, R.id.btnSign, R.id.btnDivide,
                R.id.btnMultiply, R.id.btnMinus, R.id.btnPlus, R.id.btnEquals,
                R.id.btnPercent, R.id.btnDot
        };

        for (int id : buttonIds) {
            Button btn = findViewById(id);
            btn.setOnClickListener(this::onButtonClick);
        }
    }

    private void onButtonClick(View view) {
        Button button = (Button) view;
        String text = button.getText().toString();

        switch (text) {
            case "AC":
                currentInput = "";
                operator = "";
                txtResult.setText("0");
                break;

            case "⌫":
                if (!currentInput.isEmpty()) {
                    currentInput = currentInput.substring(0, currentInput.length() - 1);
                }
                txtResult.setText(currentInput.isEmpty() ? "0" : currentInput);
                break;

            case "=":
                if (!operator.isEmpty() && !currentInput.isEmpty()) {
                    double secondOperand = calculator.parseInput(currentInput);
                    String result = calculator.calculate(firstOperand, secondOperand, operator);
                    currentInput = result.replace('.', ',');
                    txtResult.setText(currentInput);
                    operator = "";
                }
                break;

            case "+": case "−": case "×": case "÷":
                if (!currentInput.isEmpty()) {
                    firstOperand = calculator.parseInput(currentInput);
                    operator = text;
                    currentInput = "";
                }
                break;

            case "%":
                if (!currentInput.isEmpty()) {
                    double val = calculator.parseInput(currentInput);
                    currentInput = calculator.percentage(val).replace('.', ',');
                    txtResult.setText(currentInput);
                }
                break;

            case "+/−":
                if (!currentInput.isEmpty()) {
                    double val = calculator.parseInput(currentInput);
                    currentInput = calculator.changeSign(val).replace('.', ',');
                    txtResult.setText(currentInput);
                }
                break;

            case ",":
                if (!currentInput.contains(",")) {
                    currentInput += ",";
                    txtResult.setText(currentInput);
                }
                break;

            default:
                currentInput += text;
                txtResult.setText(currentInput);
                break;
        }
    }
}
