package com.mdval.bussiness.entities.types;

import com.mdval.utils.ConfigurationSingleton;
import com.mdval.utils.Constants;
import lombok.*;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TypeLine implements SQLData {

    private String txtLinea;

    @Override
    @SneakyThrows
    public String getSQLTypeName() throws SQLException {
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String paquete = configuration.getConfig("paquete");
        String typeLinea = String.format("%s.%s", paquete, Constants.T_T_LINEA).toUpperCase();
        return typeLinea;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        txtLinea = stream.readString();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeString(txtLinea);
    }

    @Override
    public String toString() {
        return String.format(
                "txtLinea:    %s",
                txtLinea
        );
    }
}
