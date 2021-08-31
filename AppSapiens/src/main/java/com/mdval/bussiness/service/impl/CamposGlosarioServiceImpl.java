package com.mdval.bussiness.service.impl;

import com.mdval.bussiness.entities.CampoGlosario;
import com.mdval.bussiness.service.CamposGlosarioService;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.ConfigurationSingleton;
import com.mdval.utils.Constants;
import com.mdval.utils.LogWrapper;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hcarreno
 */
@Service(Constants.CAMPOS_GLOSARIO_SERVICE)
@Log4j
public class CamposGlosarioServiceImpl extends ServiceSupport implements CamposGlosarioService {

    @Autowired
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public List<CampoGlosario> consultarCamposGlosario(BigDecimal codigoGlosario, String tipoDato, String nombreColumna, String mostrarExcepciones) {
        List<CampoGlosario> campoGlosarios = new ArrayList<>();
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig("paquete");
        String procedure = configuration.getConfig("p_con_campos_glosario");
        String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
        String runSP = String.format("{call %s(?,?,?,?,?,?,?)}", llamada);
        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();
            String typeCampoGlosario = String.format("%s.%s", paquete, Constants.T_T_CAMPO_GLOSARIO).toUpperCase();

            logProcedure(runSP, codigoGlosario, tipoDato, nombreColumna, mostrarExcepciones);

            callableStatement.setBigDecimal(1, codigoGlosario);
            callableStatement.setString(2, tipoDato);
            callableStatement.setString(3, nombreColumna);
            callableStatement.setString(4, mostrarExcepciones);
            callableStatement.registerOutParameter(5, Types.ARRAY, typeCampoGlosario);
            callableStatement.registerOutParameter(6, Types.INTEGER);
            callableStatement.registerOutParameter(7, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(6);

            if (result == 0) {
                Array listaErrores = callableStatement.getArray(7);
                ServiceException exception = buildException((Object[]) listaErrores.getArray());
                throw exception;
            }

            Array arrayCamposGlosario = callableStatement.getArray(5);
            if (arrayCamposGlosario != null) {
                Object[] rows = (Object[]) arrayCamposGlosario.getArray();
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
                    campoGlosarios.add(campoGlosario);
                }
            }

        } catch (SQLException e) {
            LogWrapper.error(log, "[CamposGlosarioService.consultarCamposGlosario] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
        return campoGlosarios;
    }

    @Override
    @SneakyThrows
    public void bajaCampoGlosario(CampoGlosario campoGlosario, String codigoRF, String codigoSD) {
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig("paquete");
        String procedure = configuration.getConfig("p_baja_campo_glosario");
        String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
        String runSP = String.format("{call %s(?,?,?,?,?,?,?,?,?,?,?)}", llamada);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();
            
            logProcedure(runSP, campoGlosario, codigoRF, codigoSD);

            callableStatement.setBigDecimal(1, campoGlosario.getCodigoGlosario());
            callableStatement.setString(2, campoGlosario.getNombreColumna());
            callableStatement.setString(3, campoGlosario.getTipoDato());
            callableStatement.setBigDecimal(4, campoGlosario.getNumeroLongitud());
            callableStatement.setBigDecimal(5, campoGlosario.getNumeroDecimal());
            callableStatement.setString(6, campoGlosario.getCodigoUsuario());
            callableStatement.setString(7, codigoRF);
            callableStatement.setString(8, codigoSD);
            callableStatement.setString(9, campoGlosario.getTxtComentario());

            callableStatement.registerOutParameter(10, Types.INTEGER);
            callableStatement.registerOutParameter(11, java.sql.Types.VARCHAR, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(10);

            if (result == 0) {
                Array listaErrores = callableStatement.getArray(11);
                ServiceException exception = buildException((Object[]) listaErrores.getArray());
                throw exception;
            }

        } catch (SQLException e) {
            LogWrapper.error(log, "[CamposGlosarioService.bajaCampoGlosario] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }

    }

    @Override
    @SneakyThrows
    public void altaCampoGlosario(CampoGlosario campoGlosario) {
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig("paquete");
        String procedure = configuration.getConfig("p_alta_campo_glosario");
        String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
        String runSP = String.format("{call %s(?,?,?,?,?,?,?,?,?,?,?)}", llamada);
        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();
            logProcedure(runSP, campoGlosario);

            callableStatement.setBigDecimal(1, campoGlosario.getCodigoGlosario());
            callableStatement.setString(2, campoGlosario.getNombreColumna());
            callableStatement.setString(3, campoGlosario.getTipoDato());
            callableStatement.setBigDecimal(4, campoGlosario.getNumeroLongitud());
            callableStatement.setBigDecimal(5, campoGlosario.getNumeroDecimal());
            callableStatement.setString(6, campoGlosario.getMcaExcepcion());
            callableStatement.setString(7, campoGlosario.getTxtExcepcion());
            callableStatement.setString(8, campoGlosario.getTxtComentario());
            callableStatement.setString(9, campoGlosario.getCodigoUsuario());

            callableStatement.registerOutParameter(10, Types.INTEGER);
            callableStatement.registerOutParameter(11, java.sql.Types.VARCHAR, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(10);

            if (result == 0) {
                Array listaErrores = callableStatement.getArray(11);
                ServiceException exception = buildException((Object[]) listaErrores.getArray());
                throw exception;
            }

        } catch (SQLException e) {
            LogWrapper.error(log, "[CamposGlosarioService.altaCampoGlosario] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    public void modificarCampoGlosario(CampoGlosario oldCampoGlosario, CampoGlosario newCampoGlosario) {
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig("paquete");
        String procedure = configuration.getConfig("p_modificar_campo_glosario");
        String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
        String runSP = String.format("{call %s(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}", llamada);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();
            logProcedure(runSP, oldCampoGlosario.getCodigoGlosario(), oldCampoGlosario.getNombreColumna(), oldCampoGlosario.getTipoDato(),
                    oldCampoGlosario.getNumeroLongitud(), oldCampoGlosario.getNumeroDecimal(), oldCampoGlosario.getMcaExcepcion(),
                    newCampoGlosario.getNombreColumna(), newCampoGlosario.getTipoDato(), newCampoGlosario.getNumeroLongitud(), newCampoGlosario.getNumeroDecimal(),
                    newCampoGlosario.getMcaExcepcion(), newCampoGlosario.getTxtExcepcion(), newCampoGlosario.getTxtComentario(), newCampoGlosario.getCodigoUsuario());

            callableStatement.setBigDecimal(1, oldCampoGlosario.getCodigoGlosario());
            callableStatement.setString(2, oldCampoGlosario.getNombreColumna());
            callableStatement.setString(3, oldCampoGlosario.getTipoDato());
            callableStatement.setBigDecimal(4, oldCampoGlosario.getNumeroLongitud());
            callableStatement.setBigDecimal(5, oldCampoGlosario.getNumeroDecimal());
            callableStatement.setString(6, oldCampoGlosario.getMcaExcepcion());

            callableStatement.setString(7, newCampoGlosario.getNombreColumna());
            callableStatement.setString(8, newCampoGlosario.getTipoDato());
            callableStatement.setBigDecimal(9, newCampoGlosario.getNumeroLongitud());
            callableStatement.setBigDecimal(10, newCampoGlosario.getNumeroDecimal());
            callableStatement.setString(11, newCampoGlosario.getMcaExcepcion());
            callableStatement.setString(12, newCampoGlosario.getTxtExcepcion());
            callableStatement.setString(13, newCampoGlosario.getTxtComentario());
            callableStatement.setString(14, newCampoGlosario.getCodigoUsuario());

            callableStatement.registerOutParameter(15, Types.INTEGER);
            callableStatement.registerOutParameter(16, java.sql.Types.VARCHAR, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(15);

            if (result == 0) {
                Array listaErrores = callableStatement.getArray(16);
                ServiceException exception = buildException((Object[]) listaErrores.getArray());
                throw exception;
            }

        } catch (SQLException e) {
            LogWrapper.error(log, "[CamposGlosarioService.modificarCampoGlosario] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }
}
