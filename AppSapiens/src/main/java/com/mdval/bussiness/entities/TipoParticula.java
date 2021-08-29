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
public class TipoParticula {

    private Integer codigo;
    private String descripcion;
    private Boolean mcaProyecto;
    private String codigoUsuario;
    private Date fechaActualizacion;
}
