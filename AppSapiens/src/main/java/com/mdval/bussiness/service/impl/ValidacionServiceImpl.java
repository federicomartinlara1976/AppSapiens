package com.mdval.bussiness.service.impl;

import com.mdval.bussiness.entities.DetValidacion;
import com.mdval.bussiness.entities.ValidaParticula;
import com.mdval.bussiness.entities.ValidaScriptRequest;
import com.mdval.bussiness.entities.ValidaScriptResponse;
import com.mdval.bussiness.entities.types.TypeLine;
import com.mdval.bussiness.service.ValidacionService;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.ConfigurationSingleton;
import com.mdval.utils.Constants;
import com.mdval.utils.LogWrapper;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.OracleCallableStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public void insertarExcepcion(BigDecimal numeroValidacion, BigDecimal numeroElemento, String txtExcepcion, String codigoUsuario) {

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
	public List<ValidaParticula> validarElemento(BigDecimal codigoNorma, String codigoProyecto, String codigoSubProyecto, BigDecimal codigoElemento, String nombreElemento) {
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

					ValidaParticula validaParticula = ValidaParticula.builder()
							.numeroParticula((Integer) cols[0])
							.txtValidacion((String) cols[1])
							.txtValor((String) cols[2])
							.descripcionEstadoValidacion((String) cols[3])
							.build();
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

					DetValidacion detValidacion = DetValidacion.builder()
							.numeroValidacion((BigDecimal) cols[0])
							.numeroElementoValid((BigDecimal) cols[1])
							.descripcionElemento((String) cols[2])
							.nombreElemento((String) cols[3])
							.tipoDato((String) cols[4])
							.numeroLongitud((BigDecimal) cols[5])
							.numeroDecimal((BigDecimal) cols[6])
							.codigoEstadoValid((BigDecimal) cols[7])
							.txtDescripcionValid((String) cols[8])
							.build();
					detValidaciones.add(detValidacion);
				}
			}
			return detValidaciones;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ValidacionService.consultaElementosCorrectosValidacion] Error:  %s", e.getMessage());
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

					DetValidacion detValidacion = DetValidacion.builder()
							.numeroValidacion((BigDecimal) cols[0])
							.numeroElementoValid((BigDecimal) cols[1])
							.descripcionElemento((String) cols[2])
							.nombreElemento((String) cols[3])
							.tipoDato((String) cols[4])
							.numeroLongitud((BigDecimal) cols[5])
							.numeroDecimal((BigDecimal) cols[6])
							.codigoEstadoValid((BigDecimal) cols[7])
							.txtDescripcionValid((String) cols[8])
							.build();
					detValidaciones.add(detValidacion);
				}
			}
			return detValidaciones;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ValidacionService.consultaElementosConErroresValidacion] Error:  %s", e.getMessage());
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

					DetValidacion detValidacion = DetValidacion.builder()
							.numeroValidacion((BigDecimal) cols[0])
							.numeroElementoValid((BigDecimal) cols[1])
							.descripcionElemento((String) cols[2])
							.nombreElemento((String) cols[3])
							.tipoDato((String) cols[4])
							.numeroLongitud((BigDecimal) cols[5])
							.numeroDecimal((BigDecimal) cols[6])
							.codigoEstadoValid((BigDecimal) cols[7])
							.txtDescripcionValid((String) cols[8])
							.build();
					detValidaciones.add(detValidacion);
				}
			}
			return detValidaciones;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ValidacionService.consultaElementosExcepcionesValidacion] Error:  %s", e.getMessage());
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

					DetValidacion detValidacion = DetValidacion.builder()
							.numeroValidacion((BigDecimal) cols[0])
							.numeroElementoValid((BigDecimal) cols[1])
							.descripcionElemento((String) cols[2])
							.nombreElemento((String) cols[3])
							.tipoDato((String) cols[4])
							.numeroLongitud((BigDecimal) cols[5])
							.numeroDecimal((BigDecimal) cols[6])
							.codigoEstadoValid((BigDecimal) cols[7])
							.txtDescripcionValid((String) cols[8])
							.build();
					detValidaciones.add(detValidacion);
				}
			}
			return detValidaciones;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ValidacionService.consultaElementosExcepcionesValidacion] Error:  %s", e.getMessage());
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
			String typeLinea = String.format("%s.%s", paquete, Constants.T_T_LINEA).toUpperCase();
			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

			Map<String,Class<?>> typeMap = conn.getTypeMap();
			typeMap.put( typeLinea, TypeLine.class );

			logProcedure(runSP, validaScriptRequest.getPScript(), validaScriptRequest.getCodigoRF(), validaScriptRequest.getCodigoSD(),
					validaScriptRequest.getCodigoProyecto(), validaScriptRequest.getCodigoSubProyecto(), validaScriptRequest.getCodigoUsuario(), validaScriptRequest.getNombreFichero());

			callableStatement.setObject(1, validaScriptRequest.getPScript());
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

					DetValidacion detValidacion = DetValidacion.builder()
							.numeroValidacion((BigDecimal) cols[0])
							.numeroElementoValid((BigDecimal) cols[1])
							.descripcionElemento((String) cols[2])
							.nombreElemento((String) cols[3])
							.tipoDato((String) cols[4])
							.numeroLongitud((BigDecimal) cols[5])
							.numeroDecimal((BigDecimal) cols[6])
							.codigoEstadoValid((BigDecimal) cols[7])
							.txtDescripcionValid((String) cols[8])
							.build();
					detValidaciones.add(detValidacion);
				}
			}
			validaScriptResponse.toBuilder().numeroValidacion(numeroValidacion).listaElementosValid(detValidaciones).elementosNoGlosario(elementosNoGlosario)
					.elementosErrores(elementosErrores).build();

			return validaScriptResponse;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ValidacionService.validaScript] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}
	}
}
