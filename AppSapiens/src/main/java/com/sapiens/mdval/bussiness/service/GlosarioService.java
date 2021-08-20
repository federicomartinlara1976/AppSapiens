package com.sapiens.mdval.bussiness.service;

import com.sapiens.mdval.bussiness.entities.Glosario;
import java.util.List;

/**
 * @author hcarreno
 */
public interface GlosarioService {

    List<Glosario> buscarGlosarios(String descripcionGlosario);
    Glosario consultarGlosario(String codigoGlosario);
    String altaGlosario(String descripcionGlosario);
    String modificaGlosario(String descripcionGlosario);

}
