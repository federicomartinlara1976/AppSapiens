package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.entities.Norma;
import com.mdval.bussiness.service.NormaService;
import com.mdval.ui.glosarios.FrmDefinicionGlosarios;
import com.mdval.ui.model.NormaComboBoxModel;
import com.mdval.ui.modelos.FrmMantenimientoModelos;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.Constants;

public class FrmMantenimientoModelosListener extends ListenerSupport implements ActionListener, OnLoadListener, Observer {

	private FrmMantenimientoModelos dlgMantenimientoModelos;
	
	private FrmDefinicionGlosarios frmDefinicionGlosarios;

	public FrmMantenimientoModelosListener(FrmMantenimientoModelos dlgMantenimientoModelos) {
		super();
		this.dlgMantenimientoModelos = dlgMantenimientoModelos;
	}

	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.FRM_MANTENIMIENTO_MODELOS_BTN_BUSCAR_GLOSARIO.equals(jButton.getActionCommand())) {
			eventBtnBuscarGlosario();
		}

		if (Constants.FRM_MANTENIMIENTO_MODELOS_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}

		if (Constants.FRM_MANTENIMIENTO_MODELOS_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgMantenimientoModelos.dispose();
		}
	}

	private void eventBtnBuscarGlosario() {
		frmDefinicionGlosarios = (FrmDefinicionGlosarios) UIHelper.createFrame(Constants.MNU_DEF_GLOSARIOS);
		UIHelper.show(frmDefinicionGlosarios);

		frmDefinicionGlosarios.getFrmDefinicionGlosariosListener().addObservador(this);
	}

	private void eventBtnAlta() {
		
	}

	@Override
	public void onLoad() {
		NormaService normaService = (NormaService) getService(Constants.NORMA_SERVICE);
		List<Norma> normas = normaService.consultaNormas(StringUtils.EMPTY);
		
		NormaComboBoxModel modelNormas = new NormaComboBoxModel(normas);
		dlgMantenimientoModelos.getCmbNorma().setModel(modelNormas);
	}

	@Override
	public void update(Observable o, Object arg) {
		String cmd = (String) arg;

		if (Constants.FRM_DEFINICION_GLOSARIOS_BTN_SELECCIONAR.equals(cmd)) {
			if (!Objects.isNull(frmDefinicionGlosarios.getSeleccionado())) {
				dlgMantenimientoModelos.setGlosarioSeleccionado(frmDefinicionGlosarios.getSeleccionado());
				dlgMantenimientoModelos.getTxtCodGlosario().setText(
						frmDefinicionGlosarios.getSeleccionado().getCodigoGlosario().toBigInteger().toString());
				dlgMantenimientoModelos.getTxtDescGlosario()
						.setText(frmDefinicionGlosarios.getSeleccionado().getDescripcionGlosario());
				
			}
		}
	}

}
