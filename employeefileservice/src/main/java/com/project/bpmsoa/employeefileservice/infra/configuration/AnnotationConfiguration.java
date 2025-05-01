package com.project.bpmsoa.employeefileservice.infra.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.project.bpmsoa.employeefileservice.EmployeeFileServiceApplication;
import com.project.bpmsoa.employeefileservice.domaine.annotation.DomainService;
import com.project.bpmsoa.employeefileservice.domaine.annotation.Port;

@Configuration
@ComponentScan (
        basePackageClasses = EmployeeFileServiceApplication.class,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {DomainService.class, Port.class})}
)
public class AnnotationConfiguration {
}
