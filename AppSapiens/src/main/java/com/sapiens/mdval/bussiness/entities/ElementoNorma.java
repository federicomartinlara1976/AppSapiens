package com.sapiens.mdval.bussiness.entities;

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
public class ElementoNorma {

    private Integer codigo;
    private String descripcion;
    private Integer max;
    private String expresionRegular;
    private String txt;
}
