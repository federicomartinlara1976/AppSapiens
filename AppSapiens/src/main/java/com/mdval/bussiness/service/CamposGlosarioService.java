package com.mdval.bussiness.service;

import java.util.List;

import com.mdval.bussiness.entities.CampoGlosario;

/**
 * @author hcarreno
 */
public interface CamposGlosarioService {

    List<CampoGlosario> consultarCamposGlosario(Integer codigoGlosario, String tipoDato, String nombreColumna, Boolean mostrarExcepciones);
    String bajaCampoGlosario(Integer codigoGlosario, Integer codigoCampo);
    String altaCampoGlosario(CampoGlosario campoGlosario);
    String modificarCampoGlosario(CampoGlosario campoGlosario);
}
