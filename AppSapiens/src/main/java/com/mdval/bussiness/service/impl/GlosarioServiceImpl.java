package com.mdval.bussiness.service.impl;

import com.mdval.bussiness.entities.Glosario;
import com.mdval.bussiness.service.GlosarioService;
import com.mdval.utils.ConfigurationSingleton;
import com.mdval.utils.DateFormatter;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
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

    protected DateFormatter dateFormatter;

    @Override
    @SneakyThrows
    public List<Glosario> buscarGlosarios(String descripcionGlosario) {
        List<Glosario> glosarios = new ArrayList<>();
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig("paquete");
        String procedure = configuration.getConfig("p_buscar_glosarios");
        String llamada = paquete + "." + procedure;
        String runSP = "{ call " + llamada + "(?,?,?,?)}";
        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            callableStatement.setString(1, descripcionGlosario);
            callableStatement.registerOutParameter(2, Types.ARRAY, "SM2_K_VALIDADOR_JAVA2.T_T_GLOSARIO");
            callableStatement.registerOutParameter(3, Types.INTEGER);
            callableStatement.registerOutParameter(4, Types.ARRAY, "SM2_K_VALIDADOR_JAVA2.T_T_ERROR");

            callableStatement.execute();

            Integer resultadoOperacion = callableStatement.getInt(3);
            log.info("[GlosarioService.buscarGlosarios] ResultadoOperacion: " + resultadoOperacion);

            Array listaGlosarios = callableStatement.getArray(2);
            if (listaGlosarios != null) {
                Object[] rows = (Object[]) listaGlosarios.getArray();

                for(Object row : rows){
                    Object[] cols = ((oracle.sql.STRUCT)row).getAttributes();
                    for (Object col : cols) {
                        log.info(col + " ");
                    }
                    log.info(" ");

                }
                //String[] data = (String[]) arr.getArray();
            }

        } catch (SQLException e) {
            log.error("[GlosarioService.buscarGlosarios] Error:  " + e.getMessage());
        }
        return glosarios;
    }

    @Override
    @SneakyThrows
    public Glosario consultarGlosario(Double codigoGlosario) {
        Glosario glosario = new Glosario();
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig("paquete");
        String procedure = configuration.getConfig("p_consulta_glosario");
        String llamada = paquete + "." + procedure;
        String runSP = "{ call " + llamada + "(?,?,?,?,?,?,?)}";

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            callableStatement.setDouble(1, codigoGlosario);

            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.registerOutParameter(3, Types.DATE);
            callableStatement.registerOutParameter(4, Types.VARCHAR);
            callableStatement.registerOutParameter(5, Types.DATE);
            callableStatement.registerOutParameter(6, Types.INTEGER);
            callableStatement.registerOutParameter(7, Types.ARRAY);

            callableStatement.execute();

            String descripcion = callableStatement.getString(2);
            Date fechaAlta = callableStatement.getDate(3);
            String usuario = callableStatement.getString(4);
            Date fechaActualizacion = callableStatement.getDate(5);

            Integer resultadoOperacion = callableStatement.getInt(6);
            Array listaErrores = callableStatement.getArray(7);

            if (listaErrores != null) {
                String[] data = (String[]) listaErrores.getArray();
                log.error("[GlosarioService.consultarGlosario] ListaErrores retornado por DB : " + data);
            }
            log.info("[GlosarioService.consultarGlosario] ResultadoOperacion: " + resultadoOperacion);

            glosario.toBuilder()
                    .codigo(codigoGlosario)
                    .descripcion(descripcion)
                    .usuario(usuario)
                    .fechaAlta(fechaAlta)
                    .fechaModificacion(fechaActualizacion)
                    .build();

        } catch (SQLException e) {
            log.error("[GlosarioService.consultarGlosario] Error: " + e.getMessage());
        }
        return glosario;
    }

    @Override
    @SneakyThrows
    public Integer altaGlosario(Double codigoGlosario, String descripcionGlosario, String codigoUsuario) {
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig("paquete");
        String procedure = configuration.getConfig("p_alta_glosario");
        String llamada = paquete + "." + procedure;
        String runSP = "{ call " + llamada + "(?,?,?,?,?)}";
        Integer result = 0;

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            callableStatement.setDouble(1, codigoGlosario);
            callableStatement.setString(2, descripcionGlosario);
            callableStatement.setString(3, codigoUsuario);
            callableStatement.registerOutParameter(4, Types.INTEGER);
            callableStatement.registerOutParameter(5, Types.VARCHAR);

            // run it
            callableStatement.execute();

            result = callableStatement.getInt(4);
            Array listaErrores = callableStatement.getArray(5);

            if (listaErrores != null) {
                String[] data = (String[]) listaErrores.getArray();
                log.error("[GlosarioService.altaGlosario] ListaErrores retornado por DB : " + data);
            }

        } catch (SQLException e) {
            log.error("[GlosarioService.altaGlosario] Error: " + e.getMessage());
        }
        return result;
    }

    @Override
    @SneakyThrows
    public Integer modificaGlosario(Double codigoGlosario, String descripcionGlosario, String codigoUsuario) {
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig("paquete");
        String procedure = configuration.getConfig("p_modifica_glosario");
        String llamada = paquete + "." + procedure;
        String runSP = "{ call " + llamada + "(?,?,?,?,?)}";
        Integer result = 0;

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            callableStatement.setDouble(1, codigoGlosario);
            callableStatement.setString(2, descripcionGlosario);
            callableStatement.setString(3, codigoUsuario);
            callableStatement.registerOutParameter(4, Types.INTEGER);
            callableStatement.registerOutParameter(5, Types.VARCHAR);

            // run it
            callableStatement.execute();

            result = callableStatement.getInt(4);
            Array listaErrores = callableStatement.getArray(5);

            if (listaErrores != null) {
                String[] data = (String[]) listaErrores.getArray();
                log.error("[GlosarioService.modificaGlosario] ListaErrores retornado por DB : " + data);
            }

        } catch (SQLException e) {
            log.error("[GlosarioService.modificaGlosario] ErrorÑ " + e.getMessage());
        }
        return result;
    }
}
