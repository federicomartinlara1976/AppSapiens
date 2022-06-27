package com.mdsql.ui.model.cabeceras;

import java.math.BigDecimal;

/**
 * @author federico
 *
 */
public class DetalleValidacionCabecera extends Cabecera {
	
	/**
	 *
	 */
	public void setupCabecera() {
		columnIdentifiers.add(literales.getLiteral("tblDetalleValidacion.numValidacion"));
		columnIdentifiers.add(literales.getLiteral("tblDetalleValidacion.numElementoValid"));
		columnIdentifiers.add(literales.getLiteral("tblDetalleValidacion.desElemento"));
		columnIdentifiers.add(literales.getLiteral("tblDetalleValidacion.nombreElemento"));
		columnIdentifiers.add(literales.getLiteral("tblDetalleValidacion.tipoDato"));
		columnIdentifiers.add(literales.getLiteral("tblDetalleValidacion.numLongitud"));
		columnIdentifiers.add(literales.getLiteral("tblDetalleValidacion.numDecimales"));
		columnIdentifiers.add(literales.getLiteral("tblDetalleValidacion.txtDescripcionValid"));
		columnIdentifiers.add(literales.getLiteral("tblDetalleValidacion.codEstadoValid"));
		columnIdentifiers.add(literales.getLiteral("tblDetalleValidacion.nombreTabla"));
			
		columnClasses.add(BigDecimal.class);
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(BigDecimal.class);
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		
		columnSizes.add(120);
		columnSizes.add(120);
		columnSizes.add(120);
		columnSizes.add(120);
		columnSizes.add(120);
		columnSizes.add(120);
		columnSizes.add(120);
		columnSizes.add(500);
		columnSizes.add(120);
		columnSizes.add(120);
	}
}
