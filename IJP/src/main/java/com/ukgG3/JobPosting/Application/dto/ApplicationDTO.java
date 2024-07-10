package com.ukgG3.JobPosting.Application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class ApplicationDTO {

    private int employeeId;
    private int jobPosId;
    private boolean status;
    private boolean verifiedByManager;

}
