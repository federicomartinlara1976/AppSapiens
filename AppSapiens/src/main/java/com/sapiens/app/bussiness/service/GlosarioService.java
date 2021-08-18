package com.sapiens.app.bussiness.service;

import com.sapiens.app.bussiness.entities.Glosario;
import java.util.List;

public interface GlosarioService {

    List<Glosario> buscarGlosarios(String descripcionGlosario);
    Glosario consultarGlosario(String codigoGlosario);
    String altaGlosario(String descripcionGlosario);
    String modificaGlosario(String descripcionGlosario);

}
