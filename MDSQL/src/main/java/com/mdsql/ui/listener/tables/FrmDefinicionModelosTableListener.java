package com.mdsql.ui.listener.tables;

import java.util.Objects;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.ui.model.DefinicionModelosTableModel;
import com.mdsql.ui.modelos.FrmDefinicionModelos;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.Constants;
import com.mdsql.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FrmDefinicionModelosTableListener extends ListenerSupport implements ListSelectionListener {

	private FrmDefinicionModelos frmDefinicionModelos;

	public FrmDefinicionModelosTableListener(FrmDefinicionModelos frmDefinicionModelos) {
		super();
		this.frmDefinicionModelos = frmDefinicionModelos;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
	        return;
		
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		Integer index = lsm.getMinSelectionIndex();
		
		DefinicionModelosTableModel tableModel = (DefinicionModelosTableModel) frmDefinicionModelos.getTblModelos().getModel();
		
		Modelo seleccionado = tableModel.getSelectedRow(index);
		if (!Objects.isNull(seleccionado)) {
			LogWrapper.debug(log, "Selected: %s", seleccionado.toString());
			frmDefinicionModelos.setSeleccionado(seleccionado);
			
			frmDefinicionModelos.getBtnModificacion().setEnabled(Boolean.TRUE);
			
			// Habilitar el botón de borrado si el registro seleccionado no está deshabilitado
			if (Constants.N.equals(seleccionado.getMcaInh())) {
				frmDefinicionModelos.getBtnBaja().setEnabled(Boolean.TRUE);
				frmDefinicionModelos.getBtnSeleccionar().setEnabled(Boolean.TRUE);
			}
		}
	}
}
