package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.glookast.commons.base.Rational;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = PictureFormat.class)
public class PictureFormat
{
    private int width;
    private int height;
    private BufferFieldOrder bufferFieldOrder;
    private Rational frameRate;
    private Rational aspectRatio;
    private PixelFormat pixelFormat;
}
