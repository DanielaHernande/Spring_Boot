package com.riwi.vacants.utils.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder // patron de diseño para crear clases
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {

    @Size(min = 0, max = 40, message = "El nombre supera la cantidad de caracteres permitidos")
    @NotBlank(message = "EL nombre de la compañia es requerido")
    private String name;

    @NotBlank(message = "EL location de la compañia es requerido")
    private String location;

    @Size(min = 0, max = 14, message = "El contacto supera la cantidad de caracteres permitidos")
    @NotBlank(message = "EL contacto de la compañia es requerido")
    private String contact;
}
