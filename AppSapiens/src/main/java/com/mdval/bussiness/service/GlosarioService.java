package com.mdval.bussiness.service;

import java.math.BigDecimal;
import java.util.List;

import com.mdval.bussiness.entities.Glosario;

/**
 * @author hcarreno
 */
public interface GlosarioService {

    List<Glosario> buscarGlosarios(String descripcionGlosario);
    Glosario consultarGlosario(BigDecimal codigoGlosario);
    Integer altaGlosario(BigDecimal codigoGlosario, String descripcionGlosario, String usuario);
    Integer modificaGlosario(BigDecimal codigoGlosario, String descripcionGlosario, String usuario);

}
