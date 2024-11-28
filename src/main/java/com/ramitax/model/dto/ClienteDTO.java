package com.ramitax.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class ClienteDTO extends EntidadDTO {

    private String dni;
    private List<DomicilioDTO> domicilios;
}
