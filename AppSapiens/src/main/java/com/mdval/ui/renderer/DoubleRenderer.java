package com.mdval.ui.renderer;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class DoubleRenderer extends LabelRenderer implements TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2863654858834389960L;
	
	public DoubleRenderer() {
		super();
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Double num = (Double) value;
		
		setSelected(isSelected);
		super.setHorizontalAlignment(LEFT);
		super.setText(String.format("%.2f", num));

		return this;
	}

}