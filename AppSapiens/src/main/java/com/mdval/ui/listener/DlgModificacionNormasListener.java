package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.mdval.bussiness.entities.ElementoNorma;
import com.mdval.bussiness.entities.Norma;
import com.mdval.bussiness.entities.ParticulaNorma;
import com.mdval.bussiness.service.ElementoNormaService;
import com.mdval.bussiness.service.NormaService;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.model.AltaModificacionNormasElementoNormaTableModel;
import com.mdval.ui.normasnomenclatura.DlgModificacionNormas;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.utils.Constants;
import com.mdval.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

/**
 * @author federico
 *
 */
@Log4j
public class DlgModificacionNormasListener extends ListenerSupport implements ActionListener, OnLoadListener, Observer {

	private DlgModificacionNormas dlgModificacionNormas;

	public DlgModificacionNormasListener(DlgModificacionNormas dlgModificacionNormas) {
		super();
		this.dlgModificacionNormas = dlgModificacionNormas;
	}

	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@SneakyThrows
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_MODIFICACION_NORMAS_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			dlgModificacionNormas.dispose();
		}

		if (Constants.DLG_MODIFICACION_NORMAS_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgModificacionNormas.dispose();
		}
	}

	@Override
	public void onLoad() {
		try {
			Norma normaSeleccionada = dlgModificacionNormas.getNormaSeleccionada();
			
			Norma norma = cargarNorma(normaSeleccionada.getCodigoNorma());
			List<ElementoNorma> elementosNorma = cargarElementosNorma(normaSeleccionada.getCodigoNorma());
			
			dlgModificacionNormas.getTxtCodigo().setText(norma.getCodigoNorma().toString());
			dlgModificacionNormas.getTxtDescripcion().setText(norma.getDescripcionNorma());
			dlgModificacionNormas.getTxtUsuario().setText(norma.getCodigoUsuario());
			dlgModificacionNormas.getTxtFecha().setText(dateFormatter.dateToString(norma.getFechaActualizacion()));
			
			populateModelElementos(elementosNorma);
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup((JFrame) dlgModificacionNormas.getParent(), Constants.CMD_ERROR, params);
		}
	}

	/**
	 * @param codigoNorma
	 * @return
	 */
	private Norma cargarNorma(BigDecimal codigoNorma) throws ServiceException {
		NormaService normaService = (NormaService) getService(Constants.NORMA_SERVICE);
		return normaService.consultaNorma(codigoNorma);
	}
	
	/**
	 * @param codigoNorma
	 * @return
	 */
	private List<ElementoNorma> cargarElementosNorma(BigDecimal codigoNorma) {
		ElementoNormaService elementoNormaService = (ElementoNormaService) getService(Constants.ELEMENTO_NORMA_SERVICE);
		return elementoNormaService.consultarElementosNorma(codigoNorma);
	}
	
	/**
	 * @param codigoNorma
	 * @return
	 */
	private List<ParticulaNorma> cargarParticulasElemento(BigDecimal codigoElemento) {
		return Collections.emptyList();
	}
	
	/**
	 * Vuelca la lista de elementos encontrados en la tabla
	 * 
	 * @return
	 */
	private void populateModelElementos(List<ElementoNorma> elementos) {
		// Obtiene el modelo y lo actualiza
		AltaModificacionNormasElementoNormaTableModel tableModel = (AltaModificacionNormasElementoNormaTableModel) dlgModificacionNormas
				.getTblElementos().getModel();
		tableModel.setData(elementos);
	}
	
	/**
	 * Vuelca la lista de partículas encontradas para un elemento
	 * 
	 * @return
	 */
	private void populateModelParticulas(List<ParticulaNorma> particulas) {
		
	}

	/**
	 *
	 */
	@Override
	public void update(Observable o, Object arg) {
		String cmd = (String) arg;
		
		if (Constants.DLG_MODIFICACION_NORMAS_ELEMENTO_SELECCIONADO.equals(cmd)) {
			// Cargar la tabla de partículas
			LogWrapper.debug(log, "Seleccionado: %s", dlgModificacionNormas.getElementoSeleccionado().toString());
			List<ParticulaNorma> particulas = cargarParticulasElemento(dlgModificacionNormas.getElementoSeleccionado().getCodigoElemento());
			populateModelParticulas(particulas);
		}
		
	}
}
