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
    protected int width;
    protected int height;
    protected BufferFieldOrder bufferFieldOrder;
    protected Rational frameRate;
    protected Rational aspectRatio;
    protected PixelFormat pixelFormat;

    public PictureFormat(PictureFormat pictureFormat)
    {
        this.width = pictureFormat.width;
        this.height = pictureFormat.height;
        this.bufferFieldOrder = pictureFormat.bufferFieldOrder;
        this.frameRate = pictureFormat.frameRate != null ? new Rational(pictureFormat.frameRate) : null;
        this.aspectRatio = pictureFormat.aspectRatio != null ? new Rational(pictureFormat.aspectRatio) : null;
        this.pixelFormat = pictureFormat.pixelFormat;
    }
}
