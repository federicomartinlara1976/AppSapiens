package com.sapiens.app.ui.listener;

import com.sapiens.app.bussiness.service.impl.GlosarioServiceImpl;
import com.sapiens.app.ui.glosarios.DlgAltaModificacionGlosarios;
import com.sapiens.app.utils.AppHelper;
import com.sapiens.app.utils.Constants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DlgAltaModificacionGlosariosListener extends ListenerSupport implements ActionListener {

	private DlgAltaModificacionGlosarios dlgAltaModificacionGlosarios;

	public DlgAltaModificacionGlosariosListener(DlgAltaModificacionGlosarios dlgAltaModificacionGlosarios) {
		super();
		this.dlgAltaModificacionGlosarios = dlgAltaModificacionGlosarios;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_ACEPTAR.equals(jButton.getName())) {
			eventBtnAlta();
		}

		if (Constants.DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_CANCELAR.equals(jButton.getName())) {
			dlgAltaModificacionGlosarios.dispose();
		}
	}

	private void eventBtnAlta() {
		GlosarioServiceImpl glosarioService = (GlosarioServiceImpl) AppHelper.getBean("glosarioService");
		String inParam = "test inputParam";
		String outResponse = glosarioService.procedurePostgres(inParam);
		//String outResponse = glosarioService.procedureOracle();
		System.out.println(outResponse);

	}

}
