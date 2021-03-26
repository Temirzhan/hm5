package com.example.hmnewcalcul.domain;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ArgumentCount {
    private ArrayDeque<Integer> argumentOne;
    private ArrayDeque<Integer> argumentTwo;
    private Operation operation;

    public ArgumentCount() {
        this.operation = null;
        argumentTwo = new ArrayDeque<Integer>(10);
        argumentOne = new ArrayDeque<Integer>(10);
    }

    public void setArgument(int i){
        if(!isOperationNotEqual())
            clearAll();
        if(!isOperationNotNull())
            argumentOne.add(i);
        else
            argumentTwo.add(i);
    }



    public double getArgument() {
        if(operation==null){
            return getArray(argumentOne);
        }else {
            return getArray(argumentTwo);
        }
    }

    public int getArgumentOne(){
        return getArray(argumentOne);
    }

    public int getArgumentTwo(){
        return getArray(argumentTwo);
    }

    public Operation getOperation() {
        return operation;
    }

    public int getArray(ArrayDeque<Integer> argument) {
        int count;
        ArrayDeque<Integer> clone = new ArrayDeque<>(argument);
        count = clone.poll();
        for (int i = 0; i <clone.size(); i++) {
            count = (count*10) +  clone.poll();
        }
        return count;
    }
    public void clearTwo(){
        argumentTwo.clear();
    }

    public void clearAll(){
        argumentOne.clear();
        argumentTwo.clear();
        operation = null;
    }

    public void setArgumentOne(int result){
        while (result != 0){
            argumentOne.add(result%10);
            result/=10;
        }
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public boolean isOperationNotEqual(){
        if(operation != Operation.EQUAL){
            return true;
        }
        return false;
    }

    public  boolean isOperationNotNull(){
        if(operation != null){
            return true;
        }
        return false;
    }

}
