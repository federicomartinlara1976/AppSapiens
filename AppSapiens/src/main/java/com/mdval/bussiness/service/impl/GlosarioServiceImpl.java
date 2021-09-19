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

import com.mdval.bussiness.entities.Glosario;
import com.mdval.bussiness.service.GlosarioService;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.ConfigurationSingleton;
import com.mdval.utils.Constants;
import com.mdval.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

/**
 * @author hcarreno
 */
@Service(Constants.GLOSARIO_SERVICE)
@Log4j
public class GlosarioServiceImpl extends ServiceSupport implements GlosarioService {

	@Autowired
	private DataSource dataSource;

	@Override
	@SneakyThrows
	public List<Glosario> buscarGlosarios(String descripcionGlosario) {
		List<Glosario> glosarios = new ArrayList<>();

		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_buscar_glosarios");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeGlosario = String.format("%s.%s", paquete, Constants.T_T_GLOSARIO).toUpperCase();
			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();
			
			logProcedure(runSP, descripcionGlosario);

			callableStatement.setString(1, descripcionGlosario);
			callableStatement.registerOutParameter(2, Types.ARRAY, typeGlosario);
			callableStatement.registerOutParameter(3, Types.INTEGER);
			callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(3);
			
			if (result == 0) {
				Array listaErrores = callableStatement.getArray(4);
				ServiceException exception = buildException((Object[]) listaErrores.getArray());
				throw exception;
			}

			Array listaGlosarios = callableStatement.getArray(2);
			if (listaGlosarios != null) {
				Object[] rows = (Object[]) listaGlosarios.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

					Glosario glosario = Glosario.builder().codigoGlosario((BigDecimal) cols[0])
							.descripcionGlosario((String) cols[1]).fechaAlta((Date) cols[2])
							.codigoUsuario((String) cols[3]).fechaActualizacion((Date) cols[4]).build();
					glosarios.add(glosario);
				}
			}

			return glosarios;
		} catch (SQLException e) {
			LogWrapper.error(log, "[GlosarioService.buscarGlosarios] Error:  %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	@SneakyThrows
	public Glosario consultarGlosario(BigDecimal codigoGlosario) {
		Glosario glosario = new Glosario();
		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_consulta_glosario");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?,?,?,?)}", llamada);
		
		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();
			
			logProcedure(runSP, codigoGlosario);
			
			callableStatement.setBigDecimal(1, codigoGlosario);

			callableStatement.registerOutParameter(2, Types.VARCHAR);
			callableStatement.registerOutParameter(3, Types.DATE);
			callableStatement.registerOutParameter(4, Types.VARCHAR);
			callableStatement.registerOutParameter(5, Types.DATE);
			callableStatement.registerOutParameter(6, Types.INTEGER);
			callableStatement.registerOutParameter(7, Types.ARRAY, typeError);

			callableStatement.execute();

			String descripcion = callableStatement.getString(2);
			Date fechaAlta = callableStatement.getDate(3);
			String usuario = callableStatement.getString(4);
			Date fechaActualizacion = callableStatement.getDate(5);

			Integer result = callableStatement.getInt(6);
			
			if (result == 0) {
				Array listaErrores = callableStatement.getArray(7);
				ServiceException exception = buildException((Object[]) listaErrores.getArray());
				throw exception;
			}

			glosario = Glosario.builder().codigoGlosario(codigoGlosario).descripcionGlosario(descripcion).codigoUsuario(usuario)
					.fechaAlta(fechaAlta).fechaActualizacion(fechaActualizacion).build();

			return glosario;
		} catch (SQLException e) {
			LogWrapper.error(log, "[GlosarioService.consultarGlosario] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	@SneakyThrows
	public void altaGlosario(String descripcionGlosario, String codigoUsuario) {
		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_alta_glosario");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

			logProcedure(runSP, descripcionGlosario, codigoUsuario);
			
			callableStatement.setString(1, descripcionGlosario);
			callableStatement.setString(2, codigoUsuario);
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
			LogWrapper.error(log, "[GlosarioService.altaGlosario] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	@SneakyThrows
	public void modificaGlosario(BigDecimal codigoGlosario, String descripcionGlosario, String codigoUsuario) {
		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_modifica_glosario");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?,?)}", llamada);
		
		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();
			
			logProcedure(runSP, codigoGlosario, descripcionGlosario, codigoUsuario);
			
			callableStatement.setBigDecimal(1, codigoGlosario);
			callableStatement.setString(2, descripcionGlosario);
			callableStatement.setString(3, codigoUsuario);
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
			LogWrapper.error(log, "[GlosarioService.modificaGlosario] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}
	}
}
