package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.ParticulaNorma;

/**
 * @author federico
 *
 */
public abstract class ParticulaNormaTableModel extends DefaultTableModel<ParticulaNorma> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public ParticulaNormaTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public ParticulaNormaTableModel(List<ParticulaNorma> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		ParticulaNorma row = data.get(rowIndex);

		return getField(row, columnIndex);
	}

	/**
	 * @param row
	 * @param columnIndex
	 * @return
	 */
	protected abstract Object getField(ParticulaNorma row, int columnIndex);
}
