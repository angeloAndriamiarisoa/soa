package com.project.bpmsoa.employeefileservice.domaine;

import java.util.List;


import com.project.bpmsoa.employeefileservice.domaine.annotation.DomainService;

import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class EmployeeFileService {
    private final ServicePort service;
    public EmployeeFile save(EmployeeFile employeeFile) {
        return this.service.save(employeeFile);
    }

    public EmployeeFile changeBeneficiary(String employee, Beneficiary beneficiary) {
       return this.service.changeBeneficiary(employee, beneficiary);
    }

    public EmployeeFile getEmployeeFileByID(String employee) {
       return this.service.getEmployeeFileByID(employee);
    }

    public List<EmployeeFile> getEmployeeFile( ) {
        return this.service.getEmployeeFile();
     }

}
