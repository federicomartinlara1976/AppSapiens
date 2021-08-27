package com.mdval.bussiness.entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
public class Modelo {

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
    private String mcaInh;
    private List<SubProyecto> subProyectos;
}
