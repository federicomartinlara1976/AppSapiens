package com.mdsql.bussiness.service;

import java.util.List;

import com.mdsql.bussiness.entities.CampoGlosario;
import com.mdsql.bussiness.entities.InformeValidacion;

/**
 * @author hcarreno
 */
public interface ExcelGeneratorService {

    void generarExcelGlosarioCampoModelo(List<CampoGlosario> camposGlosario, String path, String codigoGlosario, String descripcionGlosario);

    void generarExcelValidacionNomenclatura(InformeValidacion informeValidacion, String path);

}
