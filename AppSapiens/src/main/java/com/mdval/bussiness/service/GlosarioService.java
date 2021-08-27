package com.mdval.bussiness.service;

import java.math.BigDecimal;
import java.util.List;

import com.mdval.bussiness.entities.Glosario;

/**
 * @author hcarreno
 */
public interface GlosarioService {

    /**
     * @param descripcionGlosario
     * @return
     */
    List<Glosario> buscarGlosarios(String descripcionGlosario);

    /**
     * @param codigoGlosario
     * @return
     */
    Glosario consultarGlosario(BigDecimal codigoGlosario);

    /**
     * @param descripcionGlosario
     * @param usuario
     * @return
     */
    Integer altaGlosario(String descripcionGlosario, String usuario);

    /**
     * @param codigoGlosario
     * @param descripcionGlosario
     * @param usuario
     * @return
     */
    Integer modificaGlosario(BigDecimal codigoGlosario, String descripcionGlosario, String usuario);

}
