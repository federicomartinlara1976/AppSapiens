package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import com.mdval.bussiness.entities.TipoParticula;
import com.mdval.bussiness.service.TipoParticulaService;
import com.mdval.ui.model.DefinicionTiposParticulaTableModel;
import com.mdval.ui.normasnomenclatura.FrmDefinicionTiposParticula;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.Constants;

public class FrmDefinicionTiposParticulaListener extends ListenerSupport implements ActionListener, Observer {

	private FrmDefinicionTiposParticula frmDefinicionTiposParticula;

	public FrmDefinicionTiposParticulaListener(FrmDefinicionTiposParticula frmDefinicionTiposParticula) {
		super();
		this.frmDefinicionTiposParticula = frmDefinicionTiposParticula;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.FRM_DEFINICION_TIPOS_PARTICULA_BTN_BUSCAR.equals(jButton.getActionCommand())) {
			eventBtnBuscar();
		}

		if (Constants.FRM_DEFINICION_TIPOS_PARTICULA_BTN_ALTA.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}

		if (Constants.FRM_DEFINICION_TIPOS_PARTICULA_BTN_MODIFICACION.equals(jButton.getActionCommand())) {
			evntBtnModificacion();
		}
	}

	/**
	 * 
	 */
	private void eventBtnBuscar() {
		try {
			String cadenaBuscar = frmDefinicionTiposParticula.getTxtTipoParticula().getText();
			List<TipoParticula> tiposParticula = buscar(cadenaBuscar);
			populateModel(tiposParticula);
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(frmDefinicionTiposParticula, Constants.CMD_ERROR, params);
		}
	}

	/**
	 * 
	 */
	private void eventBtnAlta() {
		showPopup(frmDefinicionTiposParticula, Constants.CMD_ALTA_TIPOS_PARTICULA);
	}

	/**
	 * 
	 */
	private void evntBtnModificacion() {
		Map<String, Object> params = new HashMap<>();
		params.put(Constants.FRM_DEFINICION_TIPOS_PARTICULA_SELECCIONADO,
				frmDefinicionTiposParticula.getSeleccionado());

		showPopup(frmDefinicionTiposParticula, Constants.CMD_MODIFICACION_TIPOS_PARTICULA, params);
	}

	/**
	 * Busca tipos de partícula por descripción
	 * 
	 * @param termino descripcion tipo a buscar
	 * @return lista de tipos que cumple con el termino buscado
	 */
	private List<TipoParticula> buscar(String termino) {
		TipoParticulaService tipoParticulaService = (TipoParticulaService) getService(Constants.TIPO_PARTICULA_SERVICE);
		List<TipoParticula> tipos = tipoParticulaService.consultarDefinicionTiposParticula(termino);
		return tipos;
	}

	/**
	 * Vuelca la lista de tipos encontrados en la tabla
	 * 
	 * @return
	 */
	private void populateModel(List<TipoParticula> tipos) {
		// Obtiene el modelo y lo actualiza
		DefinicionTiposParticulaTableModel tableModel = (DefinicionTiposParticulaTableModel) frmDefinicionTiposParticula
				.getTblTiposParticula().getModel();
		tableModel.setData(tipos);

		// Como se ha regenerado el contenido de la tabla y se ha perdido la selección,
		// deshabilitar el botón de selección para la próxima.
		frmDefinicionTiposParticula.getBtnModificacion().setEnabled(Boolean.FALSE);
	}

	/**
	 *
	 */
	@Override
	public void update(Observable o, Object arg) {
		eventBtnBuscar();
	}
}
