package com.mdval.ui.renderer;

import java.awt.Component;
import java.util.Objects;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.entities.SubProyecto;

public class SubProyectoRenderer extends BasicComboBoxRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3517770689739103773L;

	@SuppressWarnings("rawtypes")
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

		SubProyecto subProyecto = (SubProyecto) value;

		if (Objects.isNull(subProyecto)) {
			setText(StringUtils.EMPTY);
		} else {
			setText(subProyecto.getDescripcionSubProyecto());
		}
		return this;
	}
}
