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

import com.mdval.bussiness.entities.ValorParticula;
import com.mdval.bussiness.service.ValorParticulaService;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.MDValConstants;
import com.mdval.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hcarreno
 */
@Service(MDValConstants.VALOR_PARTICULA_SERVICE)
@Slf4j
public class ValorParticulaServiceImpl extends ServiceSupport implements ValorParticulaService {

	@Autowired
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public void altaValorParticula(ValorParticula valorParticula) {
        String runSP = createCall("p_alta_valor_particula", MDValConstants.CALL_09_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = createCallTypeError();
            
            logProcedure(runSP, valorParticula.getCodigoParticula(), valorParticula.getValor(), valorParticula.getDescripcionValorParticula(),
                    valorParticula.getCodigoProyecto(), valorParticula.getCodigoSubProyecto(), valorParticula.getValorParticulaPadre(), valorParticula.getCodigoUsuario());

            callableStatement.setBigDecimal(1, valorParticula.getCodigoParticula());
            callableStatement.setString(2, valorParticula.getValor());
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
        String runSP = createCall("p_alta_valor_particula", MDValConstants.CALL_09_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = createCallTypeError();
            
            logProcedure(runSP, valorParticula.getCodigoParticula(), valorParticula.getValor(), valorParticula.getDescripcionValorParticula(),
                    valorParticula.getCodigoProyecto(), valorParticula.getCodigoSubProyecto(), valorParticula.getValorParticulaPadre(), valorParticula.getCodigoUsuario());

            callableStatement.setBigDecimal(1, valorParticula.getCodigoParticula());
            callableStatement.setString(2, valorParticula.getValor());
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
        String runSP = createCall("p_con_valores_particula", MDValConstants.CALL_04_ARGS);
        
        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {
        	
            String typeValorParticula = createCallType(MDValConstants.T_T_VAL_PARTICULA);
            String typeError = createCallTypeError();
            
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

            List<ValorParticula> valorParticulas = new ArrayList<>();
            Array arrayValorParticulas = callableStatement.getArray(2);
            
            if (arrayValorParticulas != null) {
                Object[] rows = (Object[]) arrayValorParticulas.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    ValorParticula valorParticula = ValorParticula.builder()
                            .codigoParticula((BigDecimal) cols[0])
                            .valor((String) cols[1])
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

            return valorParticulas;
        } catch (SQLException e) {
            LogWrapper.error(log, "[ValorParticulaService.consultarValoresParticula] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    public void modificarValorParticula(ValorParticula oldValorParticula, ValorParticula newValorParticula) {
    	String runSP = createCall("p_modificar_valor_particula", MDValConstants.CALL_12_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = createCallTypeError();
            
            logProcedure(runSP, oldValorParticula.getCodigoParticula(), oldValorParticula.getValor(), oldValorParticula.getCodigoProyecto(),
                    oldValorParticula.getCodigoSubProyecto(), newValorParticula.getValor(), newValorParticula.getDescripcionValorParticula(),
                    newValorParticula.getCodigoProyecto(), newValorParticula.getCodigoSubProyecto(), newValorParticula.getValorParticulaPadre(), newValorParticula.getCodigoUsuario());

            callableStatement.setBigDecimal(1, oldValorParticula.getCodigoParticula());
            callableStatement.setString(2, oldValorParticula.getValor());
            callableStatement.setString(3, oldValorParticula.getCodigoProyecto());
            callableStatement.setString(4, oldValorParticula.getCodigoSubProyecto());

            callableStatement.setString(5, newValorParticula.getValor());
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
