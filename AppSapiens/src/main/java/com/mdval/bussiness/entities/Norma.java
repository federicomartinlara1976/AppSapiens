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
public class Norma {

    private BigDecimal codigoNorma;
    private String descripcionNorma;
    private String codigoUsuario;
    private Date fechaActualizacion;
}
