package com.mdval.ui.listener.tables;

import java.util.Objects;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdval.bussiness.entities.SubProyecto;
import com.mdval.ui.model.SubProyectoTableModel;
import com.mdval.ui.modelos.FrmMantenimientoModelos;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubProyectoTableListener extends ListenerSupport implements ListSelectionListener {

	private FrmMantenimientoModelos frmMantenimientoModelos;

	public SubProyectoTableListener(FrmMantenimientoModelos frmMantenimientoModelos) {
		super();
		this.frmMantenimientoModelos = frmMantenimientoModelos;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
	        return;
		
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		Integer index = lsm.getMinSelectionIndex();
		
		SubProyectoTableModel tableModel = (SubProyectoTableModel) frmMantenimientoModelos.getTblSubproyectos().getModel();
		
		SubProyecto seleccionado = tableModel.getSelectedRow(index);
		if (!Objects.isNull(seleccionado)) {
			LogWrapper.debug(log, "Selected: %s", seleccionado.toString());
			frmMantenimientoModelos.setSubProyectoSeleccionado(seleccionado);
			
			frmMantenimientoModelos.getTxtCodigoSubmodelo().setText(seleccionado.getCodigoSubProyecto());
			frmMantenimientoModelos.getTxtDescripcionSubmodelo().setText(seleccionado.getDescripcionSubProyecto());
			frmMantenimientoModelos.getBtnRemoveSubmodelo().setEnabled(Boolean.TRUE);
		}
	}
}
