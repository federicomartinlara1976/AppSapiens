package com.mdval.bussiness.service.impl;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdval.bussiness.entities.CampoGlosario;
import com.mdval.bussiness.entities.DetValidacion;
import com.mdval.bussiness.entities.InformeValidacion;
import com.mdval.bussiness.entities.ValidaParticula;
import com.mdval.bussiness.entities.ValidaScriptRequest;
import com.mdval.bussiness.entities.ValidaScriptResponse;
import com.mdval.bussiness.service.ValidacionService;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.ConfigurationSingleton;
import com.mdval.utils.Constants;
import com.mdval.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleConnection;

/**
 * @author hcarreno
 */
@Service(Constants.VALIDACION_SERVICE)
@Log4j
public class ValidacionServiceImpl extends ServiceSupport implements ValidacionService {

	@Autowired
	private DataSource dataSource;

	@Override
	@SneakyThrows
	public void insertarGlosario(BigDecimal numeroValidacion, BigDecimal numeroElemento, String codigoUsuario) {
		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_insertar_en_glosario");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

			logProcedure(runSP, numeroValidacion, numeroElemento, codigoUsuario);

			callableStatement.setBigDecimal(1, numeroValidacion);
			callableStatement.setBigDecimal(2, numeroElemento);
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
			LogWrapper.error(log, "[ValidacionService.insertarGlosario] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	@SneakyThrows
	public void insertarExcepcion(BigDecimal numeroValidacion, BigDecimal numeroElemento, String txtExcepcion,
			String codigoUsuario) {

		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_insertar_excepcion");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

			logProcedure(runSP, numeroValidacion, numeroElemento, codigoUsuario);

			callableStatement.setBigDecimal(1, numeroValidacion);
			callableStatement.setBigDecimal(2, numeroElemento);
			callableStatement.setString(3, txtExcepcion);
			callableStatement.setString(4, codigoUsuario);
			callableStatement.registerOutParameter(5, Types.INTEGER);
			callableStatement.registerOutParameter(6, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(5);

			if (result == 0) {
				Array listaErrores = callableStatement.getArray(6);
				ServiceException exception = buildException((Object[]) listaErrores.getArray());
				throw exception;
			}
		} catch (SQLException e) {
			LogWrapper.error(log, "[ValidacionService.insertarExcepcion] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	@SneakyThrows
	public List<ValidaParticula> validarElemento(BigDecimal codigoNorma, String codigoProyecto,
			String codigoSubProyecto, BigDecimal codigoElemento, String nombreElemento) {
		List<ValidaParticula> validaParticulas = new ArrayList<>();

		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_validar_elemento");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?,?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeValidaParticula = String.format("%s.%s", paquete, Constants.T_T_VALIDA_PARTICULA).toUpperCase();
			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

			logProcedure(runSP, codigoNorma, codigoProyecto, codigoSubProyecto, codigoElemento, nombreElemento);

			callableStatement.setBigDecimal(1, codigoNorma);
			callableStatement.setString(2, codigoProyecto);
			callableStatement.setString(3, codigoSubProyecto);
			callableStatement.setBigDecimal(4, codigoElemento);
			callableStatement.setString(5, nombreElemento);
			callableStatement.registerOutParameter(6, Types.ARRAY, typeValidaParticula);
			callableStatement.registerOutParameter(7, Types.INTEGER);
			callableStatement.registerOutParameter(8, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(7);

			if (result == 0) {
				Array listaErrores = callableStatement.getArray(8);
				ServiceException exception = buildException((Object[]) listaErrores.getArray());
				throw exception;
			}

			Array arrayValidaParticula = callableStatement.getArray(6);
			if (arrayValidaParticula != null) {
				Object[] rows = (Object[]) arrayValidaParticula.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

					ValidaParticula validaParticula = ValidaParticula.builder().numeroParticula((BigDecimal) cols[0])
							.txtValidacion((String) cols[1]).txtValor((String) cols[2])
							.descripcionEstadoValidacion((String) cols[3]).build();
					validaParticulas.add(validaParticula);
				}
			}

			return validaParticulas;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ValidacionService.validarElemento] Error:  %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	@SneakyThrows
	public List<DetValidacion> consultaElementosCorrectosValidacion(BigDecimal numeroValidacion) {
		List<DetValidacion> detValidaciones = new ArrayList<>();

		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_con_elem_correctos_valid");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeDetValidacion = String.format("%s.%s", paquete, Constants.T_T_DET_VALIDACION).toUpperCase();
			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

			logProcedure(runSP, numeroValidacion);

			callableStatement.setBigDecimal(1, numeroValidacion);
			callableStatement.registerOutParameter(2, Types.ARRAY, typeDetValidacion);
			callableStatement.registerOutParameter(3, Types.INTEGER);
			callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(3);

			if (result == 0) {
				Array listaErrores = callableStatement.getArray(4);
				ServiceException exception = buildException((Object[]) listaErrores.getArray());
				throw exception;
			}

			Array arrayDetValidacion = callableStatement.getArray(2);
			if (arrayDetValidacion != null) {
				Object[] rows = (Object[]) arrayDetValidacion.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

					DetValidacion detValidacion = DetValidacion.builder().numeroValidacion((BigDecimal) cols[0])
							.numeroElementoValid((BigDecimal) cols[1]).descripcionElemento((String) cols[2])
							.nombreElemento((String) cols[3]).nombreTabla((String) cols[4]).tipoDato((String) cols[5])
							.numeroLongitud((BigDecimal) cols[6]).numeroDecimal((BigDecimal) cols[7])
							.codigoEstadoValid((BigDecimal) cols[8]).txtDescripcionValid((String) cols[9]).build();
					detValidaciones.add(detValidacion);
				}
			}
			return detValidaciones;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ValidacionService.consultaElementosCorrectosValidacion] Error:  %s",
					e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	@SneakyThrows
	public List<DetValidacion> consultaElementosConErroresValidacion(BigDecimal numeroValidacion) {
		List<DetValidacion> detValidaciones = new ArrayList<>();

		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_con_elem_errores_validacion");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeDetValidacion = String.format("%s.%s", paquete, Constants.T_T_DET_VALIDACION).toUpperCase();
			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

			logProcedure(runSP, numeroValidacion);

			callableStatement.setBigDecimal(1, numeroValidacion);
			callableStatement.registerOutParameter(2, Types.ARRAY, typeDetValidacion);
			callableStatement.registerOutParameter(3, Types.INTEGER);
			callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(3);

			if (result == 0) {
				Array listaErrores = callableStatement.getArray(4);
				ServiceException exception = buildException((Object[]) listaErrores.getArray());
				throw exception;
			}

			Array arrayDetValidacion = callableStatement.getArray(2);
			if (arrayDetValidacion != null) {
				Object[] rows = (Object[]) arrayDetValidacion.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

					DetValidacion detValidacion = DetValidacion.builder().numeroValidacion((BigDecimal) cols[0])
							.numeroElementoValid((BigDecimal) cols[1]).descripcionElemento((String) cols[2])
							.nombreElemento((String) cols[3]).nombreTabla((String) cols[4]).tipoDato((String) cols[5])
							.numeroLongitud((BigDecimal) cols[6]).numeroDecimal((BigDecimal) cols[7])
							.codigoEstadoValid((BigDecimal) cols[8]).txtDescripcionValid((String) cols[9]).build();
					detValidaciones.add(detValidacion);
				}
			}
			return detValidaciones;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ValidacionService.consultaElementosConErroresValidacion] Error:  %s",
					e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	@SneakyThrows
	public List<DetValidacion> consultaElementosExcepcionesValidacion(BigDecimal numeroValidacion) {
		List<DetValidacion> detValidaciones = new ArrayList<>();

		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_con_elem_excepciones_valid");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeDetValidacion = String.format("%s.%s", paquete, Constants.T_T_DET_VALIDACION).toUpperCase();
			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

			logProcedure(runSP, numeroValidacion);

			callableStatement.setBigDecimal(1, numeroValidacion);
			callableStatement.registerOutParameter(2, Types.ARRAY, typeDetValidacion);
			callableStatement.registerOutParameter(3, Types.INTEGER);
			callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(3);

			if (result == 0) {
				Array listaErrores = callableStatement.getArray(4);
				ServiceException exception = buildException((Object[]) listaErrores.getArray());
				throw exception;
			}

			Array arrayDetValidacion = callableStatement.getArray(2);
			if (arrayDetValidacion != null) {
				Object[] rows = (Object[]) arrayDetValidacion.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

					DetValidacion detValidacion = DetValidacion.builder().numeroValidacion((BigDecimal) cols[0])
							.numeroElementoValid((BigDecimal) cols[1]).descripcionElemento((String) cols[2])
							.nombreElemento((String) cols[3]).nombreTabla((String) cols[4]).tipoDato((String) cols[5])
							.numeroLongitud((BigDecimal) cols[6]).numeroDecimal((BigDecimal) cols[7])
							.codigoEstadoValid((BigDecimal) cols[8]).txtDescripcionValid((String) cols[9]).build();
					detValidaciones.add(detValidacion);
				}
			}
			return detValidaciones;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ValidacionService.consultaElementosExcepcionesValidacion] Error:  %s",
					e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	@SneakyThrows
	public List<DetValidacion> consultaElementosNoGlosarioValidacion(BigDecimal numeroValidacion) {
		List<DetValidacion> detValidaciones = new ArrayList<>();

		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_con_elem_no_glosario_valid");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeDetValidacion = String.format("%s.%s", paquete, Constants.T_T_DET_VALIDACION).toUpperCase();
			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

			logProcedure(runSP, numeroValidacion);

			callableStatement.setBigDecimal(1, numeroValidacion);
			callableStatement.registerOutParameter(2, Types.ARRAY, typeDetValidacion);
			callableStatement.registerOutParameter(3, Types.INTEGER);
			callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(3);

			if (result == 0) {
				Array listaErrores = callableStatement.getArray(4);
				ServiceException exception = buildException((Object[]) listaErrores.getArray());
				throw exception;
			}

			Array arrayDetValidacion = callableStatement.getArray(2);
			if (arrayDetValidacion != null) {
				Object[] rows = (Object[]) arrayDetValidacion.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

					DetValidacion detValidacion = DetValidacion.builder().numeroValidacion((BigDecimal) cols[0])
							.numeroElementoValid((BigDecimal) cols[1]).descripcionElemento((String) cols[2])
							.nombreElemento((String) cols[3]).nombreTabla((String) cols[4]).tipoDato((String) cols[5])
							.numeroLongitud((BigDecimal) cols[6]).numeroDecimal((BigDecimal) cols[7])
							.codigoEstadoValid((BigDecimal) cols[8]).txtDescripcionValid((String) cols[9]).build();
					detValidaciones.add(detValidacion);
				}
			}
			return detValidaciones;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ValidacionService.consultaElementosExcepcionesValidacion] Error:  %s",
					e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	@SneakyThrows
	public ValidaScriptResponse validaScript(ValidaScriptRequest validaScriptRequest) {
		ValidaScriptResponse validaScriptResponse = new ValidaScriptResponse();
		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_valida_script");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?,?,?,?,?,?,?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
				OracleCallableStatement callableStatement = (OracleCallableStatement) conn.prepareCall(runSP)) {

			String typeDetValidacion = String.format("%s.%s", paquete, Constants.T_T_DET_VALIDACION).toUpperCase();
			String trLinea = String.format("%s.%s", paquete, Constants.T_R_LINEA).toUpperCase();
			String tableLinea = String.format("%s.%s", paquete, Constants.T_T_LINEA).toUpperCase();
			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

			// El script se manda manda línea a línea
			Struct[] struct = new Struct[validaScriptRequest.getLines().size()];
			
			int arrayIndex = 0;
			for (String linea : validaScriptRequest.getLines()) {
				struct[arrayIndex++] = conn.createStruct(trLinea,
						new Object[]{ linea });
			}
			
			Array lineaArray = ((OracleConnection) conn).createOracleArray(tableLinea, struct);

			logProcedure(runSP, validaScriptRequest.getCodigoRF(), validaScriptRequest.getCodigoSD(),
					validaScriptRequest.getCodigoProyecto(), validaScriptRequest.getCodigoSubProyecto(),
					validaScriptRequest.getCodigoUsuario(), validaScriptRequest.getNombreFichero(),
					validaScriptRequest.getLines());

			callableStatement.setArray(1, lineaArray);
			callableStatement.setString(2, validaScriptRequest.getCodigoRF());
			callableStatement.setString(3, validaScriptRequest.getCodigoSD());
			callableStatement.setString(4, validaScriptRequest.getCodigoProyecto());
			callableStatement.setString(5, validaScriptRequest.getCodigoSubProyecto());
			callableStatement.setString(6, validaScriptRequest.getCodigoUsuario());
			callableStatement.setString(7, validaScriptRequest.getNombreFichero());

			callableStatement.registerOutParameter(8, Types.NUMERIC);
			callableStatement.registerOutParameter(9, Types.ARRAY, typeDetValidacion);
			callableStatement.registerOutParameter(10, Types.VARCHAR);
			callableStatement.registerOutParameter(11, Types.VARCHAR);
			callableStatement.registerOutParameter(12, Types.INTEGER);
			callableStatement.registerOutParameter(13, Types.ARRAY, typeError);

			callableStatement.execute();

			BigDecimal numeroValidacion = callableStatement.getBigDecimal(8);
			String elementosNoGlosario = callableStatement.getString(10);
			String elementosErrores = callableStatement.getString(11);

			Integer result = callableStatement.getInt(12);

			if (result == 0) {
				Array listaErrores = callableStatement.getArray(13);
				ServiceException exception = buildException((Object[]) listaErrores.getArray());
				throw exception;
			}
			List<DetValidacion> detValidaciones = new ArrayList<>();
			Array arrayDetValidacion = callableStatement.getArray(9);
			if (arrayDetValidacion != null) {
				Object[] rows = (Object[]) arrayDetValidacion.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

					DetValidacion detValidacion = DetValidacion.builder().numeroValidacion((BigDecimal) cols[0])
							.numeroElementoValid((BigDecimal) cols[1]).descripcionElemento((String) cols[2])
							.nombreTabla((String) cols[3]).nombreElemento((String) cols[4]).tipoDato((String) cols[5])
							.numeroLongitud((BigDecimal) cols[6]).numeroDecimal((BigDecimal) cols[7])
							.codigoEstadoValid((BigDecimal) cols[8]).txtDescripcionValid((String) cols[9]).build();
					detValidaciones.add(detValidacion);
				}
			}
			validaScriptResponse = ValidaScriptResponse.builder().numeroValidacion(numeroValidacion)
					.listaElementosValid(detValidaciones).elementosNoGlosario(elementosNoGlosario)
					.elementosErrores(elementosErrores).build();

			return validaScriptResponse;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ValidacionService.validaScript] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	@SneakyThrows
	public InformeValidacion generarInformeValidacion(BigDecimal numeroValidacion) {
		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_generar_informe_val");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();
			String typeDetValidacion = String.format("%s.%s", paquete, Constants.T_T_DET_VALIDACION).toUpperCase();
			String typeCampoGlosario = String.format("%s.%s", paquete, Constants.T_T_CAMPO_GLOSARIO).toUpperCase();

			logProcedure(runSP, numeroValidacion);

			callableStatement.setBigDecimal(1, numeroValidacion);
			callableStatement.registerOutParameter(2, Types.ARRAY, typeDetValidacion);
			callableStatement.registerOutParameter(3, Types.ARRAY, typeDetValidacion);
			callableStatement.registerOutParameter(4, Types.ARRAY, typeCampoGlosario);
			callableStatement.registerOutParameter(5, Types.INTEGER);
			callableStatement.registerOutParameter(6, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(5);

			if (result == 0) {
				Array listaErrores = callableStatement.getArray(6);
				ServiceException exception = buildException((Object[]) listaErrores.getArray());
				throw exception;
			}

			Array arrayDetValidacion = callableStatement.getArray(2);
			List<DetValidacion> listaErrores = toListDetalles(arrayDetValidacion);

			arrayDetValidacion = callableStatement.getArray(3);
			List<DetValidacion> listaOtraDef = toListDetalles(arrayDetValidacion);

			Array arrayCampoGlosario = callableStatement.getArray(4);
			List<CampoGlosario> listaCampos = toListCampos(arrayCampoGlosario);

			InformeValidacion informeValidacion = new InformeValidacion();
			informeValidacion.setNumValidacion(numeroValidacion);
			informeValidacion.setListaErroneos(listaErrores);
			informeValidacion.setListaOtraDefinicion(listaOtraDef);
			informeValidacion.setListaDefinicionGlosario(listaCampos);

			return informeValidacion;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ValidacionService.generarInformeValidacion] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	/**
	 * @param arrayCamposGlosario
	 * @return
	 * @throws SQLException
	 */
	private List<CampoGlosario> toListCampos(Array arrayCamposGlosario) throws SQLException {
		List<CampoGlosario> camposGlosario = new ArrayList<>();

		if (arrayCamposGlosario != null) {
			Object[] rows = (Object[]) arrayCamposGlosario.getArray();
			for (Object row : rows) {
				Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

				CampoGlosario campoGlosario = CampoGlosario.builder().nombreColumna((String) cols[0])
						.tipoDato((String) cols[1]).numeroLongitud((BigDecimal) cols[2])
						.numeroDecimal((BigDecimal) cols[3]).codigoGlosario((BigDecimal) cols[4])
						.mcaExcepcion((String) cols[5]).txtComentario((String) cols[6]).txtExcepcion((String) cols[7])
						.codigoUsuario((String) cols[8]).fechaActualizacion((Date) cols[9]).build();
				camposGlosario.add(campoGlosario);
			}
		}

		return camposGlosario;
	}

	private List<DetValidacion> toListDetalles(Array arrayDetValidacion) throws SQLException {
		List<DetValidacion> detValidaciones = new ArrayList<>();

		if (arrayDetValidacion != null) {
			Object[] rows = (Object[]) arrayDetValidacion.getArray();
			for (Object row : rows) {
				Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

				DetValidacion detValidacion = DetValidacion.builder().numeroValidacion((BigDecimal) cols[0])
						.numeroElementoValid((BigDecimal) cols[1]).descripcionElemento((String) cols[2])
						.nombreElemento((String) cols[3]).nombreTabla((String) cols[4]).tipoDato((String) cols[5])
						.numeroLongitud((BigDecimal) cols[6]).numeroDecimal((BigDecimal) cols[7])
						.codigoEstadoValid((BigDecimal) cols[8]).txtDescripcionValid((String) cols[9]).build();
				detValidaciones.add(detValidacion);
			}
		}

		return detValidaciones;
	}
}
