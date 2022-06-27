package com.mdsql.ui.utils.collections;

import org.apache.commons.collections.Predicate;

import com.mdsql.bussiness.entities.SubProyecto;

/**
 * @author federico
 *
 */
public class SubProyectoPredicate implements Predicate {
	
	private SubProyecto subProyecto;

	public SubProyectoPredicate(SubProyecto subProyecto) {
		super();
		this.subProyecto = subProyecto;
	}



	@Override
	public boolean evaluate(Object object) {
		SubProyecto input = (SubProyecto) object;
		
		return subProyecto.getCodigoSubProyecto().equals(input.getCodigoSubProyecto());
	}

}
