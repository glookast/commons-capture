package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = DescriptiveMetadata.class)
public class DescriptiveMetadata extends LinkedHashMap<String, String>
{
    public DescriptiveMetadata(int initialCapacity, float loadFactor)
    {
        super(initialCapacity, loadFactor);
    }

    public DescriptiveMetadata(int initialCapacity)
    {
        super(initialCapacity);
    }

    public DescriptiveMetadata()
    {
    }

    public DescriptiveMetadata(Map<? extends String, ? extends String> m)
    {
        super(m);
    }

    public DescriptiveMetadata(int initialCapacity, float loadFactor, boolean accessOrder)
    {
        super(initialCapacity, loadFactor, accessOrder);
    }
}
