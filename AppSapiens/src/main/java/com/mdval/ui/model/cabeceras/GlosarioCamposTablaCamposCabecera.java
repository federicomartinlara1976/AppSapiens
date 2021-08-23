package com.mdval.ui.model.cabeceras;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author federico
 *
 */
public class GlosarioCamposTablaCamposCabecera extends Cabecera {
	
	private List<String> columnIdentifiers;
	private List<Class<?>> columnClasses;

	/**
	 *
	 */
	public void setupCabecera() {
		columnIdentifiers = new ArrayList<>();
		columnClasses = new ArrayList<>();
		
		columnIdentifiers.add(literales.getLiteral("tblCampos.campo"));
		columnIdentifiers.add(literales.getLiteral("tblCampos.tipo"));
		columnIdentifiers.add(literales.getLiteral("tblCampos.longitud"));
		columnIdentifiers.add(literales.getLiteral("tblCampos.decimales"));
		columnIdentifiers.add(literales.getLiteral("tblCampos.excepcion"));
		columnIdentifiers.add(literales.getLiteral("tblCampos.comentario"));
		columnIdentifiers.add(literales.getLiteral("tblCampos.comentarioExcepcion"));
		columnIdentifiers.add(literales.getLiteral("tblCampos.codUsu"));
		columnIdentifiers.add(literales.getLiteral("tblCampos.fecActu"));
			
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(Integer.class);
		columnClasses.add(Integer.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(Date.class);
	}
	
	
	/**
	 *
	 */
	@Override
	public List<String> getColumnIdentifiers() {
		return columnIdentifiers;
	}


	/**
	 *
	 */
	@Override
	public List<Class<?>> getColumnClasses() {
		return columnClasses;
	}

}
