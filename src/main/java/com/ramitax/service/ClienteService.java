package com.ramitax.service;

import com.ramitax.mapper.ClienteMapper;
import com.ramitax.model.entity.Cliente;
import com.ramitax.model.dto.ClienteDTO;
import com.ramitax.repository.ClienteRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public Page<Cliente> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).get();
    }

    public Cliente save(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.dtoToCliente(clienteDTO);
        cliente.setSaldo(0.0);
        return clienteRepository.save(cliente);
    }

    public void delete(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
