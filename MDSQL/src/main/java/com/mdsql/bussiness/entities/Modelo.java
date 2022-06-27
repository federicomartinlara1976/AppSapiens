package com.mdsql.bussiness.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Modelo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1060226242769948540L;
	
	private String codigoProyecto;
    private String nombreModelo;
    private String nombreEsquema;
    private String nombreBbdd;
    private String codigoGrupoBds;
    private String nombreCarpetaAdj;
    private BigDecimal codigoNorma;
    private String descripcionNorma;
    private String nomApnCmdb;
    private BigDecimal codigoGlosario;
    private String descripcionGlosario;
    private String codigoHerramienta;
    private String observacionesModelo;
    private String codigoUsuario;
    private Date fechaActualizacion;
    private String codigoCapaUsrown;
    private String mcaVariables;
    private String mcaGrantAll;
    private String mcaGrantPublic;
    private String mcaVariablesConCapa;
    private String mcaInh;
    private List<SubProyecto> subProyectos;
}
