package com.mdval.bussiness.entities;

import java.math.BigDecimal;
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
public class DetValidacion {

    private BigDecimal numeroValidacion;
    private BigDecimal numeroElementoValid;
    private String descripcionElemento;
    private String nombreElemento;
    private String tipoDato;
    private BigDecimal numeroLongitud;
    private BigDecimal numeroDecimal;
    private BigDecimal codigoEstadoValid;
    private String txtDescripcionValid;


}
