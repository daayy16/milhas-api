package com.milhas.api.controllers;

import com.milhas.api.dtos.PromotionRecordDTO;
import com.milhas.api.models.PromotionModel;
import com.milhas.api.repositories.PromotionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promotion")
public class PromotionController {

    @Autowired
    private PromotionRepository repository;

    @PostMapping("/create")
    public ResponseEntity<?> createPromotion(@RequestBody @Valid PromotionRecordDTO requestDTO){
        var promotionModel = new PromotionModel();
        BeanUtils.copyProperties(requestDTO, promotionModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(promotionModel));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPromotion() {
        return ResponseEntity.ok(repository.findAll());
    }
}
