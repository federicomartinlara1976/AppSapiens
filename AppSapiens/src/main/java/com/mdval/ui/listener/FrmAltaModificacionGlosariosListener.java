package com.mdval.ui.listener;

import com.mdval.bussiness.service.GlosarioService;
import com.mdval.ui.glosarios.FrmAltaModificacionGlosarios;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.Constants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

@Log4j
public class FrmAltaModificacionGlosariosListener extends ListenerSupport implements ActionListener {

	private FrmAltaModificacionGlosarios frmAltaModificacionGlosarios;
	@Setter
	private Boolean isEditing = Boolean.FALSE;

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
		String descripcion = frmAltaModificacionGlosarios.getTxtDescripcion().getText();
		String resultado = "";
		if(isEditing){
			resultado = glosarioService.modificaGlosario(descripcion);
		}
		resultado = glosarioService.altaGlosario(descripcion);
		log.debug(resultado);
	}

}
