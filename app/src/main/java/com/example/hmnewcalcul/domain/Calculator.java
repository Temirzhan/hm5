package com.example.hmnewcalcul.domain;

import android.media.VolumeShaper;
import android.widget.Switch;

public class Calculator {

    private int result;
    public void operation(int argumentOne, int argumentTwo, Operation operation){
        switch(operation){
            case ADD:
                result = argumentOne + argumentTwo;
                break;
            case DIV:
                result = argumentOne - argumentTwo;
                break;
            case DIST:
                result = argumentOne / argumentTwo;
                break;
            case MULT:
                result = argumentOne * argumentTwo;
                break;
        }
    }

    public int getResult() {
        return result;
    }
}
