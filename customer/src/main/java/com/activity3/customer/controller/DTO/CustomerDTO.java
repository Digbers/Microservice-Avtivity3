package com.activity3.customer.controller.DTO;


import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
@Data
@Builder
public class CustomerDTO {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private Long usuarioCreacion;
    private Timestamp fechaCreacion;
    private Long usuarioActualizacion;
    private String fechaActualizacion;
}
