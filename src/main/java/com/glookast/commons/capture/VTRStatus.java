package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.glookast.commons.timecode.TimecodeDuration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = VTRStatus.class)
public class VTRStatus
{
    protected VTRDeckType deckType;
    protected VTRState state;
    protected VTRStatusDetail detail;
    protected TimecodeDuration prerollDuration;

    public VTRStatus(VTRStatus vtrStatus)
    {
        deckType = vtrStatus.deckType != null ? new VTRDeckType(deckType) : null;
        state = vtrStatus.state;
        detail = vtrStatus.detail != null ? new VTRStatusDetail(detail) : null;
        prerollDuration = vtrStatus.prerollDuration;
    }
}
