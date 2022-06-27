package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.ElementoNorma;

/**
 * @author federico
 *
 */
public abstract class ElementoNormaTableModel extends DefaultTableModel<ElementoNorma> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public ElementoNormaTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public ElementoNormaTableModel(List<ElementoNorma> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		ElementoNorma row = data.get(rowIndex);

		return getField(row, columnIndex);
	}

	/**
	 * @param row
	 * @param columnIndex
	 * @return
	 */
	protected abstract Object getField(ElementoNorma row, int columnIndex);
}
