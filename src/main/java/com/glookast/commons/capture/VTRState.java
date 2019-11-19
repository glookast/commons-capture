package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum VTRState
{
    @JsonProperty("UNKNOWN")
    UNKNOWN,
    @JsonProperty("RECORDING")
    RECORDING,
    @JsonProperty("PLAYING")
    PLAYING,
    @JsonProperty("PAUSED")
    PAUSED,
    @JsonProperty("STOPPED")
    STOPPED,
    @JsonProperty("FAST_FORWARD")
    FAST_FORWARD,
    @JsonProperty("REWIND")
    REWIND,
    @JsonProperty("SHUTTLE_FORWARD")
    SHUTTLE_FORWARD,
    @JsonProperty("SHUTTLE_REVERSE")
    SHUTTLE_REVERSE,
    @JsonProperty("JOG_FORWARD")
    JOG_FORWARD,
    @JsonProperty("JOG_REVERSE")
    JOG_REVERSE,
    @JsonProperty("VAR_FORWARD")
    VAR_FORWARD,
    @JsonProperty("VAR_REVERSE")
    VAR_REVERSE,
    @JsonProperty("PREROLL")
    PREROLL,
    @JsonProperty("CUE_UP_COMPLETED")
    CUE_UP_COMPLETED,
    @JsonProperty("END_OF_TAPE")
    END_OF_TAPE,
    @JsonProperty("EJECTING")
    EJECTING,
    @JsonProperty("CASSETTE_OUT")
    CASSETTE_OUT
}
