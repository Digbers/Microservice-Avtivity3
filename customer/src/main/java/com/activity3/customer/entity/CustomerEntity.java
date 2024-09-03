package com.activity3.customer.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60, nullable = false)
    private String name;
    @Column(length = 60, nullable = false)
    private String lastName;
    @Column(length = 60, nullable = false)
    private String email;
    @Column(name = "usuario_creacion")
    private Long usuarioCreacion;
    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private Timestamp fechaCreacion;
    @Column(name = "usuario_actualizacion")
    private Long usuarioActualizacion;
    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private String fechaActualizacion;
}
