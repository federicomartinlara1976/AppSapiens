package com.mdval.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TipoDato {

    private String tipoDato;
    private String longitud;
    private String decimales;
    private String maximo;
    private String minimo;
}
