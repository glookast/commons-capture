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
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
public class SystemTestResult
{
    private Boolean storageSystemConnectionOK;
    private Boolean storageSystemAuthenticationOK;
    private Boolean storageSystemPathExists;
    private Boolean storageSystemPathIsFolder;
    private Boolean storageSystemPathCanRead;
    private Boolean storageSystemPathCanWrite;
    private Boolean storageSystemPathCanExecute;
    private Boolean metadataSystemConnectionOK;
    private Boolean metadataSystemAuthenticationOK;
    private Boolean metadataSystemRootFolderExists;
    private Boolean metadataSystemFolderExists;
}
