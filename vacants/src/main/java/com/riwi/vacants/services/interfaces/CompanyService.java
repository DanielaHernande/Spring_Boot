package com.riwi.vacants.services.interfaces;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.vacants.entities.Company;
import com.riwi.vacants.repositories.CompanyRepository;
import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService{

    @Autowired
    private final CompanyRepository companyRepository;

    @Override
    public void delet(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delet'");
    }

    @Override
    public CompanyResponse create(CompanyRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public CompanyResponse update(String id, CompanyRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Page<CompanyResponse> getAll(int page, int size) {

        if (page < 0) page = 1;

        PageRequest pagination =  PageRequest.of(page, size);

        // Expresion landa de fecha
        /*return this.companyRepository.findAll(pagination)
            .map(company -> this.entityToResponse(company));*/

        // Expresion landa 
        return this.companyRepository.findAll(pagination)
            .map(company -> this.entityToResponse(company));

    }

    // Metodo para convertir (mapear)
    private CompanyResponse entityToResponse(Company entity) {

        CompanyResponse response = new CompanyResponse();

        BeanUtils.copyProperties(entity, response);
        return response;

    }

    
} 
