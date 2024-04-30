package com.riwi.vacants.services;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.vacants.entities.Company;
import com.riwi.vacants.entities.Vacant;
import com.riwi.vacants.repositories.CompanyRepository;
import com.riwi.vacants.services.interfaces.ICompanyService;
import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;
import com.riwi.vacants.utils.dto.response.VacantToCompanyResponse;
import com.riwi.vacants.utils.exceptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {

    @Autowired
    private final CompanyRepository companyRepository;

    // Listar las compañias
    @Override
    public Page<CompanyResponse> getAll(int page, int size) {

        /** 1. Configuramos la paginación */
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        // *LLamamos el repositorio */
        // return this.companyRepository.findAll(pagination)
        // .map(company -> this.entityToResponse(company));

        return this.companyRepository.findAll(pagination)
                .map(this::entityToResponse);
    }

    // Crear
    @Override
    public CompanyResponse create(CompanyRequest request) {

        /** Convertimos el Request en la entidad */
        Company company = this.requestToEntity(request, new Company());
        /**
         * Agregamos la entidad en el repositorio y el retorno lo convertimos
         * en respuesta
         */
        return this.entityToResponse(this.companyRepository.save(company));
    }

    @Override
    public CompanyResponse update(CompanyRequest request, String id) {

        // Buscamos la compañia por el ID
        Company company = this.find(id);
        
        // LLenamos la compañia co los nuevos datos a la vez que convertimos en entidad
        Company companyUpdate = this.requestToEntity(request, company);

        // Guardamos la compañia actualizada y convertimos la respuesta
        return this.entityToResponse(this.companyRepository.save(companyUpdate));

    }

    @Override
    public void delete(String id) {

        // Busco la compañia a la que corresponde el ID
        Company company = this.find(id);
        // Elimino
        this.companyRepository.delete(company);
    }

    // Obtener por ID
    @Override
    public CompanyResponse getById(String id) {
        
        // Convertimos la entidad al dto de respuesta y lo retornamos
        return this.entityToResponse(this.find(id));
    }


    /**
     *  METODOS PRIVADOS
     * Este método se encargará de convertir una entidad en el dto de respuesta
     * de la entidad
     */
    private CompanyResponse entityToResponse(Company entity) {

        CompanyResponse response = new CompanyResponse();
        /**
         * Bean Utils nos permite hacer un copia de una clase en otra
         * En este caso toda la entidad de tipo Company sera copiada con la información
         * requerida por la variable tipo CompanyResponse
         */

        BeanUtils.copyProperties(entity, response);

        /**
         * stream -> Convierte la lista en colección para poder iterarse
         * map -> Itera toda la lista y retorna cambios
         * collect -> Crea de nuevo toda la lista que se habia transformado en coleccion
         */
        response.setVacants(entity.getVacants().stream()
                .map(this::vacantToResponse)
                .collect(Collectors.toList()));

        return response;

    }

    private VacantToCompanyResponse vacantToResponse(Vacant entity) {

        VacantToCompanyResponse response = new VacantToCompanyResponse();

        BeanUtils.copyProperties(entity, response);

        return response;
    }

    private Company requestToEntity(CompanyRequest request, Company company) {

        company.setContact(request.getContact());
        company.setLocation(request.getLocation());
        company.setName(request.getName());
        company.setVacants(new ArrayList<>());
        return company;
    }

    // Obtener por ID
    private Company find(String id) {
        return this.companyRepository.findById(id).orElseThrow(() -> new 
        IdNotFoundException("Company"));
    }

}
