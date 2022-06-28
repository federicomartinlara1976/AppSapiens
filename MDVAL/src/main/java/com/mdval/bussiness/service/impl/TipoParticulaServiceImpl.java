package com.mdval.bussiness.service.impl;

import java.math.BigDecimal;
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

import com.mdval.bussiness.entities.TipoParticula;
import com.mdval.bussiness.service.TipoParticulaService;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.MDValConstants;
import com.mdval.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hcarreno
 */
@Service(MDValConstants.TIPO_PARTICULA_SERVICE)
@Slf4j
public class TipoParticulaServiceImpl extends ServiceSupport implements TipoParticulaService {

	@Autowired
	private DataSource dataSource;

	@Override
	@SneakyThrows
	public void altaTipoParticula(TipoParticula particula) {
		String runSP = createCall("p_alta_tipo_particula", MDValConstants.CALL_06_ARGS);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeError = createCallTypeError();

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
		String runSP = createCall("p_modifcar_tipo_particula", MDValConstants.CALL_07_ARGS);

		try (Connection conn = dataSource.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeError = createCallTypeError();

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
		String runSP = createCall("p_con_def_tipos_particulas", MDValConstants.CALL_04_ARGS);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeTipoParticula = createCallType(MDValConstants.T_T_PARTICULA);
			String typeError = createCallTypeError();

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

			List<TipoParticula> tipoParticulas = new ArrayList<>();
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
		String runSP = createCall("p_con_particulas", MDValConstants.CALL_07_ARGS);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeTipoParticula = createCallType(MDValConstants.T_T_PARTICULA);
			String typeError = createCallTypeError();

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

			List<TipoParticula> tipoParticulas = new ArrayList<>();
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
