package com.project.bpmsoa.employeefileservice.domaine;

import java.util.List;

import com.project.bpmsoa.employeefileservice.domaine.annotation.Port;

@Port
public interface ServicePort {
    EmployeeFile save (EmployeeFile employeeFile);
    EmployeeFile changeBeneficiary (String employee, Beneficiary beneficiary);
    EmployeeFile getEmployeeFileByID (String employee);
    List<EmployeeFile> getEmployeeFile ();
}
