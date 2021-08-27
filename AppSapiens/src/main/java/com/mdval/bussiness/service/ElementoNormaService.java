package com.mdval.bussiness.service;

import com.mdval.bussiness.entities.ElementoNorma;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author hcarreno
 */
public interface ElementoNormaService {

    List<ElementoNorma> consultarDefinicionElementoNorma(BigDecimal codigoNorma, BigDecimal codigoElemento);

    List<ElementoNorma> consultarElementoNorma(BigDecimal codigoNorma);
}
