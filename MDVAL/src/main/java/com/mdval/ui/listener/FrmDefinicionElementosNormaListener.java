package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.JButton;

import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.entities.ElementoNorma;
import com.mdval.bussiness.entities.Norma;
import com.mdval.bussiness.entities.TipoElemento;
import com.mdval.bussiness.service.ElementoNormaService;
import com.mdval.bussiness.service.NormaService;
import com.mdval.bussiness.service.TipoElementoService;
import com.mdval.ui.model.DefinicionElementosNormaTableModel;
import com.mdval.ui.model.NormaComboBoxModel;
import com.mdval.ui.model.TipoElementoComboBoxModel;
import com.mdval.ui.normasnomenclatura.FrmDefinicionElementosNorma;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.ui.utils.observer.Observer;
import com.mdval.utils.Constants;

/**
 * @author federico
 *
 */
public class FrmDefinicionElementosNormaListener extends ListenerSupport implements ActionListener, OnLoadListener {

	private FrmDefinicionElementosNorma frmDefinicionElementosNorma;

	public FrmDefinicionElementosNormaListener(FrmDefinicionElementosNorma frmDefinicionElementosNorma) {
		super();
		this.frmDefinicionElementosNorma = frmDefinicionElementosNorma;
	}
	
	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.FRM_DEFINICION_ELEMENTOS_NORMA_BTN_BUSCAR.equals(jButton.getActionCommand())) {
			eventBtnBuscar();
		}
	}

	/**
	 * 
	 */
	private void eventBtnBuscar() {
		try {
			TipoElemento elemento = (TipoElemento) frmDefinicionElementosNorma.getCmbElemento().getSelectedItem();
			Norma norma = (Norma) frmDefinicionElementosNorma.getCmbNorma().getSelectedItem();
			List<ElementoNorma> elementos = buscar(elemento, norma);
			populateModel(elementos);
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(frmDefinicionElementosNorma, Constants.CMD_ERROR, params);
		}
	}
	
	/**
	 * @param elemento
	 * @param norma
	 * @return
	 */
	private List<ElementoNorma> buscar(TipoElemento elemento, Norma norma) {
		ElementoNormaService elementoNormaService = (ElementoNormaService) getService(Constants.ELEMENTO_NORMA_SERVICE);
		
		BigDecimal codigoNorma = !Objects.isNull(norma) ? norma.getCodigoNorma() : null;
		BigDecimal codigoElemento = !Objects.isNull(elemento) ? elemento.getCodigoElemento() : null;
		
		List<ElementoNorma> elementos = elementoNormaService.consultarDefinicionElementoNorma(codigoNorma, codigoElemento);
		return elementos;
	}

	/**
	 * Vuelca la lista de glosarios encontrados en la tabla
	 * 
	 * @return
	 */
	private void populateModel(List<ElementoNorma> elementos) {
		// Obtiene el modelo y lo actualiza
		DefinicionElementosNormaTableModel tableModel = (DefinicionElementosNormaTableModel) frmDefinicionElementosNorma
				.getTblElementos().getModel();
		tableModel.setData(elementos);
	}

	/**
	 *
	 */
	@Override
	public void onLoad() {
		NormaService normaService = (NormaService) getService(Constants.NORMA_SERVICE);
		TipoElementoService tipoElementoService = (TipoElementoService) getService(Constants.TIPO_ELEMENTO_SERVICE);
		
		List<Norma> normas = normaService.consultaNormas(StringUtils.EMPTY);
		List<TipoElemento> elementos = tipoElementoService.consultarTiposElementos(StringUtils.EMPTY);
		
		NormaComboBoxModel modelNormas = new NormaComboBoxModel(normas);
		frmDefinicionElementosNorma.getCmbNorma().setModel(modelNormas);
		
		TipoElementoComboBoxModel modelElementos = new TipoElementoComboBoxModel(elementos);
		frmDefinicionElementosNorma.getCmbElemento().setModel(modelElementos);
	}
}
