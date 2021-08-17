package com.sapiens.app.bussiness.service;

import com.sapiens.app.bussiness.entities.CampoGlosario;
import com.sapiens.app.bussiness.entities.ElementoNorma;
import com.sapiens.app.bussiness.entities.Glosario;
import com.sapiens.app.bussiness.entities.Modelo;
import com.sapiens.app.bussiness.entities.Norma;
import com.sapiens.app.bussiness.entities.Particula;
import com.sapiens.app.bussiness.entities.TipoDato;
import com.sapiens.app.bussiness.entities.TipoParticula;
import com.sapiens.app.bussiness.entities.ValidaScript;
import com.sapiens.app.bussiness.entities.ValidaScriptResponse;
import com.sapiens.app.bussiness.entities.ValorParticula;
import java.util.List;

//TODO separar por funcionalidad? Glosario, Norma, Validacion, Modelo, Particula ?
public interface FirmaProcedimientosAplicacion {

    ValidaScriptResponse validaScript(ValidaScript validaScript);
    List<String> consultaElementosCorrectosValidacion(Integer numeroValidacion);
    List<String> consultaElementosNoGlosarioValidacion(Integer numeroValidacion);
    List<String> consultaElementosConErroresValidacion(Integer numeroValidacion);
    List<String> consultaElementosExcepcionesValidacion(Integer numeroValidacion);
    String insertarGlosario(Integer numeroValidacion, Integer numeroElemento);
    String insertarExcepcion(Integer numeroValidacion, Integer numeroElemento, String textoExcepcion);

    List<Glosario> buscarGlosario(String descripcionGlosario);
    Glosario consultarGlosario(String codigoGlosario);
    List<CampoGlosario> consultarCamposGlosario(Integer codigoGlosario, String tipoDato, String nombreColumna, Boolean mostrarExcepciones);

    List<Modelo> consultarModelosGlosario(Integer codigoGlosario);//TODO verificar que retorna y cambiar entidad, Modelo o ModeloGlosario

    String bajaCampoGlosario(Integer codigoGlosario, Integer codigoCampo);
    String altaCampoGlosario(CampoGlosario campoGlosario);
    String modificarCampoGlosario(CampoGlosario campoGlosario);

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
