package com.mdval.ui.model;

import java.util.List;

import com.mdval.bussiness.entities.Glosario;
import com.mdval.ui.utils.GenericDomainTableModel;

/**
 * @author federico
 *
 */
public class DefinicionGlosariosTableModel extends GenericDomainTableModel<Glosario> {

	/**
	 * 
	 */
	public DefinicionGlosariosTableModel() {
		super();
	}

	/**
	 * @param columnIdentifiers
	 */
	public DefinicionGlosariosTableModel(List<String> columnIdentifiers) {
		super(columnIdentifiers);
	}
}
