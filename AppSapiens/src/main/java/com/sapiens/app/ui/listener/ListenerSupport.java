package com.sapiens.app.ui.listener;

import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.sapiens.app.ui.utils.UIHelper;
import com.sapiens.app.utils.AppHelper;

public abstract class ListenerSupport {
	
	/**
	 * @param nameService
	 * @return
	 */
	protected Object getService(String nameService) {
		return AppHelper.getBean(nameService);
	}
	
	/**
	 * @param frame
	 * @param cmd
	 */
	protected void showPopup(JFrame frame, String cmd) {
		JDialog dialog = UIHelper.createDialog(frame, cmd);
		UIHelper.showDialog(dialog);
	}
	
	/**
	 * @param frame
	 * @param cmd
	 * @param params
	 */
	protected void showPopup(JFrame frame, String cmd, Map<String, Object> params) {
		JDialog dialog = UIHelper.createDialog(frame, cmd, params);
		UIHelper.showDialog(dialog);
	}
}
