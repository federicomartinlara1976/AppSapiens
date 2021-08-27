package com.mdval.bussiness.service;

import com.mdval.bussiness.entities.InformeValidacion;
import java.math.BigDecimal;

/**
 * @author hcarreno
 */
public interface InformeService {

    InformeValidacion generarInformeValidacion(BigDecimal codigoValidacion);

}
