package com.mdval.bussiness.entities;

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
public class ValorParticula {

    private BigDecimal codigoParticula;
    private String valorParticula;
    private String descripcionValorParticula;
    private String codigoProyecto;
    private String codigoSubProyecto;
    private String valorParticulaPadre;
    private String codigoUsuario;
    private Date fechaActualizacion;
}
