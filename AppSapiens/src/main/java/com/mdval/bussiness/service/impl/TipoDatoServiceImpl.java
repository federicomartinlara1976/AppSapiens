package com.mdval.bussiness.service.impl;

import com.mdval.bussiness.entities.Glosario;
import com.mdval.bussiness.entities.TipoDato;
import com.mdval.bussiness.service.GlosarioService;
import com.mdval.bussiness.service.TipoDatoService;
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
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_consulta_tipos_datos");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?)}", llamada);

		LogWrapper.debug(log, "%s", runSP);

		try (Connection conn = dataSource.getConnection();
			 CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeTipoDato = String.format("%s.%s", paquete, Constants.T_T_TIPO_DATO).toUpperCase();
			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

			logProcedure(runSP);

			callableStatement.registerOutParameter(1, Types.ARRAY, typeTipoDato);
			callableStatement.registerOutParameter(2, Types.INTEGER);
			callableStatement.registerOutParameter(3, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(3);

			if (result == 0) {
				Array listaErrores = callableStatement.getArray(4);
				ServiceException exception = buildException((Object[]) listaErrores.getArray());
				throw exception;
			}

			Array arrayTiposDatos = callableStatement.getArray(2);
			if (arrayTiposDatos != null) {
				Object[] rows = (Object[]) arrayTiposDatos.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
					TipoDato tipoDato = TipoDato.builder().tipoDato((String) cols[0]).build();
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
