package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.entities.Modelo;
import com.mdval.bussiness.entities.Norma;
import com.mdval.bussiness.entities.SubProyecto;
import com.mdval.bussiness.service.ModeloService;
import com.mdval.bussiness.service.NormaService;
import com.mdval.ui.glosarios.FrmDefinicionGlosarios;
import com.mdval.ui.model.NormaComboBoxModel;
import com.mdval.ui.model.SubProyectoTableModel;
import com.mdval.ui.modelos.FrmMantenimientoModelos;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.ui.utils.UIHelper;
import com.mdval.ui.utils.collections.SubProyectoPredicate;
import com.mdval.ui.utils.collections.SubProyectoUpdateClosure;
import com.mdval.utils.Constants;

public class FrmMantenimientoModelosListener extends ListenerSupport implements ActionListener, OnLoadListener, Observer {

	private FrmMantenimientoModelos frmMantenimientoModelos;
	
	private FrmDefinicionGlosarios frmDefinicionGlosarios;

	public FrmMantenimientoModelosListener(FrmMantenimientoModelos frmMantenimientoModelos) {
		super();
		this.frmMantenimientoModelos = frmMantenimientoModelos;
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
		
		if (Constants.FRM_MANTENIMIENTO_MODELOS_BTN_ADD_SUBMODELO.equals(jButton.getActionCommand())) {
			eventBtnAddSubmodelo();
		}
		
		if (Constants.FRM_MANTENIMIENTO_MODELOS_BTN_REMOVE_SUBMODELO.equals(jButton.getActionCommand())) {
			eventBtnRemoveSubmodelo();
		}

		if (Constants.FRM_MANTENIMIENTO_MODELOS_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}

		if (Constants.FRM_MANTENIMIENTO_MODELOS_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			frmMantenimientoModelos.dispose();
		}
	}

	private void eventBtnBuscarGlosario() {
		frmDefinicionGlosarios = (FrmDefinicionGlosarios) UIHelper.createFrame(Constants.MNU_DEF_GLOSARIOS);
		UIHelper.show(frmDefinicionGlosarios);

		frmDefinicionGlosarios.getFrmDefinicionGlosariosListener().addObservador(this);
	}
	
	@SuppressWarnings("unchecked")
	private void eventBtnAddSubmodelo() {
		// Recoger los datos de los cuadros y crear un objeto SubProyecto
		String codigoSubProyecto = frmMantenimientoModelos.getTxtCodigoSubmodelo().getText();
		String descripcionSubProyecto = frmMantenimientoModelos.getTxtDescripcionSubmodelo().getText();
		
		SubProyecto subProyecto = new SubProyecto();
		subProyecto.setCodigoSubProyecto(codigoSubProyecto);
		subProyecto.setDescripcionSubProyecto(descripcionSubProyecto);
		
		// Ver si el objeto ya está en la lista (por código de subproyecto)
		SubProyectoTableModel tableModel = (SubProyectoTableModel) frmMantenimientoModelos.getTblSubproyectos().getModel();
		List<SubProyecto> subProyectos = tableModel.getData();
		
		SubProyectoPredicate predicate = new SubProyectoPredicate(subProyecto);
		List<SubProyecto> encontrados = new ArrayList<>(CollectionUtils.select(subProyectos, predicate));
		
		if (CollectionUtils.isEmpty(encontrados)) { // Meterlo si no está
			tableModel.addData(subProyecto);
		}
		else { // Actualizarlo si está
			List<SubProyecto> replaces = new ArrayList<>(subProyectos);
			SubProyectoUpdateClosure closure = new SubProyectoUpdateClosure(subProyecto);
			CollectionUtils.forAllDo(replaces, closure);
			tableModel.setData(replaces);
		}
	}

	private void eventBtnRemoveSubmodelo() {
		SubProyecto seleccionado = frmMantenimientoModelos.getSubProyectoSeleccionado();
		SubProyectoTableModel tableModel = (SubProyectoTableModel) frmMantenimientoModelos.getTblSubproyectos().getModel();
		tableModel.removeData(seleccionado);
		
		frmMantenimientoModelos.getTxtCodigoSubmodelo().setText(StringUtils.EMPTY);
		frmMantenimientoModelos.getTxtDescripcionSubmodelo().setText(StringUtils.EMPTY);
	}

	private void eventBtnAlta() {
		
	}

	@Override
	public void onLoad() {
		try {
			NormaService normaService = (NormaService) getService(Constants.NORMA_SERVICE);
			List<Norma> normas = normaService.consultaNormas(StringUtils.EMPTY);
			
			NormaComboBoxModel modelNormas = new NormaComboBoxModel(normas);
			frmMantenimientoModelos.getCmbNorma().setModel(modelNormas);
			
			Map<String, Object> params = frmMantenimientoModelos.getParams();
			
			if (!Objects.isNull(params)) {
				ModeloService modeloService = (ModeloService) getService(Constants.MODELO_SERVICE);
				Modelo seleccionado = (Modelo) params.get(Constants.FRM_DEFINICION_MODELOS_SELECCIONADO);
				seleccionado = modeloService.consultaModelo(seleccionado.getCodigoProyecto());
			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup((JFrame) frmMantenimientoModelos.getParent(), Constants.CMD_ERROR, params);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		String cmd = (String) arg;

		if (Constants.FRM_DEFINICION_GLOSARIOS_BTN_SELECCIONAR.equals(cmd)) {
			if (!Objects.isNull(frmDefinicionGlosarios.getSeleccionado())) {
				frmMantenimientoModelos.setGlosarioSeleccionado(frmDefinicionGlosarios.getSeleccionado());
				frmMantenimientoModelos.getTxtCodGlosario().setText(
						frmDefinicionGlosarios.getSeleccionado().getCodigoGlosario().toBigInteger().toString());
				frmMantenimientoModelos.getTxtDescGlosario()
						.setText(frmDefinicionGlosarios.getSeleccionado().getDescripcionGlosario());
				
			}
		}
	}

}
