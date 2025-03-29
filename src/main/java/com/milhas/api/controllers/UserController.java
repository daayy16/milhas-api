package com.milhas.api.controllers;

import com.milhas.api.dtos.StateRecordDTO;
import com.milhas.api.dtos.UserRecordDTO;
import com.milhas.api.models.StateModel;
import com.milhas.api.models.UserModel;
import com.milhas.api.repositories.StateRepository;
import com.milhas.api.repositories.UserRepository;
import com.milhas.api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserRecordDTO userDTO) {
        var user = repository.findByEmail(userDTO.email());
        if(user.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já cadastrado");
        }
        StateModel state = stateRepository.findByInitials(userDTO.initials());


        if (state == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: Estado com as iniciais '" + userDTO.initials() + "' não encontrado.");
        }


        var userModel = new UserModel();
        BeanUtils.copyProperties(userDTO, userModel, "dateOfBirth", "password");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        userModel.setDateOfBirth(LocalDate.parse(userDTO.dateOfBirth(), formatter).atStartOfDay());
        userModel.setState(state);
        userModel.setPassword(passwordEncoder.encode(userDTO.password()));

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }
}
