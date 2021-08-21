package com.mdval.bussiness.entities;

import java.util.Date;

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
public class Particula {

    private Integer codigo;
    private String valorParticula;
    private String descripcionValorParticula;
    private String valorParticulaPadre;
    private String codigoUsuario;
    private Date fechaActualizacion;
}
