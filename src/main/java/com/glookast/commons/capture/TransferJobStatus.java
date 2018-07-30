package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TransferJobStatus
{
    @JsonProperty ("STARTING")
    STARTING,
    @JsonProperty ("RUNNING")
    RUNNING,
    @JsonProperty ("PAUSED")
    PAUSED,
    @JsonProperty ("FAILED")
    FAILED,
    @JsonProperty ("ABORTED")
    ABORTED,
    @JsonProperty ("FINISHED")
    FINISHED,
    @JsonProperty ("IDLE")
    IDLE
}
