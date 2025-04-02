package com.milhas.api.controllers;

import com.milhas.api.dtos.CompanyRecordDTO;
import com.milhas.api.models.CompanyModel;
import com.milhas.api.repositories.CompanyRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createCompany(@RequestBody @Valid CompanyRecordDTO requestDTO) {
        Optional<CompanyModel> company = companyRepository.findByName(requestDTO.name());

        if(company.isPresent()) {
           return ResponseEntity.status(HttpStatus.CONFLICT).body("Compania já cadastrada");
        }

        var newCompany = new CompanyModel();
        BeanUtils.copyProperties(requestDTO, newCompany);

        return ResponseEntity.status(HttpStatus.CREATED).body(companyRepository.save(newCompany));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCompany(){
        return ResponseEntity.ok().body(companyRepository.findAll());
    }
}
