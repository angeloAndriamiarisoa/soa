package com.project.bpmsoa.hrservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;

import com.project.bpmsoa.hrservice.dto.BeneficiaryRequestDto;
import com.project.bpmsoa.hrservice.dto.EmployeeFileDto;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@FeignClient(name = "employee-file-service", url = "http://localhost:8082")
public interface EmployeeFileClient {
    @PutMapping("/employee-file/{employee}")
    EmployeeFileDto changeBeneficiary(@PathVariable String employee,
                        @RequestBody  BeneficiaryRequestDto beneficiary);
} 