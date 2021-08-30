package com.mdval.bussiness.service;

import com.mdval.bussiness.entities.TipoParticula;

import java.util.List;

/**
 * @author hcarreno
 */
public interface TipoParticulaService {

    void altaTipoParticula(TipoParticula particula);

    void modificarTipoParticula(TipoParticula particula);

    List<TipoParticula> consultarDefinicionTiposParticula(String descripcionParticula);

}
