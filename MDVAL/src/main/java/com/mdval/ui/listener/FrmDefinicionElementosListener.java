package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.entities.TipoElemento;
import com.mdval.bussiness.service.TipoElementoService;
import com.mdval.ui.model.DefinicionTipoElementoTableModel;
import com.mdval.ui.normasnomenclatura.FrmDefinicionElementos;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.ui.utils.observer.Observable;
import com.mdval.ui.utils.observer.Observer;
import com.mdval.utils.Constants;

public class FrmDefinicionElementosListener extends ListenerSupport implements ActionListener, OnLoadListener, Observer {

	private FrmDefinicionElementos frmDefinicionElementos;

	public FrmDefinicionElementosListener(FrmDefinicionElementos frmDefinicionElementos) {
		super();
		this.frmDefinicionElementos = frmDefinicionElementos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.FRM_DEFINICION_ELEMENTOS_BTN_BUSCAR.equals(jButton.getActionCommand())) {
			eventBtnBuscar();
		}

		if (Constants.FRM_DEFINICION_ELEMENTOS_BTN_ALTA.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}

		if (Constants.FRM_DEFINICION_ELEMENTOS_BTN_MODIFICACION.equals(jButton.getActionCommand())) {
			evntBtnModificacion();
		}
	}

	/**
	 * 
	 */
	private void eventBtnBuscar() {
		try {
			String cadenaBuscar = frmDefinicionElementos.getTxtDescripcionElemento().getText();
			List<TipoElemento> elementos = buscar(cadenaBuscar);
			populateModel(elementos);
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(frmDefinicionElementos, Constants.CMD_ERROR, params);
		}
	}

	/**
	 * 
	 */
	private void eventBtnAlta() {
		showPopup(frmDefinicionElementos, Constants.CMD_ALTA_ELEMENTOS);
	}

	/**
	 * 
	 */
	private void evntBtnModificacion() {
		Map<String, Object> params = new HashMap<>();
		params.put(Constants.FRM_DEFINICION_ELEMENTOS_SELECCIONADO, frmDefinicionElementos.getSeleccionado());
		
		showPopup(frmDefinicionElementos, Constants.CMD_MODIFICACION_ELEMENTOS, params);
	}
	
	/**
	 * Busca glosarios por descripcion glosario
	 * 
	 * @param termino descripcion glosario a buscar
	 * @return lista de glosarios que cumple con el termino buscado
	 */
	private List<TipoElemento> buscar(String termino) {
		TipoElementoService tipoElementoService = (TipoElementoService) getService(Constants.TIPO_ELEMENTO_SERVICE);
		List<TipoElemento> elementos = tipoElementoService.consultarTiposElementos(termino);
		return elementos;
	}

	/**
	 * Vuelca la lista de glosarios encontrados en la tabla
	 * 
	 * @return
	 */
	private void populateModel(List<TipoElemento> elementos) {
		// Obtiene el modelo y lo actualiza
		DefinicionTipoElementoTableModel tableModel = (DefinicionTipoElementoTableModel) frmDefinicionElementos
				.getTblElementos().getModel();
		tableModel.setData(elementos);
		
		// Como se ha regenerado el contenido de la tabla y se ha perdido la selección,
		// deshabilitar el botón de selección para la próxima.
		frmDefinicionElementos.getBtnModificacion().setEnabled(Boolean.FALSE);
	}
	
	/**
	 *
	 */
	@Override
	public void update(Observable o, Object arg) {
		eventBtnBuscar();
	}

	@Override
	public void onLoad() {
		try {
			List<TipoElemento> elementos = buscar(StringUtils.EMPTY);
			populateModel(elementos);
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(frmDefinicionElementos, Constants.CMD_ERROR, params);
		}
	}
}
