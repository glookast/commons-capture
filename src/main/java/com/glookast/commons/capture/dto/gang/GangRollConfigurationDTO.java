package com.glookast.commons.capture.dto.gang;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = GangRollConfigurationDTO.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Setter(AccessLevel.NONE)
@EqualsAndHashCode
public class GangRollConfigurationDTO {

    public Set<GangChannelDTO> gangs = new HashSet<>();

}
