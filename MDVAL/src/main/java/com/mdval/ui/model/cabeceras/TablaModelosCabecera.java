package com.mdval.ui.model.cabeceras;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author federico
 *
 */
public class TablaModelosCabecera extends Cabecera {
	
	public void setupCabecera() {
		columnIdentifiers.add(literales.getLiteral("tblModelos.codProyecto"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.nombreModelo"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.nombreEsquema"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.nombreBbdd"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.codigoGrupoBds"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.nombreCarpetaAdj"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.codigoNorma"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.descripcionNorma"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.nomApnCmdb"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.codigoGlosario"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.descripcionGlosario"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.codigoHerramienta"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.observacionesModelo"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.codigoCapaUsrown"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.mcaVariables"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.mcaGrantAll"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.mcaGrantPublic"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.mcaInh"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.codigoUsuario"));
		columnIdentifiers.add(literales.getLiteral("tblModelos.fechaActualizacion"));
		
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
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
