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
) {

    public User(String uuid, String name, String email, String phoneNumber, String bankAccountNumber, Long dob, Long createdAt, String aadharCardNumber, String pan) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bankAccountNumber = bankAccountNumber;
        this.dob = dob;
        this.createdAt = createdAt;
        this.aadharCardNumber = aadharCardNumber;
        this.pan = pan;
    }
}
