package com.mdval.ui.model.cabeceras;

import java.util.ArrayList;
import java.util.List;

/**
 * @author federico
 *
 */
public class DefinicionGlosariosTablaGlosariosCabecera extends Cabecera {
	
	private List<String> columnIdentifiers;

	public DefinicionGlosariosTablaGlosariosCabecera() {
		columnIdentifiers = new ArrayList<>();
		
		// TODO - A los literales
		columnIdentifiers.add("COD_GLOSARIO");
		columnIdentifiers.add("DES_GLOSARIO");
		columnIdentifiers.add("FEC_ALTA");
		columnIdentifiers.add("COD_USR");
		columnIdentifiers.add("FEC_ACTU");
	}
	
	
	/**
	 *
	 */
	@Override
	public List<String> getColumnIdentifiers() {
		return columnIdentifiers;
	}

}
