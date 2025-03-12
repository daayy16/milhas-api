package com.milhas.api.services;

import com.milhas.api.models.StateModel;
import com.milhas.api.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public StateModel save(StateModel state) {
        return stateRepository.save(state);
    }
}
