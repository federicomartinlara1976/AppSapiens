package com.mdsql.ui.model.cabeceras;

import java.math.BigDecimal;

/**
 * @author federico
 *
 */
public class TablaValidaParticulaCabecera extends Cabecera {
	
	/**
	 *
	 */
	public void setupCabecera() {
		columnIdentifiers.add(literales.getLiteral("tblValidaParticula.numeroParticula"));
		columnIdentifiers.add(literales.getLiteral("tblValidaParticula.valor"));
		columnIdentifiers.add(literales.getLiteral("tblValidaParticula.validacion"));
		columnIdentifiers.add(literales.getLiteral("tblValidaParticula.descEstadoValidacion"));
			
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		
		columnSizes.add(100);
		columnSizes.add(100);
		columnSizes.add(300);
		columnSizes.add(800);
	}
}
