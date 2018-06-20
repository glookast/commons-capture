package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BufferFieldOrder
{
    @JsonProperty("UNKNOWN")
    UNKNOWN,
    @JsonProperty("INTERLACED_LOWER_FIELD_FIRST")
    INTERLACED_LOWER_FIELD_FIRST,
    @JsonProperty("INTERLACED_UPPER_FIELD_FIRST")
    INTERLACED_UPPER_FIELD_FIRST,
    @JsonProperty("PROGRESSIVE_FRAME")
    PROGRESSIVE_FRAME,
    @JsonProperty("PROGRESSIVE_SEGMENTED_FRAME")
    PROGRESSIVE_SEGMENTED_FRAME
}
