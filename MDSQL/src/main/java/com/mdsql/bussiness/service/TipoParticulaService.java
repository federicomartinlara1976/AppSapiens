package com.mdsql.bussiness.service;

import java.math.BigDecimal;
import java.util.List;

import com.mdsql.bussiness.entities.TipoParticula;

/**
 * @author hcarreno
 */
public interface TipoParticulaService {

    /**
     * @param particula
     */
    void altaTipoParticula(TipoParticula particula);

    /**
     * @param particula
     */
    void modificarTipoParticula(TipoParticula particula);

    /**
     * @param descripcionParticula
     * @return
     */
    List<TipoParticula> consultarDefinicionTiposParticula(String descripcionParticula);

	/**
	 * @param codigo
	 * @param sDescripcion
	 * @param mcaProyecto
	 * @param mcaSubproyecto
	 * @return
	 */
	List<TipoParticula> consultarTiposParticula(BigDecimal codigo, String sDescripcion, String mcaProyecto,
			String mcaSubproyecto);

}
