package com.mdsql.ui.utils.creators;

import java.util.Map;

/**
 * @author federico
 *
 */
public abstract class Creator {
	
	/**
	 * @return
	 */
	public abstract Object factoryMethod();
	
	/**
	 * @return
	 */
	public abstract Object factoryMethod(Map<String, Object> params);
}
