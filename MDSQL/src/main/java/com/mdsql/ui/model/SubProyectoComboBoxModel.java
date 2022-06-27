package com.mdsql.ui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import com.mdsql.bussiness.entities.SubProyecto;

/**
 * @author federico
 *
 */
public class SubProyectoComboBoxModel extends AbstractListModel<SubProyecto> implements ComboBoxModel<SubProyecto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8083638254718894808L;
	
	private List<SubProyecto> subProyectos;
	
	private SubProyecto selection = null;
	
	/**
	 * 
	 */
	public SubProyectoComboBoxModel() {
		super();
		subProyectos = new ArrayList<>();
	}
	
	/**
	 * 
	 */
	public SubProyectoComboBoxModel(List<SubProyecto> subProyectos) {
		super();
		this.subProyectos = new ArrayList<>();
		
		for (SubProyecto subProyecto : subProyectos) {
			this.subProyectos.add(subProyecto);
		}
	}
	
	/**
	 * 
	 */
	public void clear() {
		this.subProyectos.clear();
	}

	@Override
	public int getSize() {
		return subProyectos.size();
	}

	@Override
	public SubProyecto getElementAt(int index) {
		return subProyectos.get(index);
	}

	@Override
	public void setSelectedItem(Object anItem) {
		selection = (SubProyecto) anItem;
	}

	@Override
	public Object getSelectedItem() {
		return selection;
	}

}
