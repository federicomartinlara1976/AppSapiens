package com.mdval.ui.model;

import java.util.List;

import com.mdval.bussiness.entities.Modelo;

/**
 * @author federico
 *
 */
public class DefinicionCamposGlosarioTableModelosModel extends DefaultTableModel<Modelo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionCamposGlosarioTableModelosModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionCamposGlosarioTableModelosModel(List<Modelo> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Modelo row = data.get(rowIndex);

		if (0 == columnIndex) {
			return row.getCodigoProyecto();
		} else if (1 == columnIndex) {
			return row.getNombreModelo();
		} else if (2 == columnIndex) {
			return row.getDescripcionNorma();
		} else if (3 == columnIndex) {
			return row.getDescripcionGlosario();
		} else if (4 == columnIndex) {
			return row.getNombreEsquema();
		} else if (5 == columnIndex) {
			return row.getNombreBbdd();
		} else if (6 == columnIndex) {
			return row.getCodigoUsuario();
		} else if (7 == columnIndex) {
			return row.getFechaActualizacion();
		} 

		return null;
	}
}
