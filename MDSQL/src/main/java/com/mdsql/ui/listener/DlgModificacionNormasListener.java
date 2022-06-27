package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.ElementoNorma;
import com.mdsql.bussiness.entities.Norma;
import com.mdsql.bussiness.entities.ParticulaNorma;
import com.mdsql.bussiness.service.ElementoNormaService;
import com.mdsql.bussiness.service.NormaService;
import com.mdsql.bussiness.service.ParticulaNormaService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.ui.model.AltaModificacionNormasElementoNormaTableModel;
import com.mdsql.ui.model.AltaModificacionNormasParticulaNormaTableModel;
import com.mdsql.ui.normasnomenclatura.DlgModificacionNormas;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.OnLoadListener;
import com.mdsql.utils.Constants;

import lombok.SneakyThrows;

/**
 * @author federico
 *
 */
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
			Map<String, Object> params = dlgModificacionNormas.getParams();
			
			if (!Objects.isNull(params)) {
				Norma normaSeleccionada = (Norma) params.get(Constants.FRM_DEFINICION_NORMAS_SELECCIONADA);
				dlgModificacionNormas.setNormaSeleccionada(normaSeleccionada);

				Norma norma = cargarNorma(normaSeleccionada.getCodigoNorma());
				List<ElementoNorma> elementosNorma = cargarElementosNorma(normaSeleccionada.getCodigoNorma());

				dlgModificacionNormas.getTxtCodigo().setText(norma.getCodigoNorma().toString());
				dlgModificacionNormas.getTxtDescripcion().setText(norma.getDescripcionNorma());
				dlgModificacionNormas.getTxtUsuario().setText(norma.getCodigoUsuario());
				dlgModificacionNormas.getTxtFecha().setText(dateFormatter.dateToString(norma.getFechaActualizacion()));

				populateModelElementos(elementosNorma);
			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(dlgModificacionNormas.getFrameParent(), Constants.CMD_ERROR, params);
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
	private List<ParticulaNorma> cargarParticulasElemento(BigDecimal codigoNorma, BigDecimal codigoElemento) {
		ParticulaNormaService particulaNormaService = (ParticulaNormaService) getService(
				Constants.PARTICULA_NORMA_SERVICE);
		return particulaNormaService.consultarParticulasElemento(codigoNorma, codigoElemento);
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
		// Obtiene el modelo y lo actualiza
		AltaModificacionNormasParticulaNormaTableModel tableModel = (AltaModificacionNormasParticulaNormaTableModel) dlgModificacionNormas
				.getTblParticulas().getModel();
		tableModel.setData(particulas);
	}

	/**
	 *
	 */
	@Override
	public void update(Observable o, Object arg) {
		String cmd = (String) arg;

		if (Constants.DLG_MODIFICACION_NORMAS_ELEMENTO_SELECCIONADO.equals(cmd)) {
			// Cargar la tabla de partículas
			Norma normaSeleccionada = dlgModificacionNormas.getNormaSeleccionada();
			ElementoNorma elementoSeleccionado = dlgModificacionNormas.getElementoSeleccionado();
			List<ParticulaNorma> particulas = cargarParticulasElemento(normaSeleccionada.getCodigoNorma(),
					elementoSeleccionado.getCodigoElemento());
			populateModelParticulas(particulas);
		}

	}
}
