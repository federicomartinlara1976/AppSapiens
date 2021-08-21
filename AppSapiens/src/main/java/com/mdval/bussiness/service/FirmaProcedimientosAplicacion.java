package com.mdval.bussiness.service;

import java.util.List;

import com.mdval.bussiness.entities.ElementoNorma;
import com.mdval.bussiness.entities.Modelo;
import com.mdval.bussiness.entities.Norma;
import com.mdval.bussiness.entities.Particula;
import com.mdval.bussiness.entities.TipoDato;
import com.mdval.bussiness.entities.TipoParticula;
import com.mdval.bussiness.entities.ValidaScript;
import com.mdval.bussiness.entities.ValidaScriptResponse;
import com.mdval.bussiness.entities.ValorParticula;

//TODO separar por funcionalidad? Glosario, Norma, Validacion, Modelo, Particula ?
public interface FirmaProcedimientosAplicacion {

    ValidaScriptResponse validaScript(ValidaScript validaScript);
    List<String> consultaElementosCorrectosValidacion(Integer numeroValidacion);
    List<String> consultaElementosNoGlosarioValidacion(Integer numeroValidacion);
    List<String> consultaElementosConErroresValidacion(Integer numeroValidacion);
    List<String> consultaElementosExcepcionesValidacion(Integer numeroValidacion);

    String insertarGlosario(Integer numeroValidacion, Integer numeroElemento);
    String insertarExcepcion(Integer numeroValidacion, Integer numeroElemento, String textoExcepcion);


    List<Modelo> consultarModelosGlosario(Integer codigoGlosario);//TODO verificar que retorna y cambiar entidad, Modelo o ModeloGlosario


    List<Norma> consultaNormas(String descripcionNorma);
    Norma consultaNorma(Integer codigoNorma);
    List<ElementoNorma> consultarElementoNorma(Integer codigoNorma);

    List<Particula> consultarParticulasElemento(Integer codigoNorma, Integer codigoParticula);//TODO verrificar entidad ParticulaElemento
    List<ElementoNorma> consultarTiposElementos(String descripcionElemento);//TODO verrificar entidad TipoElemento

    String consultarTipoElemento(Integer codigoElemento); //TODO respuesta descripcion, usuario, fecha
    String altaTipoElemento(String descripcionElemento);
    String modificarTipoElemento(String descripcionElemento);

    List<String> consultarDefinicionElementoNorma(Integer codigoNorma, Integer codigoElemento); //TODO respuesta DefinicionElemento
    List<String> consultarDefinicionTipoParticula(String descripcionTipoParticula); //TODO  respuesta DefinicionParticula

    String altaTipoParticula(String descripcionTipoParticula, Boolean distinguePorProyecto);
    String modificarTipoParticula(String descripcionTipoParticula, Boolean distinguePorProyecto);

    List<TipoParticula> consultarDefinicionParticulaNormaElemento(Integer codigoNorma, Integer codigoElemento);

    List<TipoParticula> consultarParticulas(Integer codigoParticula, String descripcionParticula, String proyecto, String subProyecto);
    List<ValorParticula> consultarValoresParticula(Integer codigoParticula);
    String altaValorParticula(ValorParticula valorParticula);
    String modificarValorParticula(ValorParticula valorParticula);

    List<String> validarElemento(Integer codigoModelo, Integer codigoSubModelo, Integer codigoElemento, String nombre); //TODO  respuesta ValidacionesRealizadas

    List<Modelo> consultaModelos(Integer codigoModelo, String nombreModelo, Integer codigoNorma, Integer glosario, String esquema, String baseDatos, Boolean mostrarDeshabilitados); //TODO peticion Modelo?
    String bajaLogicaModelo(Integer codigoModelo);
    Modelo consultaModelo(Integer codigoModelo);
    String altaModelo(Modelo modelo);
    String modificaModelo(Modelo modelo);

    String generarInformeValidacion(Integer codigoValidacion); //TODO  respuesta Informe con listaErrores, listaNoGlosario, listaOtraDefinicion
    List<TipoDato> consultaTipoDatos();
}
