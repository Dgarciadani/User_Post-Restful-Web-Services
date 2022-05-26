package com.grego.web_restful_services.exeptions;

import lombok.Data;

import java.time.DateTimeException;

public class ExceptionResponse {
    private DateTimeException dateTimeException;
    private String errorMessage;
    private String detailMessage;


    public ExceptionResponse(DateTimeException dateTimeException, String errorMessage, String detailMessage) {
        super();
        this.dateTimeException = dateTimeException;
        this.errorMessage = errorMessage;
        this.detailMessage = detailMessage;
    }

    public DateTimeException getDateTimeException() {
        return dateTimeException;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getDetailMessage() {
        return detailMessage;
    }
}
