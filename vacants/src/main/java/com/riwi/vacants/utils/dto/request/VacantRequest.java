package com.riwi.vacants.utils.dto.request;

import com.riwi.vacants.utils.enums.StateVacant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Esto es una clase comun y corriente

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VacantRequest {

    private String title;
    private String description;
    private StateVacant status;
    private String companyId;
}
