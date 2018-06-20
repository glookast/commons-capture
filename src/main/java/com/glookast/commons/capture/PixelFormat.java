package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PixelFormat
{
    @JsonProperty("UNKNOWN")
    UNKNOWN,
    @JsonProperty("UYVY")
    UYVY,
    @JsonProperty("V210")
    V210,
    @JsonProperty("RGB24")
    RGB24
}
