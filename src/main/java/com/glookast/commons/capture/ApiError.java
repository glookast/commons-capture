package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = ApiError.class)
@Builder(toBuilder = true)

@Setter(AccessLevel.NONE)
public class ApiError {
    @Builder.Default
    @NonNull
    protected OffsetDateTime timestamp = OffsetDateTime.now();
    protected int status;
    @NonNull
    protected String error;
    protected String message;
    protected String detail;
    @NonNull
    protected String path;
    @NonNull
    protected String method;

    public ApiError(ApiError apiError) {
        this.timestamp = apiError.timestamp;
        this.status = apiError.status;
        this.error = apiError.error;
        this.message = apiError.message;
        this.detail = apiError.detail;
        this.path = apiError.path;
        this.method = apiError.method;
    }

}
