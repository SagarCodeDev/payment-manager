package com.project.payment.payments.models;

public record User(
        String uuid,
        String name,
        String email,
        String phoneNumber,
        String bankAccountNumber,
        Long dob,
        Long createdAt,
        String aadharCardNumber,
        String pan
){

}
