package com.mdval.bussiness.entities;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class SubProyecto {

    private String codigoProyecto;
    private String codigoSubProyecto;
    private String descripcionSubProyecto;
    private String codigoUsuario;
    private Date fechaActualizacion;
}
