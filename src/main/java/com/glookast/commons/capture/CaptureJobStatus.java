package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CaptureJobStatus
{
    @JsonProperty("NEW")
    NEW,
    @JsonProperty("QUEUED")
    QUEUED,
    @JsonProperty("SCHEDULED")
    SCHEDULED,
    @JsonProperty("RECORDING")
    RECORDING,
    @JsonProperty("RECORDING_TRANSFER_FAILED")
    RECORDING_TRANSFER_FAILED,
    @JsonProperty("TRANSFERRING")
    TRANSFERRING,
    @JsonProperty("PAUSED")
    PAUSED,
    @JsonProperty("TRANSFER_FAILED")
    TRANSFER_FAILED,
    @JsonProperty("COMPLETED")
    COMPLETED,
    @JsonProperty("CANCELED")
    CANCELED,
    @JsonProperty("STOPPED")
    STOPPED,
    @JsonProperty("FAILED")
    FAILED,
    @JsonProperty("CLEANED")
    CLEANED,
    @JsonProperty("UNKNOWN")
    UNKNOWN
}
