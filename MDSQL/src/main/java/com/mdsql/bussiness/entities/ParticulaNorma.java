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
public class ParticulaNorma implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3543364571399304931L;
	
	private BigDecimal codigoNorma;
    private String descripcionNorma;
    private BigDecimal codigoElemento;
    private String descripcionElemento;
    private BigDecimal numeroParticula;
    private String descripcionNumeroParticula;
    private String mcaObligatoria;
    private String mcaValidacion;
    private BigDecimal valorTamanoMinimo;
    private BigDecimal valorTamanoMaximo;
    private String mcaValorPadre;
    private BigDecimal numParticulaPadre;
    private String codigoUsuario;
    private Date fechaActualizacion;
    private String tipoValidacion;
    private BigDecimal codigoParticula;
    private String descripcionParticula;
    private String mcaProyecto;
    private String txtFormatoParticula;

}
