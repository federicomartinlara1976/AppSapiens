package com.mdsql.ui.model.cabeceras;

import java.util.Date;

/**
 * @author federico
 *
 */
public class GlosarioCamposTablaModelosCabecera extends Cabecera {
	
	/**
	 *
	 */
	public void setupCabecera() {
		columnIdentifiers.add(literales.getLiteral("tblModelos.codProyecto"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.nomModelo"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.desNorma"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.desGlosario"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.nomEsquema"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.nomBBDD"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.codUsr"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.fecActu"));
			
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(Date.class);
	}
}
