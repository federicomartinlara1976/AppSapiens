package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import com.mdval.bussiness.entities.Glosario;
import com.mdval.ui.glosarios.FrmDefinicionGlosarios;
import com.mdval.ui.model.DefinicionGlosariosTableModel;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.Constants;

public class FrmDefinicionGlosariosListener extends ListenerSupport implements ActionListener {

	private FrmDefinicionGlosarios frmDefinicionGlosarios;

	public FrmDefinicionGlosariosListener(FrmDefinicionGlosarios frmDefinicionGlosarios) {
		super();
		this.frmDefinicionGlosarios = frmDefinicionGlosarios;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.DLG_DEFINICION_GLOSARIOS_BTN_BUSCAR.equals(jButton.getName())) {
			eventBtnBuscar();
		}

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

	private void eventBtnBuscar() {
		populateModel();
	}

	private void eventBtnAlta() {
		showPopup(frmDefinicionGlosarios, Constants.CMD_ALTA_GLOSARIOS);
	}

	private void evntBtnModificacion() {
		Map<String, Object> params = new HashMap<>();
		params.put(Constants.DLG_DEFINICION_GLOSARIOS_SELECCIONADO, frmDefinicionGlosarios.getSeleccionado());
		
		showPopup(frmDefinicionGlosarios, Constants.CMD_MODIFICACION_GLOSARIOS, params);
	}

	private void eventBtnSeleccionar() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * TODO - Borrar este método de prueba y usar una conexión a BBDD
	 * 
	 * @return
	 */
	private void populateModel() {
		// Test - add Glosario to model
		List<Glosario> glosarios = new ArrayList<>();
		

		// Populate with 100 glosarios
		for (int i = 0; i < 100; i++) {
			Glosario glosario = new Glosario(i, "Glosario " + i, "usuario", new Date(), new Date());
			glosarios.add(glosario);
		}

		DefinicionGlosariosTableModel tableModel = (DefinicionGlosariosTableModel) frmDefinicionGlosarios.getTblGlosarios().getModel();
		tableModel.setGlosarios(glosarios);
		frmDefinicionGlosarios.getTblGlosarios().setModel(tableModel);
		tableModel.fireTableDataChanged();
		
		frmDefinicionGlosarios.getBtnModificacion().setEnabled(Boolean.FALSE);
	}
}
