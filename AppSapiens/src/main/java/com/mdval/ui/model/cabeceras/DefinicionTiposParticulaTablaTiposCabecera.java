package com.mdval.ui.model.cabeceras;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author federico
 *
 */
public class DefinicionTiposParticulaTablaTiposCabecera extends Cabecera {
	
	private List<String> columnIdentifiers;
	private List<Class<?>> columnClasses;

	/**
	 *
	 */
	public void setupCabecera() {
		columnIdentifiers = new ArrayList<>();
		columnClasses = new ArrayList<>();
		
		columnIdentifiers.add(literales.getLiteral("tblTiposParticula.codParticula"));
		columnIdentifiers.add(literales.getLiteral("tblTiposParticula.desParticula"));
		columnIdentifiers.add(literales.getLiteral("tblTiposParticula.mcaProyecto"));
		columnIdentifiers.add(literales.getLiteral("tblTiposParticula.codUsu"));
		columnIdentifiers.add(literales.getLiteral("tblTiposParticula.fecActu"));
		
		columnClasses.add(Integer.class);
		columnClasses.add(String.class);
		columnClasses.add(Boolean.class);
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
