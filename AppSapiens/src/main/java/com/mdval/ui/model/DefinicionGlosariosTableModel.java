package com.mdval.ui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.springframework.util.CollectionUtils;

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
	
	public DefinicionGlosariosTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		this.glosarios = new ArrayList<>();
		this.columnNames = columnNames;
		this.columnClasses = columnClasses;
	}

	public DefinicionGlosariosTableModel(List<Glosario> glosarios, List<String> columnNames, List<Class<?>> columnClasses) {
		this.glosarios = glosarios;
		this.columnNames = columnNames;
		this.columnClasses = columnClasses;
	}
	
	public void setGlosarios(List<Glosario> glosarios) {
		if (!CollectionUtils.isEmpty(this.glosarios)) {
			this.glosarios.clear();
		}
		this.glosarios.addAll(glosarios);
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
	
	/**
	 * @param rowIndex
	 * @return
	 */
	public Glosario getSelectedRow(int rowIndex) {
		return (rowIndex != -1) ? glosarios.get(rowIndex) : null;
	}
}