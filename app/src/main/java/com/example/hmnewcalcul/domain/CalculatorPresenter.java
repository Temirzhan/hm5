package com.example.hmnewcalcul.domain;

import android.view.View;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textview.MaterialTextView;

public class CalculatorPresenter {

    private com.example.hmnewcalcul.domain.Calculator calculator = new com.example.hmnewcalcul.domain.Calculator();
    private ArgumentCount argumentCount = new ArgumentCount();
    private MaterialTextView text;

    public void setText(MaterialTextView text) {
        this.text = text;
    }

    public void pressButton(View button, final int num){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(num);
                setText(argumentCount.getArgument());
            }
        });
    }
    public void pressButton(View button, Operation operation){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation(operation);
            }
        });
    }


    private void setNumber(final int num){
        argumentCount.setArgument(num);
    }



    private void setOperation(Operation operation){
        if (operation == Operation.EQUAL) {
            if(argumentCount.isOperationNotEqual()&& argumentCount.isOperationNotNull()){
                calculator.operation(argumentCount.getArgumentOne(),argumentCount.getArgumentTwo(),argumentCount.getOperation());
                setText(calculator.getResult());
                argumentCount.clearAll();
                argumentCount.setArgumentOne(calculator.getResult());
                argumentCount.setOperation(operation);
            }else argumentCount.clearAll();


        }else if(operation == Operation.CLEAR){
            argumentCount.clearAll();
            setText(0);
        }
        else {
            argumentCount.setOperation(operation);
        }
    }

    public void setText( double result){
        text.setText(result +"");
    }
}
