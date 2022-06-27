package com.mdsql.bussiness.service;

import java.math.BigDecimal;
import java.util.List;

import com.mdsql.bussiness.entities.DetValidacion;
import com.mdsql.bussiness.entities.InformeValidacion;
import com.mdsql.bussiness.entities.ValidaParticula;
import com.mdsql.bussiness.entities.ValidaScriptRequest;
import com.mdsql.bussiness.entities.ValidaScriptResponse;

/**
 * @author hcarreno
 */
public interface ValidacionService {

    void insertarGlosario(BigDecimal numeroValidacion, BigDecimal numeroElemento, String codigoUsuario);

    void insertarExcepcion(BigDecimal numeroValidacion, BigDecimal numeroElemento, String txtExcepcion, String codigoUsuario);

    List<ValidaParticula> validarElemento(BigDecimal codigoNorma, String codigoProyecto, String codigoSubProyecto, BigDecimal codigoElemento, String nombreElemento);

    List<DetValidacion> consultaElementosCorrectosValidacion(BigDecimal numeroValidacion);

    List<DetValidacion> consultaElementosConErroresValidacion(BigDecimal numeroValidacion);

    List<DetValidacion> consultaElementosExcepcionesValidacion(BigDecimal numeroValidacion);

    List<DetValidacion> consultaElementosNoGlosarioValidacion(BigDecimal numeroValidacion);

    ValidaScriptResponse validaScript(ValidaScriptRequest validaScriptRequest);
    
    InformeValidacion generarInformeValidacion(BigDecimal numeroValidacion);

}
