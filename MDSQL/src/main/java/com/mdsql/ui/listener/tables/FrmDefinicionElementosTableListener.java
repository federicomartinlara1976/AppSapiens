package com.mdsql.ui.listener.tables;

import java.util.Objects;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdsql.bussiness.entities.TipoElemento;
import com.mdsql.ui.model.DefinicionTipoElementoTableModel;
import com.mdsql.ui.normasnomenclatura.FrmDefinicionElementos;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FrmDefinicionElementosTableListener extends ListenerSupport implements ListSelectionListener {

	private FrmDefinicionElementos frmDefinicionElementos;

	public FrmDefinicionElementosTableListener(FrmDefinicionElementos frmDefinicionElementos) {
		super();
		this.frmDefinicionElementos = frmDefinicionElementos;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
	        return;
		
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		Integer index = lsm.getMinSelectionIndex();
		
		DefinicionTipoElementoTableModel tableModel = (DefinicionTipoElementoTableModel) frmDefinicionElementos.getTblElementos().getModel();
		
		TipoElemento seleccionado = tableModel.getSelectedRow(index);
		if (!Objects.isNull(seleccionado)) {
			LogWrapper.debug(log, "Selected: %s", seleccionado.toString());
			frmDefinicionElementos.setSeleccionado(seleccionado);
			frmDefinicionElementos.getBtnModificacion().setEnabled(Boolean.TRUE);
		}
	}
}
