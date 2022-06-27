package com.mdsql.ui.listener.tables;

import java.util.Objects;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdsql.bussiness.entities.Glosario;
import com.mdsql.ui.glosarios.FrmDefinicionGlosarios;
import com.mdsql.ui.model.DefinicionGlosariosTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		if (!Objects.isNull(seleccionado)) {
			LogWrapper.debug(log, "Selected: %s", seleccionado.toString());
			frmDefinicionGlosarios.setSeleccionado(seleccionado);
			frmDefinicionGlosarios.getBtnModificacion().setEnabled(Boolean.TRUE);
			frmDefinicionGlosarios.getBtnSeleccionar().setEnabled(Boolean.TRUE);
		}
	}

	
}
