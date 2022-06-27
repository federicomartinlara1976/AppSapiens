package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.DetValidacion;

/**
 * @author federico
 *
 */
public class DetalleValidacionTableModel extends DefaultTableModel<DetValidacion> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public DetalleValidacionTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public DetalleValidacionTableModel(List<DetValidacion> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		DetValidacion row = data.get(rowIndex);

		if (0 == columnIndex) {
			return row.getNumeroValidacion();
		} else if (1 == columnIndex) {
			return row.getNumeroElementoValid();
		} else if (2 == columnIndex) {
			return row.getDescripcionElemento();
		} else if (3 == columnIndex) {
			return row.getNombreElemento();
		} else if (4 == columnIndex) {
			return row.getTipoDato();
		} else if (5 == columnIndex) {
			return row.getNumeroLongitud();
		} else if (6 == columnIndex) {
			return row.getNumeroDecimal();	
		} else if (7 == columnIndex) {
			return row.getTxtDescripcionValid();
		} else if (8 == columnIndex) {
			return row.getCodigoEstadoValid();
		} else if (9 == columnIndex) {
			return row.getNombreTabla();
		}

		return null;
	}
}
