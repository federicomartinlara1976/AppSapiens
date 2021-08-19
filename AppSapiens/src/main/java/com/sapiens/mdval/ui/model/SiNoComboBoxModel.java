package com.sapiens.mdval.ui.model;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class SiNoComboBoxModel extends AbstractListModel<String> implements ComboBoxModel<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8083638254718894808L;
	
	private String[] responses = { "SI", "NO" };
	
	private String selection = null;

	@Override
	public int getSize() {
		return responses.length;
	}

	@Override
	public String getElementAt(int index) {
		return responses[index];
	}

	@Override
	public void setSelectedItem(Object anItem) {
		selection = (String) anItem;
	}

	@Override
	public Object getSelectedItem() {
		return selection;
	}

}
