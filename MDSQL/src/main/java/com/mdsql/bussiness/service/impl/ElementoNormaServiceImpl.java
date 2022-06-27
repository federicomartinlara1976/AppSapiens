package com.mdsql.bussiness.service.impl;


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

import com.mdsql.bussiness.entities.ElementoNorma;
import com.mdsql.bussiness.service.ElementoNormaService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.utils.Constants;
import com.mdsql.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hcarreno
 */
@Service(Constants.ELEMENTO_NORMA_SERVICE)
@Slf4j
public class ElementoNormaServiceImpl extends ServiceSupport implements ElementoNormaService {

    @Autowired
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public List<ElementoNorma> consultarDefinicionElementoNorma(BigDecimal codigoNorma, BigDecimal codigoElemento) {
        String runSP = createCall("p_con_def_elem_norma", Constants.CALL_05_ARGS);
        
        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {
        	
            String typeError = createCallTypeError();
            String typeElementoNorma = createCallType(Constants.T_T_ELEMENTO_NORMA);
            
            logProcedure(runSP, codigoNorma, codigoElemento);

            callableStatement.setBigDecimal(1, codigoNorma);
            callableStatement.setBigDecimal(2, codigoElemento);
            callableStatement.registerOutParameter(3, Types.ARRAY, typeElementoNorma);
            callableStatement.registerOutParameter(4, Types.INTEGER);
            callableStatement.registerOutParameter(5, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(4);

            if (result == 0) {
                throw buildException(callableStatement.getArray(5));
            }

            List<ElementoNorma> elementoNormas = new ArrayList<>();
            Array listaElementoNorma = callableStatement.getArray(3);
            
            if (listaElementoNorma != null) {
                Object[] rows = (Object[]) listaElementoNorma.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    ElementoNorma elementoNorma = ElementoNorma.builder()
                            .codigoNorma((BigDecimal) cols[0])
                            .descripcionNorma((String) cols[1])
                            .codigoElemento((BigDecimal) cols[2])
                            .descripcionElemento((String) cols[3])
                            .valorTamanoMaximo((BigDecimal) cols[4])
                            .txtFormato((String) cols[5])
                            .codigoUsuario((String) cols[6])
                            .fechaActualizacion((Date) cols[7])
                            .txtFormatoDescripcion1((String) cols[8])
                            .txtFormatoDescripcion2((String) cols[9])
                            .txtFormatoDescripcion3((String) cols[10])
                            .build();
                    elementoNormas.add(elementoNorma);
                }
            }

            return elementoNormas;
        } catch (SQLException e) {
            LogWrapper.error(log, "[ElementoNormaService.consultarDefinicionElementoNorma] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    public List<ElementoNorma> consultarElementosNorma(BigDecimal codigoNorma) {
        String runSP = createCall("p_con_elem_norma", Constants.CALL_04_ARGS);
        
        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeElementoNorma = createCallType(Constants.T_T_ELEMENTO_NORMA);
            String typeError = createCallTypeError();
            
            logProcedure(runSP, codigoNorma);

            callableStatement.setBigDecimal(1, codigoNorma);
            callableStatement.registerOutParameter(2, Types.ARRAY, typeElementoNorma);
            callableStatement.registerOutParameter(3, Types.INTEGER);
            callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(3);

            if (result == 0) {
                throw buildException(callableStatement.getArray(4));
            }

            List<ElementoNorma> elementoNormas = new ArrayList<>();
            Array listaElementoNorma = callableStatement.getArray(2);
            
            if (listaElementoNorma != null) {
                Object[] rows = (Object[]) listaElementoNorma.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    ElementoNorma elementoNorma = ElementoNorma.builder()
                            .codigoNorma((BigDecimal) cols[0])
                            .descripcionNorma((String) cols[1])
                            .codigoElemento((BigDecimal) cols[2])
                            .descripcionElemento((String) cols[3])
                            .valorTamanoMaximo((BigDecimal) cols[4])
                            .txtFormato((String) cols[5])
                            .codigoUsuario((String) cols[6])
                            .fechaActualizacion((Date) cols[7])
                            .txtFormatoDescripcion1((String) cols[8])
                            .txtFormatoDescripcion2((String) cols[9])
                            .txtFormatoDescripcion3((String) cols[10])
                            .build();
                    elementoNormas.add(elementoNorma);
                }
            }

            return elementoNormas;
        } catch (SQLException e) {
            LogWrapper.error(log, "[ElementoNormaService.consultarElementoNorma] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }
}
