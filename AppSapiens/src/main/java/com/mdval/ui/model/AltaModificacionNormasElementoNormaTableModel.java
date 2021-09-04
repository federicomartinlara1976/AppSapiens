package com.mdval.ui.model;

import java.util.List;

import com.mdval.bussiness.entities.ElementoNorma;

/**
 * @author federico
 *
 */
public class AltaModificacionNormasElementoNormaTableModel extends ElementoNormaTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public AltaModificacionNormasElementoNormaTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public AltaModificacionNormasElementoNormaTableModel(List<ElementoNorma> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}

	@Override
	protected Object getField(ElementoNorma row, int columnIndex) {
		if (0 == columnIndex) {
			return row.getCodigoNorma();
		} else if (1 == columnIndex) {
			return row.getDescripcionNorma();
		} else if (2 == columnIndex) {
			return row.getCodigoElemento();
		} else if (3 == columnIndex) {
			return row.getDescripcionElemento();
		} else if (4 == columnIndex) {
			return row.getValorTamanoMaximo();
		} else if (5 == columnIndex) {
			return row.getTxtFormato();
		} else if (6 == columnIndex) {
			return row.getCodigoUsuario();
		} else if (7 == columnIndex) {
			return row.getFechaActualizacion();
		} else if (8 == columnIndex) {
			return row.getTxtFormatoDescripcion1();
		} else if (9 == columnIndex) {
			return row.getTxtFormatoDescripcion2();
		} else if (10 == columnIndex) {
			return row.getTxtFormatoDescripcion3();
		}

		return null;
	}
}
