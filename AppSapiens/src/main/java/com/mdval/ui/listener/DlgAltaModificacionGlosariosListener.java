package com.mdval.ui.listener;

import com.mdval.bussiness.service.GlosarioService;
import com.mdval.ui.glosarios.DlgAltaModificacionGlosarios;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.Constants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.*;
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
		String codigo = dlgAltaModificacionGlosarios.getTxtCodigo().getText();
		String usuario = dlgAltaModificacionGlosarios.getTxtUsuario().getText();
		Integer resultado = 0;

		BigDecimal codigoBigDecimal = new BigDecimal(codigo);

		if (isEditing) {
			System.out.println("Editando");
			resultado = glosarioService.modificaGlosario(codigoBigDecimal, descripcion, usuario);
		}
		System.out.println("no editando");
		resultado = glosarioService.altaGlosario(codigoBigDecimal, descripcion, usuario);
		log.debug(resultado);
	}

}
