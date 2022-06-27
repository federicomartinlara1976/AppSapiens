package com.mdsql.ui.listener.tables;

import java.util.Objects;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdsql.bussiness.entities.CampoGlosario;
import com.mdsql.ui.glosarios.FrmGlosarioCampos;
import com.mdsql.ui.model.DefinicionCamposGlosarioTableCamposModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FrmGlosarioCamposTableListener extends ListenerSupport implements ListSelectionListener {

	private FrmGlosarioCampos frmGlosarioCampos;

	public FrmGlosarioCamposTableListener(FrmGlosarioCampos frmGlosarioCampos) {
		super();
		this.frmGlosarioCampos = frmGlosarioCampos;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
	        return;
		
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		Integer index = lsm.getMinSelectionIndex();
		
		DefinicionCamposGlosarioTableCamposModel tableModel = (DefinicionCamposGlosarioTableCamposModel) frmGlosarioCampos.getTblCampos().getModel();
		
		CampoGlosario seleccionado = tableModel.getSelectedRow(index);
		if (!Objects.isNull(seleccionado)) {
			LogWrapper.debug(log, "Selected: %s", seleccionado.toString());
			frmGlosarioCampos.setCampoSeleccionado(seleccionado);
			frmGlosarioCampos.getBtnModificacion().setEnabled(Boolean.TRUE);
			frmGlosarioCampos.getBtnBaja().setEnabled(Boolean.TRUE);
		}
	}

	
}
