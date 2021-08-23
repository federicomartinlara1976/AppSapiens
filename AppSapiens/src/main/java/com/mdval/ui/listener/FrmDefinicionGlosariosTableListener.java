package com.mdval.ui.listener;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdval.bussiness.entities.Glosario;
import com.mdval.ui.glosarios.FrmDefinicionGlosarios;
import com.mdval.ui.model.DefinicionGlosariosTableModel;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.LogWrapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class FrmDefinicionGlosariosTableListener extends ListenerSupport implements ListSelectionListener {

	private FrmDefinicionGlosarios frmDefinicionGlosarios;

	public FrmDefinicionGlosariosTableListener(FrmDefinicionGlosarios frmDefinicionGlosarios) {
		super();
		this.frmDefinicionGlosarios = frmDefinicionGlosarios;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
	        return;
		
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		Integer index = lsm.getMinSelectionIndex();
		
		DefinicionGlosariosTableModel tableModel = (DefinicionGlosariosTableModel) frmDefinicionGlosarios.getTblGlosarios().getModel();
		
		Glosario seleccionado = tableModel.getSelectedRow(index);
		LogWrapper.debug(log, "Selected: %s", seleccionado.toString());
		frmDefinicionGlosarios.setSeleccionado(seleccionado);
		frmDefinicionGlosarios.getBtnModificacion().setEnabled(Boolean.TRUE);
	}

	
}
