package com.mdval.bussiness.service;

import com.mdval.bussiness.entities.ValorParticula;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author hcarreno
 */
public interface ValorParticulaService {

    void altaValorParticula(ValorParticula valorParticula);

    void modificarTipoParticula(ValorParticula valorParticula);

    List<ValorParticula> consultarValoresParticula(BigDecimal codigoParticula);

    void modificarValorParticula(ValorParticula oldValorParticula, ValorParticula newValorParticula);

}
