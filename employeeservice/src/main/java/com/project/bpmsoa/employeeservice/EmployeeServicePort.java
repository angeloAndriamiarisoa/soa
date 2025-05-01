package com.project.bpmsoa.employeeservice;

import java.util.List;

public interface EmployeeServicePort {
    List<Employee> findEmployees();
    Employee findEmployee(String id);
    Employee save (Employee employee);
    Employee update (String number, Employee employee);
    void delete (String number);
}
