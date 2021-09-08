package com.mdval.bussiness.service;

import java.util.List;

import com.mdval.bussiness.entities.CampoGlosario;
import com.mdval.bussiness.entities.InformeValidacion;

/**
 * @author hcarreno
 */
public interface ExcelGeneratorService {

    void generarExcelGlosarioCampoModelo(List<CampoGlosario> camposGlosario, String path, String codigoGlosario, String descripcionGlosario);

    void generarExcelValidacionNomenclatura(InformeValidacion informeValidacion, String path);

}
