package com.project.bpmsoa.employeeservice;

public record EmployeeRequest(
     String number,
     String name,
     String address,
     String socialInsuranceNumber
) {

    public Employee toDomain () {
        return Employee.builder()
            .name(this.name)
            .address(this.address)
            .number(this.number)
            .socialInsuranceNumber(this.socialInsuranceNumber)
            .build();
    }
    
}
