package com.mdval.bussiness.service;

import com.mdval.bussiness.entities.Norma;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author hcarreno
 */
public interface NormaService {

    /**
     * @param codigoNorma
     * @return
     */
    Norma consultaNorma(BigDecimal codigoNorma);

    /**
     * @param descripcionNorma
     * @return
     */
    List<Norma> consultaNormas(String descripcionNorma);

	/**
	 * @param codigoBigDecimal
	 * @param descripcion
	 * @param usuario
	 */
	void modificaNorma(BigDecimal codigoBigDecimal, String descripcion, String usuario);

	/**
	 * @param descripcion
	 * @param usuario
	 */
	void altaNorma(String descripcion, String usuario);

}
