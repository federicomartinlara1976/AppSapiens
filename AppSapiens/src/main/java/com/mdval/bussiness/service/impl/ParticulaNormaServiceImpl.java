package com.mdval.bussiness.service.impl;

import com.mdval.bussiness.entities.ParticulaNorma;
import com.mdval.bussiness.service.ParticulaNormaService;
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
@Service(Constants.PARTICULA_NORMA_SERVICE)
@Log4j
public class ParticulaNormaServiceImpl extends ServiceSupport implements ParticulaNormaService {

	@Autowired
	private DataSource dataSource;

	@Override
	@SneakyThrows
	public List<ParticulaNorma> consultarDefinicionParticulaNormaElemento(BigDecimal codigoNorma, BigDecimal codigoElemento) {
		List<ParticulaNorma> particulaNormas = new ArrayList<>();

		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_con_def_part_norma_elemento");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
			 CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeTipoParticula = String.format("%s.%s", paquete, Constants.T_T_PARTICULA_NORMA).toUpperCase();
			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

			logProcedure(runSP, codigoNorma, codigoElemento);

			callableStatement.setBigDecimal(1, codigoNorma);
			callableStatement.setBigDecimal(2, codigoElemento);
			callableStatement.registerOutParameter(3, Types.ARRAY, typeTipoParticula);
			callableStatement.registerOutParameter(4, Types.INTEGER);
			callableStatement.registerOutParameter(5, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(4);

			if (result == 0) {
				Array listaErrores = callableStatement.getArray(5);
				ServiceException exception = buildException((Object[]) listaErrores.getArray());
				throw exception;
			}

			Array arrayParticulasNormas = callableStatement.getArray(3);
			if (arrayParticulasNormas != null) {
				Object[] rows = (Object[]) arrayParticulasNormas.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
					ParticulaNorma tipoParticula = ParticulaNorma.builder().codigoNorma((BigDecimal) cols[0])
							.descripcionNorma((String) cols[1]).codigoElemento((BigDecimal) cols[2]).descripcionElemento((String) cols[3])
							.numeroParticula((BigDecimal) cols[4]).descripcionNumeroParticula((String) cols[5]).mcaObligatoria((String) cols[6])
							.mcaValidacion((String) cols[7]).valorTamanoMinimo((BigDecimal) cols[8]).valorTamanoMaximo((BigDecimal) cols[9])
							.mcaValorPadre((String) cols[10]).numParticulaPadre((BigDecimal) cols[11]).codigoUsuario((String) cols[12])
							.fechaActualizacion((java.util.Date) cols[13]).tipoValidacion((String) cols[14]).codigoParticula((BigDecimal) cols[15])
							.descripcionParticula((String) cols[16]).mcaProyecto((String) cols[17]).txtFormatoParticula((String) cols[18])
							.build();
					particulaNormas.add(tipoParticula);
				}
			}
			return particulaNormas;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ParticulaNormaService.consultarDefinicionParticulaNormaElemento] Error:  %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	@SneakyThrows
	public List<ParticulaNorma> consultarParticulasElemento(BigDecimal codigoNorma, BigDecimal codigoElemento) {
		List<ParticulaNorma> particulaNormas = new ArrayList<>();

		ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
		String paquete = configuration.getConfig("paquete");
		String procedure = configuration.getConfig("p_con_particulas_elemento");
		String llamada = String.format("%s.%s", paquete, procedure).toUpperCase();
		String runSP = String.format("{call %s(?,?,?,?,?)}", llamada);

		try (Connection conn = dataSource.getConnection();
			 CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeTipoParticula = String.format("%s.%s", paquete, Constants.T_T_PARTICULA).toUpperCase();
			String typeError = String.format("%s.%s", paquete, Constants.T_T_ERROR).toUpperCase();

			logProcedure(runSP, codigoNorma, codigoElemento);

			callableStatement.setBigDecimal(1, codigoNorma);
			callableStatement.setBigDecimal(2, codigoElemento);
			callableStatement.registerOutParameter(3, Types.ARRAY, typeTipoParticula);
			callableStatement.registerOutParameter(4, Types.INTEGER);
			callableStatement.registerOutParameter(5, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(4);

			if (result == 0) {
				Array listaErrores = callableStatement.getArray(5);
				ServiceException exception = buildException((Object[]) listaErrores.getArray());
				throw exception;
			}

			Array arrayParticulasNormas = callableStatement.getArray(3);
			if (arrayParticulasNormas != null) {
				Object[] rows = (Object[]) arrayParticulasNormas.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
					ParticulaNorma tipoParticula = ParticulaNorma.builder().codigoNorma((BigDecimal) cols[0])
							.descripcionNorma((String) cols[1]).codigoElemento((BigDecimal) cols[2]).descripcionElemento((String) cols[3])
							.numeroParticula((BigDecimal) cols[4]).descripcionNumeroParticula((String) cols[5]).mcaObligatoria((String) cols[6])
							.mcaValidacion((String) cols[7]).valorTamanoMinimo((BigDecimal) cols[8]).valorTamanoMaximo((BigDecimal) cols[9])
							.mcaValorPadre((String) cols[10]).numParticulaPadre((BigDecimal) cols[11]).codigoUsuario((String) cols[12])
							.fechaActualizacion((java.util.Date) cols[13]).tipoValidacion((String) cols[14]).codigoParticula((BigDecimal) cols[15])
							.descripcionParticula((String) cols[16]).mcaProyecto((String) cols[17]).txtFormatoParticula((String) cols[18])
							.build();
					particulaNormas.add(tipoParticula);
				}
			}
			return particulaNormas;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ParticulaNormaService.consultarParticulasElemento] Error:  %s", e.getMessage());
			throw new ServiceException(e);
		}
	}
}
