package com.mdval.ui.listener.tables;

import java.util.Objects;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdval.bussiness.entities.ValorParticula;
import com.mdval.ui.model.ValoresParticulaTableModel;
import com.mdval.ui.normasnomenclatura.FrmMantenimientoParticulas;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.LogWrapper;

import lombok.extern.log4j.Log4j;

@Log4j
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
