package com.mdval.ui.model;

import java.util.List;

import com.mdval.bussiness.entities.Norma;

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
			return row.getCodigo();
		} else if (1 == columnIndex) {
			return row.getDescripcion();
		} else if (2 == columnIndex) {
			return row.getUsuario();
		} else if (3 == columnIndex) {
			return row.getFecha();
		}

		return null;
	}
}
