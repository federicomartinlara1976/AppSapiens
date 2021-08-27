package com.mdval.bussiness.entities;

import java.util.List;
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
public class InformeValidacion {

    private List<DetValidacion> listaErroneos;
    private List<DetValidacion> listaOtraDefinicion;
    private List<CampoGlosario> listaDefinicionGlosario;

}
