package com.mdsql.ui.model.cabeceras;

import java.math.BigDecimal;
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
		
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(Date.class);
	}
}
