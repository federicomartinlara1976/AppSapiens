package com.mdval.ui.model;

import java.util.List;

import com.mdval.bussiness.entities.ParticulaNorma;

/**
 * @author federico
 *
 */
public class AltaModificacionNormasParticulaNormaTableModel extends ParticulaNormaTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public AltaModificacionNormasParticulaNormaTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public AltaModificacionNormasParticulaNormaTableModel(List<ParticulaNorma> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}

	@Override
	protected Object getField(ParticulaNorma row, int columnIndex) {
		if (0 == columnIndex) {
			return row.getNumeroParticula();
		} else if (1 == columnIndex) {
			return row.getDescripcionNumeroParticula();
		} else if (2 == columnIndex) {
			return row.getMcaObligatoria();
		} else if (3 == columnIndex) {
			return row.getMcaValidacion();
		} else if (4 == columnIndex) {
			return row.getValorTamanoMinimo();
		} else if (5 == columnIndex) {
			return row.getValorTamanoMaximo();
		} else if (6 == columnIndex) {
			return row.getMcaValorPadre();
		} else if (7 == columnIndex) {
			return row.getNumParticulaPadre();
		} else if (8 == columnIndex) {
			return row.getCodigoUsuario();
		} else if (9 == columnIndex) {
			return row.getFechaActualizacion();
		} else if (10 == columnIndex) {
			return row.getTipoValidacion();
		} else if (11 == columnIndex) {
			return row.getCodigoParticula();
		} else if (12 == columnIndex) {
			return row.getDescripcionParticula();
		} else if (13 == columnIndex) {
			return row.getMcaProyecto();
		} else if (14 == columnIndex) {
			return row.getTxtFormatoParticula();
		} 

		return null;
	}
}
