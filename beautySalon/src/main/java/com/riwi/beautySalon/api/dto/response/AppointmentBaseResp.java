package com.riwi.beautySalon.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentBaseResp {
    
    private Long id;
    private LocalDateTime dateTime;
    private Integer duration;
    private String comments;
    private ServiceResp service;
    private EmployeeResp employee;
}
