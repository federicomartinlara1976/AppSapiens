package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.TipoElemento;

/**
 * @author federico
 *
 */
public class DefinicionTipoElementoTableModel extends DefaultTableModel<TipoElemento> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionTipoElementoTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionTipoElementoTableModel(List<TipoElemento> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		TipoElemento row = data.get(rowIndex);

		if (0 == columnIndex) {
			return row.getCodigoElemento();
		} else if (1 == columnIndex) {
			return row.getDescripcionElemento();
		} else if (2 == columnIndex) {
			return row.getCodigoUsuario();
		} else if (3 == columnIndex) {
			return row.getFechaActualizacion();
		} 
		
		return null;
	}
}
