package com.mdval.ui.renderer;

import java.awt.Component;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import org.apache.commons.lang3.StringUtils;

import com.mdval.utils.ConfigurationSingleton;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateRenderer extends LabelRenderer implements TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2863654858834389960L;
	
	private SimpleDateFormat dateFormat;

	public DateRenderer() {
		super();
		
		try {
			ConfigurationSingleton instance = ConfigurationSingleton.getInstance();
			String format = instance.getConfig("dateFormat");
			dateFormat = new SimpleDateFormat(format);
		} catch (IOException e) {
			LogWrapper.error(log, "ERROR:", e);
		}
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Date date = (Date) value;
		
		setSelected(isSelected);
		super.setHorizontalAlignment(LEFT);
		
		String val = !Objects.isNull(date) ? dateFormat.format(date) : StringUtils.EMPTY;
		super.setText(val);

		return this;
	}

}