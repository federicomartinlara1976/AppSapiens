package com.mdval.bussiness.service.impl;

import com.mdval.bussiness.entities.CampoGlosario;
import com.mdval.bussiness.service.CamposGlosarioService;
import com.mdval.utils.ConfigurationSingleton;
import com.mdval.utils.DateFormatter;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
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
@Service("camposGlosarioService")
@Log4j
public class CamposGlosarioServiceImpl implements CamposGlosarioService {

    @Autowired
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public List<CampoGlosario> consultarCamposGlosario(Integer codigoGlosario, String tipoDato, String nombreColumna, Boolean mostrarExcepciones) {
        List<CampoGlosario> campoGlosarios = new ArrayList<>();
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String procedure = configuration.getConfig("p_con_campos_glosario");
        String runSP = "{ call "+procedure+"(?,?,?,?,?)}";
        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            callableStatement.setInt(1, codigoGlosario);
            callableStatement.setString(2, tipoDato);
            callableStatement.setString(3, nombreColumna);
            callableStatement.setBoolean(4, mostrarExcepciones);
            callableStatement.registerOutParameter(5, Types.ARRAY);

            callableStatement.execute();

            Array arr = callableStatement.getArray(5);
            if (arr != null) {
                ResultSet rs = arr.getResultSet();
                while (rs.next()) {
                    campoGlosarios.add(new CampoGlosario(Integer.parseInt(rs.getString("")),
                            rs.getString("des_glosario"),
                            Integer.parseInt(rs.getString("cod_usr")),
                            Integer.parseInt(rs.getString("cod_usr")),
                            Integer.parseInt(rs.getString("cod_usr")),
                            Boolean.parseBoolean(rs.getString("cod_usr")),
                            rs.getString("des_glosario"),
                            rs.getString("des_glosario"),
                            rs.getString("des_glosario"),
                            DateFormatter.stringToDate(rs.getString("fec_actu"))));
                }
                //String[] data = (String[]) arr.getArray();
            }

        } catch (SQLException e) {
            log.error("Error en CamposGlosarioService.consultarCamposGlosario "+ e.getMessage());
        }
        return campoGlosarios;
    }

    @Override
    @SneakyThrows
    public String bajaCampoGlosario(Integer codigoGlosario, Integer codigoCampo) {
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String procedure = configuration.getConfig("p_baja_campo_glosario");
        String runSP = "{ call "+procedure+"(?,?,?)}";
        String result = "";

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            callableStatement.setInt(1, codigoGlosario);
            callableStatement.setInt(2, codigoCampo);

            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);

            callableStatement.execute();

            result = callableStatement.getString(3);

        } catch (SQLException e) {
            log.error("Error en CamposGlosarioService.bajaCampoGlosario "+ e.getMessage());
        }
        return result;
    }

    @Override
    @SneakyThrows
    public String altaCampoGlosario(CampoGlosario campoGlosario) {
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String procedure = configuration.getConfig("p_baja_campo_glosario");
        String runSP = "{ call "+procedure+"(?,?,?,?,?,?,?,?,?)}";
        String result = "";

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            callableStatement.setInt(1, campoGlosario.getCodigoGlosario());
            callableStatement.setInt(2, campoGlosario.getNombreColumna());
            callableStatement.setString(3, campoGlosario.getTipoDato());
            callableStatement.setInt(4, campoGlosario.getNumeroLongitud());
            callableStatement.setInt(5, campoGlosario.getNumeroDecimal());
            callableStatement.setBoolean(6, campoGlosario.getEsExcepcion());
            callableStatement.setString(7, campoGlosario.getComentario());
            callableStatement.setString(8, campoGlosario.getComentarioExcepcion());

            callableStatement.registerOutParameter(9, java.sql.Types.VARCHAR);

            callableStatement.execute();

            result = callableStatement.getString(9);

        } catch (SQLException e) {
            log.error("Error en CamposGlosarioService.altaCampoGlosario "+ e.getMessage());
        }
        return result;
    }

    @Override
    @SneakyThrows
    public String modificarCampoGlosario(CampoGlosario campoGlosario) {
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String procedure = configuration.getConfig("p_modificar_campo_glosario");
        String runSP = "{ call "+procedure+"(?,?,?,?,?,?,?,?,?)}";
        String result = "";

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            callableStatement.setInt(1, campoGlosario.getCodigoGlosario());
            callableStatement.setInt(2, campoGlosario.getNombreColumna());
            callableStatement.setString(3, campoGlosario.getTipoDato());
            callableStatement.setInt(4, campoGlosario.getNumeroLongitud());
            callableStatement.setInt(5, campoGlosario.getNumeroDecimal());
            callableStatement.setBoolean(6, campoGlosario.getEsExcepcion());
            callableStatement.setString(7, campoGlosario.getComentario());
            callableStatement.setString(8, campoGlosario.getComentarioExcepcion());

            callableStatement.registerOutParameter(9, java.sql.Types.VARCHAR);

            callableStatement.execute();

            result = callableStatement.getString(9);

        } catch (SQLException e) {
            log.error("Error en CamposGlosarioService.modificarCampoGlosario "+ e.getMessage());
        }
        return result;
    }
}
