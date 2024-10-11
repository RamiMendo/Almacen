package com.ramitax.service;

import com.ramitax.mapper.ProveedorMapper;
import com.ramitax.model.entity.Proveedor;
import com.ramitax.model.dto.ProveedorDTO;
import com.ramitax.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorService implements ProveedorMapper {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public Proveedor save(ProveedorDTO dto){
        Proveedor proveedor = dtoToProveedor(dto);
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor dtoToProveedor(ProveedorDTO proveedorDTO) {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(proveedorDTO.getNombre());
        proveedor.setCuit(proveedorDTO.getCuit());
        proveedor.setMail(proveedorDTO.getMail());
        proveedor.setTelefono(proveedorDTO.getTelefono());
        proveedor.setSaldo(0.0);
        return proveedor;
    }
}
