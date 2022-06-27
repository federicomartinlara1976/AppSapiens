package com.mdsql.bussiness.service;

import java.math.BigDecimal;
import java.util.List;

import com.mdsql.bussiness.entities.CampoGlosario;
import com.mdsql.bussiness.entities.Modelo;

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

	/**
	 * @param codigoGlosario
	 * @return
	 */
	List<Modelo> consultarModelosGlosario(BigDecimal codigoGlosario);
}
