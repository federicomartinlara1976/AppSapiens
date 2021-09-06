package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.entities.TipoParticula;
import com.mdval.bussiness.service.TipoParticulaService;
import com.mdval.ui.model.DefinicionTiposParticulaTableModel;
import com.mdval.ui.normasnomenclatura.FrmValoresParticulas;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.utils.AppHelper;
import com.mdval.utils.Constants;

/**
 * @author federico
 *
 */
public class FrmValoresParticulasListener extends ListenerSupport implements ActionListener {

	private FrmValoresParticulas frmValoresParticulas;

	public FrmValoresParticulasListener(FrmValoresParticulas frmValoresParticulas) {
		super();
		this.frmValoresParticulas = frmValoresParticulas;
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.FRM_VALORES_PARTICULAS_BTN_BUSCAR.equals(jButton.getActionCommand())) {
			eventBtnBuscar();
		}
		
		if (Constants.FRM_VALORES_PARTICULAS_BTN_ALTA.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}
		
		if (Constants.FRM_VALORES_PARTICULAS_BTN_MODIFICACION.equals(jButton.getActionCommand())) {
			eventBtnModificacion();
		}
	}
	
	/**
	 * 
	 */
	private void eventBtnBuscar() {
		try {
			String sCodigoParticula = frmValoresParticulas.getTxtCodigo().getText();
			String descripcionParticula = frmValoresParticulas.getTxtDescripcion().getText();
			String mcaProyecto = AppHelper.normalizeCmbSiNoValue((String) frmValoresParticulas.getCmbProyecto().getSelectedItem());
			String mcaSubproyecto = AppHelper.normalizeCmbSiNoValue((String) frmValoresParticulas.getCmbSubproyecto().getSelectedItem());
			
			List<TipoParticula> tiposParticula = buscar(sCodigoParticula, descripcionParticula, mcaProyecto, mcaSubproyecto);
			populateModel(tiposParticula);
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(frmValoresParticulas, Constants.CMD_ERROR, params);
		}
	}

	/**
	 * 
	 */
	private void eventBtnAlta() {
		showFrame(Constants.CMD_ALTA_VALORES_PARTICULAS);
	}
	
	/**
	 * 
	 */
	private void eventBtnModificacion() {
		showFrame(Constants.CMD_MODIFICACION_VALORES_PARTICULAS);
	}
	
	/**
	 * Busca tipos de partícula
	 * 
	 * @param termino descripcion tipo a buscar
	 * @return lista de tipos que cumple con el termino buscado
	 */
	private List<TipoParticula> buscar(String sCodigo, String sDescripcion, String mcaProyecto, String mcaSubproyecto) {
		TipoParticulaService tipoParticulaService = (TipoParticulaService) getService(Constants.TIPO_PARTICULA_SERVICE);
		
		
		BigDecimal codigo = null;
		if (StringUtils.isNotBlank(sCodigo)) {
			Long lCodigo = Long.parseLong(sCodigo);
			codigo = new BigDecimal(lCodigo);
		}
	
		List<TipoParticula> tipos = tipoParticulaService.consultarTiposParticula(codigo, sDescripcion, mcaProyecto, mcaSubproyecto);
		return tipos;
	}

	/**
	 * Vuelca la lista de tipos encontrados en la tabla
	 * 
	 * @return
	 */
	private void populateModel(List<TipoParticula> tipos) {
		// Obtiene el modelo y lo actualiza
		DefinicionTiposParticulaTableModel tableModel = (DefinicionTiposParticulaTableModel) frmValoresParticulas
				.getTblTiposParticula().getModel();
		tableModel.setData(tipos);

		// Como se ha regenerado el contenido de la tabla y se ha perdido la selección,
		// deshabilitar el botón de selección para la próxima.
		frmValoresParticulas.getBtnModificacionElemento().setEnabled(Boolean.FALSE);
	}
}
