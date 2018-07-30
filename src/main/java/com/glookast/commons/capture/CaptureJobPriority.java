package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CaptureJobPriority
{
    @JsonProperty("LOW")
    LOW,
    @JsonProperty("MEDIUM")
    MEDIUM,
    @JsonProperty("HIGH")
    HIGH,
    @JsonProperty("URGENT")
    URGENT,
    @JsonProperty("IMMEDIATE")
    IMMEDIATE
}
