package com.project.bpmsoa.employeeservice;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService implements EmployeeServicePort {
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployee(String number) {
        System.out.println(number);
        return employeeRepository.findById(number)
        .orElseThrow(() ->  new EmployeeException("Employee not found"));
    }

    @Override
    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee update(String number, Employee employee) {
        Employee employeeToChange = this.findEmployee(number);
        employeeToChange.setName(employee.getName());
        employeeToChange.setAddress(employee.getAddress());
        employeeToChange.setSocialInsuranceNumber(employee.getSocialInsuranceNumber());
        return employeeRepository.save(employeeToChange);
    }

    @Override
    public void delete(String number) {
        Employee employeeToDelete = this.findEmployee(number);
        employeeRepository.delete(employeeToDelete);
    }
    
}
