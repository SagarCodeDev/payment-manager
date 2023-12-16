package com.project.payment.payments.exceptions;

public class NotAllowedException extends ProjectException{
    public NotAllowedException(){
        super();
    }

    public NotAllowedException(String message){
        super(message);
    }

    public NotAllowedException(String message, Throwable error){
        super(message, error);
    }
}
