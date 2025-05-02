package com.project.bpmsoa.hrservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.bpmsoa.hrservice.dto.GraphQLRequest;
import com.project.bpmsoa.hrservice.dto.GraphQLResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@FeignClient(name = "employee-service")
public interface EmployeeClient {
    @PostMapping(value = "/graphql", consumes = "application/json")
    GraphQLResponse getEmployee(@RequestBody GraphQLRequest request);
} 