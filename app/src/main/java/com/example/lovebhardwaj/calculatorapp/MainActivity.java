package com.example.lovebhardwaj.calculatorapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Reference variable for the layout widgets
    private EditText resultEditText;
    private EditText newNumberEditText;
    private TextView operatorDisplayTextView;

    //Three variables to store the numbers and the operator
    private Double operand1;
    private Double operand2;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Need to set the reference variables to layout variables

        resultEditText = (EditText) findViewById(R.id.resultEditText); //Need to type cast as the returned value is a view
        newNumberEditText = (EditText) findViewById(R.id.newNumberEditText);
        operatorDisplayTextView = (TextView) findViewById(R.id.operationsTextView);

        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);

        Button buttonDot = (Button) findViewById(R.id.buttonDecimal);

        Button buttonEquals = (Button) findViewById(R.id.buttonEquals);
        Button buttonDivide = (Button) findViewById(R.id.buttonDivide);
        Button buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        Button buttonAdd = (Button) findViewById(R.id.buttonAddition);
        Button buttonMinus = (Button) findViewById(R.id.buttonMinus);

        //We will have a separate onClick listener for numbers and decimal
        //It will update the lower textView or newNumberTextView to show whatever was clicked by the user

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v; //Need to cast the view we get into a button
                newNumberEditText.append(button.getText().toString());

            }
        };

        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        buttonDot.setOnClickListener(listener);

        //Could use a list and run a loop to assign listener but wont save any lines of code here

        //New onClickListener for operators and operations
        View.OnClickListener opListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                operator = b.getText().toString();
                operatorDisplayTextView.setText(operator);
                resultEditText.append(newNumberEditText.getText().toString());
                newNumberEditText.getText().clear();
            }
        };

        buttonAdd.setOnClickListener(opListener);
        buttonMinus.setOnClickListener(opListener);
        buttonMultiply.setOnClickListener(opListener);
        buttonDivide.setOnClickListener(opListener);


        View.OnClickListener calculateListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( !resultEditText.getText().toString().isEmpty() && !newNumberEditText.getText().toString().isEmpty()
                        && !operatorDisplayTextView.getText().toString().isEmpty()) {
                    operand1 = Double.parseDouble(resultEditText.getText().toString());
                    operand2 = Double.parseDouble(newNumberEditText.getText().toString());
                    operator = operatorDisplayTextView.getText().toString();
                    String result = performOperation(operand1, operand2, operator);
                    resultEditText.setText(result);
                    newNumberEditText.getText().clear();
                }else {
//                    Toast.makeText(MainActivity.this, "Need two operands to perform operation", Toast.LENGTH_SHORT).show();
//                    resultEditText.append(operatorDisplayTextView.getText().toString());
                    resultEditText.append(newNumberEditText.getText().toString());
                }
            }
        };
        buttonEquals.setOnClickListener(calculateListener);
    }

    private String performOperation(Double value1, Double value2, String op){
        Double result;
        String output;
        switch (op){
            case "+":
                result = value1 + value2;
                output = result.toString();
                return output;
            case "-":
                result = value1 - value2;
                output = result.toString();
                return output;

            case "/":
                result = value1 / value2;
                output = result.toString();
                return output;

            case "*":
                result = value1 * value2;
                output = result.toString();
                return output;

            default:
                return null;
        }
    }
}
