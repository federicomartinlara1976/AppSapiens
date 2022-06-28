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

import com.mdval.bussiness.entities.CampoGlosario;
import com.mdval.bussiness.entities.Modelo;
import com.mdval.bussiness.service.CamposGlosarioService;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.MDValConstants;
import com.mdval.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hcarreno
 */
@Service(MDValConstants.CAMPOS_GLOSARIO_SERVICE)
@Slf4j
public class CamposGlosarioServiceImpl extends ServiceSupport implements CamposGlosarioService {

	@Autowired
	private DataSource dataSource;

	@Override
	@SneakyThrows
	public List<CampoGlosario> consultarCamposGlosario(BigDecimal codigoGlosario, String tipoDato, String nombreColumna,
			String mostrarExcepciones) {
		String runSP = createCall("p_con_campos_glosario", MDValConstants.CALL_07_ARGS);
		
		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeError = createCallTypeError();
			String typeCampoGlosario = createCallType(MDValConstants.T_T_CAMPO_GLOSARIO);

			logProcedure(runSP, codigoGlosario, tipoDato, nombreColumna, mostrarExcepciones);

			callableStatement.setBigDecimal(1, codigoGlosario);
			callableStatement.setString(2, tipoDato);
			callableStatement.setString(3, nombreColumna);
			callableStatement.setString(4, mostrarExcepciones);
			callableStatement.registerOutParameter(5, Types.ARRAY, typeCampoGlosario);
			callableStatement.registerOutParameter(6, Types.INTEGER);
			callableStatement.registerOutParameter(7, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(6);

			if (result == 0) {
				throw buildException(callableStatement.getArray(7));
			}

			List<CampoGlosario> campoGlosarios = new ArrayList<>();
			Array arrayCamposGlosario = callableStatement.getArray(5);
			if (arrayCamposGlosario != null) {
				Object[] rows = (Object[]) arrayCamposGlosario.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

					CampoGlosario campoGlosario = CampoGlosario.builder().nombreColumna((String) cols[0])
							.tipoDato((String) cols[1]).numeroLongitud((BigDecimal) cols[2])
							.numeroDecimal((BigDecimal) cols[3]).codigoGlosario((BigDecimal) cols[4])
							.mcaExcepcion((String) cols[5]).txtComentario((String) cols[6])
							.txtExcepcion((String) cols[7]).codigoUsuario((String) cols[8])
							.fechaActualizacion((Date) cols[9]).build();
					campoGlosarios.add(campoGlosario);
				}
			}

			return campoGlosarios;
		} catch (SQLException e) {
			LogWrapper.error(log, "[CamposGlosarioService.consultarCamposGlosario] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	@SneakyThrows
	public void bajaCampoGlosario(CampoGlosario campoGlosario, String codigoRF, String codigoSD, String comentario, String codUsuario) {
		String runSP = createCall("p_baja_campo_glosario", MDValConstants.CALL_11_ARGS);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeError = createCallTypeError();

			logProcedure(runSP, campoGlosario.getCodigoGlosario(), campoGlosario.getNombreColumna(),
					campoGlosario.getTipoDato(), campoGlosario.getNumeroLongitud(),
					campoGlosario.getNumeroDecimal(), campoGlosario.getCodigoUsuario(), 
					codigoRF, codigoSD, comentario);

			callableStatement.setBigDecimal(1, campoGlosario.getCodigoGlosario());
			callableStatement.setString(2, campoGlosario.getNombreColumna());
			callableStatement.setString(3, campoGlosario.getTipoDato());
			callableStatement.setBigDecimal(4, campoGlosario.getNumeroLongitud());
			callableStatement.setBigDecimal(5, campoGlosario.getNumeroDecimal());
			callableStatement.setString(6, codUsuario);
			callableStatement.setString(7, codigoRF);
			callableStatement.setString(8, codigoSD);
			callableStatement.setString(9, comentario);

			callableStatement.registerOutParameter(10, Types.INTEGER);
			callableStatement.registerOutParameter(11, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(10);

			if (result == 0) {
				throw buildException(callableStatement.getArray(11));
			}

		} catch (SQLException e) {
			LogWrapper.error(log, "[CamposGlosarioService.bajaCampoGlosario] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}

	}

	@Override
	@SneakyThrows
	public void altaCampoGlosario(CampoGlosario campoGlosario) {
		String runSP = createCall("p_alta_campo_glosario", MDValConstants.CALL_11_ARGS);
		
		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeError = createCallTypeError();
			
			logProcedure(runSP, campoGlosario.getCodigoGlosario(), campoGlosario.getNombreColumna(),
					campoGlosario.getTipoDato(), campoGlosario.getNumeroLongitud(), campoGlosario.getNumeroDecimal(),
					campoGlosario.getMcaExcepcion(), campoGlosario.getTxtExcepcion(), campoGlosario.getTxtComentario(),
					campoGlosario.getCodigoUsuario());

			callableStatement.setBigDecimal(1, campoGlosario.getCodigoGlosario());
			callableStatement.setString(2, campoGlosario.getNombreColumna());
			callableStatement.setString(3, campoGlosario.getTipoDato());
			callableStatement.setBigDecimal(4, campoGlosario.getNumeroLongitud());
			callableStatement.setBigDecimal(5, campoGlosario.getNumeroDecimal());
			callableStatement.setString(6, campoGlosario.getMcaExcepcion());
			callableStatement.setString(7, campoGlosario.getTxtExcepcion());
			callableStatement.setString(8, campoGlosario.getTxtComentario());
			callableStatement.setString(9, campoGlosario.getCodigoUsuario());

			callableStatement.registerOutParameter(10, Types.INTEGER);
			callableStatement.registerOutParameter(11, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(10);

			if (result == 0) {
				throw buildException(callableStatement.getArray(11));
			}

		} catch (SQLException e) {
			LogWrapper.error(log, "[CamposGlosarioService.altaCampoGlosario] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	@SneakyThrows
	public void modificarCampoGlosario(CampoGlosario oldCampoGlosario, CampoGlosario newCampoGlosario) {
		String runSP = createCall("p_modificar_campo_glosario", MDValConstants.CALL_15_ARGS);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeError = createCallTypeError();
			
			logProcedure(runSP, oldCampoGlosario.getCodigoGlosario(), oldCampoGlosario.getNombreColumna(),
					oldCampoGlosario.getTipoDato(), oldCampoGlosario.getNumeroLongitud(),
					oldCampoGlosario.getNumeroDecimal(), oldCampoGlosario.getMcaExcepcion(),
					newCampoGlosario.getNombreColumna(), newCampoGlosario.getTipoDato(),
					newCampoGlosario.getNumeroLongitud(), newCampoGlosario.getNumeroDecimal(),
					newCampoGlosario.getMcaExcepcion(), newCampoGlosario.getTxtExcepcion(),
					newCampoGlosario.getTxtComentario(), newCampoGlosario.getCodigoUsuario());

			callableStatement.setBigDecimal(1, oldCampoGlosario.getCodigoGlosario());
			callableStatement.setString(2, oldCampoGlosario.getNombreColumna());
			callableStatement.setString(3, oldCampoGlosario.getTipoDato());
			callableStatement.setBigDecimal(4, oldCampoGlosario.getNumeroLongitud());
			callableStatement.setBigDecimal(5, oldCampoGlosario.getNumeroDecimal());

			callableStatement.setString(6, newCampoGlosario.getNombreColumna());
			callableStatement.setString(7, newCampoGlosario.getTipoDato());
			callableStatement.setBigDecimal(8, newCampoGlosario.getNumeroLongitud());
			callableStatement.setBigDecimal(9, newCampoGlosario.getNumeroDecimal());
			callableStatement.setString(10, newCampoGlosario.getMcaExcepcion());
			callableStatement.setString(11, newCampoGlosario.getTxtExcepcion());
			callableStatement.setString(12, newCampoGlosario.getTxtComentario());
			callableStatement.setString(13, newCampoGlosario.getCodigoUsuario());

			callableStatement.registerOutParameter(14, Types.INTEGER);
			callableStatement.registerOutParameter(15, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(14);

			if (result == 0) {
				throw buildException(callableStatement.getArray(15));
			}

		} catch (SQLException e) {
			LogWrapper.error(log, "[CamposGlosarioService.modificarCampoGlosario] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	/**
	 *
	 */
	@Override
	@SneakyThrows
	public List<Modelo> consultarModelosGlosario(BigDecimal codigoGlosario) {
		String runSP = createCall("p_con_modelos_glosario", MDValConstants.CALL_04_ARGS);
		
		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeError = createCallTypeError();
			String typeModeloGlosario = createCallType(MDValConstants.T_T_MODELO);

			logProcedure(runSP, codigoGlosario);

			callableStatement.setBigDecimal(1, codigoGlosario);
			callableStatement.registerOutParameter(2, Types.ARRAY, typeModeloGlosario);
			callableStatement.registerOutParameter(3, Types.INTEGER);
			callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(3);

			if (result == 0) {
				throw buildException(callableStatement.getArray(4));
			}

			List<Modelo> modelos = new ArrayList<>();
			Array arrayModelosGlosario = callableStatement.getArray(2);
			
			if (arrayModelosGlosario != null) {
				Object[] rows = (Object[]) arrayModelosGlosario.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

					Modelo modelo = Modelo.builder().codigoProyecto((String) cols[0])
							.nombreModelo((String) cols[1]).nombreEsquema((String) cols[2])
							.nombreBbdd((String) cols[3]).codigoGrupoBds((String) cols[4])
							.nombreCarpetaAdj((String) cols[5]).codigoNorma((BigDecimal) cols[6])
							.descripcionNorma((String) cols[7]).nomApnCmdb((String) cols[8])
							.codigoGlosario((BigDecimal) cols[9]).descripcionGlosario((String) cols[10])
							.codigoHerramienta((String) cols[11]).observacionesModelo((String) cols[12])
							.codigoUsuario((String) cols[13]).fechaActualizacion((Date) cols[14])
							.codigoCapaUsrown((String) cols[15]).mcaVariables((String) cols[16])
							.mcaGrantAll((String) cols[17]).mcaGrantPublic((String) cols[18])
							.mcaInh((String) cols[19]).build();
					modelos.add(modelo);
				}
			}

			return modelos;
		} catch (SQLException e) {
			LogWrapper.error(log, "[CamposGlosarioService.consultarModelosGlosario] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}
	}
}
