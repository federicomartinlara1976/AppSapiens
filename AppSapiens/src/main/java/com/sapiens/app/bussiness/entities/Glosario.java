package com.sapiens.app.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
public class Glosario {

    private Integer codigo;
    private String descripcion;
    private String usuario;
    private Date fechaAlta;
    private Date fechaModificacion;
}
