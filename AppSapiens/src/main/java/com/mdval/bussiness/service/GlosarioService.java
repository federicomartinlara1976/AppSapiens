package com.mdval.bussiness.service;

import java.util.List;

import com.mdval.bussiness.entities.Glosario;

/**
 * @author hcarreno
 */
public interface GlosarioService {

    List<Glosario> buscarGlosarios(String descripcionGlosario);
    Glosario consultarGlosario(Double codigoGlosario);
    Integer altaGlosario(Double codigoGlosario, String descripcionGlosario, String usuario);
    Integer modificaGlosario(Double codigoGlosario, String descripcionGlosario, String usuario);

}
