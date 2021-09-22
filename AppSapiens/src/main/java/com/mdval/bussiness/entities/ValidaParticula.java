package com.mdval.bussiness.entities;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ValidaParticula {

    private BigDecimal numeroParticula;
    private String txtValidacion;
    private String txtValor;
    private String descripcionEstadoValidacion;

}
