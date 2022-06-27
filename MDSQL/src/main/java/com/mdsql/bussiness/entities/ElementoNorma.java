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
public class ElementoNorma implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5552517950987284206L;
	
	private BigDecimal codigoNorma;
    private String descripcionNorma;
    private BigDecimal codigoElemento;
    private String descripcionElemento;
    private BigDecimal valorTamanoMaximo;
    private String txtFormato;
    private String codigoUsuario;
    private Date fechaActualizacion;
    private String txtFormatoDescripcion1;
    private String txtFormatoDescripcion2;
    private String txtFormatoDescripcion3;
}
