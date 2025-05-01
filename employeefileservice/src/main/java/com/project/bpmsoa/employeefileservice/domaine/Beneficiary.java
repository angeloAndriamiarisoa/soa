package com.project.bpmsoa.employeefileservice.domaine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Beneficiary {
    private String name;
    private String contact;
    private RelationShip relationShip;
}
