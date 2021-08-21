package com.mdval.bussiness.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
@Entity
public class TipoDato {

    @Id
    @Column
    private String tipoDato;

    @Column
    private String longitud;

    @Column
    private String decimales;

    @Column
    private String maximo;

    @Column
    private String minimo;
}
