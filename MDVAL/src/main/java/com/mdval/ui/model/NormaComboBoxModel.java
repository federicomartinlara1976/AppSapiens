package com.mdval.ui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import com.mdval.bussiness.entities.Norma;

/**
 * @author federico
 *
 */
public class NormaComboBoxModel extends AbstractListModel<Norma> implements ComboBoxModel<Norma> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8083638254718894808L;
	
	private List<Norma> normas;
	
	private Norma selection = null;
	
	/**
	 * 
	 */
	public NormaComboBoxModel() {
		super();
		normas = new ArrayList<>();
	}
	
	/**
	 * 
	 */
	public NormaComboBoxModel(List<Norma> normas) {
		super();
		this.normas = new ArrayList<>();
		
		// En este modelo de combo se añade el campo vacío
		this.normas.add(null);
		
		for (Norma norma : normas) {
			this.normas.add(norma);
		}
	}

	@Override
	public int getSize() {
		return normas.size();
	}

	@Override
	public Norma getElementAt(int index) {
		return normas.get(index);
	}

	@Override
	public void setSelectedItem(Object anItem) {
		selection = (Norma) anItem;
	}

	@Override
	public Object getSelectedItem() {
		return selection;
	}

}
