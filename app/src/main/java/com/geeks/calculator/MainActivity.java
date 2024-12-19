package com.geeks.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private double a, b;
    private boolean isOperationClick;
    private String operation;
    private Button hiddenButton;
    private double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        textView = findViewById(R.id.text_view);
        hiddenButton = findViewById(R.id.hiddenButton);

        hiddenButton.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

    }



    public void onNumberClick(View view) {
        String text = ((MaterialButton) view).getText().toString();
        if (text.equals("AC")) {
            textView.setText("0");
            a = 0;
            b = 0;
        } else if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(text);
        } else {
            textView.append(text);
        }
       hiddenButton.setVisibility(View.INVISIBLE);

        hiddenButton.setVisibility(View.INVISIBLE);
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        if (view.getId() == R.id.btn_plus) {
            a = Double.parseDouble(textView.getText().toString());
            operation = "+";
        } else if (view.getId() == R.id.btn_minus) {
            a = Double.parseDouble(textView.getText().toString());
            operation = "-";
        } else if (view.getId() == R.id.btn_x) {
            a = Double.parseDouble(textView.getText().toString());
            operation = "x";
        } else if (view.getId() == R.id.btn_division) {
            a = Double.parseDouble(textView.getText().toString());
            operation = "/";
        } else if (view.getId() == R.id.btn_procent) {
            a = Double.parseDouble(textView.getText().toString());
            operation = "%";
        } else if (view.getId() == R.id.btn_equal) {
            b = Double.parseDouble(textView.getText().toString());

            double result = 0;
            if ("+".equals(operation)) {
                result = a + b;
            } else if ("-".equals(operation)) {
                result = a - b;
            } else if ("x".equals(operation)) {
                result = a * b;
            } else if ("%".equals(operation)) {
                result = a / 100;
                if (view.getId() == R.id.btn_procent) {
                    if (result == (int) result) {
                        textView.setText(String.valueOf((int) result));
                    } else {
                        textView.setText(String.valueOf(result));
                    }
                }
            } else if ("/".equals(operation)) {
                if (b != 0) {
                    result = a / b;
                } else {
                    textView.setText("Ошибка");
                    return;
                }
            }

            if (result == (int) result) {
                textView.setText(String.valueOf((int) result));
            } else {
                textView.setText(String.valueOf(result));
            }


            hiddenButton.setVisibility(View.VISIBLE);
            hiddenButton.setEnabled(true);

        }
        isOperationClick = true;
    }



}