package com.ramitax.service;

import com.ramitax.exception.CustomException;
import com.ramitax.model.entity.Rol;
import com.ramitax.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public Page<Rol> findAll(Pageable pageable) {
        return rolRepository.findAll(pageable);
    }

    public Rol findById(Integer id) throws CustomException {
        return rolRepository.findById(id).orElse(null);
    }

    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    public void delete(Rol rol) {
        rolRepository.delete(rol);
    }

    public Rol update(Rol rol) {
        return rolRepository.save(rol);
    }

}
