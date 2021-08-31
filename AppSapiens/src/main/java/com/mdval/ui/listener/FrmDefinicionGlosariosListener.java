package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import com.mdval.bussiness.entities.Glosario;
import com.mdval.bussiness.service.GlosarioService;
import com.mdval.ui.glosarios.FrmDefinicionGlosarios;
import com.mdval.ui.model.DefinicionGlosariosTableModel;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.Constants;

public class FrmDefinicionGlosariosListener extends ListenerSupport implements ActionListener, Observer {

	private FrmDefinicionGlosarios frmDefinicionGlosarios;

	public FrmDefinicionGlosariosListener(FrmDefinicionGlosarios frmDefinicionGlosarios) {
		super();
		this.frmDefinicionGlosarios = frmDefinicionGlosarios;
	}
	
	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.FRM_DEFINICION_GLOSARIOS_BTN_BUSCAR.equals(jButton.getActionCommand())) {
			eventBtnBuscar();
		}

		if (Constants.FRM_DEFINICION_GLOSARIOS_BTN_ALTA.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}

		if (Constants.FRM_DEFINICION_GLOSARIOS_BTN_MODIFICACION.equals(jButton.getActionCommand())) {
			evntBtnModificacion();
		}

		if (Constants.FRM_DEFINICION_GLOSARIOS_BTN_SELECCIONAR.equals(jButton.getActionCommand())) {
			eventBtnSeleccionar();
		}
	}

	/**
	 * 
	 */
	private void eventBtnBuscar() {
		try {
			String cadenaBuscar = frmDefinicionGlosarios.getTxtGlosario().getText();
			List<Glosario> glosarios = buscar(cadenaBuscar);
			populateModel(glosarios);
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(frmDefinicionGlosarios, Constants.CMD_ERROR, params);
		}
	}

	private void eventBtnAlta() {
		showPopup(frmDefinicionGlosarios, Constants.CMD_ALTA_GLOSARIOS);
	}

	private void evntBtnModificacion() {
		Map<String, Object> params = new HashMap<>();
		params.put(Constants.FRM_DEFINICION_GLOSARIOS_SELECCIONADO, frmDefinicionGlosarios.getSeleccionado());

		showPopup(frmDefinicionGlosarios, Constants.CMD_MODIFICACION_GLOSARIOS, params);
	}

	/**
	 * 
	 */
	private void eventBtnSeleccionar() {
		updateObservers();
		frmDefinicionGlosarios.dispose();
	}
	
	/**
	 * Busca glosarios por descripcion glosario
	 * 
	 * @param termino descripcion glosario a buscar
	 * @return lista de glosarios que cumple con el termino buscado
	 */
	private List<Glosario> buscar(String termino) {
		GlosarioService glosarioService = (GlosarioService) getService(Constants.GLOSARIO_SERVICE);
		List<Glosario> glosarios = glosarioService.buscarGlosarios(termino);
		return glosarios;
	}

	/**
	 * Vuelca la lista de glosarios encontrados en la tabla
	 * 
	 * @return
	 */
	private void populateModel(List<Glosario> glosarios) {
		// Obtiene el modelo y lo actualiza
		DefinicionGlosariosTableModel tableModel = (DefinicionGlosariosTableModel) frmDefinicionGlosarios
				.getTblGlosarios().getModel();
		tableModel.setData(glosarios);
		
		// Como se ha regenerado el contenido de la tabla y se ha perdido la selección,
		// deshabilitar el botón de selección para la próxima.
		frmDefinicionGlosarios.getBtnModificacion().setEnabled(Boolean.FALSE);
		frmDefinicionGlosarios.getBtnSeleccionar().setEnabled(Boolean.FALSE);
	}

	/**
	 *
	 */
	@Override
	public void update(Observable o, Object arg) {
		eventBtnBuscar();
	}
}
