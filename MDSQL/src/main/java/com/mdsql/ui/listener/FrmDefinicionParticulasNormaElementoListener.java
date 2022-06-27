package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Observer;

import javax.swing.JButton;

import org.apache.commons.lang3.StringUtils;

import com.mdsql.bussiness.entities.Norma;
import com.mdsql.bussiness.entities.ParticulaNorma;
import com.mdsql.bussiness.entities.TipoElemento;
import com.mdsql.bussiness.service.NormaService;
import com.mdsql.bussiness.service.ParticulaNormaService;
import com.mdsql.bussiness.service.TipoElementoService;
import com.mdsql.ui.model.DefinicionParticulasNormaTableModel;
import com.mdsql.ui.model.NormaComboBoxModel;
import com.mdsql.ui.model.TipoElementoComboBoxModel;
import com.mdsql.ui.normasnomenclatura.FrmDefinicionParticulasNormaElemento;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.OnLoadListener;
import com.mdsql.utils.Constants;

/**
 * @author federico
 *
 */
public class FrmDefinicionParticulasNormaElementoListener extends ListenerSupport implements ActionListener, OnLoadListener {

	private FrmDefinicionParticulasNormaElemento frmDefinicionParticulasNormaElemento;

	public FrmDefinicionParticulasNormaElementoListener(FrmDefinicionParticulasNormaElemento frmDefinicionParticulasNormaElemento) {
		super();
		this.frmDefinicionParticulasNormaElemento = frmDefinicionParticulasNormaElemento;
	}
	
	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.FRM_DEFINICION_PARTICULAS_NORMA_BTN_BUSCAR.equals(jButton.getActionCommand())) {
			eventBtnBuscar();
		}
	}

	/**
	 * 
	 */
	private void eventBtnBuscar() {
		try {
			TipoElemento elemento = (TipoElemento) frmDefinicionParticulasNormaElemento.getCmbElemento().getSelectedItem();
			Norma norma = (Norma) frmDefinicionParticulasNormaElemento.getCmbNorma().getSelectedItem();
			List<ParticulaNorma> particulas = buscar(elemento, norma);
			populateModel(particulas);
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(frmDefinicionParticulasNormaElemento, Constants.CMD_ERROR, params);
		}
	}
	
	/**
	 * @param elemento
	 * @param norma
	 * @return
	 */
	private List<ParticulaNorma> buscar(TipoElemento elemento, Norma norma) {
		ParticulaNormaService particulaNormaService = (ParticulaNormaService) getService(Constants.PARTICULA_NORMA_SERVICE);
		
		BigDecimal codigoNorma = !Objects.isNull(norma) ? norma.getCodigoNorma() : null;
		BigDecimal codigoElemento = !Objects.isNull(elemento) ? elemento.getCodigoElemento() : null;
		
		List<ParticulaNorma> particulas = particulaNormaService.consultarDefinicionParticulaNormaElemento(codigoNorma, codigoElemento);
		return particulas;
	}

	/**
	 * Vuelca la lista de glosarios encontrados en la tabla
	 * 
	 * @return
	 */
	private void populateModel(List<ParticulaNorma> particulas) {
		// Obtiene el modelo y lo actualiza
		DefinicionParticulasNormaTableModel tableModel = (DefinicionParticulasNormaTableModel) frmDefinicionParticulasNormaElemento
				.getTblParticulas().getModel();
		tableModel.setData(particulas);
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
		frmDefinicionParticulasNormaElemento.getCmbNorma().setModel(modelNormas);
		
		TipoElementoComboBoxModel modelElementos = new TipoElementoComboBoxModel(elementos);
		frmDefinicionParticulasNormaElemento.getCmbElemento().setModel(modelElementos);
	}
}
