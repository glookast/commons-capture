package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.glookast.commons.timecode.Timecode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = Locator.class)
public class Locator
{
    protected Timecode timecode;
    protected LocatorColor color;
    protected String message;
    protected String notes;

    public Locator(Locator locator)
    {
        this.timecode = locator.timecode;
        this.color = locator.color;
        this.message = locator.message;
        this.notes = locator.notes;
    }

    @JsonIgnore
    public String getMessageNotes()
    {
        if (notes == null || notes.isEmpty()) {
            return message;
        } else if (message == null || message.isEmpty()) {
            return notes;
        } else {
            return message + ": " + notes;
        }
    }
}
