package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = Notification.class)
public class Notification
{
    protected NotificationType type;
    protected URL url;
    protected JsonNode content;

    @JsonIgnore
    public String getContentType()
    {
        if (content != null) {
            JsonNode typeProperty = content.get("@type");
            if (typeProperty != null && typeProperty.isTextual()) {
                return typeProperty.asText();
            }
        }
        return "";
    }

    public <T> T getContent(ObjectMapper objectMapper, Class<T> valueType) throws JsonProcessingException
    {
        return objectMapper.treeToValue(content, valueType);
    }

    public void setContent(ObjectMapper objectMapper, Object content)
    {
        this.content = objectMapper.valueToTree(content);
    }
}
