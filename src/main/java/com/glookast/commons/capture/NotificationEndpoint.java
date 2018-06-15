package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = NotificationEndpoint.class)
public class NotificationEndpoint
{
    protected UUID id;
    protected URL url;

    public NotificationEndpoint(NotificationEndpoint notificationEndpoint)
    {
        id = notificationEndpoint.id;
        url = notificationEndpoint.url;
    }
}
