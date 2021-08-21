package com.mdval.ui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.mdval.bussiness.entities.Glosario;

/**
 * @author federico
 *
 */
public class DefinicionGlosariosTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8351154302842174012L;

	private final List<Glosario> glosarios;
	private final List<String> columnNames;
	private final List<Class<?>> columnClasses ;

	public DefinicionGlosariosTableModel(List<Glosario> glosarios, List<String> columnNames, List<Class<?>> columnClasses) {
		this.glosarios = glosarios;
		this.columnNames = columnNames;
		this.columnClasses = columnClasses;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames.get(column);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClasses.get(columnIndex);
	}

	@Override
	public int getRowCount() {
		return glosarios.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Glosario row = glosarios.get(rowIndex);

		if (0 == columnIndex) {
			return row.getCodigo();
		} else if (1 == columnIndex) {
			return row.getDescripcion();
		} else if (2 == columnIndex) {
			return row.getFechaAlta();
		} else if (3 == columnIndex) {
			return row.getUsuario();
		} else if (4 == columnIndex) {
			return row.getFechaModificacion();
		}

		return null;
	}
}
