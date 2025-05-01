package com.project.bpmsoa.hrservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bpmsoa.hrservice.dto.BeneficiaryRequestDto;
import com.project.bpmsoa.hrservice.dto.EmployeeDto;
import com.project.bpmsoa.hrservice.dto.EmployeeFileDto;
import com.project.bpmsoa.hrservice.rabbitmq.MQService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("hr")
@RequiredArgsConstructor
public class HRController {
    private final HrService service;
    private final MQService mqService;

    @PostMapping("/iam")
    public String checkIdentity (@RequestBody EmployeeDto employee) {
        return service.checkIdentity(employee);
    }   

    @PutMapping("/change-benef/{number}")
    public EmployeeFileDto changeBeneficiary (@PathVariable String number,
                                    @RequestBody BeneficiaryRequestDto beneficiary) {
        return service.changeBeneficiary(number, beneficiary);

    }

    @GetMapping("/mq")
    public String  sendNotification () {
        this.mqService.sendMessage("hello from hr");
        return "message send";
    }
}
