package com.mdval.ui.model.cabeceras;

import java.util.Date;

/**
 * @author federico
 *
 */
public class DefinicionTiposParticulaTablaTiposCabecera extends Cabecera {
	
	public void setupCabecera() {
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
}
