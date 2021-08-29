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
public class ElementoNorma {

    private BigDecimal codigoNorma;
    private String descripcionNorma;
    private BigDecimal codigoElemento;
    private String descripcionElemento;
    private BigDecimal valorTamanoMaximo;
    private String txtFormato;
    private String codigoUsuario;
    private Date fechaActualizacion;
    private String txtFormatoDescripcion1;
    private String txtFormatoDescripcion2;
    private String txtFormatoDescripcion3;
}
