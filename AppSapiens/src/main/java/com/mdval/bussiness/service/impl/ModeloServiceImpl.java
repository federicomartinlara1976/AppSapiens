package com.mdval.bussiness.service.impl;

import com.mdval.bussiness.entities.Modelo;
import com.mdval.bussiness.entities.SubProyecto;
import com.mdval.bussiness.service.ModeloService;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.ConfigurationSingleton;
import com.mdval.utils.Constants;
import com.mdval.utils.LogWrapper;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.internal.OracleConnection;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author hcarreno
 */
@Service(Constants.MODELO_SERVICE)
@Log4j
public class ModeloServiceImpl extends ServiceSupport implements ModeloService {

	@Autowired
	private DataSource dataSource;

	@Override
	@SneakyThrows
	public void altaModelo(Modelo modelo) {
		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig(Constants.PAQUETE);
		String procedure = configuration.getConfig("p_alta_modelo");
		String llamada = String.format(FORMATO_LLAMADA, paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection(); OracleConnection oConn = (OracleConnection) conn;
			 CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeError = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_ERROR).toUpperCase();
			String tableSubProyecto = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_SUBPROYECTO).toUpperCase();
			String recordSubProyecto = String.format(FORMATO_LLAMADA, paquete, Constants.T_R_SUBPROYECTO).toUpperCase();

			logProcedure(runSP, modelo.getCodigoProyecto(), modelo.getNombreModelo(), modelo.getCodigoNorma(), modelo.getCodigoGlosario(), modelo.getNombreEsquema(),
					modelo.getNombreBbdd(), modelo.getNombreCarpetaAdj(), modelo.getCodigoGrupoBds(), modelo.getCodigoHerramienta(), modelo.getObservacionesModelo(),
					modelo.getCodigoUsuario(), modelo.getNomApnCmdb(), modelo.getMcaGrantAll(), modelo.getMcaGrantPublic(), modelo.getMcaVariables(),
					modelo.getCodigoCapaUsrown(), modelo.getSubProyectos());

			Struct[] struct = new Struct[modelo.getSubProyectos().size()];

			int arrayIndex = 0;
			for (SubProyecto data : modelo.getSubProyectos()) {
				struct[arrayIndex++] = conn.createStruct(recordSubProyecto,
						new Object[]{ data.getCodigoProyecto(), data.getCodigoSubProyecto(), data.getDescripcionSubProyecto(),
								data.getCodigoUsuario(), formatDate(data.getFechaActualizacion()) });
			}

			Array subProyectoTable = ((OracleConnection) conn).createOracleArray(tableSubProyecto, struct);

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
			callableStatement.setArray(17, subProyectoTable);
			
