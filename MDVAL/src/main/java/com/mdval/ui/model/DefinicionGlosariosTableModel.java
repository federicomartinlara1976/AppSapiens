package com.mdval.ui.model;

import java.util.List;

import com.mdval.bussiness.entities.Glosario;

/**
 * @author federico
 *
 */
public class DefinicionGlosariosTableModel extends DefaultTableModel<Glosario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionGlosariosTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionGlosariosTableModel(List<Glosario> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Glosario row = data.get(rowIndex);

		if (0 == columnIndex) {
			return row.getCodigoGlosario();
		} else if (1 == columnIndex) {
			return row.getDescripcionGlosario();
		} else if (2 == columnIndex) {
			return row.getFechaAlta();
		} else if (3 == columnIndex) {
			return row.getCodigoUsuario();
		} else if (4 == columnIndex) {
			return row.getFechaActualizacion();
		}

		return null;
	}
}
