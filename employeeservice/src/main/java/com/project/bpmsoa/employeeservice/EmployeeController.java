package com.project.bpmsoa.employeeservice;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeServicePort employeeService;

    @QueryMapping
    public Employee getEmployeeById(@Argument String number) {
        return employeeService.findEmployee(number);
    }

    @QueryMapping
    public List<Employee> getEmployees() {
        return employeeService.findEmployees();
    }

    @MutationMapping
    public Employee create(@Argument EmployeeRequest employee) {
        return employeeService.save(employee.toDomain());
    }

    @MutationMapping
    public Employee update(@Argument String number ,@Argument EmployeeRequest employee) {
        return employeeService.update(number, employee.toDomain());
    }

    @MutationMapping
    public String delete(@Argument String number) {
        employeeService.delete(number);
        return "Employee deleted successfully";
    }
  
    
}
