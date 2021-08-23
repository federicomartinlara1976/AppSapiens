package com.mdval.ui.model.cabeceras;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author federico
 *
 */
public class GlosarioCamposTablaCamposCabecera extends Cabecera {
	
	private List<String> columnIdentifiers;
	private List<Class<?>> columnClasses;

	public void setupCabecera() {
		columnIdentifiers = new ArrayList<>();
		columnClasses = new ArrayList<>();
		
		columnIdentifiers.add("Campo");
		columnIdentifiers.add("Tipo");
		columnIdentifiers.add("Longitud");
		columnIdentifiers.add("Decimales");
		columnIdentifiers.add("Excepción");
		columnIdentifiers.add("Comentario");
		columnIdentifiers.add("ComentarioExcepción");
		columnIdentifiers.add("COD_USR");
		columnIdentifiers.add("FEC_ACTU");
		
//		columnIdentifiers.add(literales.getLiteral("tblGlosarios.codGlosario"));
//		columnIdentifiers.add(literales.getLiteral("tblGlosarios.desGlosario"));
//		columnIdentifiers.add(literales.getLiteral("tblGlosarios.fecAlta"));
//		columnIdentifiers.add(literales.getLiteral("tblGlosarios.codUsu"));
//		columnIdentifiers.add(literales.getLiteral("tblGlosarios.fecActu"));
		
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(Integer.class);
		columnClasses.add(Integer.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
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
