package com.mdval.bussiness.service;

import com.mdval.bussiness.entities.Glosario;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author hcarreno
 */
public interface GlosarioService {

    List<Glosario> buscarGlosarios(String descripcionGlosario);

    Glosario consultarGlosario(BigDecimal codigoGlosario);

    Integer altaGlosario(String descripcionGlosario, String usuario);

    Integer modificaGlosario(BigDecimal codigoGlosario, String descripcionGlosario, String usuario);

}
