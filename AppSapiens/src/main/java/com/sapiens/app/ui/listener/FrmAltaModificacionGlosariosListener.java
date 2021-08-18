package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sapiens.app.bussiness.service.GlosarioService;
import com.sapiens.app.ui.glosarios.FrmAltaModificacionGlosarios;
import com.sapiens.app.ui.utils.ListenerSupport;
import com.sapiens.app.utils.Constants;

import lombok.extern.log4j.Log4j;

@Log4j
public class FrmAltaModificacionGlosariosListener extends ListenerSupport implements ActionListener {

	private FrmAltaModificacionGlosarios frmAltaModificacionGlosarios;

	public FrmAltaModificacionGlosariosListener(FrmAltaModificacionGlosarios frmAltaModificacionGlosarios) {
		super();
		this.frmAltaModificacionGlosarios = frmAltaModificacionGlosarios;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_ACEPTAR.equals(jButton.getName())) {
			eventBtnAlta();
		}

		if (Constants.DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_CANCELAR.equals(jButton.getName())) {
			frmAltaModificacionGlosarios.dispose();
		}
	}

	private void eventBtnAlta() {
		GlosarioService glosarioService = (GlosarioService) getService("glosarioService");
		String inParam = "test inputParam";
		String outResponse = glosarioService.procedurePostgres(inParam);
		//String outResponse = glosarioService.procedureOracle();
		log.debug(outResponse);
	}

}
