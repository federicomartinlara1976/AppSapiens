package com.mdval.ui.model.cabeceras;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author federico
 *
 */
public class GlosarioCamposTablaCamposCabecera extends Cabecera {
	
	/**
	 *
	 */
	public void setupCabecera() {
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
		columnClasses.add(BigDecimal.class);
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(Date.class);
	}
}
