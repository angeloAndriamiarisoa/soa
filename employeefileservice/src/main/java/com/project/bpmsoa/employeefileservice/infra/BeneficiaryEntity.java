package com.project.bpmsoa.employeefileservice.infra;

import com.project.bpmsoa.employeefileservice.domaine.Beneficiary;
import com.project.bpmsoa.employeefileservice.domaine.RelationShip;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "beneficiary")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BeneficiaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String contact;
    private RelationShip relationShip;

    public Beneficiary toDomain () {
        return new Beneficiary(
                this.name,
                this.contact,
                this.relationShip);
    }

    public static BeneficiaryEntity fromDomain(Beneficiary beneficiary) {
        return new BeneficiaryEntity(null, 
                beneficiary.getName(),
                beneficiary.getContact(),
                beneficiary.getRelationShip());
    }
}
