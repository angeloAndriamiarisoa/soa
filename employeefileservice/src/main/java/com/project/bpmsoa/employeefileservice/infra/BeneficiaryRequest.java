package com.project.bpmsoa.employeefileservice.infra;

import com.project.bpmsoa.employeefileservice.domaine.Beneficiary;
import com.project.bpmsoa.employeefileservice.domaine.RelationShip;

public record BeneficiaryRequest(
    String name,
    String contact,
    String relationShip
) {
    
    public Beneficiary toBeneficiary () {
        System.out.println(this.toString());
        if (this.relationShip == null) {
            throw new IllegalArgumentException("Relationship cannot be null");
        }
        return new Beneficiary(this.name,
                             this.contact, 
                             RelationShip.valueOf(this.relationShip.toUpperCase()));
    }
}
