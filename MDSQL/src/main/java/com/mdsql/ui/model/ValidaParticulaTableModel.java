package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.ValidaParticula;

/**
 * @author federico
 *
 */
public class ValidaParticulaTableModel extends DefaultTableModel<ValidaParticula> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public ValidaParticulaTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public ValidaParticulaTableModel(List<ValidaParticula> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		ValidaParticula row = data.get(rowIndex);

		if (0 == columnIndex) {
			return row.getNumeroParticula();
		} else if (1 == columnIndex) {
			return row.getTxtValor();
		} else if (2 == columnIndex) {
			return row.getTxtValidacion();
		} else if (3 == columnIndex) {
			return row.getDescripcionEstadoValidacion();
		} 

		return null;
	}
}
