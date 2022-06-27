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
public class Glosario implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3901357571657379613L;
	
	private BigDecimal codigoGlosario;
    private String descripcionGlosario;
    private Date fechaAlta;
    private String codigoUsuario;
    private Date fechaActualizacion;
}
