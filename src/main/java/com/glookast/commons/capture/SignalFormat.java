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
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = SignalFormat.class)
public class SignalFormat
{
    protected PictureFormat picture;
    protected SoundFormat sound;
    protected boolean ancDataPresent;

    public SignalFormat(SignalFormat signalFormat)
    {
        this.picture = signalFormat.picture != null ? new PictureFormat(signalFormat.picture) : null;
        this.sound = signalFormat.sound != null ? new SoundFormat(signalFormat.sound) : null;
        this.ancDataPresent = signalFormat.ancDataPresent;
    }
}
