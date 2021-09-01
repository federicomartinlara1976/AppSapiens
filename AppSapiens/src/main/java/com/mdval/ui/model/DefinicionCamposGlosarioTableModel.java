package com.mdval.ui.model;

import java.util.List;

import com.mdval.bussiness.entities.CampoGlosario;

/**
 * @author federico
 *
 */
public class DefinicionCamposGlosarioTableModel extends DefaultTableModel<CampoGlosario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionCamposGlosarioTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionCamposGlosarioTableModel(List<CampoGlosario> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		CampoGlosario row = data.get(rowIndex);

		if (0 == columnIndex) {
			return row.getNombreColumna();
		} else if (1 == columnIndex) {
			return row.getTipoDato();
		} else if (2 == columnIndex) {
			return row.getNumeroLongitud();
		} else if (3 == columnIndex) {
			return row.getNumeroDecimal();
		} else if (4 == columnIndex) {
			return row.getMcaExcepcion();
		} else if (5 == columnIndex) {
			return row.getTxtComentario();
		} else if (6 == columnIndex) {
			return row.getTxtExcepcion();
		} else if (7 == columnIndex) {
			return row.getCodigoUsuario();
		} else if (8 == columnIndex) {
			return row.getFechaActualizacion();
		}

		return null;
	}
}
