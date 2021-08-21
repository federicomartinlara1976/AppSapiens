package com.mdval.ui.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import com.mdval.utils.LiteralesSingleton;
import com.mdval.utils.LogWrapper;

import lombok.extern.log4j.Log4j;

/**
 * @author federico
 *
 */
@Log4j
public class SiNoComboBoxModel extends AbstractListModel<String> implements ComboBoxModel<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8083638254718894808L;
	
	private List<String> responses;
	
	private String selection = null;
	
	/**
	 * 
	 */
	public SiNoComboBoxModel() {
		super();
		
		try {
			LiteralesSingleton literales = LiteralesSingleton.getInstance();
			
			responses = new ArrayList<>();
			responses.add(literales.getLiteral("si"));
			responses.add(literales.getLiteral("no"));
		} catch (IOException e) {
			LogWrapper.error(log, "ERROR:", e);
		}
	}

	@Override
	public int getSize() {
		return responses.size();
	}

	@Override
	public String getElementAt(int index) {
		return responses.get(index);
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
