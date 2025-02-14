package com.ukgG3.JobPosting.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class StringtoIntegerConverter implements AttributeConverter<List<Integer>, String> {

    private static final String SPLIT_CHAR = ",";

    @Override
    public String convertToDatabaseColumn(List<Integer> attribute) {
        return attribute != null ? attribute.stream().map(String::valueOf).collect(Collectors.joining(SPLIT_CHAR)) : "";
    }

    @Override
    public List<Integer> convertToEntityAttribute(String dbData) {
        return dbData != null ? Arrays.stream(dbData.split(SPLIT_CHAR)).map(Integer::valueOf).collect(Collectors.toList()) : null;
    }

}



