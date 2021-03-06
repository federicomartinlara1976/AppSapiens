package com.mdsql.ui.utils.creators;

import java.util.Map;

import com.mdsql.ui.model.cabeceras.AltaModificacionNormasElementoNormaCabecera;
import com.mdsql.ui.model.cabeceras.AltaModificacionNormasElementoParticulaCabecera;
import com.mdsql.ui.model.cabeceras.Cabecera;
import com.mdsql.ui.model.cabeceras.DefinicionElementosNormaCabecera;
import com.mdsql.ui.model.cabeceras.DefinicionElementosTablaTipoElementoCabecera;
import com.mdsql.ui.model.cabeceras.DefinicionGlosariosTablaGlosariosCabecera;
import com.mdsql.ui.model.cabeceras.DefinicionNormasTablaNormasCabecera;
import com.mdsql.ui.model.cabeceras.DefinicionParticulasNormaElementoCabecera;
import com.mdsql.ui.model.cabeceras.DefinicionTiposParticulaTablaTiposCabecera;
import com.mdsql.ui.model.cabeceras.DetalleValidacionCabecera;
import com.mdsql.ui.model.cabeceras.GlosarioCamposTablaCamposCabecera;
import com.mdsql.ui.model.cabeceras.GlosarioCamposTablaModelosCabecera;
import com.mdsql.ui.model.cabeceras.SubProyectoCabecera;
import com.mdsql.ui.model.cabeceras.TablaModelosCabecera;
import com.mdsql.ui.model.cabeceras.TablaValidaParticulaCabecera;
import com.mdsql.ui.model.cabeceras.TablaValoresParticulasCabecera;
import com.mdsql.utils.Constants;

/**
 * Factory method para gestionar la creación centralizada de la cabecera de 
 * títulos de las tablas.
 * 
 * @author federico
 *
 */
public class CabeceraTablaCreator extends Creator {
	
	private String item;
	
	public CabeceraTablaCreator(String item) {
		this.item = item;
	}
	
	@Override
	public Object factoryMethod() {
		Cabecera cabecera = null;
	
		if (Constants.FRM_DEFINICION_GLOSARIOS_TABLA_GLOSARIOS_CABECERA.equals(item)) {
			cabecera = new DefinicionGlosariosTablaGlosariosCabecera();
		}
		
		if (Constants.FRM_GLOSARIO_CAMPOS_TABLA_CAMPO_CABECERA.equals(item)) {
			cabecera = new GlosarioCamposTablaCamposCabecera();
		}
		
		if (Constants.FRM_GLOSARIO_CAMPOS_TABLA_MODELO_CABECERA.equals(item)) {
			cabecera = new GlosarioCamposTablaModelosCabecera();
		}
		
		if (Constants.FRM_DEFINICION_NORMAS_TABLA_NORMAS_CABECERA.equals(item)) {
			cabecera = new DefinicionNormasTablaNormasCabecera();
		}
		
		if (Constants.DLG_MODIFICACION_NORMAS_TABLA_ELEMENTOS_CABECERA.equals(item)) {
			cabecera = new AltaModificacionNormasElementoNormaCabecera();
		}
		
		if (Constants.DLG_MODIFICACION_NORMAS_TABLA_PARTICULAS_CABECERA.equals(item)) {
			cabecera = new AltaModificacionNormasElementoParticulaCabecera();
		}
		
		if (Constants.FRM_DEFINICION_ELEMENTOS_TABLA_TIPOS_ELEMENTO_CABECERA.equals(item)) {
			cabecera = new DefinicionElementosTablaTipoElementoCabecera();
		}
		
		if (Constants.FRM_DEFINICION_ELEMENTOS_NORMA_TABLA_ELEMENTOS_CABECERA.equals(item)) {
			cabecera = new DefinicionElementosNormaCabecera();
		}
		
		if (Constants.FRM_DEFINICION_TIPOS_PARTICULA_TABLA_TIPOS_CABECERA.equals(item)) {
			cabecera = new DefinicionTiposParticulaTablaTiposCabecera();
		}
		
		if (Constants.FRM_DEFINICION_PARTICULAS_NORMA_CABECERA.equals(item)) {
			cabecera = new DefinicionParticulasNormaElementoCabecera();
		}
		
		if (Constants.FRM_VALORES_PARTICULAS_CABECERA.equals(item)) {
			cabecera = new TablaValoresParticulasCabecera();
		}
		
		if (Constants.FRM_DEFINICION_MODELOS_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaModelosCabecera();
		}
		
		if (Constants.FRM_COMPROBACION_NOMBRE_ELEMENTO_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaValidaParticulaCabecera();
		}
		
		if (Constants.FRM_MANTENIMIENTO_MODELOS_SUBPROYECTO_TABLA_CABECERA.equals(item)) {
			cabecera = new SubProyectoCabecera();
		}
		
		if (Constants.DETALLE_VALIDACION_TABLA_CABECERA.equals(item)) {
			cabecera = new DetalleValidacionCabecera();
		}
		
		return cabecera;
	}

	/**
	 *
	 */
	@Override
	public Object factoryMethod(Map<String, Object> params) {
		return null;
	}
}