			callableStatement.registerOutParameter(18, Types.INTEGER);
			callableStatement.registerOutParameter(19, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(18);

			if (result == 0) {
				throw buildException(callableStatement.getArray(19));
			}
		} catch (SQLException e) {
			LogWrapper.error(log, "[ModeloService.altaModelo] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	@SneakyThrows
	public void bajaLogicaModelo(String codigoProyecto, String codigoUsuario) {
		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig(Constants.PAQUETE);
		String procedure = configuration.getConfig("p_baja_logica_modelo");
		String llamada = String.format(FORMATO_LLAMADA, paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?)}", llamada);
		try (Connection conn = dataSource.getConnection();
			 CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeError = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_ERROR).toUpperCase();
			logProcedure(runSP, codigoProyecto, codigoUsuario);

			callableStatement.setString(1, codigoProyecto);
			callableStatement.setString(2, codigoUsuario);
			callableStatement.registerOutParameter(3, Types.INTEGER);
			callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(3);

			if (result == 0) {
				throw buildException(callableStatement.getArray(4));
			}
		} catch (SQLException e) {
			LogWrapper.error(log, "[ModeloService.bajaLogicaModelo] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	@SneakyThrows
	public List<Modelo> consultaModelos(String codigoProyecto, String nombreModelo,
										BigDecimal codigoNorma, BigDecimal codigoGlosario,
										String nombreEsquema, String nombreBbdd, String mostrarInh) {
		List<Modelo> modelos = new ArrayList<>();

		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig(Constants.PAQUETE);
		String procedure = configuration.getConfig("p_consulta_modelos");
		String llamada = String.format(FORMATO_LLAMADA, paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?,?,?,?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
			 CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeModelo = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_MODELO).toUpperCase();
			String typeError = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_ERROR).toUpperCase();

			logProcedure(runSP, codigoProyecto, nombreModelo, codigoNorma, codigoGlosario, nombreEsquema, nombreBbdd, mostrarInh);

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

			Integer result = callableStatement.getInt(9);

			if (result == 0) {
				throw buildException(callableStatement.getArray(10));
			}

			Array arrayModelos = callableStatement.getArray(8);
			if (arrayModelos != null) {
				Object[] rows = (Object[]) arrayModelos.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

					Modelo modelo = Modelo.builder()
							.codigoProyecto((String) cols[0])
							.nombreModelo((String) cols[1])
							.nombreEsquema((String) cols[2])
							.nombreBbdd((String) cols[3])
							.codigoGrupoBds((String) cols[4])
							.nombreCarpetaAdj((String) cols[5])
							.codigoNorma((BigDecimal) cols[6])
							.descripcionNorma((String) cols[7])
							.nomApnCmdb((String) cols[8])
							.codigoGlosario((BigDecimal) cols[9])
							.descripcionGlosario((String) cols[10])
							.codigoHerramienta((String) cols[11])
							.observacionesModelo((String) cols[12])
							.codigoUsuario((String) cols[13])
//							.fechaActualizacion((Date) cols[14])
							.codigoCapaUsrown((String) cols[15])
							.mcaVariables((String) cols[16])
							.mcaGrantAll((String) cols[17])
							.mcaGrantPublic((String) cols[18])
							.mcaInh((String) cols[19])
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
	@SneakyThrows
	public Modelo consultaModelo(String codigoProyecto) {
		Modelo modelo = new Modelo();
		List<SubProyecto> subProyectos = new ArrayList<>();
		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig(Constants.PAQUETE);
		String procedure = configuration.getConfig("p_con_modelo");
		String llamada = String.format(FORMATO_LLAMADA, paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
			 CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeSubProyecto = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_SUBPROYECTO).toUpperCase();
			String typeError = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_ERROR).toUpperCase();
			logProcedure(runSP, codigoProyecto);

			callableStatement.setString(1, codigoProyecto);
			callableStatement.registerOutParameter(2, Types.VARCHAR);
			callableStatement.registerOutParameter(3, Types.NUMERIC);
			callableStatement.registerOutParameter(4, Types.NUMERIC);
			callableStatement.registerOutParameter(5, Types.VARCHAR);
			callableStatement.registerOutParameter(6, Types.VARCHAR);
			callableStatement.registerOutParameter(7, Types.VARCHAR);
			callableStatement.registerOutParameter(8, Types.VARCHAR);
			callableStatement.registerOutParameter(9, Types.VARCHAR);
			callableStatement.registerOutParameter(10, Types.VARCHAR);
			callableStatement.registerOutParameter(11, Types.VARCHAR);
			callableStatement.registerOutParameter(12, Types.VARCHAR);
			callableStatement.registerOutParameter(13, Types.DATE);
			callableStatement.registerOutParameter(14, Types.VARCHAR);
			callableStatement.registerOutParameter(15, Types.VARCHAR);
			callableStatement.registerOutParameter(16, Types.VARCHAR);
			callableStatement.registerOutParameter(17, Types.VARCHAR);
			callableStatement.registerOutParameter(18, Types.VARCHAR);
			callableStatement.registerOutParameter(19, Types.ARRAY, typeSubProyecto);
			callableStatement.registerOutParameter(20, Types.INTEGER);
			callableStatement.registerOutParameter(21, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(20);

			if (result == 0) {
				throw buildException(callableStatement.getArray(21));
			}

			Array arraySubProyectos = callableStatement.getArray(19);
			if (arraySubProyectos != null) {
				Object[] rows = (Object[]) arraySubProyectos.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

					SubProyecto subProyecto = SubProyecto.builder()
							.codigoProyecto((String) cols[0])
							.codigoSubProyecto((String) cols[1])
							.descripcionSubProyecto((String) cols[2])
							.codigoUsuario((String) cols[3])
							.fechaActualizacion((Date) cols[4])
							.build();
					subProyectos.add(subProyecto);
				}
			}

			String nombreModelo = callableStatement.getString(2);
			BigDecimal codigoNorma = callableStatement.getBigDecimal(3);
			BigDecimal codigoGlosario = callableStatement.getBigDecimal(4);
			String descripcionGlosario = callableStatement.getString(5);
			String nombreEsquema = callableStatement.getString(6);
			String nombreBbdd = callableStatement.getString(7);
			String carpetaAdj = callableStatement.getString(8);
			String codGrupoBds = callableStatement.getString(9);
			String nomApnCmdb = callableStatement.getString(10);
			String codigoHerramienta = callableStatement.getString(11);
			String codigoUsuario = callableStatement.getString(12);
			Date fechaActualizacion = callableStatement.getDate(13);
			String codCapaUsrOwn = callableStatement.getString(14);
			String mcaGrantAll = callableStatement.getString(15);
			String mcaGrantPublic = callableStatement.getString(16);
			String mcaVariables = callableStatement.getString(17);
			String obsModelo = callableStatement.getString(18);

			modelo = Modelo.builder()
					.codigoProyecto(codigoProyecto)
					.nombreModelo(nombreModelo)
					.nombreEsquema(nombreEsquema)
					.nombreBbdd(nombreBbdd)
					.codigoGrupoBds(codGrupoBds)
					.nombreCarpetaAdj(carpetaAdj)
					.codigoNorma(codigoNorma)
					.nomApnCmdb(nomApnCmdb)
					.codigoGlosario(codigoGlosario)
					.descripcionGlosario(descripcionGlosario)
					.codigoHerramienta(codigoHerramienta)
					.observacionesModelo(obsModelo)
					.codigoUsuario(codigoUsuario)
					.fechaActualizacion(fechaActualizacion)
					.codigoCapaUsrown(codCapaUsrOwn)
					.mcaVariables(mcaVariables)
					.mcaGrantAll(mcaGrantAll)
					.mcaGrantPublic(mcaGrantPublic)
					.subProyectos(subProyectos)
					.build();

			return modelo;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ModeloService.consultaModelo] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	@SneakyThrows
	public List<Modelo> consultarModelosGlosario(BigDecimal codigoGlosario) {
		List<Modelo> modelos = new ArrayList<>();

		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig(Constants.PAQUETE);
		String procedure = configuration.getConfig("p_con_modelos_glosario");
		String llamada = String.format(FORMATO_LLAMADA, paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
			 CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeModelo = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_MODELO).toUpperCase();
			String typeError = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_ERROR).toUpperCase();

			logProcedure(runSP, codigoGlosario);

			callableStatement.setBigDecimal(1, codigoGlosario);
			callableStatement.registerOutParameter(2, Types.ARRAY, typeModelo);
			callableStatement.registerOutParameter(3, Types.INTEGER);
			callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(3);

			if (result == 0) {
				throw buildException(callableStatement.getArray(4));
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
	@SneakyThrows
	public void modificaModelo(Modelo modelo) {
		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig(Constants.PAQUETE);
		String procedure = configuration.getConfig("p_modifica_modelo");
		String llamada = String.format(FORMATO_LLAMADA, paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
			 CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeError = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_ERROR).toUpperCase();
			String tableSubProyecto = String.format(FORMATO_LLAMADA, paquete, Constants.T_T_SUBPROYECTO).toUpperCase();
			String recordSubProyecto = String.format(FORMATO_LLAMADA, paquete, Constants.T_R_SUBPROYECTO).toUpperCase();

			logProcedure(runSP, modelo.getCodigoProyecto(), modelo.getNombreModelo(), modelo.getCodigoNorma(), modelo.getCodigoGlosario(), modelo.getNombreEsquema(),
					modelo.getNombreBbdd(), modelo.getNombreCarpetaAdj(), modelo.getCodigoGrupoBds(), modelo.getCodigoHerramienta(), modelo.getObservacionesModelo(),
					modelo.getCodigoUsuario(), modelo.getNomApnCmdb(), modelo.getMcaGrantAll(), modelo.getMcaGrantPublic(), modelo.getMcaVariables(),
					modelo.getCodigoCapaUsrown(), modelo.getSubProyectos());

			Struct[] struct = new Struct[modelo.getSubProyectos().size()];

			int arrayIndex = 0;
			for (SubProyecto data : modelo.getSubProyectos()) {
				struct[arrayIndex++] = conn.createStruct(recordSubProyecto,
						new Object[]{ data.getCodigoProyecto(), data.getCodigoSubProyecto(), data.getDescripcionSubProyecto(),
								data.getCodigoUsuario(), formatDate(data.getFechaActualizacion()) });
			}

			Array subProyectoTable = ((OracleConnection) conn).createOracleArray(tableSubProyecto, struct);

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
			callableStatement.setArray(17, subProyectoTable);

			callableStatement.registerOutParameter(18, Types.INTEGER);
			callableStatement.registerOutParameter(19, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(18);

			if (result == 0) {
				throw buildException(callableStatement.getArray(19));
			}
		} catch (SQLException e) {
			LogWrapper.error(log, "[GlosarioService.altaModelo] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	private String formatDate(Date date){
		if (date == null ) return StringUtils.EMPTY;
		SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.ORACLE_OBJECT_DATE_FORMAT_FOR_PROCEDURES);
		return dateFormat.format(date);
	}
}
