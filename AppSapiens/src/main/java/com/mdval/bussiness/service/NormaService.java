package com.mdval.bussiness.service;

import java.math.BigDecimal;
import java.util.List;

import com.mdval.bussiness.entities.Norma;

/**
 * @author hcarreno
 */
public interface NormaService {

    /**
     * @param codigoNorma
     * @return
     */
    Norma consultaNorma(BigDecimal codigoNorma);

    /**
     * @param descripcionNorma
     * @return
     */
    List<Norma> consultaNormas(String descripcionNorma);
}
