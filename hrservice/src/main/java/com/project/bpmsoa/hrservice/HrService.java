package com.project.bpmsoa.hrservice;

import org.springframework.stereotype.Service;

import com.project.bpmsoa.hrservice.client.EmployeeClient;
import com.project.bpmsoa.hrservice.client.EmployeeFileClient;
import com.project.bpmsoa.hrservice.dto.BeneficiaryRequestDto;
import com.project.bpmsoa.hrservice.dto.EmployeeDto;
import com.project.bpmsoa.hrservice.dto.EmployeeFileDto;
import com.project.bpmsoa.hrservice.dto.GraphQLRequest;
import com.project.bpmsoa.hrservice.dto.GraphQLResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HrService {
    private final EmployeeClient employeeClient;
    private final EmployeeFileClient employeeFileClient;

    public String checkIdentity (EmployeeDto employee) {
        String query = String.format(
            """
            query MyQuery {
                getEmployeeById(number: "%s") {
                    address
                    name
                    number
                    socialInsuranceNumber
                }
            }
            """, employee.number()
        );

        GraphQLResponse response   = this.employeeClient
                            .getEmployee(new GraphQLRequest(query));
        if(response.data() == null) return "Invalid employee";
        EmployeeDto employeeFetched = response.data().getEmployeeById();

        return employee.equals(employeeFetched) ? "Valid employee" : "Invalid employee";
    }

    public EmployeeFileDto changeBeneficiary (String number,
                                     BeneficiaryRequestDto beneficiary) {
        return employeeFileClient.changeBeneficiary(number, beneficiary);

    }
}
