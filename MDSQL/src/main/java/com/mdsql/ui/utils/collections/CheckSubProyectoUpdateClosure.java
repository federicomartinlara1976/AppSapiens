package com.mdsql.ui.utils.collections;

import org.apache.commons.collections.Closure;

import com.mdsql.bussiness.entities.SubProyecto;

/**
 * @author federico
 *
 */
public class CheckSubProyectoUpdateClosure implements Closure {
	
	private String codigoProyecto;

	public CheckSubProyectoUpdateClosure(String codigoProyecto) {
		super();
		this.codigoProyecto = codigoProyecto;
	}

	@Override
	public void execute(Object input) {
		SubProyecto toUpdate = (SubProyecto) input;
		
		if (!codigoProyecto.equals(toUpdate.getCodigoProyecto())) {
			toUpdate.setCodigoProyecto(codigoProyecto);
		}
	}

}
