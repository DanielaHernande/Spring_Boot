package com.riwi.vacants.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.vacants.entities.Company;
import com.riwi.vacants.entities.Vacant;
import com.riwi.vacants.repositories.CompanyRepository;
import com.riwi.vacants.repositories.VacantRepository;
import com.riwi.vacants.services.interfaces.IVacantService;
import com.riwi.vacants.utils.dto.request.VacantRequest;
import com.riwi.vacants.utils.dto.response.CompanyToVancantResponse;
import com.riwi.vacants.utils.dto.response.VacantResponse;
import com.riwi.vacants.utils.enums.StatusVacant;
import com.riwi.vacants.utils.exceptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VacantService implements IVacantService {

    // Repositorio vacante
    @Autowired
    public final VacantRepository vacantRepository;

    // Repositorio de compañia
    @Autowired
    public final CompanyRepository companyRepository;

    @Override
    public Page<VacantResponse> getAll(int page, int size) {

        if (page < 0) page = 0;

        // Creamos la paginacion
        PageRequest pagination = PageRequest.of(page, size);

        /* Obtenemos todas las vacantes de la BD y las mapemaos al dto de respuesta */
        return this.vacantRepository.findAll(pagination)
                .map(this::entityToResponse);

    }

    @Override
    public VacantResponse create(VacantRequest request) {

        /*
         * NOs aseguramos que el ID de la compañia dentro del request sea valido
         * Buscamos la compañia que corresponda con el id que esta dentro del request
         */
        Company company = this.companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new IdNotFoundException("Company"));

        // Convertimos el request a la entidad
        Vacant vacant = this.requestToVacant(request, new Vacant());

        // Agregamos la empresa encontrada anteriormente
        vacant.setCompany(company);

        // Guardamos en la BD y convertimos la nueva entidad al DTO de respuesta
        return this.entityToResponse(this.vacantRepository.save(vacant));

    }

    @Override
    public VacantResponse update(VacantRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public VacantResponse getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    private VacantResponse entityToResponse(Vacant vacant) {

        // Crear una instancia
        VacantResponse response = new VacantResponse();

        // Copiamos las propiedades de la entidad al dto de respuesta
        BeanUtils.copyProperties(vacant, response);

        // Crear la instancia de dto de compañia dentro de vacante
        CompanyToVancantResponse companyResp = new CompanyToVancantResponse();

        // Copio las propiedades de la entidad en el dto de respuesta
        BeanUtils.copyProperties(vacant.getCompany(), companyResp);

        // Agregego el dto lleno a la respuesta final
        response.setCompany(companyResp);

        return response;
    }

    private Vacant requestToVacant(VacantRequest request, Vacant entity) {

        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setStatus(StatusVacant.ACTIVE);

        return entity;
    }

}
