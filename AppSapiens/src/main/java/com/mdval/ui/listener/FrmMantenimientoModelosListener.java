package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
import com.mdval.utils.AppGlobalSingleton;
import com.mdval.utils.AppHelper;
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
		AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
		String usuario = (String) appGlobalSingleton.getProperty(Constants.COD_USR);
		
		// Recoger los datos de los cuadros y crear un objeto SubProyecto
		String codigoSubProyecto = frmMantenimientoModelos.getTxtCodigoSubmodelo().getText();
		String descripcionSubProyecto = frmMantenimientoModelos.getTxtDescripcionSubmodelo().getText();
		
		SubProyecto subProyecto = new SubProyecto();
		subProyecto.setCodigoSubProyecto(codigoSubProyecto);
		subProyecto.setDescripcionSubProyecto(descripcionSubProyecto);
		subProyecto.setCodigoUsuario(usuario);
		
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
		try {
			AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
			ModeloService modeloService = (ModeloService) getService(Constants.MODELO_SERVICE);

			String usuario = (String) appGlobalSingleton.getProperty(Constants.COD_USR);
			String msg = StringUtils.EMPTY;
			
			String codigoProyecto = frmMantenimientoModelos.getTxtCodModelo().getText();
			String nombreModelo = frmMantenimientoModelos.getTxtNombreModelo().getText();
			Norma norma = (Norma) frmMantenimientoModelos.getCmbNorma().getSelectedItem();
			BigDecimal codigoNorma = !Objects.isNull(norma) ? norma.getCodigoNorma() : null;
			String sCodigoGlosario = frmMantenimientoModelos.getTxtCodGlosario().getText();
			BigDecimal codigoGlosario = AppHelper.toBigDecimal(sCodigoGlosario);
			String esquema = frmMantenimientoModelos.getTxtEsquema().getText();
			String bbdd = frmMantenimientoModelos.getTxtBD().getText();
			String carpeta = frmMantenimientoModelos.getTxtCarpeta().getText();
			String grupo = frmMantenimientoModelos.getTxtGrupo().getText();
			String herramienta = frmMantenimientoModelos.getTxtHerramienta().getText();
			String mcaGrantAll = AppHelper.normalizeCmbSiNoValue((String) frmMantenimientoModelos.getCmbGrantAll().getSelectedItem());
			String mcaGrantPublic = AppHelper.normalizeCmbSiNoValue((String) frmMantenimientoModelos.getCmbGrantPublic().getSelectedItem());
			String mcaGeneraVariables = AppHelper.normalizeCmbSiNoValue((String) frmMantenimientoModelos.getCmbGeneraVariables().getSelectedItem());
			String mcaVariablesConCapa = AppHelper.normalizeCmbSiNoValue((String) frmMantenimientoModelos.getCmbVariablesConCapa().getSelectedItem());
			
			Modelo modelo = new Modelo();
			modelo.setCodigoProyecto(codigoProyecto);
			modelo.setNombreModelo(nombreModelo);
			modelo.setCodigoNorma(codigoNorma);
			modelo.setCodigoGlosario(codigoGlosario);
			modelo.setNombreEsquema(esquema);
			modelo.setNombreBbdd(bbdd);
			modelo.setNombreCarpetaAdj(carpeta);
			modelo.setCodigoGrupoBds(grupo);
			modelo.setCodigoHerramienta(herramienta);
			modelo.setMcaGrantAll(mcaGrantAll);
			modelo.setMcaGrantPublic(mcaGrantPublic);
			modelo.setMcaVariables(mcaGeneraVariables);
			modelo.setMcaVariablesConCapa(mcaVariablesConCapa);
			modelo.setMcaInh(Constants.S);
			modelo.setCodigoUsuario(usuario);
			
			Integer response = UIHelper.showConfirm(literales.getLiteral("confirmacion.mensaje"),
					literales.getLiteral("confirmacion.titulo"));
			
			if (response == JOptionPane.YES_OPTION) {
				// Se van a guardar las modificaciones de un registro existente
				if (frmMantenimientoModelos.getEditar()) {
					modeloService.modificaModelo(modelo);
	
					msg = literales.getLiteral("mensaje.guardar");
				} else {
					modeloService.altaModelo(modelo);
	
					msg = literales.getLiteral("mensaje.crear");
				}
	
				JOptionPane.showMessageDialog(frmMantenimientoModelos, msg);
	
				/**
				 * En este punto invocar un método que informe a los observadores del patrón
				 * observer para que invoquen a su método de actualización
				 */
				updateObservers(Constants.FRM_MANTENIMIENTO_MODELOS_BTN_ACEPTAR);
				frmMantenimientoModelos.dispose();
			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(frmMantenimientoModelos, Constants.CMD_ERROR, params);
		}
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
			showPopup(frmMantenimientoModelos, Constants.CMD_ERROR, params);
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
