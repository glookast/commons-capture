package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = ComPort.class)
public class ComPort
{
    protected String name;
    protected ComPortType portType;
    protected boolean isOwned;
    protected String ownedBy;

    public ComPort(ComPort comPort)
    {
        this.name = comPort.name;
        this.portType = comPort.portType;
        this.isOwned = comPort.isOwned;
        this.ownedBy = comPort.ownedBy;
    }
}
