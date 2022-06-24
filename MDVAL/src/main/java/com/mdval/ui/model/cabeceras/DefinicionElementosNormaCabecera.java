package com.mdval.ui.model.cabeceras;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author federico
 *
 */
public class DefinicionElementosNormaCabecera extends Cabecera {
	
	/**
	 *
	 */
	public void setupCabecera() {
		columnIdentifiers.add(literales.getLiteral("tblElementoNorma.codNorma"));
		columnIdentifiers.add(literales.getLiteral("tblElementoNorma.desNorma"));
		columnIdentifiers.add(literales.getLiteral("tblElementoNorma.codElemento"));
		columnIdentifiers.add(literales.getLiteral("tblElementoNorma.desElemento"));
		columnIdentifiers.add(literales.getLiteral("tblElementoNorma.valTamMax"));
		columnIdentifiers.add(literales.getLiteral("tblElementoNorma.formato"));
		columnIdentifiers.add(literales.getLiteral("tblElementoNorma.codUsr"));
		columnIdentifiers.add(literales.getLiteral("tblElementoNorma.fecActu"));
		columnIdentifiers.add(literales.getLiteral("tblElementoNorma.txtFormatoDes1"));
		columnIdentifiers.add(literales.getLiteral("tblElementoNorma.txtFormatoDes2"));
		columnIdentifiers.add(literales.getLiteral("tblElementoNorma.txtFormatoDes3"));
			
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(Date.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
	}
}
