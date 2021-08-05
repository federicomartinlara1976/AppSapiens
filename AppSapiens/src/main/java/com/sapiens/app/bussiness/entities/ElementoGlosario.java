package com.sapiens.app.bussiness.entities;

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
public class ElementoGlosario {

    private Integer numValidacion;
    private Integer numElementoValidacion;
    private String descripcion;
    private String nombre;
    private String tipoDato;
    private Integer longitud;
    private Integer decimal;
    private String codEstadoValidacion;
    private String txDescripcionValidacion;
}
