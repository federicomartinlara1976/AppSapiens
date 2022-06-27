package com.mdsql.bussiness.service;

import java.math.BigDecimal;
import java.util.List;

import com.mdsql.bussiness.entities.TipoElemento;

/**
 * @author hcarreno
 */
public interface TipoElementoService {

    TipoElemento consultarTipoElemento(BigDecimal codigoElemento);

    List<TipoElemento> consultarTiposElementos(String descripcionElemento);

    void altaTipoElemento(String descripcionElemento, String codigoUsuario);

    void modificarTipoElemento(BigDecimal codigoElemento, String descripcionElemento, String codigoUsuario);

}
