package com.milhas.api.controllers;

import com.milhas.api.dtos.StateRecordDTO;
import com.milhas.api.models.StateModel;
import com.milhas.api.repositories.StateRepository;
import com.milhas.api.services.StateService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateRepository repository;

    @Autowired
    private StateService stateService;

    @PostMapping("/create")
    public ResponseEntity<StateModel> saveState(@RequestBody @Valid StateRecordDTO stateDTO){
        var stateModel = new StateModel();
        BeanUtils.copyProperties(stateDTO, stateModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(stateService.save(stateModel));
    }
}
