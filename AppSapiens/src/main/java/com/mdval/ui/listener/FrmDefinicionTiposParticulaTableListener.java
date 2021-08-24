package com.mdval.ui.listener;

import java.util.Objects;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdval.bussiness.entities.TipoParticula;
import com.mdval.ui.model.DefinicionTiposParticulaTableModel;
import com.mdval.ui.normasnomenclatura.FrmDefinicionTiposParticula;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.LogWrapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class FrmDefinicionTiposParticulaTableListener extends ListenerSupport implements ListSelectionListener {

	private FrmDefinicionTiposParticula frmDefinicionTiposParticula;

	public FrmDefinicionTiposParticulaTableListener(FrmDefinicionTiposParticula frmDefinicionTiposParticula) {
		super();
		this.frmDefinicionTiposParticula = frmDefinicionTiposParticula;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
	        return;
		
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		Integer index = lsm.getMinSelectionIndex();
		
		DefinicionTiposParticulaTableModel tableModel = (DefinicionTiposParticulaTableModel) frmDefinicionTiposParticula.getTblTiposParticula().getModel();
		
		TipoParticula seleccionado = tableModel.getSelectedRow(index);
		if (!Objects.isNull(seleccionado)) {
			LogWrapper.debug(log, "Selected: %s", seleccionado.toString());
			frmDefinicionTiposParticula.setSeleccionado(seleccionado);
			frmDefinicionTiposParticula.getBtnModificacion().setEnabled(Boolean.TRUE);
		}
	}

	
}
