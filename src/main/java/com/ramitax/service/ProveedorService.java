package com.ramitax.service;

import com.ramitax.mapper.ProveedorMapper;
import com.ramitax.model.entity.Proveedor;
import com.ramitax.model.dto.ProveedorDTO;
import com.ramitax.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ProveedorMapper proveedorMapper;

    public Proveedor save(ProveedorDTO dto){
        Proveedor proveedor = proveedorMapper.dtoToProveedor(dto);
        proveedor.setSaldo(0.0);
        proveedor.setDomicilio("");
        return proveedorRepository.save(proveedor);
    }

}
