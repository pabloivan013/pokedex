package com.challenge.pokedex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    ResponseEntity<?> handleStatusException(ResponseStatusException ex, WebRequest request) {
        logger.error("Error ResponseStatusException: " + ex.getMessage() , ex);
        return handleResponseStatusException(ex, request);
    }

    @ExceptionHandler(WebClientResponseException.class)
    ResponseEntity<?> handleWebClientResponseException(WebClientResponseException ex, WebRequest request) {
        logger.error("Error WebClientResponseException: " + ex.getMessage(), ex);
        return handleWebClientException(ex, request);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<?> handleAllExceptions(Exception ex, WebRequest request) {
        logger.error("Error Exception: " + ex.getMessage(), ex);
        return handleEveryException(ex, request);
    }

    protected ResponseEntity<RestResponse> handleWebClientException(WebClientResponseException ex, WebRequest request) {
        return RestResponse.builder()
                .status(ex.getStatusCode().value())
                .message(ex.getMessage())
                .path(getPath(request))
                .entity();
    }

    protected ResponseEntity<RestResponse> handleResponseStatusException(ResponseStatusException ex, WebRequest request) {
        return RestResponse.builder()
                .exception(ex)
                .path(getPath(request))
                .entity();
    }

    protected ResponseEntity<RestResponse> handleEveryException(Exception ex, WebRequest request) {
        return RestResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message("Server encountered an error")
                .path(getPath(request))
                .entity();
    }

    private String getPath(WebRequest request) {
        return request.getDescription(false).substring(4);
    }

}