package com.mdval.ui.model.cabeceras;

import java.util.Date;

/**
 * @author federico
 *
 */
public class SubProyectoCabecera extends Cabecera {
	
	/**
	 *
	 */
	public void setupCabecera() {
		columnIdentifiers.add(literales.getLiteral("tblSubProyecto.codigo"));
		columnIdentifiers.add(literales.getLiteral("tblSubProyecto.descripcion"));
		columnIdentifiers.add(literales.getLiteral("tblSubProyecto.codigoUsuario"));
		columnIdentifiers.add(literales.getLiteral("tblSubProyecto.fecActu"));
			
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(Date.class);
		
		columnSizes.add(60);
		columnSizes.add(450);
		columnSizes.add(60);
		columnSizes.add(100);
	}
}
