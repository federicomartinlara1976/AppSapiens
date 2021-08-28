package com.mdval.ui.renderer;

import java.awt.Component;
import java.math.BigDecimal;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class BigDecimalRenderer extends LabelRenderer implements TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2863654858834389960L;
	
	public BigDecimalRenderer() {
		super();
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		BigDecimal num = (BigDecimal) value;
		
		setSelected(isSelected);
		super.setHorizontalAlignment(LEFT);
		super.setText(String.format("%d", num.toBigInteger()));

		return this;
	}

}