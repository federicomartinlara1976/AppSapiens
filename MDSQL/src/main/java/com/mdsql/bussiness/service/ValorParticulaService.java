package com.mdsql.bussiness.service;

import java.math.BigDecimal;
import java.util.List;

import com.mdsql.bussiness.entities.ValorParticula;

/**
 * @author hcarreno
 */
public interface ValorParticulaService {

    void altaValorParticula(ValorParticula valorParticula);

    void modificarTipoParticula(ValorParticula valorParticula);

    List<ValorParticula> consultarValoresParticula(BigDecimal codigoParticula);

    void modificarValorParticula(ValorParticula oldValorParticula, ValorParticula newValorParticula);

}
