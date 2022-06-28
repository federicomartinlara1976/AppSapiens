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

import com.mdval.bussiness.entities.TipoElemento;
import com.mdval.bussiness.service.TipoElementoService;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.MDValConstants;
import com.mdval.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hcarreno
 */
@Service(MDValConstants.TIPO_ELEMENTO_SERVICE)
@Slf4j
public class TipoElementoServiceImpl extends ServiceSupport implements TipoElementoService {

    @Autowired
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public TipoElemento consultarTipoElemento(BigDecimal codigoElemento) {
        String runSP = createCall("p_con_tipo_elemento", MDValConstants.CALL_06_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = createCallTypeError();

            logProcedure(runSP, codigoElemento);

            callableStatement.setBigDecimal(1, codigoElemento);

            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.registerOutParameter(3, Types.VARCHAR);
            callableStatement.registerOutParameter(4, Types.DATE);
            callableStatement.registerOutParameter(5, Types.INTEGER);
            callableStatement.registerOutParameter(6, Types.ARRAY, typeError);

            callableStatement.execute();

            String descripcion = callableStatement.getString(2);
            String usuario = callableStatement.getString(3);
            Date fechaActualizacion = callableStatement.getDate(4);

            Integer result = callableStatement.getInt(5);

            if (result == 0) {
                throw buildException(callableStatement.getArray(6));
            }

            return TipoElemento.builder().codigoElemento(codigoElemento).descripcionElemento(descripcion).codigoUsuario(usuario)
                    .fechaActualizacion(fechaActualizacion).build();
            
        } catch (SQLException e) {
            LogWrapper.error(log, "[TipoElementoService.consultarTipoElemento] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    public List<TipoElemento> consultarTiposElementos(String descripcionElemento) {
        String runSP = createCall("p_con_tipos_elementos", MDValConstants.CALL_04_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeTipoElemento = createCallType(MDValConstants.T_T_ELEMENTO);
            String typeError = createCallTypeError();

            logProcedure(runSP, descripcionElemento);

            callableStatement.setString(1, descripcionElemento);

            callableStatement.registerOutParameter(2, Types.ARRAY, typeTipoElemento);
            callableStatement.registerOutParameter(3, Types.INTEGER);
            callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(3);

            if (result == 0) {
                throw buildException(callableStatement.getArray(4));
            }

            List<TipoElemento> tipoElementos = new ArrayList<>();
            Array arrayTipoElemento = callableStatement.getArray(2);
            
            if (arrayTipoElemento != null) {
                Object[] rows = (Object[]) arrayTipoElemento.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
                    TipoElemento tipoElemento = TipoElemento.builder()
                            .codigoElemento((BigDecimal) cols[0])
                            .descripcionElemento((String) cols[1])
                            .codigoUsuario((String) cols[2])
                            .fechaActualizacion((java.util.Date) cols[3])
                            .build();
                    tipoElementos.add(tipoElemento);
                }
            }
            return tipoElementos;
        } catch (SQLException e) {
            LogWrapper.error(log, "[TipoElementoService.consultarTiposElementos] Error:  %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    public void altaTipoElemento(String descripcionElemento, String codigoUsuario) {
        String runSP = createCall("p_alta_tipo_elemento", MDValConstants.CALL_04_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = createCallTypeError();

            logProcedure(runSP, descripcionElemento, codigoUsuario);

            callableStatement.setString(1, descripcionElemento);
            callableStatement.setString(2, codigoUsuario);
            callableStatement.registerOutParameter(3, Types.INTEGER);
            callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(3);

            if (result == 0) {
                throw buildException(callableStatement.getArray(4));
            }
        } catch (SQLException e) {
            LogWrapper.error(log, "[TipoElementoService.altaTipoElemento] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    public void modificarTipoElemento(BigDecimal codigoElemento, String descripcionElemento, String codigoUsuario) {
        String runSP = createCall("p_modificar_tipo_elemento", MDValConstants.CALL_05_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = createCallTypeError();

            logProcedure(runSP, codigoElemento, descripcionElemento, codigoUsuario);

            callableStatement.setBigDecimal(1, codigoElemento);
            callableStatement.setString(2, descripcionElemento);
            callableStatement.setString(3, codigoUsuario);
            callableStatement.registerOutParameter(4, Types.INTEGER);
            callableStatement.registerOutParameter(5, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(4);

            if (result == 0) {
                throw buildException(callableStatement.getArray(5));
            }
        } catch (SQLException e) {
            LogWrapper.error(log, "[TipoElementoService.modificarTipoElemento] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }
}
