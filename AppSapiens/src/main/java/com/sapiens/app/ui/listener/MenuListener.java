package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.sapiens.app.utils.LogWrapper;

import lombok.extern.log4j.Log4j;

/**
 * @author federico
 *
 */
@Log4j
public class MenuListener implements ActionListener {

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		LogWrapper.debug(log, "%s", item.getName());
	}

}
