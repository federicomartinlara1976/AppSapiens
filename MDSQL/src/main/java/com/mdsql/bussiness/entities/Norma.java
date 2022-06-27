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
public class Norma implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 216667570502982976L;
	
	private BigDecimal codigoNorma;
    private String descripcionNorma;
    private String codigoUsuario;
    private Date fechaActualizacion;
}
