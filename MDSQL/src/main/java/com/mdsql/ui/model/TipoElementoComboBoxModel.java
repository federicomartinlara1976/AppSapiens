package com.mdsql.ui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import com.mdsql.bussiness.entities.TipoElemento;

/**
 * @author federico
 *
 */
public class TipoElementoComboBoxModel extends AbstractListModel<TipoElemento> implements ComboBoxModel<TipoElemento> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8083638254718894808L;
	
	private List<TipoElemento> tipos;
	
	private TipoElemento selection = null;
	
	/**
	 * 
	 */
	public TipoElementoComboBoxModel() {
		super();
		tipos = new ArrayList<>();
	}
	
	/**
	 * 
	 */
	public TipoElementoComboBoxModel(List<TipoElemento> tipos) {
		super();
		this.tipos = new ArrayList<>();
		
		for (TipoElemento tipoElemento : tipos) {
			this.tipos.add(tipoElemento);
		}
	}

	@Override
	public int getSize() {
		return tipos.size();
	}

	@Override
	public TipoElemento getElementAt(int index) {
		return tipos.get(index);
	}

	@Override
	public void setSelectedItem(Object anItem) {
		selection = (TipoElemento) anItem;
	}

	@Override
	public Object getSelectedItem() {
		return selection;
	}

}
