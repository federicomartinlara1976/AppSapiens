package com.mdval.bussiness.service.impl;

import com.mdval.bussiness.entities.CampoGlosario;
import com.mdval.bussiness.entities.DetValidacion;
import com.mdval.bussiness.entities.InformeValidacion;
import com.mdval.bussiness.service.InformeService;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.ConfigurationSingleton;
import com.mdval.utils.Constants;
import com.mdval.utils.LogWrapper;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hcarreno
 */
@Service(Constants.INFORME_SERVICE)
@Log4j
public class InformeServiceImpl extends ServiceSupport implements InformeService {

    @Autowired
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public InformeValidacion generarInformeValidacion(BigDecimal codigoValidacion) {
        InformeValidacion informeValidacion = new InformeValidacion();

        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig(Constants.PAQUETE);
        String procedure = configuration.getConfig("p_generar_informe_val");
        String llamada = String.format(Constants.FORMATO_LLAMADA, paquete, procedure).toUpperCase();
        String runSP = String.format(Constants.CALL_06_ARGS, llamada);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeDetValidacion = String.format(Constants.FORMATO_LLAMADA, paquete, Constants.T_T_DET_VALIDACION).toUpperCase();
            String typeCampoGlosario = String.format(Constants.FORMATO_LLAMADA, paquete, Constants.T_T_CAMPO_GLOSARIO).toUpperCase();
            String typeError = String.format(Constants.FORMATO_LLAMADA, paquete, Constants.T_T_ERROR).toUpperCase();

            logProcedure(runSP, codigoValidacion);

            callableStatement.setBigDecimal(1, codigoValidacion);
            callableStatement.registerOutParameter(2, Types.ARRAY, typeDetValidacion);
            callableStatement.registerOutParameter(3, Types.ARRAY, typeDetValidacion);
            callableStatement.registerOutParameter(4, Types.ARRAY, typeCampoGlosario);
            callableStatement.registerOutParameter(5, Types.INTEGER);
            callableStatement.registerOutParameter(6, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(5);

            if (result == 0) {
                throw buildException(callableStatement.getArray(6));
            }

            Array arrayErroneos = callableStatement.getArray(2);
            Array arrayOtraDefinicion = callableStatement.getArray(3);
            Array arrayDefinicionGlosarios = callableStatement.getArray(4);

            List<DetValidacion> listaErroneos = getListaErroneos(arrayErroneos);
            List<DetValidacion> listaOtraDefinicion = getListaOtraDefinicion(arrayOtraDefinicion);
            List<CampoGlosario> listaDefinicionGlosario = getListaDefinicionGlosario(arrayDefinicionGlosarios);

            informeValidacion.toBuilder()
                    .listaErroneos(listaErroneos)
                    .listaOtraDefinicion(listaOtraDefinicion)
                    .listaDefinicionGlosario(listaDefinicionGlosario)
                    .build();

        } catch (SQLException e) {
            LogWrapper.error(log, "[InformeService.generarInformeValidacion] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
        return informeValidacion;
    }

    @SneakyThrows
    private List<DetValidacion> getListaErroneos(Array arrayErroneos) {
        List<DetValidacion> listaErroneos = new ArrayList<>();
        if (arrayErroneos != null) {
            Object[] rows = (Object[]) arrayErroneos.getArray();
            for (Object row : rows) {
                Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                DetValidacion detValidacion = DetValidacion.builder()
                        .numeroValidacion((BigDecimal) cols[0])
                        .numeroElementoValid((BigDecimal) cols[1])
                        .descripcionElemento((String) cols[2])
                        .nombreElemento((String) cols[3])
                        .tipoDato((String) cols[4])
                        .numeroLongitud((BigDecimal) cols[5])
                        .numeroDecimal((BigDecimal) cols[6])
                        .codigoEstadoValid((BigDecimal) cols[7])
                        .txtDescripcionValid((String) cols[8])
                        .build();

                listaErroneos.add(detValidacion);
            }
        }
        return listaErroneos;
    }

    @SneakyThrows
    private List<DetValidacion> getListaOtraDefinicion(Array arrayOtraDefinicion) {
        List<DetValidacion> listaOtraDefinicion = new ArrayList<>();
        if (arrayOtraDefinicion != null) {
            Object[] rows = (Object[]) arrayOtraDefinicion.getArray();
            for (Object row : rows) {
                Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                DetValidacion detValidacion = DetValidacion.builder()
                        .numeroValidacion((BigDecimal) cols[0])
                        .numeroElementoValid((BigDecimal) cols[1])
                        .descripcionElemento((String) cols[2])
                        .nombreElemento((String) cols[3])
                        .tipoDato((String) cols[4])
                        .numeroLongitud((BigDecimal) cols[5])
                        .numeroDecimal((BigDecimal) cols[6])
                        .codigoEstadoValid((BigDecimal) cols[7])
                        .txtDescripcionValid((String) cols[8])
                        .build();

                listaOtraDefinicion.add(detValidacion);
            }
        }
        return listaOtraDefinicion;
    }

    @SneakyThrows
    private List<CampoGlosario> getListaDefinicionGlosario(Array arrayDefinicionGlosarios) {
        List<CampoGlosario> listaDefinicionGlosario = new ArrayList<>();
        if (arrayDefinicionGlosarios != null) {
            Object[] rows = (Object[]) arrayDefinicionGlosarios.getArray();
            for (Object row : rows) {
                Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                CampoGlosario campoGlosario = CampoGlosario.builder()
                        .nombreColumna((String) cols[0])
                        .tipoDato((String) cols[1])
                        .numeroLongitud((BigDecimal) cols[2])
                        .numeroDecimal((BigDecimal) cols[3])
                        .codigoGlosario((BigDecimal) cols[4])
                        .mcaExcepcion((String) cols[5])
                        .txtComentario((String) cols[6])
                        .txtExcepcion((String) cols[7])
                        .codigoUsuario((String) cols[8])
                        .fechaActualizacion((Date) cols[9])
                        .build();

                listaDefinicionGlosario.add(campoGlosario);
            }
        }
        return listaDefinicionGlosario;
    }
}
