package com.mdval.bussiness.service;

import java.math.BigDecimal;

import com.mdval.bussiness.entities.InformeValidacion;

/**
 * @author hcarreno
 */
public interface InformeService {

    InformeValidacion generarInformeValidacion(BigDecimal codigoValidacion);

}
