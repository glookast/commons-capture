package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum NotificationType
{
    @JsonProperty("UPDATE")
    UPDATE,
    @JsonProperty("DELETE")
    DELETE
}
