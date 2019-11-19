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
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = VTRDeckType.class)
public class VTRDeckType
{
    protected String manufacturer;
    protected String model;
    protected String description;
    protected String code;

    public VTRDeckType(VTRDeckType vtrDeckType)
    {
        this.manufacturer = vtrDeckType.manufacturer;
        this.model = vtrDeckType.model;
        this.description = vtrDeckType.description;
        this.code = vtrDeckType.code;
    }
}