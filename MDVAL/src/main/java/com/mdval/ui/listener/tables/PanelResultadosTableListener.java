package com.mdval.ui.listener.tables;

import java.util.Objects;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdval.bussiness.entities.DetValidacion;
import com.mdval.ui.model.DetalleValidacionTableModel;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.validacionscripts.PanelResultados;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PanelResultadosTableListener extends ListenerSupport implements ListSelectionListener {

	private PanelResultados panelResultados;

	public PanelResultadosTableListener(PanelResultados panelResultados) {
		super();
		this.panelResultados = panelResultados;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
	        return;
		
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		Integer index = lsm.getMinSelectionIndex();
		
		DetalleValidacionTableModel tableModel = (DetalleValidacionTableModel) panelResultados.getTblResultados().getModel();
		
		DetValidacion seleccionado = tableModel.getSelectedRow(index);
		if (!Objects.isNull(seleccionado)) {
			LogWrapper.debug(log, "Selected: %s", seleccionado.toString());
			panelResultados.setSeleccionado(seleccionado);
			onSeleccionado();
		}
	}
}
