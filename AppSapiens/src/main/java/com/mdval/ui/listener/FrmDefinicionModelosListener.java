package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.entities.Modelo;
import com.mdval.bussiness.entities.Norma;
import com.mdval.bussiness.service.ModeloService;
import com.mdval.bussiness.service.NormaService;
import com.mdval.ui.model.DefinicionModelosTableModel;
import com.mdval.ui.model.NormaComboBoxModel;
import com.mdval.ui.modelos.FrmDefinicionModelos;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.AppGlobalSingleton;
import com.mdval.utils.Constants;

/**
 * @author federico
 *
 */
public class FrmDefinicionModelosListener extends ListenerSupport implements ActionListener, OnLoadListener {

	private FrmDefinicionModelos frmDefinicionModelos;

	public FrmDefinicionModelosListener(FrmDefinicionModelos frmDefinicionModelos) {
		super();
		this.frmDefinicionModelos = frmDefinicionModelos;
	}
	
	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.FRM_DEFINICION_MODELOS_BTN_BUSCAR.equals(jButton.getActionCommand())) {
			eventBtnBuscar();
		}

		if (Constants.FRM_DEFINICION_MODELOS_BTN_ALTA.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}

		if (Constants.FRM_DEFINICION_MODELOS_BTN_BAJA.equals(jButton.getActionCommand())) {
			eventBtnBaja();
		}

		if (Constants.FRM_DEFINICION_MODELOS_BTN_MODIFICACION.equals(jButton.getActionCommand())) {
			evntBtnModificacion();
		}
	}

	/**
	 * 
	 */
	private void eventBtnBuscar() {
		try {
			Norma norma = (Norma) frmDefinicionModelos.getCmbNorma().getSelectedItem();
			String baseDatos = frmDefinicionModelos.getTxtBaseDatos().getText();
			String codModelo = frmDefinicionModelos.getTxtCodModelo().getText();
			String esquema = frmDefinicionModelos.getTxtEsquema().getText();
			String glosario = frmDefinicionModelos.getTxtGlosario().getText();
			String nombreModelo = frmDefinicionModelos.getTxtNombreModelo().getText();

			List<Modelo> modelos = buscar(codModelo, nombreModelo, norma, glosario, esquema, baseDatos);
			populateModel(modelos);
			
			frmDefinicionModelos.getBtnModificacion().setEnabled(Boolean.FALSE);
			frmDefinicionModelos.getBtnBaja().setEnabled(Boolean.FALSE);
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(frmDefinicionModelos, Constants.CMD_ERROR, params);
		}
	}

	/**
	 * 
	 */
	private void eventBtnAlta() {
		showFrame(frmDefinicionModelos, Constants.CMD_ALTA_MODELOS);
	}

	/**
	 * 
	 */
	private void eventBtnBaja() {
		try {
			AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
			ModeloService modeloService = (ModeloService) getService(Constants.MODELO_SERVICE);
			
			String codUsuario = (String) appGlobalSingleton.getProperty(Constants.COD_USR);
			Modelo seleccionado = frmDefinicionModelos.getSeleccionado();
			
			String msg = StringUtils.EMPTY;

			Integer response = UIHelper.showConfirm(literales.getLiteral("confirmacion.mensaje"),
					literales.getLiteral("confirmacion.titulo"));

			if (response == JOptionPane.YES_OPTION) {
				// Se va a borrar un registro existente
				modeloService.bajaLogicaModelo(seleccionado.getCodigoProyecto(), codUsuario);

				msg = literales.getLiteral("mensaje.borrar");
				JOptionPane.showMessageDialog(frmDefinicionModelos.getParent(), msg);

				eventBtnBuscar();
			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup((JFrame) frmDefinicionModelos.getParent(), Constants.CMD_ERROR, params);
		}

	}

	/**
	 * 
	 */
	private void evntBtnModificacion() {
		Map<String, Object> params = new HashMap<>();
		params.put(Constants.FRM_MANTENIMIENTO_MODELOS_SELECCIONADO, frmDefinicionModelos.getSeleccionado());
		showPopup(frmDefinicionModelos, Constants.CMD_MODIFICACION_MODELOS, params);
	}

	/**
	 *
	 */
	@Override
	public void onLoad() {
		NormaService normaService = (NormaService) getService(Constants.NORMA_SERVICE);

		List<Norma> normas = normaService.consultaNormas(StringUtils.EMPTY);
		NormaComboBoxModel modelNormas = new NormaComboBoxModel(normas);

		frmDefinicionModelos.getCmbNorma().setModel(modelNormas);
	}

	/**
	 * @param codModelo
	 * @param nombreModelo
	 * @param norma
	 * @param glosario
	 * @param esquema
	 * @param baseDatos
	 * @return
	 */
	private List<Modelo> buscar(String codModelo, String nombreModelo, Norma norma, String glosario, String esquema,
			String baseDatos) {
		
		Boolean fromMenu = Boolean.TRUE;
		BigDecimal codigoNorma = !Objects.isNull(norma) ? norma.getCodigoNorma() : null;
		BigDecimal codigoGlosario = null;
		if (StringUtils.isNotBlank(glosario)) {
			Long lCodigo = Long.parseLong(glosario);
			codigoGlosario = new BigDecimal(lCodigo);
		}

		ModeloService modeloService = (ModeloService) getService(Constants.MODELO_SERVICE);
		
		Map<String, Object> params = frmDefinicionModelos.getParams();
		
		if (!Objects.isNull(params)) {
			fromMenu = (Boolean) params.get("fromMenu");
		}
		
		String mcaInh = (fromMenu) ? Constants.S : Constants.N;
		
		return modeloService.consultaModelos(codModelo, nombreModelo, codigoNorma, codigoGlosario, esquema, baseDatos,
				mcaInh);
	}

	/**
	 * @param modelos
	 */
	private void populateModel(List<Modelo> modelos) {
		// Obtiene el modelo y lo actualiza
		DefinicionModelosTableModel tableModel = (DefinicionModelosTableModel) frmDefinicionModelos
				.getTblModelos().getModel();
		tableModel.setData(modelos);
	}
}
