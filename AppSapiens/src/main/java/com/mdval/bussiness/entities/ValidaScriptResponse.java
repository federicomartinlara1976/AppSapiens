package com.mdval.bussiness.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.mdval.exceptions.ServiceException;

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
public class ValidaScriptResponse implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3746196642964184264L;
	
	private BigDecimal numeroValidacion;
    private List<DetValidacion> listaElementosValid;
    private String elementosNoGlosario;
    private String elementosErrores;
    
    // Para los warnings
    private ServiceException serviceException;

}
