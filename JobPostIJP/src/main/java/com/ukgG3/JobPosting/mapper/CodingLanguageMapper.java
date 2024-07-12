package com.ukgG3.JobPosting.mapper;

import com.ukgG3.JobPosting.dto.CodingLanguageDto;
import com.ukgG3.JobPosting.entity.CodingLanguage;

public class CodingLanguageMapper {

    public static CodingLanguageDto mapToCodingLanguageDto(CodingLanguage codingLanguage, CodingLanguageDto codingLanguageDto) {

        codingLanguageDto.setLangName(codingLanguage.getLangName());
        return codingLanguageDto;
    }

    public static CodingLanguage mapToCodingLanguage(CodingLanguageDto codingLanguageDto, CodingLanguage codingLanguage) {

        codingLanguage.setLangName(codingLanguageDto.getLangName());
        return codingLanguage;
    }
}
