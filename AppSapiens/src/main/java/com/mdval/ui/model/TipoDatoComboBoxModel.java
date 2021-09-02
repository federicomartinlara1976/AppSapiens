package com.mdval.ui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.entities.TipoDato;

/**
 * @author federico
 *
 */
public class TipoDatoComboBoxModel extends AbstractListModel<String> implements ComboBoxModel<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8083638254718894808L;
	
	private List<String> tipos;
	
	private String selection = null;
	
	/**
	 * 
	 */
	public TipoDatoComboBoxModel() {
		super();
		tipos = new ArrayList<>();
	}
	
	/**
	 * 
	 */
	public TipoDatoComboBoxModel(List<TipoDato> tiposDatos) {
		super();
		this.tipos = new ArrayList<>();
		
		// En este modelo de combo se añade el campo vacío
		tipos.add(StringUtils.EMPTY);
		
		for (TipoDato tipoDato : tiposDatos) {
			tipos.add(tipoDato.getTipoDato());
		}
	}

	@Override
	public int getSize() {
		return tipos.size();
	}

	@Override
	public String getElementAt(int index) {
		return tipos.get(index);
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
