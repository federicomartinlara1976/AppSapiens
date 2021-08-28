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
public class Glosario {

    private BigDecimal codigoGlosario;
    private String descripcionGlosario;
    private Date fechaAlta;
    private String codigoUsuario;
    private Date fechaActualizacion;
}
