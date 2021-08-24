package com.mdval.ui.model;

import java.util.List;

import com.mdval.bussiness.entities.TipoParticula;

/**
 * @author federico
 *
 */
public class DefinicionTiposParticulaTableModel extends DefaultTableModel<TipoParticula> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionTiposParticulaTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionTiposParticulaTableModel(List<TipoParticula> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		TipoParticula row = data.get(rowIndex);

		if (0 == columnIndex) {
			return row.getCodigo();
		} else if (1 == columnIndex) {
			return row.getDescripcion();
		} else if (2 == columnIndex) {
			return row.getMcaProyecto();
		} else if (3 == columnIndex) {
			return row.getCodigoUsuario();
		} else if (4 == columnIndex) {
			return row.getFechaActualizacion();
		}

		return null;
	}
}
