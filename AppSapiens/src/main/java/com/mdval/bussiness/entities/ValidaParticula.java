package com.mdval.bussiness.entities;

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
public class ValidaParticula {

    private Integer numeroParticula;
    private String txtValidacion;
    private String txtValor;
    private String descripcionEstadoValidacion;

}
