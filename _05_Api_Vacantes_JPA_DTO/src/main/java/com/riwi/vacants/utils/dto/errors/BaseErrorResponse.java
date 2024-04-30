package com.riwi.vacants.utils.dto.errors;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder // Crea un constructor con super de Serializable
@NoArgsConstructor
@AllArgsConstructor
public class BaseErrorResponse implements Serializable{

    private String status;
    private Integer code;
}
