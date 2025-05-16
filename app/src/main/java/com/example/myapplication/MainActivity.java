package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_main);
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    });

    // Bind views
    Button btnPlus = findViewById(R.id.btnPlus);
    Button btnMinus = findViewById(R.id.btnMinus);
    Button btnMultiply = findViewById(R.id.btnMultiply);
    Button btnDivide = findViewById(R.id.btnDivide);

    EditText txtNumber1 = findViewById(R.id.txtInputNumber1);
    EditText txtNumber2 = findViewById(R.id.txtInputNumber2);

    TextView txtResult = findViewById(R.id.txtResult);

    // Set click listeners
    btnPlus.setOnClickListener(v -> calculateAndShow(txtNumber1, txtNumber2, txtResult, "+"));
    btnMinus.setOnClickListener(v -> calculateAndShow(txtNumber1, txtNumber2, txtResult, "-"));
    btnMultiply.setOnClickListener(v -> calculateAndShow(txtNumber1, txtNumber2, txtResult, "*"));
    btnDivide.setOnClickListener(v -> calculateAndShow(txtNumber1, txtNumber2, txtResult, "/"));
}

private void calculateAndShow(EditText txt1, EditText txt2, TextView resultView, String op) {
    try {
        double num1 = Double.parseDouble(txt1.getText().toString().trim());
        double num2 = Double.parseDouble(txt2.getText().toString().trim());
        resultView.setText(Calculate(num1, num2, op));
    } catch (NumberFormatException e) {
        resultView.setText("Please enter valid numbers");
    }
}

public String Calculate(double num1, double num2, String operation) {
    double result;

    switch (operation) {
        case "+":
            result = num1 + num2;
            break;
        case "-":
            result = num1 - num2;
            break;
        case "*":
            result = num1 * num2;
            break;
        case "/":
            if (num2 == 0) {
                return "Cannot divide by zero";
            }
            result = num1 / num2;
            break;
        default:
            return "Unknown operation";
    }

    if (result == Math.floor(result)) {
        return String.valueOf((int) result);
    } else {
        return String.valueOf(result);
    }
}
}