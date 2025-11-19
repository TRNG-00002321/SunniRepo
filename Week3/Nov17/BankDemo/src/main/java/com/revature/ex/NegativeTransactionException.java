package com.revature.ex;

public class NegativeTransactionException extends RuntimeException{
    public NegativeTransactionException(String message){
        super(message);
    }
}
