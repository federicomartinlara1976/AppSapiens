package com.mdval.bussiness.service;

import com.mdval.bussiness.entities.TipoElemento;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author hcarreno
 */
public interface TipoElementoService {

    TipoElemento consultarTipoElemento(BigDecimal codigoElemento);

    List<TipoElemento> consultarTiposElementos(String descripcionElemento);

    Integer altaTipoElemento(TipoElemento tipoElemento);

    Integer modificarTipoElemento(TipoElemento tipoElemento);

}
