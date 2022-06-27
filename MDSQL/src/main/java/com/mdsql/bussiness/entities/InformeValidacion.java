package com.mdsql.bussiness.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class InformeValidacion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5935042541104594281L;
	
	private BigDecimal numValidacion;
	private String rf;
	private String sd;

    private List<DetValidacion> listaErroneos;
    private List<DetValidacion> listaOtraDefinicion;
    private List<CampoGlosario> listaDefinicionGlosario;

}
