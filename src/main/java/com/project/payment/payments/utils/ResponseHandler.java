package com.project.payment.payments.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(Object response, HttpStatus statusCode, String error){
        Map<String,Object> httpResponse = new HashMap<>();
        httpResponse.put("data", response);
        httpResponse.put("code", statusCode.value());
        httpResponse.put("error", error);
        return new ResponseEntity<>(httpResponse, statusCode);
    }

    public static  ResponseEntity<Object> ok(Object response){
        return generateResponse(response, HttpStatus.OK, null);
    }

    public static ResponseEntity<Object> error(Object response){
        return generateResponse(response, HttpStatus.BAD_REQUEST, null);
    }
}
