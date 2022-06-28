package com.mdval.ui.utils;

import java.util.List;

import com.mdval.bussiness.entities.TipoDato;
import com.mdval.bussiness.service.TipoDatoService;
import com.mdval.ui.model.TipoDatoComboBoxModel;
import com.mdval.utils.AppHelper;
import com.mdval.utils.MDValConstants;

/**
 * @author federico
 *
 */
public class MDValMaestrasSupport extends MaestrasSupport {
	
	/**
	 * @return
	 */
	public static TipoDatoComboBoxModel getTipoDatoCmbModel() {
		TipoDatoService tipoDatoService = (TipoDatoService) AppHelper.getBean(MDValConstants.TIPO_DATO_SERVICE);
		List<TipoDato> tiposDatos = tipoDatoService.consultaTipoDatos();
		return new TipoDatoComboBoxModel(tiposDatos);
	}
}
