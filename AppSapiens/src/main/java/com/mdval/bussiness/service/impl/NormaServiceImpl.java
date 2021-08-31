package com.mdval.bussiness.service.impl;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdval.bussiness.entities.Norma;
import com.mdval.bussiness.service.NormaService;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.ConfigurationSingleton;
import com.mdval.utils.Constants;
import com.mdval.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

/**
 * @author hcarreno
 */
@Service(Constants.NORMA_SERVICE)
@Log4j
public class NormaServiceImpl extends ServiceSupport implements NormaService {

    @Autowired
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public Norma consultaNorma(BigDecimal codigoNorma) {
        Norma norma = new Norma();
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig("paquete");
        String procedure = configuration.getConfig("p_consulta_norma");
        String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
        String runSP = String.format("{call %s(?,?,?,?,?,?)}", llamada);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

            logProcedure(runSP, codigoNorma);

            callableStatement.setBigDecimal(1, codigoNorma);

            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.registerOutParameter(3, Types.VARCHAR);
            callableStatement.registerOutParameter(4, Types.DATE);
            callableStatement.registerOutParameter(5, Types.INTEGER);
            callableStatement.registerOutParameter(6, Types.ARRAY, typeError);

            callableStatement.execute();

            String descripcionNorma = callableStatement.getString(2);
            String codigoUsuario = callableStatement.getString(3);
            Date fechaActualizacion = callableStatement.getDate(4);

            Integer result = callableStatement.getInt(5);

            if (result == 0) {
                Array listaErrores = callableStatement.getArray(6);
                ServiceException exception = buildException((Object[]) listaErrores.getArray());
                throw exception;
            }

            norma.toBuilder().codigoNorma(codigoNorma).descripcionNorma(descripcionNorma)
                    .codigoUsuario(codigoUsuario).fechaActualizacion(fechaActualizacion).build();

            return norma;
        } catch (SQLException e) {
            LogWrapper.error(log, "[NormaService.consultaNorma] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    public List<Norma> consultaNormas(String descripcionNorma) {
        List<Norma> normas = new ArrayList<>();

        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig("paquete");
        String procedure = configuration.getConfig("p_consulta_normas");
        String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
        String runSP = String.format("{call %s(?,?,?,?)}", llamada);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeNorma = String.format("%s.%s", paquete, Constants.T_T_NORMA).toUpperCase();
            String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

            logProcedure(runSP, descripcionNorma);

            callableStatement.setString(1, descripcionNorma);
            callableStatement.registerOutParameter(2, Types.ARRAY, typeNorma);
            callableStatement.registerOutParameter(3, Types.INTEGER);
            callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(3);

            if (result == 0) {
                Array listaErrores = callableStatement.getArray(4);
                ServiceException exception = buildException((Object[]) listaErrores.getArray());
                throw exception;
            }

            Array arrayNormas = callableStatement.getArray(2);
            if (arrayNormas != null) {
                Object[] rows = (Object[]) arrayNormas.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    Norma norma = Norma.builder().codigoNorma((BigDecimal) cols[0]).descripcionNorma((String) cols[1])
                            .codigoUsuario((String) cols[2]).fechaActualizacion((Date) cols[3]).build();
                    normas.add(norma);
                }
            }

            return normas;
        } catch (SQLException e) {
            LogWrapper.error(log, "[NormaService.consultaNormas] Error:  %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    //TODO no esta en el paquete
    public void modificaNorma(BigDecimal codigoBigDecimal, String descripcion, String usuario) {
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig("paquete");
        String procedure = configuration.getConfig("p_modifica_norma");//TODO validar nombre procedimiento, no esta en paquete
        String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
        String runSP = String.format("{call %s(?,?,?,?,?)}", llamada);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

            logProcedure(runSP, codigoBigDecimal, descripcion, usuario);

            callableStatement.setBigDecimal(1, codigoBigDecimal);
            callableStatement.setString(2, descripcion);
            callableStatement.setString(3, usuario);
            callableStatement.registerOutParameter(4, Types.INTEGER);
            callableStatement.registerOutParameter(5, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(4);

            if (result == 0) {
                Array listaErrores = callableStatement.getArray(5);
                ServiceException exception = buildException((Object[]) listaErrores.getArray());
                throw exception;
            }
        } catch (SQLException e) {
            LogWrapper.error(log, "[NormaService.modificaNorma] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    //TODO no esta en el paquete
    public void altaNorma(String descripcion, String usuario) {

        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig("paquete");
        String procedure = configuration.getConfig("p_alta_norma"); //TODO validar nombre procedimiento, no esta en paquete
        String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
        String runSP = String.format("{call %s(?,?,?,?)}", llamada);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

            logProcedure(runSP, descripcion, usuario);

            callableStatement.setString(1, descripcion);
            callableStatement.setString(2, usuario);
            callableStatement.registerOutParameter(3, Types.INTEGER);
            callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(3);

            if (result == 0) {
                Array listaErrores = callableStatement.getArray(4);
                ServiceException exception = buildException((Object[]) listaErrores.getArray());
                throw exception;
            }
        } catch (SQLException e) {
            LogWrapper.error(log, "[NormaService.altaNorma] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }

    }
}
