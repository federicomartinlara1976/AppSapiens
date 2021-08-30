package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import com.mdval.bussiness.entities.Norma;
import com.mdval.bussiness.service.NormaService;
import com.mdval.ui.model.DefinicionNormasTableModel;
import com.mdval.ui.normasnomenclatura.FrmDefinicionNormas;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.Constants;

public class FrmDefinicionNormasListener extends ListenerSupport implements ActionListener, Observer {

	private FrmDefinicionNormas frmDefinicionNormas;

	public FrmDefinicionNormasListener(FrmDefinicionNormas frmDefinicionNormas) {
		super();
		this.frmDefinicionNormas = frmDefinicionNormas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.FRM_DEFINICION_NORMAS_BTN_BUSCAR.equals(jButton.getActionCommand())) {
			eventBtnBuscar();
		}

		if (Constants.FRM_DEFINICION_NORMAS_BTN_ALTA.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}

		if (Constants.FRM_DEFINICION_NORMAS_BTN_MODIFICACION.equals(jButton.getActionCommand())) {
			evntBtnModificacion();
		}
	}

	/**
	 * 
	 */
	private void eventBtnBuscar() {
		String cadenaBuscar = frmDefinicionNormas.getTxtNorma().getText();
		List<Norma> normas = buscar(cadenaBuscar);
		populateModel(normas);
	}

	/**
	 * 
	 */
	private void eventBtnAlta() {
		showPopup(frmDefinicionNormas, Constants.CMD_ALTA_NORMAS);
	}

	/**
	 * 
	 */
	private void evntBtnModificacion() {
		Map<String, Object> params = new HashMap<>();
		params.put(Constants.FRM_DEFINICION_NORMAS_SELECCIONADA, frmDefinicionNormas.getSeleccionada());
		
		showPopup(frmDefinicionNormas, Constants.CMD_MODIFICACION_NORMAS);
	}
	
	/**
	 * Busca glosarios por descripcion glosario
	 * 
	 * @param termino descripcion glosario a buscar
	 * @return lista de glosarios que cumple con el termino buscado
	 */
	private List<Norma> buscar(String termino) {
		NormaService normaService = (NormaService) getService(Constants.NORMA_SERVICE);
		List<Norma> normas = normaService.consultaNormas(termino);
		return normas;
	}
	
	/**
	 * Vuelca la lista de glosarios encontrados en la tabla
	 * 
	 * @return
	 */
	private void populateModel(List<Norma> normas) {
		// Obtiene el modelo y lo actualiza
		DefinicionNormasTableModel tableModel = (DefinicionNormasTableModel) frmDefinicionNormas
				.getTblNormas().getModel();
		tableModel.setData(normas);
		
		// Como se ha regenerado el contenido de la tabla y se ha perdido la selección,
		// deshabilitar el botón de selección para la próxima.
		frmDefinicionNormas.getBtnModificacion().setEnabled(Boolean.FALSE);
	}
	
	/**
	 *
	 */
	@Override
	public void update(Observable o, Object arg) {
		eventBtnBuscar();
	}
}
