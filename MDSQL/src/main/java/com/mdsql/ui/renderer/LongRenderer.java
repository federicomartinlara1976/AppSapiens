package com.mdsql.ui.renderer;

import java.awt.Component;
import java.util.Objects;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import org.apache.commons.lang3.StringUtils;

public class LongRenderer extends LabelRenderer implements TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2863654858834389960L;
	
	public LongRenderer() {
		super();
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Long num = (Long) value;
		
		setSelected(isSelected);
		super.setHorizontalAlignment(LEFT);
		
		String val = !Objects.isNull(num) ? num.toString() : StringUtils.EMPTY;
		super.setText(val);

		return this;
	}

}