package com.mdval.bussiness.entities;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class InformeValidacion {

    private List<DetValidacion> listaErroneos;
    private List<DetValidacion> listaOtraDefinicion;
    private List<CampoGlosario> listaDefinicionGlosario;

}
