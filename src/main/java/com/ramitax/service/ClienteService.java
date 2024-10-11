package com.ramitax.service;

import com.ramitax.mapper.ClienteMapper;
import com.ramitax.model.entity.Cliente;
import com.ramitax.model.dto.ClienteDTO;
import com.ramitax.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements ClienteMapper {

    @Autowired
    private ClienteRepository clienteRepository;

    public Page<Cliente> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).get();
    }

    public Cliente save(ClienteDTO clienteDTO) {
        Cliente cliente = dtoToCliente(clienteDTO);
        return clienteRepository.save(cliente);
    }

    public void delete(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente dtoToCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setDni(dto.getDni());
        cliente.setNombre(dto.getNombre());
        cliente.setCuit(dto.getCuit());
        cliente.setMail(dto.getMail());
        cliente.setTelefono(dto.getTelefono());
        cliente.setSaldo(0.0);
        return cliente;
    }
}
