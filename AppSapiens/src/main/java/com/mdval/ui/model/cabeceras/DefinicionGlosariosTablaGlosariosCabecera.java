package com.mdval.ui.model.cabeceras;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author federico
 *
 */
public class DefinicionGlosariosTablaGlosariosCabecera extends Cabecera {
	
	private List<String> columnIdentifiers;
	private List<Class<?>> columnClasses;

	public DefinicionGlosariosTablaGlosariosCabecera() {
		columnIdentifiers = new ArrayList<>();
		columnClasses = new ArrayList<>();
		
		// TODO - A los literales
		columnIdentifiers.add("COD_GLOSARIO");
		columnIdentifiers.add("DES_GLOSARIO");
		columnIdentifiers.add("FEC_ALTA");
		columnIdentifiers.add("COD_USR");
		columnIdentifiers.add("FEC_ACTU");
		
		columnClasses.add(Integer.class);
		columnClasses.add(String.class);
		columnClasses.add(Date.class);
		columnClasses.add(String.class);
		columnClasses.add(Date.class);
	}
	
	
	/**
	 *
	 */
	@Override
	public List<String> getColumnIdentifiers() {
		return columnIdentifiers;
	}


	@Override
	public List<Class<?>> getColumnClasses() {
		return columnClasses;
	}

}
