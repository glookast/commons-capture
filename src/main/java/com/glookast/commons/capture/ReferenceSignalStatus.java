package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ReferenceSignalStatus
{
    @JsonProperty("UNKNOWN")
    UNKNOWN,
    @JsonProperty("NO_SIGNAL")
    NO_SIGNAL,
    @JsonProperty("WRONG_SIGNAL")
    WRONG_SIGNAL,
    @JsonProperty("UNLOCKED")
    UNLOCKED,
    @JsonProperty("OK")
    OK
}
