package com.mdval.bussiness.entities;

import java.math.BigDecimal;
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
public class ParticulaNorma {

    private BigDecimal codigoNorma;
    private String descripcionNorma;
    private BigDecimal codigoElemento;
    private String descripcionElemento;
    private BigDecimal numeroParticula;
    private String descripcionNumeroParticula;
    private String mcaObligatoria;
    private String mcaValidacion;
    private BigDecimal valorTamanoMinimo;
    private BigDecimal valorTamanoMaximo;
    private String mcaValorPadre;
    private BigDecimal numParticulaPadre;
    private String codigoUsuario;
    private Date fechaActualizacion;
    private String tipoValidacion;
    private BigDecimal codigoParticula;
    private String descripcionParticula;
    private String mcaProyecto;
    private String txtFormatoParticula;

}
