package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.service.GlosarioService;
import com.mdval.ui.glosarios.DlgAltaModificacionGlosarios;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.Constants;
import com.mdval.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

@Log4j
public class DlgAltaModificacionGlosariosListener extends ListenerSupport implements ActionListener {

	private DlgAltaModificacionGlosarios dlgAltaModificacionGlosarios;

	public DlgAltaModificacionGlosariosListener(DlgAltaModificacionGlosarios dlgAltaModificacionGlosarios) {
		super();
		this.dlgAltaModificacionGlosarios = dlgAltaModificacionGlosarios;
	}

	@SneakyThrows
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAltaModificacion();
		}

		if (Constants.DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgAltaModificacionGlosarios.dispose();
		}
	}

	@SneakyThrows
	private void eventBtnAltaModificacion() {
		GlosarioService glosarioService = (GlosarioService) getService(Constants.GLOSARIO_SERVICE);
		String descripcion = dlgAltaModificacionGlosarios.getTxtDescripcion().getText();
		String sCodigo = dlgAltaModificacionGlosarios.getTxtCodigo().getText();
		String usuario = dlgAltaModificacionGlosarios.getTxtUsuario().getText();
		String msg = StringUtils.EMPTY;
		Integer resultado = 0;

		// Se van a guardar las modificaciones de un registro existente
		if (dlgAltaModificacionGlosarios.getEditar()) {
			BigDecimal codigoBigDecimal = new BigDecimal(Integer.parseInt(sCodigo));
			resultado = glosarioService.modificaGlosario(codigoBigDecimal, descripcion, usuario);
			msg = (resultado == 0) ? "Registro guardado correctamente" : "Ocurrió un error al guardar el registro";
		} else {
			resultado = glosarioService.altaGlosario(descripcion, usuario);
			msg = (resultado == 0) ? "Registro creado correctamente" : "Ocurrió un error al crear el registro";
		}

		LogWrapper.debug(log, msg);
		JOptionPane.showMessageDialog(dlgAltaModificacionGlosarios.getFrameParent(), msg);
		dlgAltaModificacionGlosarios.dispose();
	}

}
