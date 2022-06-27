package com.mdsql.bussiness.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ValorParticula implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3748941609849395236L;
	
	private BigDecimal codigoParticula;
    private String valor;
    private String descripcionValorParticula;
    private String codigoProyecto;
    private String codigoSubProyecto;
    private String valorParticulaPadre;
    private String codigoUsuario;
    private Date fechaActualizacion;
}
