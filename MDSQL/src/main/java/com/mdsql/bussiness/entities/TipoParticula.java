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
public class TipoParticula implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4453719302834200539L;
	
	private BigDecimal codigoParticula;
    private String descripcionParticula;
    private String codigoUsuario;
    private Date fechaActualizacion;
    private String mcaProyecto;
    private String mcaSubProyecto;
}
