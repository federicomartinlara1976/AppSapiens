package com.mdval.bussiness.service;

import java.math.BigDecimal;
import java.util.List;

import com.mdval.bussiness.entities.DetValidacion;
import com.mdval.bussiness.entities.InformeValidacion;
import com.mdval.bussiness.entities.ValidaParticula;
import com.mdval.bussiness.entities.ValidaScriptRequest;
import com.mdval.bussiness.entities.ValidaScriptResponse;

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
