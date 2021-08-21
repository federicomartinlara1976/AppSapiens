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
public class TipoParticula {

    private Integer codigo;
    private String descripcion;
    private Boolean mcaProyecto;
    private String codigoUsuario;
    private Date fechaActualizacion;
}
