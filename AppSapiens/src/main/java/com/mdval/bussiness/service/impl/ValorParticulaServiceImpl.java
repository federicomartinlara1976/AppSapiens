package com.mdval.bussiness.service.impl;

import com.mdval.bussiness.entities.ValorParticula;
import com.mdval.bussiness.service.ValorParticulaService;
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
@Service(Constants.VALOR_PARTICULA_SERVICE)
@Log4j
public class ValorParticulaServiceImpl extends ServiceSupport implements ValorParticulaService {

	@Autowired
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public void altaValorParticula(ValorParticula valorParticula) {
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig(Constants.PAQUETE);
        String procedure = configuration.getConfig("p_alta_valor_particula");
        String llamada = String.format(FORMATO_LLAMADA, paquete, procedure).toUpperCase();
        String runSP = String.format(Constants.CALL_09_ARGS, llamada);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_ERROR).toUpperCase();
            logProcedure(runSP, valorParticula.getCodigoParticula(), valorParticula.getValorParticula(), valorParticula.getDescripcionValorParticula(),
                    valorParticula.getCodigoProyecto(), valorParticula.getCodigoSubProyecto(), valorParticula.getValorParticulaPadre(), valorParticula.getCodigoUsuario());

            callableStatement.setBigDecimal(1, valorParticula.getCodigoParticula());
            callableStatement.setString(2, valorParticula.getValorParticula());
            callableStatement.setString(3, valorParticula.getDescripcionValorParticula());
            callableStatement.setString(4, valorParticula.getCodigoProyecto());
            callableStatement.setString(5, valorParticula.getCodigoSubProyecto());
            callableStatement.setString(6, valorParticula.getValorParticulaPadre());
            callableStatement.setString(7, valorParticula.getCodigoUsuario());
            callableStatement.registerOutParameter(8, Types.INTEGER);
            callableStatement.registerOutParameter(9, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(8);

            if (result == 0) {
                throw buildException(callableStatement.getArray(9));
            }

        } catch (SQLException e) {
            LogWrapper.error(log, "[ValorParticulaService.altaValorParticula] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    public void modificarTipoParticula(ValorParticula valorParticula) {
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig(Constants.PAQUETE);
        String procedure = configuration.getConfig("p_alta_valor_particula");
        String llamada = String.format(FORMATO_LLAMADA, paquete, procedure).toUpperCase();
        String runSP = String.format(Constants.CALL_09_ARGS, llamada);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_ERROR).toUpperCase();
            logProcedure(runSP, valorParticula.getCodigoParticula(), valorParticula.getValorParticula(), valorParticula.getDescripcionValorParticula(),
                    valorParticula.getCodigoProyecto(), valorParticula.getCodigoSubProyecto(), valorParticula.getValorParticulaPadre(), valorParticula.getCodigoUsuario());

            callableStatement.setBigDecimal(1, valorParticula.getCodigoParticula());
            callableStatement.setString(2, valorParticula.getValorParticula());
            callableStatement.setString(3, valorParticula.getDescripcionValorParticula());
            callableStatement.setString(4, valorParticula.getCodigoProyecto());
            callableStatement.setString(5, valorParticula.getCodigoSubProyecto());
            callableStatement.setString(6, valorParticula.getValorParticulaPadre());
            callableStatement.setString(7, valorParticula.getCodigoUsuario());
            callableStatement.registerOutParameter(8, Types.INTEGER);
            callableStatement.registerOutParameter(9, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(8);

            if (result == 0) {
                throw buildException(callableStatement.getArray(9));
            }

        } catch (SQLException e) {
            LogWrapper.error(log, "[ValorParticulaService.altaValorParticula] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    public List<ValorParticula> consultarValoresParticula(BigDecimal codigoParticula) {
        List<ValorParticula> valorParticulas = new ArrayList<>();
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig(Constants.PAQUETE);
        String procedure = configuration.getConfig("p_con_valores_particula");
        String llamada = String.format(FORMATO_LLAMADA, paquete, procedure).toUpperCase();
        String runSP = String.format(Constants.CALL_04_ARGS, llamada);
        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_ERROR).toUpperCase();
            String typeValorParticula = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_VAL_PARTICULA).toUpperCase();

            logProcedure(runSP, codigoParticula);

            callableStatement.setBigDecimal(1, codigoParticula);
            callableStatement.registerOutParameter(2, Types.ARRAY, typeValorParticula);
            callableStatement.registerOutParameter(3, Types.INTEGER);
            callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(3);

            if (result == 0) {
                throw buildException(callableStatement.getArray(4));
            }

            Array arrayValorParticulas = callableStatement.getArray(2);
            if (arrayValorParticulas != null) {
                Object[] rows = (Object[]) arrayValorParticulas.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    ValorParticula valorParticula = ValorParticula.builder()
                            .codigoParticula((BigDecimal) cols[0])
                            .valorParticula((String) cols[1])
                            .descripcionValorParticula((String) cols[2])
                            .codigoProyecto((String) cols[3])
                            .codigoSubProyecto((String) cols[4])
                            .valorParticulaPadre((String) cols[5])
                            .codigoUsuario((String) cols[6])
                            .fechaActualizacion((Date) cols[7])
                            .build();
                    valorParticulas.add(valorParticula);
                }
            }

        } catch (SQLException e) {
            LogWrapper.error(log, "[ValorParticulaService.consultarValoresParticula] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
        return valorParticulas;
    }

    @Override
    @SneakyThrows
    public void modificarValorParticula(ValorParticula oldValorParticula, ValorParticula newValorParticula) {

        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig(Constants.PAQUETE);
        String procedure = configuration.getConfig("p_modificar_valor_particula");
        String llamada = String.format(FORMATO_LLAMADA, paquete, procedure).toUpperCase();
        String runSP = String.format(Constants.CALL_12_ARGS, llamada);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_ERROR).toUpperCase();
            logProcedure(runSP, oldValorParticula.getCodigoParticula(), oldValorParticula.getValorParticula(), oldValorParticula.getCodigoProyecto(),
                    oldValorParticula.getCodigoSubProyecto(), newValorParticula.getValorParticula(), newValorParticula.getDescripcionValorParticula(),
                    newValorParticula.getCodigoProyecto(), newValorParticula.getCodigoSubProyecto(), newValorParticula.getValorParticulaPadre(), newValorParticula.getCodigoUsuario());

            callableStatement.setBigDecimal(1, oldValorParticula.getCodigoParticula());
            callableStatement.setString(2, oldValorParticula.getValorParticula());
            callableStatement.setString(3, oldValorParticula.getCodigoProyecto());
            callableStatement.setString(4, oldValorParticula.getCodigoSubProyecto());

            callableStatement.setString(5, newValorParticula.getValorParticula());
            callableStatement.setString(6, newValorParticula.getDescripcionValorParticula());
            callableStatement.setString(7, newValorParticula.getCodigoProyecto());
            callableStatement.setString(8, newValorParticula.getCodigoSubProyecto());
            callableStatement.setString(9, newValorParticula.getValorParticulaPadre());
            callableStatement.setString(10, newValorParticula.getCodigoUsuario());

            callableStatement.registerOutParameter(11, Types.INTEGER);
            callableStatement.registerOutParameter(12, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(11);

            if (result == 0) {
                throw buildException(callableStatement.getArray(12));
            }

        } catch (SQLException e) {
            LogWrapper.error(log, "[ValorParticulaService.modificarValorParticula] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }

    }
}
