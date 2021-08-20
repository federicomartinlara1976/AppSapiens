package com.sapiens.mdval.bussiness.service.impl;

import com.sapiens.mdval.bussiness.entities.Glosario;
import com.sapiens.mdval.bussiness.service.GlosarioService;
import com.sapiens.mdval.utils.ConfigurationSingleton;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hcarreno
 */
@Service("glosarioService")
@Log4j
public class GlosarioServiceImpl implements GlosarioService {

    @Autowired
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public List<Glosario> buscarGlosarios(String descripcionGlosario) {
        List<Glosario> glosarios = new ArrayList<>();
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String procedure = configuration.getConfig("p_buscar_glosarios");
        String runSP = "{ call "+procedure+"(?,?)}";
        try (Connection conn = dataSource.getConnection();
                CallableStatement callableStatement = conn.prepareCall(runSP)) {

            callableStatement.setString(1, descripcionGlosario);
            callableStatement.registerOutParameter(2, Types.ARRAY);

            callableStatement.execute();

            DateFormat format = new SimpleDateFormat("MMMM d, yyyy");

            Array arr = callableStatement.getArray(2);
            if (arr != null) {
                ResultSet rs = arr.getResultSet();
                while (rs.next()) {
                    glosarios.add(new Glosario(Integer.parseInt(rs.getString("cod_glosario")),
                            rs.getString("des_glosario"),
                            rs.getString("cod_usr"),
                            format.parse(rs.getString("fec_alta")),
                            format.parse(rs.getString("fec_actu"))));
                }
                //String[] data = (String[]) arr.getArray();
            }

        } catch (SQLException | ParseException e) {
            log.error("Error en GlosarioService.buscarGlosarios "+ e.getMessage());
        }
        return glosarios;
    }

    @Override
    @SneakyThrows
    public Glosario consultarGlosario(String codigoGlosario) {
        Glosario glosario = new Glosario();
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String procedure = configuration.getConfig("p_consulta_glosario");
        String runSP = "{ call "+procedure+"(?,?,?,?,?,?)}";

        try (Connection conn = dataSource.getConnection();
                CallableStatement callableStatement = conn.prepareCall(runSP)) {

            callableStatement.setString(1, codigoGlosario);

            callableStatement.registerOutParameter(2, Types.INTEGER);
            callableStatement.registerOutParameter(3, Types.VARCHAR);
            callableStatement.registerOutParameter(4, Types.VARCHAR);
            callableStatement.registerOutParameter(5, Types.DATE);
            callableStatement.registerOutParameter(6, Types.DATE);

            // run it
            callableStatement.execute();

            Integer codigo = callableStatement.getInt(2);
            String descripcion = callableStatement.getString(3);
            String usuario = callableStatement.getString(4);
            Date fechaAlta = callableStatement.getDate(5);
            Date fechaModificacion = callableStatement.getDate(6);

            glosario.toBuilder()
                    .codigo(codigo)
                    .descripcion(descripcion)
                    .usuario(usuario)
                    .fechaAlta(fechaAlta)
                    .fechaModificacion(fechaModificacion)
                    .build();

        } catch (SQLException e) {
            log.error("Error en GlosarioService.consultarGlosario "+ e.getMessage());
        }
        return glosario;
    }

    @Override
    @SneakyThrows
    public String altaGlosario(String descripcionGlosario) {
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String procedure = configuration.getConfig("p_alta_glosario");
        String runSP = "{ call "+procedure+"(?,?)}";
        String result = "";

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            callableStatement.setString(1, descripcionGlosario);

            callableStatement.registerOutParameter(2, Types.VARCHAR);

            // run it
            callableStatement.execute();

            result = callableStatement.getString(2);

        } catch (SQLException e) {
            log.error("Error en GlosarioService.altaGlosario "+ e.getMessage());
        }
        return result;
    }

    @Override
    @SneakyThrows
    public String modificaGlosario(String descripcionGlosario) {
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String procedure = configuration.getConfig("p_modifica_glosario");
        String runSP = "{ call "+procedure+"(?,?)}";
        String result = "";

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            callableStatement.setString(1, descripcionGlosario);

            callableStatement.registerOutParameter(2, Types.VARCHAR);

            // run it
            callableStatement.execute();

            result = callableStatement.getString(2);

        } catch (SQLException e) {
            log.error("Error en GlosarioService.modificaGlosario "+ e.getMessage());
        }
        return result;
    }
}
