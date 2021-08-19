package com.sapiens.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sapiens.mdval.bussiness.service.GlosarioService;
import com.sapiens.mdval.ui.glosarios.FrmAltaModificacionGlosarios;
import com.sapiens.mdval.ui.utils.ListenerSupport;
import com.sapiens.mdval.utils.Constants;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

@Log4j
public class FrmAltaModificacionGlosariosListener extends ListenerSupport implements ActionListener {

	private FrmAltaModificacionGlosarios frmAltaModificacionGlosarios;

	public FrmAltaModificacionGlosariosListener(FrmAltaModificacionGlosarios frmAltaModificacionGlosarios) {
		super();
		this.frmAltaModificacionGlosarios = frmAltaModificacionGlosarios;
	}

	@SneakyThrows
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

	@SneakyThrows
	private void eventBtnAlta() {
		GlosarioService glosarioService = (GlosarioService) getService("glosarioService");
		String descripcion = "test inputParam";
		//String descripcion = frmAltaModificacionGlosarios.getTxtDescripcion().getText();
		String resultado = glosarioService.altaGlosario(descripcion);
		//String outResponse = glosarioService.procedureOracle();
		log.debug(resultado);
	}

}
