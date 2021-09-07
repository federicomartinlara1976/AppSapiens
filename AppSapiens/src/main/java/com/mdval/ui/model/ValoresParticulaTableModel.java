package com.mdval.ui.model;

import java.util.List;

import com.mdval.bussiness.entities.ValorParticula;

/**
 * @author federico
 *
 */
public class ValoresParticulaTableModel extends DefaultTableModel<ValorParticula> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public ValoresParticulaTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public ValoresParticulaTableModel(List<ValorParticula> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		ValorParticula row = data.get(rowIndex);

		if (0 == columnIndex) {
			return row.getCodigoParticula();
		} else if (1 == columnIndex) {
			return row.getValorParticula();
		} else if (2 == columnIndex) {
			return row.getDescripcionValorParticula();
		} else if (3 == columnIndex) {
			return row.getValorParticulaPadre();
		} else if (4 == columnIndex) {
			return row.getCodigoProyecto();
		} else if (5 == columnIndex) {
			return row.getCodigoSubProyecto();
		} else if (6 == columnIndex) {
			return row.getCodigoUsuario();	
		} else if (7 == columnIndex) {
			return row.getFechaActualizacion();
		}

		return null;
	}
}
