package com.mdsql.ui.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.mdsql.exceptions.ServiceException;
import com.mdsql.utils.AppHelper;
import com.mdsql.utils.Constants;
import com.mdsql.utils.DateFormatter;
import com.mdsql.utils.LiteralesSingleton;

import lombok.extern.slf4j.Slf4j;

/**
 * @author federico
 *
 */
@Slf4j
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
	 * @param parent
	 * @param cmd
	 */
	protected void showFrame(FrameSupport parent, String cmd) {
		JFrame frame = UIHelper.createFrame(parent, cmd);
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
	 * @param parent
	 * @param cmd
	 * @param params
	 */
	protected void showFrame(FrameSupport parent, String cmd, Map<String, Object> params) {
		JFrame frame = UIHelper.createFrame(parent, cmd, params);
		UIHelper.show(frame);
	}
	
	/**
	 * @param frame
	 * @param cmd
	 */
	protected void showPopup(FrameSupport frame, String cmd) {
		JDialog dialog = UIHelper.createDialog(frame, cmd);
		UIHelper.show(dialog);
	}
	
	/**
	 * @param frame
	 * @param cmd
	 * @param params
	 */
	protected void showPopup(FrameSupport frame, String cmd, Map<String, Object> params) {
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
	 * @param e
	 * @return
	 */
	protected Map<String, Object> buildWarning(ServiceException e) {
		Map<String, Object> params = new HashMap<>();

		params.put(Constants.SERVICE_ERROR, e);
		params.put(Constants.TYPE, Constants.WARN);
		
		return params;
	}
	
	/**
	 * @param cmd
	 */
	protected void updateObservers(String cmd) {
		this.setChanged();
		this.notifyObservers(cmd);
	}
	
	/**
	 * 
	 */
	public void onSeleccionado() {}
}
