package com.mdval.bussiness.service;

import com.mdval.bussiness.entities.ValorParticula;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author hcarreno
 */
public interface ValorParticulaService {

    Integer altaValorParticula(ValorParticula valorParticula);

    Integer modificarTipoParticula(ValorParticula valorParticula);

    List<ValorParticula> consultarValoresParticula(BigDecimal codigoParticula);

    List<ValorParticula> consultarDefinicionTiposParticula(String valorParticula);

    Integer modificarValorParticula(ValorParticula oldValorParticula, ValorParticula newValorParticula);

}
