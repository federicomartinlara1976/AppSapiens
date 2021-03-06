package com.mdval.ui.utils.creators;

import java.util.Map;

import com.mdval.ui.model.cabeceras.AltaModificacionNormasElementoNormaCabecera;
import com.mdval.ui.model.cabeceras.AltaModificacionNormasElementoParticulaCabecera;
import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.model.cabeceras.DefinicionElementosNormaCabecera;
import com.mdval.ui.model.cabeceras.DefinicionElementosTablaTipoElementoCabecera;
import com.mdval.ui.model.cabeceras.DefinicionGlosariosTablaGlosariosCabecera;
import com.mdval.ui.model.cabeceras.DefinicionNormasTablaNormasCabecera;
import com.mdval.ui.model.cabeceras.DefinicionParticulasNormaElementoCabecera;
import com.mdval.ui.model.cabeceras.DefinicionTiposParticulaTablaTiposCabecera;
import com.mdval.ui.model.cabeceras.DetalleValidacionCabecera;
import com.mdval.ui.model.cabeceras.GlosarioCamposTablaCamposCabecera;
import com.mdval.ui.model.cabeceras.GlosarioCamposTablaModelosCabecera;
import com.mdval.ui.model.cabeceras.SubProyectoCabecera;
import com.mdval.ui.model.cabeceras.TablaModelosCabecera;
import com.mdval.ui.model.cabeceras.TablaValidaParticulaCabecera;
import com.mdval.ui.model.cabeceras.TablaValoresParticulasCabecera;
import com.mdval.utils.MDValConstants;

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
	
		if (MDValConstants.FRM_DEFINICION_GLOSARIOS_TABLA_GLOSARIOS_CABECERA.equals(item)) {
			cabecera = new DefinicionGlosariosTablaGlosariosCabecera();
		}
		
		if (MDValConstants.FRM_GLOSARIO_CAMPOS_TABLA_CAMPO_CABECERA.equals(item)) {
			cabecera = new GlosarioCamposTablaCamposCabecera();
		}
		
		if (MDValConstants.FRM_GLOSARIO_CAMPOS_TABLA_MODELO_CABECERA.equals(item)) {
			cabecera = new GlosarioCamposTablaModelosCabecera();
		}
		
		if (MDValConstants.FRM_DEFINICION_NORMAS_TABLA_NORMAS_CABECERA.equals(item)) {
			cabecera = new DefinicionNormasTablaNormasCabecera();
		}
		
		if (MDValConstants.DLG_MODIFICACION_NORMAS_TABLA_ELEMENTOS_CABECERA.equals(item)) {
			cabecera = new AltaModificacionNormasElementoNormaCabecera();
		}
		
		if (MDValConstants.DLG_MODIFICACION_NORMAS_TABLA_PARTICULAS_CABECERA.equals(item)) {
			cabecera = new AltaModificacionNormasElementoParticulaCabecera();
		}
		
		if (MDValConstants.FRM_DEFINICION_ELEMENTOS_TABLA_TIPOS_ELEMENTO_CABECERA.equals(item)) {
			cabecera = new DefinicionElementosTablaTipoElementoCabecera();
		}
		
		if (MDValConstants.FRM_DEFINICION_ELEMENTOS_NORMA_TABLA_ELEMENTOS_CABECERA.equals(item)) {
			cabecera = new DefinicionElementosNormaCabecera();
		}
		
		if (MDValConstants.FRM_DEFINICION_TIPOS_PARTICULA_TABLA_TIPOS_CABECERA.equals(item)) {
			cabecera = new DefinicionTiposParticulaTablaTiposCabecera();
		}
		
		if (MDValConstants.FRM_DEFINICION_PARTICULAS_NORMA_CABECERA.equals(item)) {
			cabecera = new DefinicionParticulasNormaElementoCabecera();
		}
		
		if (MDValConstants.FRM_VALORES_PARTICULAS_CABECERA.equals(item)) {
			cabecera = new TablaValoresParticulasCabecera();
		}
		
		if (MDValConstants.FRM_DEFINICION_MODELOS_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaModelosCabecera();
		}
		
		if (MDValConstants.FRM_COMPROBACION_NOMBRE_ELEMENTO_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaValidaParticulaCabecera();
		}
		
		if (MDValConstants.FRM_MANTENIMIENTO_MODELOS_SUBPROYECTO_TABLA_CABECERA.equals(item)) {
			cabecera = new SubProyectoCabecera();
		}
		
		if (MDValConstants.DETALLE_VALIDACION_TABLA_CABECERA.equals(item)) {
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
