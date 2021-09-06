package com.mdval.bussiness.service;

import com.mdval.bussiness.entities.CampoGlosario;
import com.mdval.bussiness.entities.InformeValidacion;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author hcarreno
 */
public interface ExcelGeneratorService {

    void generarExcelGlosarioCampoModelo(List<CampoGlosario> camposGlosario, String path, BigDecimal codigoGlosario, String descripcionGlosario);

    void generarExcelValidacionNomenclatura(InformeValidacion informeValidacion);

}
