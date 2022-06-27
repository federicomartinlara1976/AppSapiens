package com.mdsql.bussiness.service;

import java.math.BigDecimal;
import java.util.List;

import com.mdsql.bussiness.entities.Glosario;

/**
 * @author hcarreno
 */
public interface GlosarioService {

    /**
     * @param descripcionGlosario
     * @return
     * 
     * @throws ServiceException
     */
    List<Glosario> buscarGlosarios(String descripcionGlosario);

    /**
     * @param codigoGlosario
     * @return
     * 
     * @throws ServiceException
     */
    Glosario consultarGlosario(BigDecimal codigoGlosario);

    /**
     * @param descripcionGlosario
     * @param usuario
     * @return
     * 
     * @throws ServiceException
     */
    void altaGlosario(String descripcionGlosario, String usuario);

    /**
     * @param codigoGlosario
     * @param descripcionGlosario
     * @param usuario
     * @return
     * 
     * @throws ServiceException
     */
    void modificaGlosario(BigDecimal codigoGlosario, String descripcionGlosario, String usuario);

}
