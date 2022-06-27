package com.mdsql.ui.utils;

import java.util.List;

import com.mdsql.bussiness.entities.TipoDato;
import com.mdsql.bussiness.service.TipoDatoService;
import com.mdsql.ui.model.TipoDatoComboBoxModel;
import com.mdsql.utils.AppHelper;
import com.mdsql.utils.Constants;

/**
 * @author federico
 *
 */
public class MaestrasSupport {
	
	/**
	 * @return
	 */
	public static TipoDatoComboBoxModel getTipoDatoCmbModel() {
		TipoDatoService tipoDatoService = (TipoDatoService) AppHelper.getBean(Constants.TIPO_DATO_SERVICE);
		List<TipoDato> tiposDatos = tipoDatoService.consultaTipoDatos();
		return new TipoDatoComboBoxModel(tiposDatos);
	}
}
