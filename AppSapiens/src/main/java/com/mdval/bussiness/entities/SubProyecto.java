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
public class SubProyecto {

    private String codigoProyecto;
    private String codigoSubProyecto;
    private String descripcionSubProyecto;
    private String codigoUsuario;
    private Date fechaActualizacion;
}
