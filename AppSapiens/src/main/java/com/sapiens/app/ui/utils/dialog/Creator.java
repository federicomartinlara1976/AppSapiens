package com.sapiens.app.ui.utils.dialog;

import java.util.Map;

/**
 * @author federico
 *
 */
public abstract class Creator {
	/**
	 * @return
	 */
	public abstract Object factoryMethod(Map<String, Object> params);
}
