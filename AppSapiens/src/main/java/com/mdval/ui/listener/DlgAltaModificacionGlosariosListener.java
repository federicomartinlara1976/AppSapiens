package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.service.GlosarioService;
import com.mdval.ui.glosarios.DlgAltaModificacionGlosarios;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.Constants;

import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

@Log4j
public class DlgAltaModificacionGlosariosListener extends ListenerSupport implements ActionListener {

	private DlgAltaModificacionGlosarios dlgAltaModificacionGlosarios;
	
	@Setter
	private Boolean isEditing = Boolean.FALSE;

	public DlgAltaModificacionGlosariosListener(DlgAltaModificacionGlosarios dlgAltaModificacionGlosarios) {
		super();
		this.dlgAltaModificacionGlosarios = dlgAltaModificacionGlosarios;
	}

	@SneakyThrows
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}

		if (Constants.DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgAltaModificacionGlosarios.dispose();
		}
	}

	@SneakyThrows
	private void eventBtnAlta() {
		GlosarioService glosarioService = (GlosarioService) getService("glosarioService");
		String descripcion = dlgAltaModificacionGlosarios.getTxtDescripcion().getText();
		String resultado = StringUtils.EMPTY;
		
		if (isEditing) {
			resultado = glosarioService.modificaGlosario(descripcion);
		}
		
		resultado = glosarioService.altaGlosario(descripcion);
		log.debug(resultado);
	}

}
