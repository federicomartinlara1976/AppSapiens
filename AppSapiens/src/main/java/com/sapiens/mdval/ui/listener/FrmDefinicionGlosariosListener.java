package com.sapiens.mdval.ui.listener;

import com.sapiens.mdval.bussiness.entities.Glosario;
import com.sapiens.mdval.bussiness.service.GlosarioService;
import com.sapiens.mdval.ui.glosarios.FrmAltaModificacionGlosarios;
import com.sapiens.mdval.ui.glosarios.FrmDefinicionGlosarios;
import com.sapiens.mdval.ui.utils.ListenerSupport;
import com.sapiens.mdval.utils.Constants;
import com.sapiens.mdval.utils.DateFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class FrmDefinicionGlosariosListener extends ListenerSupport implements ActionListener {

	private FrmDefinicionGlosarios frmDefinicionGlosarios;

	public FrmDefinicionGlosariosListener(FrmDefinicionGlosarios frmDefinicionGlosarios) {
		super();
		this.frmDefinicionGlosarios = frmDefinicionGlosarios;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_DEFINICION_GLOSARIOS_BTN_ALTA.equals(jButton.getName())) {
			eventBtnAlta();
		}

		if (Constants.DLG_DEFINICION_GLOSARIOS_BTN_MODIFICACION.equals(jButton.getName())) {
			evntBtnModificacion();
		}

		if (Constants.DLG_DEFINICION_GLOSARIOS_BTN_SELECCIONAR.equals(jButton.getName())) {
			eventBtnSeleccionar();
		}
	}

	private void eventBtnAlta() {
		showFrame(Constants.CMD_ALTA_GLOSARIOS);
	}

	private void evntBtnModificacion() {
		showFrame(Constants.CMD_MODIFICACION_GLOSARIOS);
		FrmAltaModificacionGlosarios form = new FrmAltaModificacionGlosarios();
		FrmAltaModificacionGlosariosListener form2 = new FrmAltaModificacionGlosariosListener(form);
		form2.setIsEditing(Boolean.TRUE);
		GlosarioService glosarioService = (GlosarioService) getService("glosarioService");
		Glosario glosarioConsultado = glosarioService.consultarGlosario("");//TODO get codigoglosario cambiar glosario por glosarioConsultado
		Glosario glosario = Glosario.builder().codigo(1).descripcion("descripcion").fechaAlta(new Date()).fechaModificacion(new Date()).usuario("123").build();
		form.getTxtCodigo().setText(glosario.getCodigo().toString());
		form.getTxtAlta().setText(DateFormatter.dateToString(glosario.getFechaAlta()));
		form.getTxtModificacion().setText(DateFormatter.dateToString(glosario.getFechaModificacion()));

	}

	private void eventBtnSeleccionar() {
		// TODO Auto-generated method stub

	}
}
