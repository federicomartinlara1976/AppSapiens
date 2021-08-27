package com.mdval.bussiness.service;

import com.mdval.bussiness.entities.Particula;
import java.util.List;

/**
 * @author hcarreno
 */
public interface ParticulaService {

    Integer altaTipoParticula(Particula particula);

    Integer modificarTipoParticula(Particula particula);

    List<Particula> consultarDefinicionTiposParticula(String descripcionParticula);

}
