package com.sapiens.mdval.bussiness.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
@Entity
public class Glosario {

    @Id
    @Column
    private Integer codigo;

    @Column
    private String descripcion;

    @Column
    private String usuario;

    @Column
    private Date fechaAlta;

    @Column
    private Date fechaModificacion;
}
