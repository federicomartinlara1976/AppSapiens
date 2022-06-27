package com.mdsql.bussiness.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ValidaParticula implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6805910678611807945L;
	
	private BigDecimal numeroParticula;
    private String txtValidacion;
    private String txtValor;
    private String descripcionEstadoValidacion;

}
