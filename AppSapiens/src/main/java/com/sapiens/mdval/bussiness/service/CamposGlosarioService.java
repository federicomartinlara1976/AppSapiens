package com.sapiens.mdval.bussiness.service;

import com.sapiens.mdval.bussiness.entities.CampoGlosario;
import java.util.List;

/**
 * @author hcarreno
 */
public interface CamposGlosarioService {

    List<CampoGlosario> consultarCamposGlosario(Integer codigoGlosario, String tipoDato, String nombreColumna, Boolean mostrarExcepciones);
    String bajaCampoGlosario(Integer codigoGlosario, Integer codigoCampo);
    String altaCampoGlosario(CampoGlosario campoGlosario);
    String modificarCampoGlosario(CampoGlosario campoGlosario);
}
