package com.mdval.bussiness.service;

import com.mdval.bussiness.entities.CampoGlosario;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author hcarreno
 */
public interface CamposGlosarioService {

    List<CampoGlosario> consultarCamposGlosario(BigDecimal codigoGlosario, String tipoDato, String nombreColumna, String mostrarExcepciones);

    Integer bajaCampoGlosario(CampoGlosario campoGlosario, String codigoRF, String codigoSD);

    Integer altaCampoGlosario(CampoGlosario campoGlosario);

    Integer modificarCampoGlosario(CampoGlosario oldCampoGlosario, CampoGlosario newCampoGlosario);
}
