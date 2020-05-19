package com.glookast.commons.capture.dto.gang;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder(toBuilder = true)
@EqualsAndHashCode
@Setter(AccessLevel.NONE)
public class GangChannelDTO {
    private Integer id;
    private String address;
    @Builder.Default
    private Set<GangChannelDTO> slaves = null;
    @Builder.Default
    private Boolean enabled = null;
    private Boolean local;

    public GangChannelDTO clone() {
        return this.toBuilder().build();
    }

}