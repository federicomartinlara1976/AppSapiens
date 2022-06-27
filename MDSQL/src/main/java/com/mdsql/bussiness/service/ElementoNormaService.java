package com.mdsql.bussiness.service;

import java.math.BigDecimal;
import java.util.List;

import com.mdsql.bussiness.entities.ElementoNorma;

/**
 * @author hcarreno
 */
public interface ElementoNormaService {

    /**
     * @param codigoNorma
     * @param codigoElemento
     * @return
     */
    List<ElementoNorma> consultarDefinicionElementoNorma(BigDecimal codigoNorma, BigDecimal codigoElemento);

    /**
     * @param codigoNorma
     * @return
     */
    List<ElementoNorma> consultarElementosNorma(BigDecimal codigoNorma);
}
