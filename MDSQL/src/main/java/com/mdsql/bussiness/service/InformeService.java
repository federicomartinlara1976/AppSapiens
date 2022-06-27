package com.mdsql.bussiness.service;

import java.math.BigDecimal;

import com.mdsql.bussiness.entities.InformeValidacion;

/**
 * @author hcarreno
 */
public interface InformeService {

    InformeValidacion generarInformeValidacion(BigDecimal codigoValidacion);

}
