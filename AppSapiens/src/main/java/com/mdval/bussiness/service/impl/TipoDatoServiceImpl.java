package com.mdval.bussiness.service.impl;

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

import com.mdval.bussiness.entities.TipoDato;
import com.mdval.bussiness.service.TipoDatoService;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.ConfigurationSingleton;
import com.mdval.utils.Constants;
import com.mdval.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

/**
 * @author hcarreno
 */
@Service(Constants.TIPO_DATO_SERVICE)
@Log4j
public class TipoDatoServiceImpl extends ServiceSupport implements TipoDatoService {

	@Autowired
	private DataSource dataSource;

	@Override
	@SneakyThrows
	public List<TipoDato> consultaTipoDatos() {
		List<TipoDato> tipoDatos = new ArrayList<>();

		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig(Constants.PAQUETE);
		String procedure = configuration.getConfig("p_consulta_tipos_datos");
		String llamada = String.format(FORMATO_LLAMADA, paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
			 CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeTipoDato = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_TIPO_DATO).toUpperCase();
			String typeError = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_ERROR).toUpperCase();

			logProcedure(runSP);

			callableStatement.registerOutParameter(1, Types.ARRAY, typeTipoDato);
			callableStatement.registerOutParameter(2, Types.INTEGER);
			callableStatement.registerOutParameter(3, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(2);

			if (result == 0) {
				throw buildException(callableStatement.getArray(3));
			}

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
