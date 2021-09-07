package com.mdval.ui.model.cabeceras;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author federico
 *
 */
public class TablaValoresParticulasCabecera extends Cabecera {
	
	/**
	 *
	 */
	public void setupCabecera() {
		columnIdentifiers.add(literales.getLiteral("tblValoresParticulas.codParticula"));
		columnIdentifiers.add(literales.getLiteral("tblValoresParticulas.valParticula"));
		columnIdentifiers.add(literales.getLiteral("tblValoresParticulas.desValPart"));
		columnIdentifiers.add(literales.getLiteral("tblValoresParticulas.valPartPadre"));
		columnIdentifiers.add(literales.getLiteral("tblValoresParticulas.codProyecto"));
		columnIdentifiers.add(literales.getLiteral("tblValoresParticulas.codSubproyecto"));
		columnIdentifiers.add(literales.getLiteral("tblValoresParticulas.codUsr"));
		columnIdentifiers.add(literales.getLiteral("tblValoresParticulas.fecActu"));
			
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(Date.class);
	}
}
