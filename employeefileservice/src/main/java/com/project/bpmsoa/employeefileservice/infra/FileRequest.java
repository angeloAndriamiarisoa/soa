package com.project.bpmsoa.employeefileservice.infra;

import com.project.bpmsoa.employeefileservice.domaine.EmployeeFile;

public record FileRequest(
    String employee,
    BeneficiaryRequest beneficiary
) {
    
    public EmployeeFile toEmployeeFile () {
        return EmployeeFile.builder()
            .employee(this.employee)
            .beneficiary(beneficiary.toBeneficiary())
            .build();
    }
}
