package com.mdval.ui.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.mdval.exceptions.ServiceException;
import com.mdval.utils.AppHelper;
import com.mdval.utils.Constants;
import com.mdval.utils.DateFormatter;
import com.mdval.utils.LiteralesSingleton;

import lombok.extern.log4j.Log4j;

/**
 * @author federico
 *
 */
@Log4j
public abstract class ListenerSupport extends Observable {
	
	protected LiteralesSingleton literales;
	
	protected DateFormatter dateFormatter;
	
	public ListenerSupport() {
		try {
			literales = LiteralesSingleton.getInstance();
			dateFormatter = new DateFormatter();
		} catch (IOException e) {
			log.warn("ERROR:", e);
		}
	}
	
	/**
	 * @param nameService
	 * @return
	 */
	protected Object getService(String nameService) {
		return AppHelper.getBean(nameService);
	}
	
	/**
	 * @param cmd
	 */
	protected void showFrame(String cmd) {
		JFrame frame = UIHelper.createFrame(cmd);
		UIHelper.show(frame);
	}
	
	/**
	 * @param cmd
	 * @param params
	 */
	protected void showFrame(String cmd, Map<String, Object> params) {
		JFrame frame = UIHelper.createFrame(cmd, params);
		UIHelper.show(frame);
	}
	
	/**
	 * @param frame
	 * @param cmd
	 */
	protected void showPopup(JFrame frame, String cmd) {
		JDialog dialog = UIHelper.createDialog(frame, cmd);
		UIHelper.show(dialog);
	}
	
	/**
	 * @param frame
	 * @param cmd
	 * @param params
	 */
	protected void showPopup(JFrame frame, String cmd, Map<String, Object> params) {
		JDialog dialog = UIHelper.createDialog(frame, cmd, params);
		UIHelper.show(dialog);
	}
	
	/**
	 * @param e
	 * @return
	 */
	protected Map<String, Object> buildError(Exception e) {
		Map<String, Object> params = new HashMap<>();

		if (e instanceof ServiceException) {
			params.put(Constants.SERVICE_ERROR, e);
		} else {
			params.put(Constants.ERROR, e);
		}
		return params;
	}
	
	/**
	 * @param cmd
	 */
	protected void updateObservers(String cmd) {
		this.setChanged();
		this.notifyObservers(cmd);
	}
}
