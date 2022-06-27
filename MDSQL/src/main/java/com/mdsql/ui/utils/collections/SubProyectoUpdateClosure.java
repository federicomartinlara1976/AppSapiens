package com.mdsql.ui.utils.collections;

import org.apache.commons.collections.Closure;

import com.mdsql.bussiness.entities.SubProyecto;

/**
 * @author federico
 *
 */
public class SubProyectoUpdateClosure implements Closure {
	
	private SubProyecto subProyecto;

	public SubProyectoUpdateClosure(SubProyecto subProyecto) {
		super();
		this.subProyecto = subProyecto;
	}

	@Override
	public void execute(Object input) {
		SubProyecto toUpdate = (SubProyecto) input;
		
		if (subProyecto.getCodigoSubProyecto().equals(toUpdate.getCodigoSubProyecto())) {
			toUpdate.setCodigoSubProyecto(subProyecto.getCodigoSubProyecto());
			toUpdate.setDescripcionSubProyecto(subProyecto.getDescripcionSubProyecto());
		}
	}

}
