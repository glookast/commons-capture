package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = ApiError.class)
public class ApiError
{
    protected OffsetDateTime timestamp;
    protected int status;
    protected String error;
    protected String message;
    protected String detail;
    protected String path;

    public ApiError(ApiError apiError)
    {
        this.timestamp = apiError.timestamp;
        this.status = apiError.status;
        this.error = apiError.error;
        this.message = apiError.message;
        this.detail = apiError.detail;
        this.path = apiError.path;
    }
}
