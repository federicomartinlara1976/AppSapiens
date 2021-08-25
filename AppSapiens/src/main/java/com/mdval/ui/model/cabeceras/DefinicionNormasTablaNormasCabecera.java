package com.mdval.ui.model.cabeceras;

import java.util.Date;

/**
 * @author federico
 *
 */
public class DefinicionNormasTablaNormasCabecera extends Cabecera {
	
	/**
	 *
	 */
	public void setupCabecera() {
		columnIdentifiers.add(literales.getLiteral("tblNormas.codNorma"));
		columnIdentifiers.add(literales.getLiteral("tblNormas.desNorma"));
		columnIdentifiers.add(literales.getLiteral("tblNormas.codUsu"));
		columnIdentifiers.add(literales.getLiteral("tblNormas.fecActu"));
		
		columnClasses.add(Integer.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(Date.class);
	}
}
