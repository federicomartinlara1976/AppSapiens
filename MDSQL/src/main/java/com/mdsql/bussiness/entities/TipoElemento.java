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
public class TipoElemento implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6188152559112814021L;
	
	private BigDecimal codigoElemento;
    private String descripcionElemento;
    private String codigoUsuario;
    private Date fechaActualizacion;

}
