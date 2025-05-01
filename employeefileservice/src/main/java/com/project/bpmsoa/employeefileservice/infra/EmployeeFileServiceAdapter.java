package com.project.bpmsoa.employeefileservice.infra;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.bpmsoa.employeefileservice.domaine.Beneficiary;
import com.project.bpmsoa.employeefileservice.domaine.EmployeeFile;
import com.project.bpmsoa.employeefileservice.domaine.ServicePort;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeFileServiceAdapter implements ServicePort {
    private final EmployeeFileRepository employeeFileRepository;
    @Override
    public EmployeeFile save(EmployeeFile employeeFile) {
        return employeeFileRepository
                .save(EmployeeFileEntity.fromDomain(employeeFile))
                .toDomain();
    }

    @Override
    public EmployeeFile changeBeneficiary(String employee, Beneficiary beneficiary) {
        EmployeeFileEntity employeeFileEntity = this.getEmployeeFileEntity(employee);
        employeeFileEntity.setBeneficiary(BeneficiaryEntity.fromDomain(beneficiary)); 
        return employeeFileRepository.save(employeeFileEntity).toDomain();      
         
    }

    @Override
    public EmployeeFile getEmployeeFileByID(String employee) {
        return this.getEmployeeFileEntity(employee).toDomain();
    }
    
    private EmployeeFileEntity getEmployeeFileEntity (String employee) {
        return this.employeeFileRepository.findById(employee)
        .orElseThrow(() -> new EmployeeException("Employee not found"));
    }

    @Override
    public List<EmployeeFile> getEmployeeFile() {
        return this.employeeFileRepository.findAll().stream()
        .map(entity -> entity.toDomain()).toList();
    }


    
} 
