package com.mdval.bussiness.service;

import java.math.BigDecimal;
import java.util.List;

import com.mdval.bussiness.entities.ParticulaNorma;

/**
 * @author hcarreno
 */
public interface ParticulaNormaService {

    List<ParticulaNorma> consultarDefinicionParticulaNormaElemento(BigDecimal codigoNorma, BigDecimal codigoElemento);

    List<ParticulaNorma> consultarParticulasElemento(BigDecimal codigoNorma, BigDecimal codigoElemento);
}
