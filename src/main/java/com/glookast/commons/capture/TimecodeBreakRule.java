package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TimecodeBreakRule
{
    @JsonProperty("IGNORE")
    IGNORE,
    @JsonProperty("STOP")
    STOP,
    @JsonProperty("CREATE_NEW_CLIP")
    CREATE_NEW_CLIP
}
