package com.mdval.bussiness.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
@Entity
@ToString
public class Glosario {

    @Id
    @Column
    private BigDecimal codigoGlosario;

    @Column
    private String descripcionGlosario;

    @Column
    private Date fechaAlta;

    @Column
    private String codigoUsuario;

    @Column
    private Date fechaActualizacion;
}
