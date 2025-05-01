package com.project.bpmsoa.employeefileservice.infra;

import org.springframework.web.bind.annotation.RestController;

import com.project.bpmsoa.employeefileservice.domaine.EmployeeFile;
import com.project.bpmsoa.employeefileservice.domaine.EmployeeFileService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/employee-file")
@RequiredArgsConstructor
public class EmployeeFileController {

    private final EmployeeFileService service;

    @PostMapping
    public FileRequest saveFile (@RequestBody FileRequest request) {
        this.service.save(request.toEmployeeFile());
        return request;
    }

    @PutMapping("/{employee}")
    public EmployeeFile changeBeneficiary(@PathVariable String employee,@RequestBody  BeneficiaryRequest beneficiary) {
       return this.service.changeBeneficiary(employee, beneficiary.toBeneficiary());
    }

    @GetMapping("/{employee}")
    public EmployeeFile getEmployeeFile(@PathVariable String employee) {
        return this.service.getEmployeeFileByID(employee);
    }
    
    @GetMapping()
    public List<EmployeeFile> getEmployeeFile() {
        return this.service.getEmployeeFile();
    }


    
}
