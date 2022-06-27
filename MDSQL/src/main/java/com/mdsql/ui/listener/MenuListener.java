package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import com.mdsql.ui.utils.UIHelper;

/**
 * El listener del menú principal usa la factoría de creación de diálogos
 * pasándole la opción del menú seleccionada, con lo que esta clase ya no 
 * crecerá en código.
 * 
 * @author federico
 *
 */
public class MenuListener implements ActionListener {
	
	public MenuListener() {
		super();
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		JFrame frame = UIHelper.createFrame(item.getActionCommand());
		UIHelper.show(frame);
	}
}
