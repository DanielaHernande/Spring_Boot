package com.riwi.beautySalon.api.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentReq {
    
    @FutureOrPresent
    @NotBlank(message = "La fecha y la hora de la cita es requerida")
    private LocalDateTime dateTime;

    @Min(value = 5)
    @Max(value = 760)
    @NotNull(message = "La duracion es obigatoria")
    private Integer duration;

    private String comments;

    @NotBlank(message = "El id del cliente es obligatorio")
    @Min(value = 1, message = "EL id deber ser mayor a cero")
    private Long clientId;

    @NotBlank(message = "El id del servicio es obligatorio")
    @Min(value = 1, message = "EL id deber ser mayor a cero")
    private Long serviceId;

    @NotBlank(message = "El id del empleado es obligatorio")
    @Min(value = 1, message = "EL id deber ser mayor a cero")
    private Long employeId;
}
