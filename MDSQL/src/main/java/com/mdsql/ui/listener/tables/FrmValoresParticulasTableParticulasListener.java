package com.mdsql.ui.listener.tables;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdsql.bussiness.entities.TipoParticula;
import com.mdsql.bussiness.entities.ValorParticula;
import com.mdsql.bussiness.service.ValorParticulaService;
import com.mdsql.ui.model.DefinicionTiposParticulaTableModel;
import com.mdsql.ui.model.ValoresParticulaTableModel;
import com.mdsql.ui.normasnomenclatura.FrmValoresParticulas;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.Constants;
import com.mdsql.utils.LogWrapper;

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
