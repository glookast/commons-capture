package com.glookast.commons.capture;

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
        this.timecode = locator.timecode != null ? new Timecode(locator.timecode) : null;
        this.color = locator.color;
        this.message = locator.message;
        this.notes = locator.notes;
    }
}
