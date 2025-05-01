package com.project.bpmsoa.employeefileservice.domaine.annotation;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface DomainService {
    String value() default "";
}
