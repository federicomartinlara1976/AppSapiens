package com.mdval.bussiness.entities;

import java.math.BigDecimal;
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

    private BigDecimal codigoParticula;
    private String descripcionParticula;
    private String codigoUsuario;
    private Date fechaActualizacion;
    private String mcaProyecto;
    private String mcaSubProyecto;

}
