package com.example.aula3calculadoraapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private double num1 = Double.NaN;
    private double num2 = Double.NaN;
    private String operador = "";

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

        TextView resultText = findViewById(R.id.resultText);

        Button acButton = findViewById(R.id.acButton);
        Button bkButton = findViewById(R.id.bkButton);
        Button porcentButton = findViewById(R.id.porcentButton);
        Button divButton = findViewById(R.id.divButton);

        Button sevenButton = findViewById(R.id.sevenButton);
        Button eightButton = findViewById(R.id.eightButton);
        Button nineButton = findViewById(R.id.nineButton);
        Button multButton = findViewById(R.id.multButton);

        Button fourButton = findViewById(R.id.fourButton);
        Button fiveButton = findViewById(R.id.fiveButton);
        Button sixButton = findViewById(R.id.sixButton);
        Button subButton = findViewById(R.id.subButton);

        Button oneButton = findViewById(R.id.oneButton);
        Button twoButton = findViewById(R.id.twoButton);
        Button threeButton = findViewById(R.id.threeButton);
        Button plusButton = findViewById(R.id.plusButton);

        Button zeroButton = findViewById(R.id.zeroButton);
        Button equalsButton = findViewById(R.id.equalsButton);

        acButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText("");
                num1 = Double.NaN;
                num2 = Double.NaN;
                operador = "";
            }
        });

        bkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = resultText.getText().toString();
                if (!currentText.isEmpty()) {
                    String newText = currentText.substring(0, currentText.length() - 1);
                    resultText.setText(newText);
                }
            }
        });

        porcentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador = "%";
                String currentText = resultText.getText().toString();
                if (!currentText.isEmpty()) {
                    num1 = Double.parseDouble(currentText);
                    resultText.setText("");
                }
            }
        });

        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador = "/";
                String currentText = resultText.getText().toString();
                if (!currentText.isEmpty()) {
                    num1 = Double.parseDouble(currentText);
                    resultText.setText("");
                }
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador = "+";
                String currentText = resultText.getText().toString();
                if (!currentText.isEmpty()) {
                    num1 = Double.parseDouble(currentText);
                    resultText.setText("");
                }
            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador = "-";
                String currentText = resultText.getText().toString();
                if (!currentText.isEmpty()) {
                    num1 = Double.parseDouble(currentText);
                    resultText.setText("");
                }
            }
        });

        multButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador = "*";
                String currentText = resultText.getText().toString();
                if (!currentText.isEmpty()) {
                    num1 = Double.parseDouble(currentText);
                    resultText.setText("");
                }
            }
        });

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("0");
            }
        });

        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("1");
            }
        });

        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("2");
            }
        });

        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("3");
            }
        });

        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("4");
            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("5");
            }
        });

        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("6");
            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("7");
            }
        });

        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("8");
            }
        });

        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("9");
            }
        });

        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Double.isNaN(num1)) {
                    String currentText = resultText.getText().toString();
                    if (!currentText.isEmpty()) {
                        num2 = Double.parseDouble(currentText);
                        double resultado = calcular();
                        resultText.setText(String.valueOf(resultado));
                        num1 = Double.NaN;
                        num2 = Double.NaN;
                    }
                }
            }
        });
    }

    private double calcular() {
        double resultado = Double.NaN;
        if (!Double.isNaN(num2)) {
            switch (operador) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0)
                        resultado = num1 / num2;
                    else
                        resultado = Double.NaN;
                    break;
                case "%":
                    resultado = num1 * (num2 / 100f);
                    break;
            }
        }
        return resultado;
    }
}
