package com.mdval.bussiness.service;

import com.mdval.bussiness.entities.CampoGlosario;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author hcarreno
 */
public interface CamposGlosarioService {

    /**
     * @param codigoGlosario
     * @param tipoDato
     * @param nombreColumna
     * @param mostrarExcepciones
     * @return
     */
    List<CampoGlosario> consultarCamposGlosario(BigDecimal codigoGlosario, String tipoDato, String nombreColumna, String mostrarExcepciones);

    /**
     * @param campoGlosario
     * @param codigoRF
     * @param codigoSD
     * @param comentario
     * @param codUsuario
     */
    void bajaCampoGlosario(CampoGlosario campoGlosario, String codigoRF, String codigoSD, String comentario, String codUsuario);

    /**
     * @param campoGlosario
     */
    void altaCampoGlosario(CampoGlosario campoGlosario);

    /**
     * @param oldCampoGlosario
     * @param newCampoGlosario
     */
    void modificarCampoGlosario(CampoGlosario oldCampoGlosario, CampoGlosario newCampoGlosario);
}
