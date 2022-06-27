package com.mdsql.ui.listener.tables;

import java.util.Objects;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdsql.bussiness.entities.TipoParticula;
import com.mdsql.ui.model.DefinicionTiposParticulaTableModel;
import com.mdsql.ui.normasnomenclatura.FrmDefinicionTiposParticula;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
