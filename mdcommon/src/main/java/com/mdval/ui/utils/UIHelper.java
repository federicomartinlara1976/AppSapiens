package com.mdval.ui.utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.text.NumberFormat;
import java.util.Objects;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.NumberFormatter;

import org.apache.commons.lang3.StringUtils;

import com.mdval.utils.LiteralesSingleton;

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
	public static void centerOnScreen(JFrame frame) {
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - frame.getWidth()) / 2;
		final int y = (screenSize.height - frame.getHeight()) / 2;
		frame.setLocation(x, y);
	}
	
	/**
	 * @param frame
	 */
	public static void showMaximized(JFrame frame) {
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
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
			UIHelper.centerOnScreen(frame);
			frame.setVisible(Boolean.TRUE);
		}
	}
	
	/**
	 * @param title
	 * @param msg
	 * @return
	 */
	public static Integer showConfirm(String title, String msg) {
		return JOptionPane.showConfirmDialog(null, title, msg, JOptionPane.YES_NO_OPTION);
	}
	
	/**
	 * @return
	 */
	public static JFormattedTextField createIntegerField() {
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(Integer.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    // If you want the value to be committed on each keystroke instead of focus lost
	    formatter.setCommitsOnValidEdit(true);
	    return new JFormattedTextField(formatter);
	}
	
	public static String selectFolder(FrameSupport parent) {
		try {
			LiteralesSingleton literales = LiteralesSingleton.getInstance();
			
			String path = StringUtils.EMPTY;
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("."));
			chooser.setDialogTitle(literales.getLiteral("glosarioCampos.tituloChooser"));
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			//
			// disable the "All files" option.
			//
			chooser.setAcceptAllFileFilterUsed(false);
			//
			if (chooser.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
				path = chooser.getSelectedFile().getAbsolutePath();
			}
	
			return path;
		} catch (Exception e) {
			return StringUtils.EMPTY;
		}
	}
}
