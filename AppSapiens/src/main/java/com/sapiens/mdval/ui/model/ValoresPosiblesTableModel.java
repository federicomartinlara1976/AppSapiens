package com.sapiens.mdval.ui.model;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class ValoresPosiblesTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5498022937971227851L;

	public ValoresPosiblesTableModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValoresPosiblesTableModel(int rowCount, int columnCount) {
		super(rowCount, columnCount);
		// TODO Auto-generated constructor stub
	}

	public ValoresPosiblesTableModel(Object[] columnNames, int rowCount) {
		super(columnNames, rowCount);
		// TODO Auto-generated constructor stub
	}

	public ValoresPosiblesTableModel(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
		// TODO Auto-generated constructor stub
	}

	public ValoresPosiblesTableModel(Vector columnNames, int rowCount) {
		super(columnNames, rowCount);
		// TODO Auto-generated constructor stub
	}

	public ValoresPosiblesTableModel(Vector data, Vector columnNames) {
		super(data, columnNames);
		// TODO Auto-generated constructor stub
	}
}
