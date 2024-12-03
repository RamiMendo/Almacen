package com.ramitax.service;

import com.ramitax.exception.CustomException;
import com.ramitax.mapper.EmpleadoMapper;
import com.ramitax.model.entity.Empleado;
import com.ramitax.model.dto.EmpleadoDTO;
import com.ramitax.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private EmpleadoMapper empleadoMapper;

    public Page<Empleado> findAll(Pageable pageable) {
        return empleadoRepository.findAll(pageable);
    }

    public Empleado findById(Integer id) throws CustomException {
        return empleadoRepository.findById(id).orElse(null);
    }

    public Empleado save(EmpleadoDTO empleadoDTO) {
        Empleado empleado = empleadoMapper.dtoToEmpleado(empleadoDTO);
        return empleadoRepository.save(empleado);
    }

    public void delete(Empleado empleado) {
        empleadoRepository.delete(empleado);
    }

    public Empleado update(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
}
