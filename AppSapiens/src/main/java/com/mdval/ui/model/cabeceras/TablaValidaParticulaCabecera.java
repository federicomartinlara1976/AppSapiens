package com.mdval.ui.model.cabeceras;

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
			
		columnClasses.add(Integer.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
	}
}
