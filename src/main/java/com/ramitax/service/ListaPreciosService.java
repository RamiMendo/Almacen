package com.ramitax.service;

import com.ramitax.repository.ListaPreciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListaPreciosService {

    @Autowired
    private ListaPreciosRepository listaPreciosRepository;

}
