package com.mdval.ui.utils;

import javax.swing.JTable;

/**
 * @author federico
 *
 */
public class TableSupport extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2528825112240587759L;
	
	public TableSupport() {
		super();
	}

	public TableSupport(Boolean isAutoresized) {
		super();
		
		if (!isAutoresized) {
			setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}
	}
}
