package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.entities.Glosario;
import com.mdval.bussiness.entities.Modelo;
import com.mdval.bussiness.entities.Norma;
import com.mdval.bussiness.entities.SubProyecto;
import com.mdval.bussiness.service.GlosarioService;
import com.mdval.bussiness.service.ModeloService;
import com.mdval.bussiness.service.NormaService;
import com.mdval.ui.glosarios.FrmDefinicionGlosarios;
import com.mdval.ui.model.NormaComboBoxModel;
import com.mdval.ui.model.SubProyectoTableModel;
import com.mdval.ui.modelos.FrmMantenimientoModelos;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.ui.utils.UIHelper;
import com.mdval.ui.utils.collections.CheckSubProyectoUpdateClosure;
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
		String codigoProyecto = frmMantenimientoModelos.getTxtCodModelo().getText();
		if (StringUtils.isBlank(codigoProyecto)) {
			JOptionPane.showMessageDialog(frmMantenimientoModelos, literales.getLiteral("subproyectos.proyecto.error"));
			return;
		}
		
		String codigoSubProyecto = frmMantenimientoModelos.getTxtCodigoSubmodelo().getText();
		String descripcionSubProyecto = frmMantenimientoModelos.getTxtDescripcionSubmodelo().getText();
		
		if (StringUtils.isNotBlank(codigoSubProyecto) && StringUtils.isNotBlank(descripcionSubProyecto)) {
			SubProyecto subProyecto = new SubProyecto();
			subProyecto.setCodigoProyecto(codigoProyecto);
			subProyecto.setCodigoSubProyecto(codigoSubProyecto);
			subProyecto.setDescripcionSubProyecto(descripcionSubProyecto);
			subProyecto.setCodigoUsuario(usuario);
			subProyecto.setFechaActualizacion(new Date());
		
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
			if (StringUtils.isBlank(codigoProyecto)) {
				JOptionPane.showMessageDialog(frmMantenimientoModelos, literales.getLiteral("proyecto.error"));
				return;
			}
			
			String nombreModelo = frmMantenimientoModelos.getTxtNombreModelo().getText();
			Norma norma = (Norma) frmMantenimientoModelos.getCmbNorma().getSelectedItem();
			BigDecimal codigoNorma = !Objects.isNull(norma) ? norma.getCodigoNorma() : null;
			String sCodigoGlosario = frmMantenimientoModelos.getTxtCodGlosario().getText();
			BigDecimal codigoGlosario = AppHelper.toBigDecimal(sCodigoGlosario, literales.getLiteral("codigoGlosario.error"));
			String esquema = frmMantenimientoModelos.getTxtEsquema().getText();
			String bbdd = frmMantenimientoModelos.getTxtBD().getText();
			String carpeta = frmMantenimientoModelos.getTxtCarpeta().getText();
			String grupo = frmMantenimientoModelos.getTxtGrupo().getText();
			String herramienta = frmMantenimientoModelos.getTxtHerramienta().getText();
			String observaciones = frmMantenimientoModelos.getTxtObservaciones().getText();
			String aplicacion = frmMantenimientoModelos.getTxtAplicacion().getText();
			String mcaGrantAll = AppHelper.normalizeCmbSiNoValue((String) frmMantenimientoModelos.getCmbGrantAll().getSelectedItem());
			String mcaGrantPublic = AppHelper.normalizeCmbSiNoValue((String) frmMantenimientoModelos.getCmbGrantPublic().getSelectedItem());
			String mcaGeneraVariables = AppHelper.normalizeCmbSiNoValue((String) frmMantenimientoModelos.getCmbGeneraVariables().getSelectedItem());
			String mcaVariablesConCapa = AppHelper.normalizeCmbSiNoValue((String) frmMantenimientoModelos.getCmbVariablesConCapa().getSelectedItem());
			SubProyectoTableModel tableModel = (SubProyectoTableModel) frmMantenimientoModelos.getTblSubproyectos().getModel();
			List<SubProyecto> subProyectos = tableModel.getData();
			
			// Error si no se ha rellenado la lista de subproyectos
			if (CollectionUtils.isEmpty(subProyectos)) {
				throw new Exception(literales.getLiteral("subproyectos.error"));
			}
			
			checkSubProyectos(subProyectos, codigoProyecto);
			
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
			modelo.setObservacionesModelo(observaciones);
			modelo.setNomApnCmdb(aplicacion);
			modelo.setMcaGrantAll(mcaGrantAll);
			modelo.setMcaGrantPublic(mcaGrantPublic);
			modelo.setMcaVariables(mcaGeneraVariables);
			modelo.setCodigoCapaUsrown(mcaVariablesConCapa);
			modelo.setMcaInh(Constants.S);
			modelo.setCodigoUsuario(usuario);
			
			// Subproyectos
			modelo.setSubProyectos(subProyectos);
			
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
				
				// rellenar los campos
				dumpData(seleccionado, normaService);
				
				// se cargan los subproyectos
				List<SubProyecto> subProyectos = seleccionado.getSubProyectos();
				if (CollectionUtils.isNotEmpty(subProyectos)) {
					SubProyectoTableModel tableModel = (SubProyectoTableModel) frmMantenimientoModelos.getTblSubproyectos().getModel();
					tableModel.setData(subProyectos);
				}
			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(frmMantenimientoModelos, Constants.CMD_ERROR, params);
		}
	}

	private void dumpData(Modelo seleccionado, NormaService normaService) {
		GlosarioService glosarioService = (GlosarioService) getService(Constants.GLOSARIO_SERVICE);
		
		frmMantenimientoModelos.getTxtCodModelo().setText(seleccionado.getCodigoProyecto());
		frmMantenimientoModelos.getTxtNombreModelo().setText(seleccionado.getNombreModelo());
		
		// Consulta la norma
		BigDecimal codNorma = seleccionado.getCodigoNorma();
		if (!Objects.isNull(codNorma)) {
			Norma norma = normaService.consultaNorma(codNorma);
			frmMantenimientoModelos.getCmbNorma().setSelectedItem(norma);
		}
		
		BigDecimal codGlosario = seleccionado.getCodigoGlosario();
		if (!Objects.isNull(codGlosario)) {
			Glosario glosario = glosarioService.consultarGlosario(codGlosario);
			frmMantenimientoModelos.getTxtCodGlosario().setText(glosario.getCodigoGlosario().toString());
			frmMantenimientoModelos.getTxtDescGlosario().setText(glosario.getDescripcionGlosario());
		}
		
		frmMantenimientoModelos.getTxtEsquema().setText(seleccionado.getNombreEsquema());
		frmMantenimientoModelos.getTxtBD().setText(seleccionado.getNombreBbdd());
		frmMantenimientoModelos.getTxtCarpeta().setText(seleccionado.getNombreCarpetaAdj());
		frmMantenimientoModelos.getTxtGrupo().setText(seleccionado.getCodigoGrupoBds());
		frmMantenimientoModelos.getTxtHerramienta().setText(seleccionado.getCodigoHerramienta());
		frmMantenimientoModelos.getTxtObservaciones().setText(seleccionado.getObservacionesModelo());
		frmMantenimientoModelos.getTxtUsuario().setText(seleccionado.getCodigoUsuario());
		frmMantenimientoModelos.getTxtFecha().setText(dateFormatter.dateToString(seleccionado.getFechaActualizacion()));
		frmMantenimientoModelos.getTxtAplicacion().setText(seleccionado.getNomApnCmdb());
		
		String selectedGrantAll = AppHelper.normalizeSiNoValueToCmb(seleccionado.getMcaGrantAll());
		frmMantenimientoModelos.getCmbGrantAll().setSelectedItem(selectedGrantAll);
		
		String selectedGrantPublic = AppHelper.normalizeSiNoValueToCmb(seleccionado.getMcaGrantPublic());
		frmMantenimientoModelos.getCmbGrantPublic().setSelectedItem(selectedGrantPublic);
		
		String selectedVariables = AppHelper.normalizeSiNoValueToCmb(seleccionado.getMcaVariables());
		frmMantenimientoModelos.getCmbGeneraVariables().setSelectedItem(selectedVariables);
		
		String selectedVariablesConCapa = AppHelper.normalizeSiNoValueToCmb(seleccionado.getMcaVariablesConCapa());
		frmMantenimientoModelos.getCmbVariablesConCapa().setSelectedItem(selectedVariablesConCapa);
	}
	
	/**
	 * @param subProyectos
	 * @param codigoProyecto
	 */
	private void checkSubProyectos(List<SubProyecto> subProyectos, String codigoProyecto) {
		Closure closure = new CheckSubProyectoUpdateClosure(codigoProyecto);
		CollectionUtils.forAllDo(subProyectos, closure);
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
