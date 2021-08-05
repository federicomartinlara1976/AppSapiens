package com.sapiens.app.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

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
