package com.mdval.ui.model.cabeceras;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author federico
 *
 */
public class DefinicionParticulasNormaElementoCabecera extends Cabecera {
	
	/**
	 *
	 */
	public void setupCabecera() {
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.codNorma"));
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.desNorma"));
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.codElemento"));
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.desElemento"));
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.numParticula"));
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.desNumPart"));
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.mcaObligatoria"));
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.mcaValidacion"));
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.valTamMin"));
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.valTamMax"));
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.mcaValPadre"));
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.numPartPadre"));
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.codUsr"));
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.fec_actu"));
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.tipValidacion"));
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.codParticula"));
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.desParticula"));
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.mcaProyecto"));
		columnIdentifiers.add(literales.getLiteral("tblParticulasNorma.txtFormatoPart"));
			
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(BigDecimal.class);
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(Date.class);
		columnClasses.add(String.class);
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
	}
}
