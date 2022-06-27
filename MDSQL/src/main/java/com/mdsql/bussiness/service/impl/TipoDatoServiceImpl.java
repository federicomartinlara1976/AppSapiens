package com.mdsql.bussiness.service.impl;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdsql.bussiness.entities.TipoDato;
import com.mdsql.bussiness.service.TipoDatoService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.utils.Constants;
import com.mdsql.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hcarreno
 */
@Service(Constants.TIPO_DATO_SERVICE)
@Slf4j
public class TipoDatoServiceImpl extends ServiceSupport implements TipoDatoService {

	@Autowired
	private DataSource dataSource;

	@Override
	@SneakyThrows
	public List<TipoDato> consultaTipoDatos() {
		String runSP = createCall("p_consulta_tipos_datos", Constants.CALL_03_ARGS);

		try (Connection conn = dataSource.getConnection();
			 CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeTipoDato = createCallType(Constants.T_T_TIPO_DATO);
			String typeError = createCallTypeError();

			logProcedure(runSP);

			callableStatement.registerOutParameter(1, Types.ARRAY, typeTipoDato);
			callableStatement.registerOutParameter(2, Types.INTEGER);
			callableStatement.registerOutParameter(3, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(2);

			if (result == 0) {
				throw buildException(callableStatement.getArray(3));
			}

			List<TipoDato> tipoDatos = new ArrayList<>();
			Array arrayTiposDatos = callableStatement.getArray(1);
			
			if (arrayTiposDatos != null) {
				Object[] rows = (Object[]) arrayTiposDatos.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
					TipoDato tipoDato = TipoDato.builder().valor((String) cols[0]).build();
					tipoDatos.add(tipoDato);
				}
			}
			return tipoDatos;
		} catch (SQLException e) {
			LogWrapper.error(log, "[TipoDatoService.consultaTipoDatos] Error:  %s", e.getMessage());
			throw new ServiceException(e);
		}
	}
}
