package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.mycalculator.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    private double valueOne = Double.NaN;
    private double valueTwo;

    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        decimalFormat = new DecimalFormat("#.##########");

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etEditText.setText(binding.etEditText.getText() + ".");
            }
        });

        binding.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etEditText.setText(binding.etEditText.getText() + "0");
            }
        });

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etEditText.setText(binding.etEditText.getText() + "1");
            }
        });

        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etEditText.setText(binding.etEditText.getText() + "2");
            }
        });

        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etEditText.setText(binding.etEditText.getText() + "3");
            }
        });

        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etEditText.setText(binding.etEditText.getText() + "4");
            }
        });

        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etEditText.setText(binding.etEditText.getText() + "5");
            }
        });

        binding.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etEditText.setText(binding.etEditText.getText() + "6");
            }
        });

        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etEditText.setText(binding.etEditText.getText() + "7");
            }
        });

        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etEditText.setText(binding.etEditText.getText() + "8");
            }
        });

        binding.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etEditText.setText(binding.etEditText.getText() + "9");
            }
        });

        binding.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                binding.tvInfo.setText(decimalFormat.format(valueOne) + "+");
                binding.etEditText.setText(null);
            }
        });

        binding.btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                binding.tvInfo.setText(decimalFormat.format(valueOne) + "-");
                binding.etEditText.setText(null);
            }
        });

        binding.btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                binding.tvInfo.setText(decimalFormat.format(valueOne) + "*");
                binding.etEditText.setText(null);
            }
        });

        binding.btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                binding.tvInfo.setText(decimalFormat.format(valueOne) + "/");
                binding.etEditText.setText(null);
            }
        });

        binding.btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                binding.tvInfo.setText(binding.tvInfo.getText().toString() +
                        decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });

        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.etEditText.getText().length() > 0) {
                    CharSequence currentText = binding.etEditText.getText();
                    binding.etEditText.setText(currentText.subSequence(0, currentText.length()-1));
                }
                else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    binding.etEditText.setText("");
                    binding.tvInfo.setText("");
                }
            }
        });
    }

    private void computeCalculation() {
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(binding.etEditText.getText().toString());
            binding.etEditText.setText(null);

            if(CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if(CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if(CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if(CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        }
        else {
            try {
                valueOne = Double.parseDouble(binding.etEditText.getText().toString());
            }
            catch (Exception e){}
        }
    }
}