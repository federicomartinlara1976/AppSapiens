package com.mdsql.ui.listener.tables;

import java.util.Objects;
import java.util.Observer;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdsql.bussiness.entities.ElementoNorma;
import com.mdsql.ui.model.AltaModificacionNormasElementoNormaTableModel;
import com.mdsql.ui.normasnomenclatura.DlgModificacionNormas;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.Constants;
import com.mdsql.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DlgModificacionNormasElementoNormaTableListener extends ListenerSupport implements ListSelectionListener {

	private DlgModificacionNormas dlgModificacionNormas;

	public DlgModificacionNormasElementoNormaTableListener(DlgModificacionNormas dlgModificacionNormas) {
		super();
		this.dlgModificacionNormas = dlgModificacionNormas;
	}
	
	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
	        return;
		
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		Integer index = lsm.getMinSelectionIndex();
		
		AltaModificacionNormasElementoNormaTableModel tableModel = (AltaModificacionNormasElementoNormaTableModel) dlgModificacionNormas.getTblElementos().getModel();
		
		ElementoNorma seleccionado = tableModel.getSelectedRow(index);
		if (!Objects.isNull(seleccionado)) {
			LogWrapper.debug(log, "Selected: %s", seleccionado.toString());
			dlgModificacionNormas.setElementoSeleccionado(seleccionado);
			updateObservers(Constants.DLG_MODIFICACION_NORMAS_ELEMENTO_SELECCIONADO);
		}
	}
}
