package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

import com.sapiens.app.ui.utils.UIHelper;

/**
 * El listener del menú principal usa la factoría de creación de diálogos
 * pasándole la opción del menú seleccionada, con lo que esta clase ya no 
 * crecerá en código.
 * 
 * @author federico
 *
 */
public class MenuListener implements ActionListener {
	
	private JFrame frameParent;

	public MenuListener(JFrame frameParent) {
		super();
		this.frameParent = frameParent;
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		JDialog dialog = UIHelper.createDialog(frameParent, item.getName());
		UIHelper.showDialog(dialog);
	}
}
