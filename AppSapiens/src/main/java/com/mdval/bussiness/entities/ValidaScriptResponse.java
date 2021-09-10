package com.mdval.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author hcarreno
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ValidaScriptResponse {

    private BigDecimal numeroValidacion;
    private List<DetValidacion> listaElementosValid;
    private String elementosNoGlosario;
    private String elementosErrores;

}
