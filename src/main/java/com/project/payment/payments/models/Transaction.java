package com.project.payment.payments.models;

public record Transaction(
        String uuid,
        Long time,
        String amount,
        String senderId,
        String receiverId,
        String sendersAccount,
        String receiverAccount,
        String message
) {
}
