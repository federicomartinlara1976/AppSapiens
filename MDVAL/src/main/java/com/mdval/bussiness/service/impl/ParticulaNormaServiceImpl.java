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

import com.mdval.bussiness.entities.ParticulaNorma;
import com.mdval.bussiness.service.ParticulaNormaService;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.Constants;
import com.mdval.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hcarreno
 */
@Service(Constants.PARTICULA_NORMA_SERVICE)
@Slf4j
public class ParticulaNormaServiceImpl extends ServiceSupport implements ParticulaNormaService {

	@Autowired
	private DataSource dataSource;

	@Override
	@SneakyThrows
	public List<ParticulaNorma> consultarDefinicionParticulaNormaElemento(BigDecimal codigoNorma, BigDecimal codigoElemento) {
		String runSP = createCall("p_con_def_part_norma_elemento", Constants.CALL_05_ARGS);

		try (Connection conn = dataSource.getConnection();
			 CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeTipoParticula = createCallType(Constants.T_T_PARTICULA_NORMA);
			String typeError = createCallTypeError();

			logProcedure(runSP, codigoNorma, codigoElemento);

			callableStatement.setBigDecimal(1, codigoNorma);
			callableStatement.setBigDecimal(2, codigoElemento);
			callableStatement.registerOutParameter(3, Types.ARRAY, typeTipoParticula);
			callableStatement.registerOutParameter(4, Types.INTEGER);
			callableStatement.registerOutParameter(5, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(4);

			if (result == 0) {
				throw buildException(callableStatement.getArray(5));
			}

			List<ParticulaNorma> particulaNormas = new ArrayList<>();
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
		String runSP = createCall("p_con_particulas_elemento", Constants.CALL_05_ARGS);

		try (Connection conn = dataSource.getConnection();
			 CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeTipoParticula = createCallType(Constants.T_T_PARTICULA_NORMA);
			String typeError = createCallTypeError();

			logProcedure(runSP, codigoNorma, codigoElemento);

			callableStatement.setBigDecimal(1, codigoNorma);
			callableStatement.setBigDecimal(2, codigoElemento);
			callableStatement.registerOutParameter(3, Types.ARRAY, typeTipoParticula);
			callableStatement.registerOutParameter(4, Types.INTEGER);
			callableStatement.registerOutParameter(5, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(4);

			if (result == 0) {
				throw buildException(callableStatement.getArray(5));
			}

			List<ParticulaNorma> particulaNormas = new ArrayList<>();
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
