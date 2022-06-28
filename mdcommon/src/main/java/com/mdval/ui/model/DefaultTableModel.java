package com.mdval.ui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.apache.commons.collections.CollectionUtils;

import lombok.Getter;

/**
 * @author federico
 *
 */
public abstract class DefaultTableModel<T> extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8351154302842174012L;

	@Getter
	protected List<T> data;
	
	private final List<String> columnNames;
	private final List<Class<?>> columnClasses ;
	
	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefaultTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		this.data = new ArrayList<>();
		this.columnNames = columnNames;
		this.columnClasses = columnClasses;
	}

	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefaultTableModel(List<T> data, List<String> columnNames, List<Class<?>> columnClasses) {
		this.data = data;
		this.columnNames = columnNames;
		this.columnClasses = columnClasses;
	}
	
	/**
	 * @param newData
	 */
	public void setData(List<T> newData) {
		if (!CollectionUtils.isEmpty(this.data)) {
			this.data.clear();
		}
		this.data.addAll(newData);
		this.fireTableDataChanged();
	}
	
	/**
	 * @param newData
	 */
	public void addData(T newData) {
		this.data.add(newData);
		this.fireTableDataChanged();
	}
	
	/**
	 * @param object
	 */
	public void removeData(T object) {
		this.data.remove(object);
		this.fireTableDataChanged();
	}
	
	/**
	 * 
	 */
	public void clearData() {
		this.data.clear();
		this.fireTableDataChanged();
	}

	/**
	 *
	 */
	@Override
	public String getColumnName(int column) {
		return columnNames.get(column);
	}

	/**
	 *
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClasses.get(columnIndex);
	}

	/**
	 *
	 */
	@Override
	public int getRowCount() {
		return data.size();
	}

	/**
	 *
	 */
	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	/**
	 *
	 */
	public abstract Object getValueAt(int rowIndex, int columnIndex);
	
	/**
	 * @param rowIndex
	 * @return
	 */
	public T getSelectedRow(int rowIndex) {
		return (rowIndex != -1) ? data.get(rowIndex) : null;
	}
}
