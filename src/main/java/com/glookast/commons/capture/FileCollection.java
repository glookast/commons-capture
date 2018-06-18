package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = FileCollection.class)
public class FileCollection
{
    protected UUID videoFormatId;
    protected UUID audioFormatId;
    protected UUID containerFormatId;

    protected List<String> files;

    public FileCollection(FileCollection fileCollection)
    {
        this.videoFormatId = fileCollection.videoFormatId;
        this.audioFormatId = fileCollection.audioFormatId;
        this.containerFormatId = fileCollection.containerFormatId;
        this.files = fileCollection.files != null ? new ArrayList<>(fileCollection.files) : null;
    }
}
