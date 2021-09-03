package com.mdval.ui.listener.tables;

import java.util.Objects;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdval.bussiness.entities.Norma;
import com.mdval.ui.model.DefinicionNormasTableModel;
import com.mdval.ui.normasnomenclatura.FrmDefinicionNormas;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.LogWrapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class FrmDefinicionNormasTableListener extends ListenerSupport implements ListSelectionListener {

	private FrmDefinicionNormas frmDefinicionNormas;

	public FrmDefinicionNormasTableListener(FrmDefinicionNormas frmDefinicionNormas) {
		super();
		this.frmDefinicionNormas = frmDefinicionNormas;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
	        return;
		
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		Integer index = lsm.getMinSelectionIndex();
		
		DefinicionNormasTableModel tableModel = (DefinicionNormasTableModel) frmDefinicionNormas.getTblNormas().getModel();
		
		Norma seleccionada = tableModel.getSelectedRow(index);
		if (!Objects.isNull(seleccionada)) {
			LogWrapper.debug(log, "Selected: %s", seleccionada.toString());
			frmDefinicionNormas.setSeleccionada(seleccionada);
			frmDefinicionNormas.getBtnModificacion().setEnabled(Boolean.TRUE);
		}
	}

	
}
