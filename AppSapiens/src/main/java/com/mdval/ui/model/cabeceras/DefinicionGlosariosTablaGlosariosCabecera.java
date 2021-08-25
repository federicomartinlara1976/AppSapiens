package com.mdval.ui.model.cabeceras;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author federico
 *
 */
public class DefinicionGlosariosTablaGlosariosCabecera extends Cabecera {

	/**
	 *
	 */
	public void setupCabecera() {
		columnIdentifiers.add(literales.getLiteral("tblGlosarios.codGlosario"));
		columnIdentifiers.add(literales.getLiteral("tblGlosarios.desGlosario"));
		columnIdentifiers.add(literales.getLiteral("tblGlosarios.fecAlta"));
		columnIdentifiers.add(literales.getLiteral("tblGlosarios.codUsu"));
		columnIdentifiers.add(literales.getLiteral("tblGlosarios.fecActu"));
		
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(Date.class);
		columnClasses.add(String.class);
		columnClasses.add(Date.class);
	}
}
