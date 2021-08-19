package com.sapiens.mdval.bussiness.service;

import java.util.List;

import com.sapiens.mdval.bussiness.entities.Glosario;

public interface GlosarioService {

    List<Glosario> buscarGlosarios(String descripcionGlosario);
    Glosario consultarGlosario(String codigoGlosario);
    String altaGlosario(String descripcionGlosario);
    String modificaGlosario(String descripcionGlosario);

}
