package com.mdval.bussiness.service;

import com.mdval.bussiness.entities.Norma;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author hcarreno
 */
public interface NormaService {

    Norma consultaNorma(BigDecimal codigoNorma);

    List<Norma> consultaNormas(String descripcionNorma);

}
