package com.sapiens.app.ui.listener;

import com.sapiens.app.utils.AppHelper;

public abstract class ListenerSupport {
	
	/**
	 * @param nameService
	 * @return
	 */
	protected Object getService(String nameService) {
		return AppHelper.getBean(nameService);
	}
}
