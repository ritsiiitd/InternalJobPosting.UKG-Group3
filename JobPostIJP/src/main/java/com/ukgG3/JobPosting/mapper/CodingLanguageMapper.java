package com.ukgG3.JobPosting.mapper;

import com.ukgG3.JobPosting.dto.CodingLanguageDto;
import com.ukgG3.JobPosting.entity.CodingLanguage;

public class CodingLanguageMapper {

    public static CodingLanguageDto mapToCodingLanguageDto(CodingLanguage codingLanguage, CodingLanguageDto codingLanguageDto) {

        codingLanguageDto.setLangName(codingLanguage.getLangName());
        codingLanguageDto.setSkill(codingLanguage.getSkill());
        codingLanguageDto.setLanguageId(codingLanguage.getLanguageId());
        return codingLanguageDto;
    }

    public static CodingLanguage mapToCodingLanguage(CodingLanguageDto codingLanguageDto, CodingLanguage codingLanguage) {

        codingLanguage.setLangName(codingLanguageDto.getLangName());
        codingLanguage.setSkill(codingLanguageDto.getSkill());
        codingLanguage.setLanguageId(codingLanguageDto.getLanguageId());
        return codingLanguage;
    }
}
