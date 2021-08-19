package com.sapiens.mdval.bussiness.entities;

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

    private Integer codigoModelo;
    private String descripcionModelo;
    private Norma norma;
    private Glosario glosario;
    private String nombreEsquema;
    private String nombreBbdd;
    private String carpetaScripts;
    private String grupo;
    private String herramienta;
    private String observaciones;
    private String generaVariables;
    private String permiteGrantAll;
    private String permiteGrantPublic;
    private List<Modelo> listadoSubProyectos;
    private String usuario;
    private Date fechaActualizacion;
}
