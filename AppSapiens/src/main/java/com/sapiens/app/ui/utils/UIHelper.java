package com.sapiens.app.ui.utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Map;
import java.util.Objects;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.sapiens.app.ui.utils.dialog.Creator;
import com.sapiens.app.ui.utils.dialog.DialogCreator;
import com.sapiens.app.ui.utils.dialog.FrameCreator;

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
		return (JDialog) dialogCreator.factoryMethod(null);
	}
	
	/**
	 * @param frameParent
	 * @param item
	 * @param params
	 * @return
	 */
	public static JDialog createDialog(JFrame frameParent, String item, Map<String, Object> params) {
		Creator dialogCreator = new DialogCreator(frameParent, item);
		return (JDialog) dialogCreator.factoryMethod(params);
	}
	
	/**
	 * @param item
	 * @return
	 */
	public static JFrame createFrame(String item) {
		Creator frameCreator = new FrameCreator(item);
		return (JFrame) frameCreator.factoryMethod(null);
	}
	
	/**
	 * @param item
	 * @param params
	 * @return
	 */
	public static JFrame createFrame(String item, Map<String, Object> params) {
		Creator frameCreator = new FrameCreator(item);
		return (JFrame) frameCreator.factoryMethod(params);
	}
	
	/**
	 * @param dialog
	 */
	public static void show(JDialog dialog) {
		if (!Objects.isNull(dialog)) {
			UIHelper.centerOnScreen(dialog);
			dialog.setVisible(Boolean.TRUE);
		}
	}

	/**
	 * @param frame
	 */
	public static void show(JFrame frame) {
		if (!Objects.isNull(frame)) {
			frame.setVisible(Boolean.TRUE);
		}
	}
}
