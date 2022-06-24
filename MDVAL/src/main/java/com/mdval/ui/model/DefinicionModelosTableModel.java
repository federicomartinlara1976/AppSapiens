package com.mdval.ui.model;

import java.util.List;

import com.mdval.bussiness.entities.Modelo;

/**
 * @author federico
 *
 */
public class DefinicionModelosTableModel extends DefaultTableModel<Modelo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionModelosTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionModelosTableModel(List<Modelo> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Modelo row = data.get(rowIndex);
		
		if (0 == columnIndex) {
			return row.getCodigoProyecto();
		} else if (1 == columnIndex) {
			return row.getNombreModelo();
		} else if (2 == columnIndex) {
			return row.getNombreEsquema();
		} else if (3 == columnIndex) {
			return row.getNombreBbdd();
		} else if (4 == columnIndex) {
			return row.getCodigoGrupoBds();
		} else if (5 == columnIndex) {
			return row.getNombreCarpetaAdj();
		} else if (6 == columnIndex) {
			return row.getCodigoNorma();	
		} else if (7 == columnIndex) {
			return row.getDescripcionNorma();
		} else if (8 == columnIndex) {
			return row.getNomApnCmdb();
		} else if (9 == columnIndex) {
			return row.getCodigoGlosario();
		} else if (10 == columnIndex) {
			return row.getDescripcionGlosario();
		} else if (11 == columnIndex) {
			return row.getCodigoHerramienta();
		} else if (12 == columnIndex) {
			return row.getObservacionesModelo();
		} else if (13 == columnIndex) {
			return row.getCodigoCapaUsrown();
		} else if (14 == columnIndex) {
			return row.getMcaVariables();
		} else if (15 == columnIndex) {
			return row.getMcaGrantAll();
		} else if (16 == columnIndex) {
			return row.getMcaGrantPublic();
		} else if (17 == columnIndex) {
			return row.getMcaInh();
		} else if (18 == columnIndex) {
			return row.getCodigoUsuario();
		} else if (19 == columnIndex) {
			return row.getFechaActualizacion();
		}
 
		return null;
	}
}
