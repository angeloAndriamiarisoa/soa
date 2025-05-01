package com.project.bpmsoa.employeefileservice.domaine.annotation;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Port {
    String value() default "";
}
