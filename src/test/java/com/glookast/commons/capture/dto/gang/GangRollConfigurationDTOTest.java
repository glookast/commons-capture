package com.glookast.commons.capture.dto.gang;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.glookast.commons.capture.ApiResponseObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GangRollConfigurationDTOTest {

    @Test
    public void toJSON() throws JsonProcessingException {

        GangRollConfigurationDTO dto = new GangRollConfigurationDTO();
        dto.gangs.add(GangChannelDTO.builder().id(1).address("192.168.5.128").enabled(false).local(true).slaves(
                Stream.of(GangChannelDTO.builder().id(2).address("192.168.5.128").local(true).build()).collect(Collectors.toSet())
        ).build());

        ObjectMapper objectMapper = ApiResponseObjectMapper.getMapper();
        String json = objectMapper.writeValueAsString(dto);
        GangRollConfigurationDTO parsedDTO = objectMapper.readValue(json, GangRollConfigurationDTO.class);
        assertEquals(dto, parsedDTO);

    }

    @Test
    public void parseJSON() throws IOException {

        String json = "{\n" +
                "    \"@type\" : \"GangRollConfigurationDTO\",\n" +
                "    \"gangs\" : [ {\n" +
                "      \"id\" : 1,\n" +
                "      \"address\" : \"192.168.5.128\",\n" +
                "      \"slaves\" : [ {\n" +
                "        \"id\" : 2,\n" +
                "        \"address\" : \"192.168.5.128\",\n" +
                "        \"local\" : true\n" +
                "      } ],\n" +
                "      \"enabled\" : false,\n" +
                "      \"local\" : true\n" +
                "    } ]\n" +
                "  }";

        ObjectMapper objectMapper = ApiResponseObjectMapper.getMapper();

        GangRollConfigurationDTO dto = objectMapper.readValue(json, GangRollConfigurationDTO.class);

        assertNotNull(dto);
        assertEquals(1, dto.gangs.size());
        assertEquals(1, dto.gangs.iterator().next().getId());
        assertEquals("192.168.5.128", dto.gangs.iterator().next().getAddress());

    }

}