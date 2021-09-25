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
		String paquete = configuration.getConfig(Constants.PAQUETE);
		String procedure = configuration.getConfig("p_alta_tipo_particula");
		String llamada = String.format(FORMATO_LLAMADA, paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeError = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_ERROR).toUpperCase();

			logProcedure(runSP, particula.getDescripcionParticula(), particula.getCodigoUsuario(),
					particula.getMcaProyecto(), particula.getMcaSubProyecto());

			callableStatement.setString(1, particula.getDescripcionParticula());
			callableStatement.setString(2, particula.getCodigoUsuario());
			callableStatement.setString(3, particula.getMcaProyecto());
			callableStatement.setString(4, particula.getMcaSubProyecto());
			callableStatement.registerOutParameter(5, Types.INTEGER);
			callableStatement.registerOutParameter(6, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(5);

			if (result == 0) {
				throw buildException(callableStatement.getArray(6));
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
		String paquete = configuration.getConfig(Constants.PAQUETE);
		String procedure = configuration.getConfig("p_modifcar_tipo_particula");
		String llamada = String.format(FORMATO_LLAMADA, paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeError = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_ERROR).toUpperCase();

			logProcedure(runSP, particula.getCodigoParticula(), particula.getDescripcionParticula(),
					particula.getCodigoUsuario(), particula.getMcaProyecto(), particula.getMcaSubProyecto());

			callableStatement.setBigDecimal(1, particula.getCodigoParticula());
			callableStatement.setString(2, particula.getDescripcionParticula());
			callableStatement.setString(3, particula.getCodigoUsuario());
			callableStatement.setString(4, particula.getMcaProyecto());
			callableStatement.setString(5, particula.getMcaSubProyecto());
			callableStatement.registerOutParameter(6, Types.INTEGER);
			callableStatement.registerOutParameter(7, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(6);

			if (result == 0) {
				throw buildException(callableStatement.getArray(7));
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
		String paquete = configuration.getConfig(Constants.PAQUETE);
		String procedure = configuration.getConfig("p_con_def_tipos_particulas");
		String llamada = String.format(FORMATO_LLAMADA, paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeTipoParticula = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_PARTICULA).toUpperCase();
			String typeError = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_ERROR).toUpperCase();

			logProcedure(runSP, descripcionParticula);

			callableStatement.setString(1, descripcionParticula);

			callableStatement.registerOutParameter(2, Types.ARRAY, typeTipoParticula);
			callableStatement.registerOutParameter(3, Types.INTEGER);
			callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(3);

			if (result == 0) {
				throw buildException(callableStatement.getArray(4));
			}

			Array arrayTipoParticula = callableStatement.getArray(2);
			if (arrayTipoParticula != null) {
				Object[] rows = (Object[]) arrayTipoParticula.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
					TipoParticula tipoParticula = TipoParticula.builder().codigoParticula((BigDecimal) cols[0])
							.descripcionParticula((String) cols[1]).codigoUsuario((String) cols[2])
							.fechaActualizacion((java.util.Date) cols[3]).mcaProyecto((String) cols[4])
							.mcaSubProyecto((String) cols[5]).build();
					tipoParticulas.add(tipoParticula);
				}
			}
			return tipoParticulas;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ParticulaService.consultarDefinicionTiposParticula] Error:  %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	@SneakyThrows
	public List<TipoParticula> consultarTiposParticula(BigDecimal codigo, String sDescripcion, String mcaProyecto,
			String mcaSubproyecto) {
		List<TipoParticula> tipoParticulas = new ArrayList<>();

		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig(Constants.PAQUETE);
		String procedure = configuration.getConfig("p_con_particulas");
		String llamada = String.format(FORMATO_LLAMADA, paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeTipoParticula = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_PARTICULA).toUpperCase();
			String typeError = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_ERROR).toUpperCase();

			logProcedure(runSP, codigo, sDescripcion, mcaProyecto, mcaSubproyecto);

			callableStatement.setBigDecimal(1, codigo);
			callableStatement.setString(2, sDescripcion);
			callableStatement.setString(3, mcaProyecto);
			callableStatement.setString(4, mcaSubproyecto);
			callableStatement.registerOutParameter(5, Types.ARRAY, typeTipoParticula);
			callableStatement.registerOutParameter(6, Types.INTEGER);
			callableStatement.registerOutParameter(7, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(6);

			if (result == 0) {
				throw buildException(callableStatement.getArray(7));
			}

			Array arrayTipoParticula = callableStatement.getArray(5);
			if (arrayTipoParticula != null) {
				Object[] rows = (Object[]) arrayTipoParticula.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
					TipoParticula tipoParticula = TipoParticula.builder().codigoParticula((BigDecimal) cols[0])
							.descripcionParticula((String) cols[1]).codigoUsuario((String) cols[2])
							.fechaActualizacion((java.util.Date) cols[3]).mcaProyecto((String) cols[4])
							.mcaSubProyecto((String) cols[5]).build();
					tipoParticulas.add(tipoParticula);
				}
			}
			return tipoParticulas;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ParticulaService.consultarTiposParticula] Error:  %s", e.getMessage());
			throw new ServiceException(e);
		}
	}
}
