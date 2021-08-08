package com.sapiens.app.ui.utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Objects;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.sapiens.app.ui.utils.dialog.Creator;
import com.sapiens.app.ui.utils.dialog.DialogCreator;

/**
 * @author federico
 *
 */
public class UIHelper {
	
	/**
	 * @param dialog
	 */
	public static void centerOnScreen(JDialog dialog) {
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - dialog.getWidth()) / 2;
		final int y = (screenSize.height - dialog.getHeight()) / 2;
		dialog.setLocation(x, y);
	}
	
	/**
	 * @param frame
	 */
	public static void showMaximized(JFrame frame) {
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	
	/**
	 * @param item
	 * @return
	 */
	public static JDialog createDialog(JFrame frameParent, String item) {
		Creator dialogCreator = new DialogCreator(frameParent, item);
		return dialogCreator.factoryMethod();
	}
	
	/**
	 * @param dialog
	 */
	public static void showDialog(JDialog dialog) {
		if (!Objects.isNull(dialog)) {
			UIHelper.centerOnScreen(dialog);
			dialog.setVisible(true);
		}
	}
}
