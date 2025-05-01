package com.project.bpmsoa.employeefileservice.domaine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeFile {
    private String employee;
    private Beneficiary beneficiary;
}
