package com.mdval.bussiness.service;

import java.util.List;

import com.mdval.bussiness.entities.Glosario;

/**
 * @author hcarreno
 */
public interface GlosarioService {

    List<Glosario> buscarGlosarios(String descripcionGlosario);
    Glosario consultarGlosario(String codigoGlosario);
    String altaGlosario(String descripcionGlosario);
    String modificaGlosario(String descripcionGlosario);

}