package com.mdval.ui.model.cabeceras;

import java.util.List;

public abstract class Cabecera {
	public abstract List<String> getColumnIdentifiers();
	
	public abstract List<Class<?>> getColumnClasses();
}
