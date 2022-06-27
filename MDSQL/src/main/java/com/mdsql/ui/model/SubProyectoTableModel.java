package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.SubProyecto;

/**
 * @author federico
 *
 */
public class SubProyectoTableModel extends DefaultTableModel<SubProyecto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public SubProyectoTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public SubProyectoTableModel(List<SubProyecto> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		SubProyecto row = data.get(rowIndex);

		if (0 == columnIndex) {
			return row.getCodigoSubProyecto();
		} else if (1 == columnIndex) {
			return row.getDescripcionSubProyecto();
		} else if (2 == columnIndex) {
			return row.getCodigoUsuario();
		} else if (3 == columnIndex) {
			return row.getFechaActualizacion();
		} 

		return null;
	}
}
