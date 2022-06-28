package com.mdval.ui.utils;

import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.utils.creators.CabeceraTablaCreator;
import com.mdval.ui.utils.creators.Creator;
import com.mdval.ui.utils.creators.DialogCreator;
import com.mdval.ui.utils.creators.FrameCreator;

public class MDValUIHelper extends UIHelper {
	
	/**
	 * @param item
	 * @return
	 */
	public static JDialog createDialog(FrameSupport frameParent, String item) {
		Creator dialogCreator = new DialogCreator(frameParent, item);
		return (JDialog) dialogCreator.factoryMethod(null);
	}
	
	/**
	 * @param frameParent
	 * @param item
	 * @param params
	 * @return
	 */
	public static JDialog createDialog(FrameSupport frameParent, String item, Map<String, Object> params) {
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
	 * @return
	 */
	public static JFrame createFrame(FrameSupport parent, String item) {
		Creator frameCreator = new FrameCreator(parent, item);
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
	 * @param parent
	 * @param item
	 * @param params
	 * @return
	 */
	public static JFrame createFrame(FrameSupport parent, String item, Map<String, Object> params) {
		Creator frameCreator = new FrameCreator(parent, item);
		return (JFrame) frameCreator.factoryMethod(params);
	}
	
	/**
	 * @param item
	 * @return
	 */
	public static Cabecera createCabeceraTabla(String item) {
		Creator cabeceraTablaCreator = new CabeceraTablaCreator(item);
		return (Cabecera) cabeceraTablaCreator.factoryMethod();
	}
}
