package com.mdval.bussiness.service;

import com.mdval.bussiness.entities.ParticulaNorma;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author hcarreno
 */
public interface ParticulaNormaService {

    List<ParticulaNorma> consultarDefinicionParticulaNormaElemento(BigDecimal codigoNorma, BigDecimal codigoElemento);

    List<ParticulaNorma> consultarParticulasElemento(BigDecimal codigoNorma, BigDecimal codigoParticula);
}
