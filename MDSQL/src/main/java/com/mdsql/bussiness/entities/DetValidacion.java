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
public class DetValidacion implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1517550841130132800L;
	
	private BigDecimal numeroValidacion;
    private BigDecimal numeroElementoValid;
    private String descripcionElemento;
    private String nombreTabla;
    private String nombreElemento;
    private String tipoDato;
    private BigDecimal numeroLongitud;
    private BigDecimal numeroDecimal;
    private BigDecimal codigoEstadoValid;
    private String txtDescripcionValid;

}
