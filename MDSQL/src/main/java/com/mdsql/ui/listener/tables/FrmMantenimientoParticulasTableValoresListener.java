package com.mdsql.ui.listener.tables;

import java.util.Objects;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdsql.bussiness.entities.ValorParticula;
import com.mdsql.ui.model.ValoresParticulaTableModel;
import com.mdsql.ui.normasnomenclatura.FrmMantenimientoParticulas;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FrmMantenimientoParticulasTableValoresListener extends ListenerSupport implements ListSelectionListener {

	private FrmMantenimientoParticulas frmMantenimientoParticulas;

	public FrmMantenimientoParticulasTableValoresListener(FrmMantenimientoParticulas frmMantenimientoParticulas) {
		super();
		this.frmMantenimientoParticulas = frmMantenimientoParticulas;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
	        return;
		
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		Integer index = lsm.getMinSelectionIndex();
		
		ValoresParticulaTableModel tableModel = (ValoresParticulaTableModel) frmMantenimientoParticulas.getTblValoresParticulas().getModel();
		
		ValorParticula seleccionado = tableModel.getSelectedRow(index);
		if (!Objects.isNull(seleccionado)) {
			LogWrapper.debug(log, "Selected: %s", seleccionado.toString());
			frmMantenimientoParticulas.setValorSeleccionado(seleccionado);
			
			frmMantenimientoParticulas.getBtnModificacionElemento().setEnabled(Boolean.TRUE);
		}
	}
}
