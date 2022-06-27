package com.mdsql.ui.renderer;

import java.awt.Component;
import java.util.Objects;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import org.apache.commons.lang3.StringUtils;

public class BooleanRenderer extends LabelRenderer implements TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2863654858834389960L;

	public BooleanRenderer() {
		super();
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Boolean val = (Boolean) value;

		setSelected(isSelected);
		super.setHorizontalAlignment(LEFT);

		String valor = !Objects.isNull(val) ? (Boolean.TRUE.equals(val)) ? literales.getLiteral("si") : literales.getLiteral("no") : StringUtils.EMPTY;
		super.setText(valor);

		return this;
	}

}