package com.riwi.beautySalon.api.dto.errors;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder // Es porque esta clase va hacer heredada por otra
@NoArgsConstructor
@AllArgsConstructor

/*Serializable clase especial para responder por http */
public class BaseErrorResp implements Serializable{
    
    private String status;
    private Integer code;
}
