package com.mdval.bussiness.service.impl;

import com.mdval.bussiness.entities.Modelo;
import com.mdval.bussiness.entities.SubProyecto;
import com.mdval.bussiness.service.ModeloService;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.ConfigurationSingleton;
import com.mdval.utils.Constants;
import com.mdval.utils.LogWrapper;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hcarreno
 */
@Service(Constants.MODELO_SERVICE)
@Log4j
public class ModeloServiceImpl implements ModeloService {

	@Autowired
	private DataSource dataSource;

	@Override
	@SneakyThrows
	public Integer altaModelo(Modelo modelo) {
		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_alta_modelo");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = "{ call " + llamada + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		Integer result = 0;

		try (Connection conn = dataSource.getConnection();
			 CallableStatement callableStatement = conn.prepareCall(runSP)) {

			SubProyecto[] arraySubProyectos = modelo.getSubProyectos().toArray(new SubProyecto[0]);

			//Object[] array = modelo.getSubProyectos().toArray(); //TODO test in array parameter

			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();
			String typeSubProyecto = String.format("%s.%s", paquete, Constants.T_T_SUBPROYECTO).toUpperCase();

			callableStatement.setString(1, modelo.getCodigoProyecto());
			callableStatement.setString(2, modelo.getNombreModelo());
			callableStatement.setBigDecimal(3, modelo.getCodigoNorma());
			callableStatement.setBigDecimal(4, modelo.getCodigoGlosario());
			callableStatement.setString(5, modelo.getNombreEsquema());
			callableStatement.setString(6, modelo.getNombreBbdd());
			callableStatement.setString(7, modelo.getNombreCarpetaAdj());
			callableStatement.setString(8, modelo.getCodigoGrupoBds());
			callableStatement.setString(9, modelo.getCodigoHerramienta());
			callableStatement.setString(10, modelo.getObservacionesModelo());
			callableStatement.setString(11, modelo.getCodigoUsuario());
			callableStatement.setString(12, modelo.getNomApnCmdb());
			callableStatement.setString(13, modelo.getMcaGrantAll());
			callableStatement.setString(14, modelo.getMcaGrantPublic());
			callableStatement.setString(15, modelo.getMcaVariables());
			callableStatement.setString(16, modelo.getCodigoCapaUsrown());
			callableStatement.setArray(17, conn.createArrayOf(typeSubProyecto, arraySubProyectos));

			callableStatement.registerOutParameter(18, Types.INTEGER);
			callableStatement.registerOutParameter(19, Types.VARCHAR, typeError);

			callableStatement.execute();

			result = callableStatement.getInt(4);
			Array listaErrores = callableStatement.getArray(5); // TODO forzar error

			if (listaErrores != null) {
				Object[] rows = (Object[]) listaErrores.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
					for (Object col : cols) {
						log.info(col + " ");
					}
					log.info(" ");
				}
			}

			return result;
		} catch (SQLException e) {
			LogWrapper.error(log, "[GlosarioService.altaModelo] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	public Integer bajaLogicaModelo(String codigoProyecto, String codigoUsuario) {
		return null;
	}

	@Override
	@SneakyThrows
	public List<Modelo> consultaModelos(String codigoProyecto, String nombreModelo,
										BigDecimal codigoNorma, BigDecimal codigoGlosario,
										String nombreEsquema, String nombreBbdd, String mostrarInh) {
		List<Modelo> modelos = new ArrayList<>();

		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_consulta_modelos");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = "{ call " + llamada + "(?,?,?,?,?,?,?,?,?,?)}";

		try (Connection conn = dataSource.getConnection();
			 CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeModelo = String.format("%s.%s", paquete, Constants.T_T_MODELO).toUpperCase();
			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

			callableStatement.setString(1, codigoProyecto);
			callableStatement.setString(2, nombreModelo);
			callableStatement.setBigDecimal(3, codigoNorma);
			callableStatement.setBigDecimal(4, codigoGlosario);
			callableStatement.setString(5, nombreEsquema);
			callableStatement.setString(6, nombreBbdd);
			callableStatement.setString(7, mostrarInh);
			callableStatement.registerOutParameter(8, Types.ARRAY, typeModelo);
			callableStatement.registerOutParameter(9, Types.INTEGER);
			callableStatement.registerOutParameter(10, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer resultadoOperacion = callableStatement.getInt(9);
			log.info("[ModeloService.consultaModelos] ResultadoOperacion: " + resultadoOperacion);

			Array listaErrores = callableStatement.getArray(10); // TODO forzar error

			if (listaErrores != null) {
				Object[] rows = (Object[]) listaErrores.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
					for (Object col : cols) {
						log.info(col + " ");
					}
					log.info(" ");
				}
			}

			Array arrayModelos = callableStatement.getArray(8);
			if (arrayModelos != null) {
				Object[] rows = (Object[]) arrayModelos.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

					Modelo modelo = Modelo.builder()
							.codigoProyecto((String) cols[0])
							.nombreModelo((String) cols[0])
							.nombreEsquema((String) cols[0])
							.nombreBbdd((String) cols[0])
							.codigoGrupoBds((String) cols[0])
							.nombreCarpetaAdj((String) cols[0])
							.codigoNorma((BigDecimal) cols[0])
							.descripcionNorma((String) cols[0])
							.nomApnCmdb((String) cols[0])
							.codigoGlosario((BigDecimal) cols[0])
							.descripcionGlosario((String) cols[0])
							.codigoHerramienta((String) cols[0])
							.observacionesModelo((String) cols[0])
							.codigoUsuario((String) cols[0])
							.fechaActualizacion((java.sql.Date) cols[0])
							.codigoCapaUsrown((String) cols[0])
							.mcaVariables((String) cols[0])
							.mcaGrantAll((String) cols[0])
							.mcaGrantPublic((String) cols[0])
							.mcaInh((String) cols[0])
							.build();

					modelos.add(modelo);
				}
			}

			return modelos;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ModeloService.consultaModelos] Error:  %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	public Modelo consultaModelo(String codigoProyecto) {
		return null;
	}

	@Override
	@SneakyThrows
	public List<Modelo> consultarModelosGlosario(BigDecimal codigoGlosario) {
		List<Modelo> modelos = new ArrayList<>();

		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_con_modelos_glosario");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = "{ call " + llamada + "(?,?,?,?)}";

		try (Connection conn = dataSource.getConnection();
			 CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeModelo = String.format("%s.%s", paquete, Constants.T_T_MODELO).toUpperCase();
			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

			callableStatement.setBigDecimal(1, codigoGlosario);
			callableStatement.registerOutParameter(2, Types.ARRAY, typeModelo);
			callableStatement.registerOutParameter(3, Types.INTEGER);
			callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer resultadoOperacion = callableStatement.getInt(3);
			log.info("[ModeloService.consultaModelos] ResultadoOperacion: " + resultadoOperacion);

			Array listaErrores = callableStatement.getArray(4); // TODO forzar error

			if (listaErrores != null) {
				Object[] rows = (Object[]) listaErrores.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
					for (Object col : cols) {
						log.info(col + " ");
					}
					log.info(" ");
				}
			}

			Array arrayModelos = callableStatement.getArray(2);
			if (arrayModelos != null) {
				Object[] rows = (Object[]) arrayModelos.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

					Modelo modelo = Modelo.builder()
							.codigoProyecto((String) cols[0])
							.nombreModelo((String) cols[0])
							.nombreEsquema((String) cols[0])
							.nombreBbdd((String) cols[0])
							.codigoGrupoBds((String) cols[0])
							.nombreCarpetaAdj((String) cols[0])
							.codigoNorma((BigDecimal) cols[0])
							.descripcionNorma((String) cols[0])
							.nomApnCmdb((String) cols[0])
							.codigoGlosario((BigDecimal) cols[0])
							.descripcionGlosario((String) cols[0])
							.codigoHerramienta((String) cols[0])
							.observacionesModelo((String) cols[0])
							.codigoUsuario((String) cols[0])
							.fechaActualizacion((java.sql.Date) cols[0])
							.codigoCapaUsrown((String) cols[0])
							.mcaVariables((String) cols[0])
							.mcaGrantAll((String) cols[0])
							.mcaGrantPublic((String) cols[0])
							.mcaInh((String) cols[0])
							.build();

					modelos.add(modelo);
				}
			}

			return modelos;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ModeloService.consultarModelosGlosario] Error:  %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	public Integer modificaModelo(Modelo modelo) {
		return null;
	}
}
