package com.project.bpmsoa.employeefileservice.infra;

import com.project.bpmsoa.employeefileservice.domaine.EmployeeFile;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_file")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeFileEntity {
    @Id
    private String employee;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BeneficiaryEntity beneficiary;

    public static EmployeeFileEntity fromDomain(EmployeeFile file) {
        BeneficiaryEntity beneficiaryEntity = new BeneficiaryEntity();
        beneficiaryEntity.setName(file.getBeneficiary().getName());
        beneficiaryEntity.setContact(file.getBeneficiary().getContact());
        beneficiaryEntity.setRelationShip(file.getBeneficiary().getRelationShip());

        EmployeeFileEntity entity = new EmployeeFileEntity();
        entity.setEmployee(file.getEmployee());
        entity.setBeneficiary(beneficiaryEntity);

        return entity;
    }

    public EmployeeFile toDomain () {
        return new EmployeeFile(
                this.employee,
                this.beneficiary.toDomain());
    }
}
