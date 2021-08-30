package com.mdval.bussiness.service.impl;

import com.mdval.bussiness.entities.TipoParticula;
import com.mdval.bussiness.service.TipoParticulaService;
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
import java.util.List;

/**
 * @author hcarreno
 */
@Service(Constants.TIPO_PARTICULA_SERVICE)
@Log4j
public class TipoParticulaServiceImpl extends ServiceSupport implements TipoParticulaService {

    @Autowired
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public void altaTipoParticula(TipoParticula particula) {
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig("paquete");
        String procedure = configuration.getConfig("p_alta_tipo_particula");
        String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
        String runSP = String.format("{call %s(?,?,?,?,?.?)}", llamada);

        LogWrapper.debug(log, "%s", runSP);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

            logProcedure(runSP, particula.getDescripcionParticula(), particula.getCodigoUsuario(), particula.getMcaProyecto(), particula.getMcaSubProyecto());

            callableStatement.setString(1, particula.getDescripcionParticula());
            callableStatement.setString(2, particula.getCodigoUsuario());
            callableStatement.setString(3, particula.getMcaProyecto());
            callableStatement.setString(4, particula.getMcaSubProyecto());
            callableStatement.registerOutParameter(5, Types.INTEGER);
            callableStatement.registerOutParameter(6, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(5);

            if (result == 0) {
                Array listaErrores = callableStatement.getArray(6);
                ServiceException exception = buildException((Object[]) listaErrores.getArray());
                throw exception;
            }
        } catch (SQLException e) {
            LogWrapper.error(log, "[ParticulaService.consultarDefinicionTiposParticula] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    public void modificarTipoParticula(TipoParticula particula) {
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig("paquete");
        String procedure = configuration.getConfig("p_modificar_tipo_particula");//TODO validar nombre p_modifcar_tipo_particula
        String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
        String runSP = String.format("{call %s(?,?,?,?,?.?,?)}", llamada);

        LogWrapper.debug(log, "%s", runSP);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

            logProcedure(runSP, particula.getCodigoParticula(), particula.getDescripcionParticula(), particula.getCodigoUsuario(), particula.getMcaProyecto(), particula.getMcaSubProyecto());

            callableStatement.setBigDecimal(1, particula.getCodigoParticula());
            callableStatement.setString(2, particula.getDescripcionParticula());
            callableStatement.setString(3, particula.getCodigoUsuario());
            callableStatement.setString(4, particula.getMcaProyecto());
            callableStatement.setString(5, particula.getMcaSubProyecto());
            callableStatement.registerOutParameter(6, Types.INTEGER);
            callableStatement.registerOutParameter(7, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(5);

            if (result == 0) {
                Array listaErrores = callableStatement.getArray(6);
                ServiceException exception = buildException((Object[]) listaErrores.getArray());
                throw exception;
            }
        } catch (SQLException e) {
            LogWrapper.error(log, "[ParticulaService.consultarDefinicionTiposParticula] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    public List<TipoParticula> consultarDefinicionTiposParticula(String descripcionParticula) {
        List<TipoParticula> tipoParticulas = new ArrayList<>();

        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig("paquete");
        String procedure = configuration.getConfig("p_con_def_tipos_particulas");
        String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
        String runSP = String.format("{call %s(?,?,?,?)}", llamada);

        LogWrapper.debug(log, "%s", runSP);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeTipoParticula = String.format("%s.%s", paquete, Constants.T_T_PARTICULA).toUpperCase();
            String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

            callableStatement.setString(1, descripcionParticula);

            callableStatement.registerOutParameter(2, Types.ARRAY, typeTipoParticula);
            callableStatement.registerOutParameter(3, Types.INTEGER);
            callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(3);

            if (result == 0) {
                Array listaErrores = callableStatement.getArray(4);
                ServiceException exception = buildException((Object[]) listaErrores.getArray());
                throw exception;
            }

            Array arrayTipoParticula = callableStatement.getArray(2);
            if (arrayTipoParticula != null) {
                Object[] rows = (Object[]) arrayTipoParticula.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
                    TipoParticula tipoParticula = TipoParticula.builder()
                            .codigoParticula((BigDecimal) cols[0])
                            .descripcionParticula((String) cols[1])
                            .codigoUsuario((String) cols[2])
                            .fechaActualizacion((java.util.Date) cols[3])
                            .mcaProyecto((String) cols[4])
                            .mcaSubProyecto((String) cols[5])
                            .build();
                    tipoParticulas.add(tipoParticula);
                }
            }
            return tipoParticulas;
        } catch (SQLException e) {
            LogWrapper.error(log, "[ParticulaService.consultarDefinicionTiposParticula] Error:  %s", e.getMessage());
            throw new ServiceException(e);
        }
    }
}
