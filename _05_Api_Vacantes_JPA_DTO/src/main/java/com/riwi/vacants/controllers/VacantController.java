package com.riwi.vacants.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.vacants.services.interfaces.IVacantService;
import com.riwi.vacants.utils.dto.errors.ErrorResponse;
import com.riwi.vacants.utils.dto.request.VacantRequest;
import com.riwi.vacants.utils.dto.response.VacantResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/vacants")
// Con @Tag puedo cambair el nombre en swagger
@Tag(name = "Vacantes")
public class VacantController {

    @Autowired
    public final IVacantService vacantService;

    // Listar 
    @Operation(
        summary = "Lista todas las vacantes con paginacion",
        description = "Debes enviar la pagina y el tamaño de la pagina para recibir todas las vacantes correspondientes"
        
    )
    @GetMapping
    public ResponseEntity<Page<VacantResponse>> getAll(

        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(this.vacantService.getAll(page - 1, size));
    }

    // Obtener por ID
    @ApiResponse(
        responseCode = "400",
        description = "Cuando el Id no es valido",
        content = {
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class)
            )
        }
    )
    @Operation(
        summary = "Lista una vacante por Id",
        description = "Busca una vacante por el ID enviado"
        
    )
    @GetMapping(path = "/{id}")
    public ResponseEntity<VacantResponse> get(

        @PathVariable Long id) {

        return ResponseEntity.ok(this.vacantService.getById(id));
    }

    // Insertar datos
    @PostMapping
    public ResponseEntity<VacantResponse> insert(
           @Validated @RequestBody VacantRequest vacant) {
        
        return ResponseEntity.ok(this.vacantService.create(vacant));
    }

    // Actualizar 
    @PutMapping("/{id}")
    public ResponseEntity<VacantResponse> update(
        @PathVariable Long id,
        @Validated @RequestBody VacantRequest vacant) 
    {

        return ResponseEntity.ok(this.vacantService.update(vacant, id));
    }

    // Eliminar una vacante
/*  @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        this.vacantServijava.util.ntity.noContent().build();
    }
*/

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String, String>> delete(
            @PathVariable Long id) {

        // Creamos el map
        Map<String, String> response = new HashMap<>();

        // Agregar mensaje
        response.put("message", "Se elimino la vacante correctamente");

        this.vacantService.delete(id);
        return ResponseEntity.ok(response);
    }
    
}
