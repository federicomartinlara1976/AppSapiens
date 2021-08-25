package com.mdval.bussiness.entities;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
@ToString
public class Norma {

    private BigDecimal codigoNorma;
    private String descripcionNorma;
    private String codigoUsuario;
    private Date fechaActualizacion;
}
