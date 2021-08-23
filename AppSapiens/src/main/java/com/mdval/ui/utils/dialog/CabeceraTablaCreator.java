package com.mdval.ui.utils.dialog;

import java.util.Map;

import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.model.cabeceras.DefinicionGlosariosTablaGlosariosCabecera;
import com.mdval.ui.model.cabeceras.DefinicionNormasTablaNormasCabecera;
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
	
	private String item;
	
	public CabeceraTablaCreator(String item) {
		this.item = item;
	}
	
	@Override
	public Object factoryMethod() {
		Cabecera cabecera = null;
	
		if (Constants.FRM_DEFINICION_GLOSARIOS_TABLA_GLOSARIOS_CABECERA.equals(item)) {
			cabecera = new DefinicionGlosariosTablaGlosariosCabecera();
		}
		
		if (Constants.FRM_GLOSARIO_CAMPOS_TABLA_CAMPO_CABECERA.equals(item)) {
			cabecera = new GlosarioCamposTablaCamposCabecera();
		}
		
		if (Constants.FRM_DEFINICION_NORMAS_TABLA_NORMAS_CABECERA.equals(item)) {
			cabecera = new DefinicionNormasTablaNormasCabecera();
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
