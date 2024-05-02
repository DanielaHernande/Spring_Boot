package com.riwi.vacants.utils.dto.request;

import com.riwi.vacants.utils.enums.StatusVacant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacantRequest {

    @NotBlank(message = "El titulo debe ser requerido")
    private String title;

    @NotBlank(message = "La descripcion es requerida")
    private String description;

    private StatusVacant status;

    @Size(max = 36, min = 0)
    @NotBlank(message = "El Id de la compañia es requerido")
    private String companyId;
}
