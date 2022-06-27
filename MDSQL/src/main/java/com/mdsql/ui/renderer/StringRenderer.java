package com.mdsql.ui.renderer;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import org.apache.commons.lang3.StringUtils;

public class StringRenderer extends LabelRenderer implements TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2863654858834389960L;
	
	public StringRenderer() {
		super();
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		String s = (String) value;
		
		setSelected(isSelected);
		super.setHorizontalAlignment(LEFT);
		
		String val = StringUtils.isNotBlank(s) ? s : StringUtils.EMPTY;
		super.setText(val);

		return this;
	}

}