package com.mdval.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ValidaParticula {

    private Integer numeroParticula;
    private String txtValidacion;
    private String txtValor;
    private String descripcionEstadoValidacion;

}
