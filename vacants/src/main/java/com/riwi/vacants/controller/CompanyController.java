package com.riwi.vacants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.vacants.services.interfaces.ICompanyService;
import com.riwi.vacants.utils.dto.response.CompanyResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyController {

    @Autowired
    private final ICompanyService companyService;

    @GetMapping
    public ResponseEntity<Page<CompanyResponse>> get(

        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "2") int size) {

            return ResponseEntity.ok(this.companyService.getAll(page, size));
        }
}
