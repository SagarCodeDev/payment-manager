package com.project.payment.payments.exceptions;

import com.project.payment.payments.utils.ResponseHandler;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionMapper extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ProjectException.class)
    public ResponseEntity<?> handleApplicationException(
            final ProjectException exception, final HttpServletRequest request
    ) {

        var response = ResponseHandler.error(
                exception.getMessage()
        );
        return new ResponseEntity<>(response, response.getStatusCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUnknownException(
            final Exception exception, final HttpServletRequest request
    ) {
        var response = ResponseHandler.error(
               "Internal Server Error"
        );
        return new ResponseEntity<>(response, response.getStatusCode());
    }
}
