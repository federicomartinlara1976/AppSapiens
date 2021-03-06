package com.mdval.ui.listener.tables;

import java.util.Objects;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdval.bussiness.entities.ElementoNorma;
import com.mdval.ui.model.AltaModificacionNormasElementoNormaTableModel;
import com.mdval.ui.normasnomenclatura.DlgModificacionNormas;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.observer.Observer;
import com.mdval.utils.MDValConstants;
import com.mdval.utils.LogWrapper;

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
			updateObservers(MDValConstants.DLG_MODIFICACION_NORMAS_ELEMENTO_SELECCIONADO);
		}
	}
}
