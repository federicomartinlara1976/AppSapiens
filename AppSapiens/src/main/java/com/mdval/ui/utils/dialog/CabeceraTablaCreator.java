package com.mdval.ui.utils.dialog;

import java.util.Map;

import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.model.cabeceras.DefinicionGlosariosTablaGlosariosCabecera;
import com.mdval.ui.model.cabeceras.GlosarioCamposTablaCamposCabecera;
import com.mdval.utils.Constants;

/**
 * Factory method para gestionar la creación centralizada de la cabecera de 
 * títulos de las tablas.
 * 
 * @author federico
 *
 */
public class CabeceraTablaCreator extends Creator {
	
	private String option;
	
	public CabeceraTablaCreator(String option) {
		this.option = option;
	}
	
	@Override
	public Object factoryMethod() {
		Cabecera cabecera = null;
	
		if (Constants.DLG_DEFINICION_GLOSARIOS_TABLA_GLOSARIOS_CABECERA.equals(option)) {
			cabecera = new DefinicionGlosariosTablaGlosariosCabecera();
		}
		
		if (Constants.DLG_GLOSARIO_CAMPOS_TABLA_CAMPO_CABECERA.equals(option)) {
			cabecera = new GlosarioCamposTablaCamposCabecera();
		}
		
		return cabecera;
	}

	/**
	 *
	 */
	@Override
	public Object factoryMethod(Map<String, Object> params) {
		return null;
	}
}
