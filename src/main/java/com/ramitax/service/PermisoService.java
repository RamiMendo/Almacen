package com.ramitax.service;

import com.ramitax.exception.CustomException;
import com.ramitax.model.entity.Permiso;
import com.ramitax.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PermisoService {

    @Autowired
    private PermisoRepository permisoRepository;

    public Page<Permiso> findAll(Pageable pageable) {
        return permisoRepository.findAll(pageable);
    }

    public Permiso findById(Integer id) throws CustomException {
        return permisoRepository.findById(id).orElse(null);
    }

    public Permiso save(Permiso permiso) throws CustomException {
        return permisoRepository.save(permiso);
    }

    public Permiso update(Permiso permiso) throws CustomException {
        return permisoRepository.save(permiso);
    }

    public void delete(Permiso permiso) throws CustomException {
        permisoRepository.delete(permiso);
    }

}
