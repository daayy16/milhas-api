package com.milhas.api.services;

import com.milhas.api.dtos.UserRecordDTO;
import com.milhas.api.models.UserModel;
import com.milhas.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel save(UserModel user) {
        return userRepository.save(user);
    }
}
