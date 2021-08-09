package com.sapiens.app.ui.utils.dialog;

import java.util.Map;

import javax.swing.JDialog;

/**
 * @author federico
 *
 */
public abstract class Creator {
	/**
	 * @return
	 */
	public abstract JDialog factoryMethod(Map<String, Object> params);
}
