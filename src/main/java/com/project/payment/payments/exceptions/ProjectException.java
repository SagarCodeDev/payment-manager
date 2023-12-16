package com.project.payment.payments.exceptions;

public class ProjectException extends Exception{
    ProjectException(){
        super();
    }

    ProjectException(String message){
        super(message);
    }

    ProjectException(String message, Throwable error){
        super(message, error);
    }
}
