package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvidCaptureJobProperties
{
    protected String masterMobId;
    protected String sourceMobId;
    protected String interplaySubfolder;
    protected Boolean interplaySplitResolutions;
}
