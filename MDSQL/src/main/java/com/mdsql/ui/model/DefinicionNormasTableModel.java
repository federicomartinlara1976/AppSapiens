package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.Norma;

/**
 * @author federico
 *
 */
public class DefinicionNormasTableModel extends DefaultTableModel<Norma> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionNormasTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionNormasTableModel(List<Norma> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Norma row = data.get(rowIndex);

		if (0 == columnIndex) {
			return row.getCodigoNorma();
		} else if (1 == columnIndex) {
			return row.getDescripcionNorma();
		} else if (2 == columnIndex) {
			return row.getCodigoUsuario();
		} else if (3 == columnIndex) {
			return row.getFechaActualizacion();
		}

		return null;
	}
}
