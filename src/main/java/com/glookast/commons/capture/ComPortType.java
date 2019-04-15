package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ComPortType
{
    @JsonProperty("SERIAL")
    SERIAL,
    @JsonProperty("PARALLEL")
    PARALLEL,
    @JsonProperty("I2C")
    I2C,
    @JsonProperty("RS485")
    RS485,
    @JsonProperty("RAW")
    RAW
}
