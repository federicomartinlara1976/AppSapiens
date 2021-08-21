package com.mdval.bussiness.entities;

import java.util.Date;

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
public class CampoGlosario {

    private Integer nombreColumna;
    private String tipoDato;
    private Integer numeroLongitud;
    private Integer numeroDecimal;
    private Integer codigoGlosario;
    private Boolean esExcepcion;
    private String comentario;
    private String comentarioExcepcion;
    private String codigoUsuario;
    private Date fechaActualizacion;
}
