package com.mdsql.bussiness.service;

import java.math.BigDecimal;
import java.util.List;

import com.mdsql.bussiness.entities.ParticulaNorma;

/**
 * @author hcarreno
 */
public interface ParticulaNormaService {

    List<ParticulaNorma> consultarDefinicionParticulaNormaElemento(BigDecimal codigoNorma, BigDecimal codigoElemento);

    List<ParticulaNorma> consultarParticulasElemento(BigDecimal codigoNorma, BigDecimal codigoElemento);
}
