package com.mdsql.ui.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.entities.Norma;
import com.mdsql.bussiness.entities.SubProyecto;
import com.mdsql.bussiness.entities.ValidaScriptRequest;
import com.mdsql.bussiness.entities.ValidaScriptResponse;
import com.mdsql.bussiness.service.ModeloService;
import com.mdsql.bussiness.service.NormaService;
import com.mdsql.bussiness.service.ValidacionService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.ui.model.DetalleValidacionTableModel;
import com.mdsql.ui.model.SubProyectoComboBoxModel;
import com.mdsql.ui.modelos.FrmDefinicionModelos;
import com.mdsql.ui.utils.UIHelper;
import com.mdsql.ui.validacionscripts.PanelPrincipal;
import com.mdsql.ui.validacionscripts.PanelResultados;
import com.mdsql.utils.AppGlobalSingleton;
import com.mdsql.utils.AppHelper;
import com.mdsql.utils.Constants;
import com.mdsql.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PanelPrincipalActionListener extends PanelPrincipalListener implements ActionListener, Observer {
	
	private FrmDefinicionModelos frmDefinicionModelos;

	public PanelPrincipalActionListener(PanelPrincipal panelPrincipal) {
		super(panelPrincipal);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.PANEL_PRINCIPAL_BTN_LIMPIAR_TODO.equals(jButton.getActionCommand())) {
			eventBtnLimpiarTodo();
		}

		if (Constants.PANEL_PRINCIPAL_BTN_LIMPIAR_VALIDACION.equals(jButton.getActionCommand())) {
			eventBtnLimpiarValidacion();
		}

		if (Constants.PANEL_PRINCIPAL_BTN_LOAD_SCRIPT.equals(jButton.getActionCommand())) {
			eventBtnLoadScript();
		}

		if (Constants.PANEL_PRINCIPAL_BTN_VALIDAR.equals(jButton.getActionCommand())) {
			eventBtnValidar();
		}

		if (Constants.PANEL_PRINCIPAL_BTN_SEARCH.equals(jButton.getActionCommand())) {
			eventBtnSearch();
		}
	}

	private void eventBtnLimpiarTodo() {
		panelPrincipal.getTxtCodGlosario().setText(StringUtils.EMPTY);
		panelPrincipal.getTxtDescGlosario().setText(StringUtils.EMPTY);
		panelPrincipal.getTxtIM().setText(StringUtils.EMPTY);
		panelPrincipal.getTxtSD().setText(StringUtils.EMPTY);
		panelPrincipal.getTxtModeloProyecto().setText(StringUtils.EMPTY);
		panelPrincipal.getTxtCodNorma().setText(StringUtils.EMPTY);
		panelPrincipal.getTxtDescNorma().setText(StringUtils.EMPTY);
		
		SubProyectoComboBoxModel modelSubProyectos = new SubProyectoComboBoxModel(new ArrayList<>());
		panelPrincipal.getCmbSubmodelo().setModel(modelSubProyectos);
		
		eventBtnLimpiarValidacion();
	}

	private void eventBtnLimpiarValidacion() {
		limpiarPaneles();
		
		panelPrincipal.getTxtArchivoScript().setText(StringUtils.EMPTY);
		panelPrincipal.getTxtScript().setText(StringUtils.EMPTY);
		
		ValidaScriptRequest request = new ValidaScriptRequest();
		panelPrincipal.setRequest(request);
		panelPrincipal.setResponse(null);
	}
	
	private void limpiarPaneles() {
		PanelResultados panelResultados = panelPrincipal.getPanelElementosValidar();
		panelResultados.reset();
		
		panelResultados = panelPrincipal.getPanelExcepciones();
		panelResultados.reset();
		
		panelResultados = panelPrincipal.getPanelConErrores();
		panelResultados.reset();
		
		panelResultados = panelPrincipal.getPanelNoEstanEnGlosario();
		panelResultados.reset();
		
		panelResultados = panelPrincipal.getPanelElementosCorrectos();
		panelResultados.reset();
		
		panelPrincipal.getJTabbedPane1().setSelectedIndex(0);
		
		panelPrincipal.getJTabbedPane1().setForegroundAt(2, Color.BLACK);
		panelPrincipal.getJTabbedPane1().setForegroundAt(4, Color.BLACK);
	}

	/**
	 * 
	 */
	private void eventBtnLoadScript() {
		try {
			File file = selectFile();
			
			if (!Objects.isNull(file)) {
				panelPrincipal.getTxtScript().setText(StringUtils.EMPTY);
				panelPrincipal.getTxtArchivoScript().setText(file.getAbsolutePath());
				List<String> lines = dumpContentToText(file, panelPrincipal.getTxtScript());
				panelPrincipal.getRequest().setLines(lines);
			}
			
			limpiarPaneles();
		} catch (IOException e) {
			Map<String, Object> params = buildError(e);
			showPopup(panelPrincipal.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}

	/**
	 * 
	 */
	private void eventBtnValidar() {
		try {
			AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
			String codUsuario = (String) appGlobalSingleton.getProperty(Constants.COD_USR);
			String pathScript = panelPrincipal.getTxtArchivoScript().getText();
			
			if (StringUtils.isNotBlank(pathScript)) {
				// Resets the panels
				panelPrincipal.getJTabbedPane1().setForegroundAt(2, Color.BLACK);
				panelPrincipal.getJTabbedPane1().setForegroundAt(4, Color.BLACK);
				
				String codProyecto = panelPrincipal.getTxtModeloProyecto().getText();
				if (StringUtils.isBlank(codProyecto)) {
					JOptionPane.showMessageDialog(panelPrincipal.getFrameParent(), literales.getLiteral("principal.validador.modelo"));
					return;
				}
				
				SubProyecto subProyecto = (SubProyecto) panelPrincipal.getCmbSubmodelo().getSelectedItem();
				if (Objects.isNull(subProyecto)) {
					JOptionPane.showMessageDialog(panelPrincipal.getFrameParent(), literales.getLiteral("principal.validador.modelo"));
					return;
				}
				
				String im = panelPrincipal.getTxtIM().getText();
				if (StringUtils.isBlank(im)) {
					JOptionPane.showMessageDialog(panelPrincipal.getFrameParent(), literales.getLiteral("principal.validador.incidencia"));
					return;
				}
				
				String sd = panelPrincipal.getTxtSD().getText();
				if (StringUtils.isBlank(sd)) {
					JOptionPane.showMessageDialog(panelPrincipal.getFrameParent(), literales.getLiteral("principal.validador.iteracion"));
					return;
				}
				
				ValidaScriptRequest validaScriptRequest = panelPrincipal.getRequest();
				validaScriptRequest.setCodigoProyecto(codProyecto);
				validaScriptRequest.setCodigoSubProyecto(subProyecto.getCodigoSubProyecto());
				validaScriptRequest.setCodigoRF(im);
				validaScriptRequest.setCodigoSD(sd);
				validaScriptRequest.setNombreFichero(pathScript);
				validaScriptRequest.setCodigoUsuario(codUsuario);
				validaScriptRequest.setPScript(panelPrincipal.getTxtScript().getText());
				
				ValidaScriptResponse response = validarScript(validaScriptRequest);
				
				panelPrincipal.setResponse(response);
				
				// Mostrar el warning
				ServiceException serviceException = response.getServiceException();
				if (!Objects.isNull(serviceException)) {
					Map<String, Object> params = buildWarning(serviceException);
					showPopup(panelPrincipal.getFrameParent(), Constants.CMD_WARN, params);
				}
				
				// Poner en rojo el t??tulo de la pesta??a si hay elementos que no est??n en el glosario
				if (Constants.S.equals(response.getElementosNoGlosario())) {
					panelPrincipal.getJTabbedPane1().setForegroundAt(2, Color.RED);
				}
				
				// Poner en rojo t??tulo de la pesta??a si hay elementos con errores
				if (Constants.S.equals(response.getElementosErrores())) {
					panelPrincipal.getJTabbedPane1().setForegroundAt(4, Color.RED);
				}
				
				// Se carga la informaci??n en Elementos a Validar
				PanelResultados panelResultados = panelPrincipal.getPanelElementosValidar();
				panelResultados.reset();
				
				DetalleValidacionTableModel model = (DetalleValidacionTableModel) panelResultados.getTblResultados().getModel();
				model.setData(response.getListaElementosValid());
				panelPrincipal.getPanelElementosValidar().getBtnGenerarLog().setEnabled(Boolean.TRUE);
			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(panelPrincipal.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}

	private void eventBtnSearch() {
		Map<String, Object> params = new HashMap<>();
		params.put("fromMenu", Boolean.FALSE);
		
		String nombreModelo = panelPrincipal.getTxtModeloProyecto().getText();
		if (StringUtils.isNotBlank(nombreModelo)) {
			params.put("nombreModelo", nombreModelo);
		}

		frmDefinicionModelos = (FrmDefinicionModelos) UIHelper.createFrame(Constants.CMD_BUSCAR_MODELOS, params);
		UIHelper.show(frmDefinicionModelos);

		frmDefinicionModelos.getFrmDefinicionModelosListener().addObservador(this);
	}
	
	private File selectFile() {
		File file = null;
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setDialogTitle(literales.getLiteral("panelPrincipal.tituloChooser"));
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		//
		// disable the "All files" option.
		//
		chooser.setAcceptAllFileFilterUsed(false);
		//
		if (chooser.showOpenDialog(panelPrincipal.getFrameParent()) == JFileChooser.APPROVE_OPTION) {
			LogWrapper.debug(log, "Archivo seleccionado: %s", chooser.getSelectedFile());
			file = chooser.getSelectedFile();
		}

		return file;
	}
	
	/**
	 * @param file
	 * @param txtScript
	 */
	private List<String> dumpContentToText(File file, JTextArea txtScript) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			List<String> lines = new ArrayList<>();
			
			String line = reader.readLine();
			
			String lineToAdd = AppHelper.secureFullTrim(line);
			if (StringUtils.isNotBlank(lineToAdd)) {
				lines.add(lineToAdd);
			}
			
			while (line != null) {
				txtScript.append(line);
				txtScript.append("\n");
				line = reader.readLine();
				
				lineToAdd = AppHelper.secureFullTrim(line);
				if (StringUtils.isNotBlank(lineToAdd)) {
					lines.add(lineToAdd);
				}
			}
			
			return lines;
		} 
		
	}
	
	/**
	 * @param validaScriptRequest
	 * @return
	 * @throws Exception
	 */
	private ValidaScriptResponse validarScript(ValidaScriptRequest validaScriptRequest) throws Exception {
		ValidacionService validacionService = (ValidacionService) getService(Constants.VALIDACION_SERVICE);
		return validacionService.validaScript(validaScriptRequest);
	}

	@Override
	public void update(Observable o, Object arg) {
		String cmd = (String) arg;
		try {
			if (Constants.FRM_DEFINICION_MODELOS_BTN_SELECCIONAR.equals(cmd)) {
				ModeloService modeloService = (ModeloService) getService(Constants.MODELO_SERVICE);
				NormaService normaService = (NormaService) getService(Constants.NORMA_SERVICE);
				Modelo seleccionado = frmDefinicionModelos.getSeleccionado();
				
				if (!Objects.isNull(seleccionado)) {
					seleccionado = modeloService.consultaModelo(seleccionado.getCodigoProyecto());
					Norma norma = normaService.consultaNorma(seleccionado.getCodigoNorma()); 
					panelPrincipal.getTxtModeloProyecto().setText(seleccionado.getCodigoProyecto());
					panelPrincipal.getTxtCodNorma().setText(norma.getCodigoNorma().toString());
					panelPrincipal.getTxtDescNorma().setText(norma.getDescripcionNorma());
					panelPrincipal.getTxtCodGlosario().setText(seleccionado.getCodigoGlosario().toString());
					panelPrincipal.getTxtDescGlosario().setText(seleccionado.getDescripcionGlosario());
					
					List<SubProyecto> subProyectos = seleccionado.getSubProyectos();
					
					if (CollectionUtils.isNotEmpty(subProyectos)) {
						SubProyectoComboBoxModel modelSubProyectos = new SubProyectoComboBoxModel(subProyectos);
						panelPrincipal.getCmbSubmodelo().setModel(modelSubProyectos);
						
						if (subProyectos.size() == 1) {
							panelPrincipal.getCmbSubmodelo().setSelectedItem(subProyectos.get(0));
						}
					}
	 			}
			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(panelPrincipal.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}
}
