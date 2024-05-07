package com.riwi.beautySalon.api.dto.request;

import com.riwi.beautySalon.utils.enums.RoleEmployee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeReq {
    
    @NotBlank(message = "El nombre es requerido")
    @Size(
        min = 1,
        max = 100,
         message = "EL nombre debe de tener entre 0 y 100 caracteres"
    )
    private String firstName;

    @NotBlank(message = "El apellido es requerido")
    @Size(
        min = 1,
        max = 100,
        message = "EL nombre debe de tener entre 1 y 100 caracteres"
    )
    private String lastName;

    @Email
    @Size(
        min = 1,
        max = 100,
        message = "EL email debe de tener entre 1 y 100 caracteres"
    )
    private String email;

    @Size(
        min = 10,
        max = 20,
        message = "EL telefono debe de tener entre 10 y 20 caracteres"
    )
    private String phone;

    @NotBlank(message = "El rol es requerido")
    private RoleEmployee role;
}
