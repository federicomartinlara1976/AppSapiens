package com.mdval.ui.model.cabeceras;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author federico
 *
 */
public class DefinicionElementosTablaTipoElementoCabecera extends Cabecera {
	
	public void setupCabecera() {
		columnIdentifiers.add(literales.getLiteral("tblTiposElemento.codElemento"));
		columnIdentifiers.add(literales.getLiteral("tblTiposElemento.desElemento"));
		columnIdentifiers.add(literales.getLiteral("tblTiposElemento.codUsu"));
		columnIdentifiers.add(literales.getLiteral("tblTiposElemento.fecActu"));
		
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(Date.class);
	}
}
