package com.mdsql.bussiness.entities;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hcarreno
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ValidaScriptRequest implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3019536137089400102L;
	
	private String pScript;
    private String codigoRF;
    private String codigoSD;
    private String codigoProyecto;
    private String codigoSubProyecto;
    private String codigoUsuario;
    private String nombreFichero;
    
    private List<String> lines;

}
