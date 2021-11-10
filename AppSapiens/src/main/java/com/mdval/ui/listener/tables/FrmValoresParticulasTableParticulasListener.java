package com.mdval.ui.listener.tables;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdval.bussiness.entities.TipoParticula;
import com.mdval.bussiness.entities.ValorParticula;
import com.mdval.bussiness.service.ValorParticulaService;
import com.mdval.ui.model.DefinicionTiposParticulaTableModel;
import com.mdval.ui.model.ValoresParticulaTableModel;
import com.mdval.ui.normasnomenclatura.FrmValoresParticulas;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.Constants;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FrmValoresParticulasTableParticulasListener extends ListenerSupport implements ListSelectionListener {

	private FrmValoresParticulas frmValoresParticulas;

	public FrmValoresParticulasTableParticulasListener(FrmValoresParticulas frmValoresParticulas) {
		super();
		this.frmValoresParticulas = frmValoresParticulas;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
	        return;
		
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		Integer index = lsm.getMinSelectionIndex();
		
		DefinicionTiposParticulaTableModel tableModel = (DefinicionTiposParticulaTableModel) frmValoresParticulas.getTblTiposParticula().getModel();
		
		TipoParticula seleccionado = tableModel.getSelectedRow(index);
		if (!Objects.isNull(seleccionado)) {
			LogWrapper.debug(log, "Selected: %s", seleccionado.toString());
			frmValoresParticulas.setSeleccionada(seleccionado);
			cargarValores(seleccionado.getCodigoParticula());
			
			frmValoresParticulas.getBtnModificacionElemento().setEnabled(Boolean.TRUE);
		}
	}

	/**
	 * 
	 */
	private void cargarValores(BigDecimal codigoParticula) {
		try {
			List<ValorParticula> valores = cargarValoresParticulas(codigoParticula);
			populateModel(valores);
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(frmValoresParticulas, Constants.CMD_ERROR, params);
		}
	}
	
	/**
	 * @param codigoParticula
	 * @return
	 */
	private List<ValorParticula> cargarValoresParticulas(BigDecimal codigoParticula) {
		ValorParticulaService valorParticulaService = (ValorParticulaService) getService(Constants.VALOR_PARTICULA_SERVICE);
		List<ValorParticula> valores = valorParticulaService.consultarValoresParticula(codigoParticula);
		return valores;
	}

	/**
	 * Vuelca la lista de valores encontrados en la tabla
	 * 
	 * @return
	 */
	private void populateModel(List<ValorParticula> valores) {
		// Obtiene el modelo y lo actualiza
		ValoresParticulaTableModel tableModel = (ValoresParticulaTableModel) frmValoresParticulas
				.getTblValoresParticulas().getModel();
		tableModel.setData(valores);
	}
}
