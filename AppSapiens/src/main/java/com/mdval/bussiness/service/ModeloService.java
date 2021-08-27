package com.mdval.bussiness.service;

import com.mdval.bussiness.entities.Modelo;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author hcarreno
 */
public interface ModeloService {

    Integer altaModelo(Modelo modelo);

    Integer bajaLogicaModelo(String codigoProyecto, String codigoUsuario);

    List<Modelo> consultaModelos(String codigoProyecto, String nombreModelo, BigDecimal codigoNorma, BigDecimal codigoGlosario, String nombreEsquema, String nombreBbdd, String mostrarInh);

    Modelo consultaModelo(String codigoProyecto);

    List<Modelo> consultarModelosGlosario(BigDecimal codigoGlosario);

    Integer modificaModelo(Modelo modelo);

}
