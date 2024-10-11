package com.ramitax.service;

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
public class EmpleadoService implements EmpleadoMapper {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Page<Empleado> findAll(Pageable pageable) {
        return empleadoRepository.findAll(pageable);
    }

    public Empleado findById(Integer id) {
        return empleadoRepository.findById(id).get();
    }

    public Empleado save(EmpleadoDTO empleadoDTO) {
        Empleado empleado = dtoToEmpleado(empleadoDTO);
        return empleadoRepository.save(empleado);
    }

    public void delete(Empleado empleado) {
        empleadoRepository.delete(empleado);
    }

    public Empleado update(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado dtoToEmpleado(EmpleadoDTO dto) {
        Empleado empleado = new Empleado();
        empleado.setNombre(dto.getNombre());
        empleado.setDni(dto.getDni());
        empleado.setCuit(dto.getCuit());
        empleado.setFechaNacimiento(dto.getFechaNacimiento());
        empleado.setSalario(0.0);
        empleado.setFechaAlta(LocalDate.now());
        empleado.setFechaBaja(LocalDate.of(1900,1,1));
        return empleado;
    }
}
