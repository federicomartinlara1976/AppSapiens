package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.mdsql.bussiness.entities.TipoParticula;
import com.mdsql.bussiness.service.TipoParticulaService;
import com.mdsql.ui.normasnomenclatura.DlgAltaModificacionTiposParticula;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.UIHelper;
import com.mdsql.utils.AppGlobalSingleton;
import com.mdsql.utils.AppHelper;
import com.mdsql.utils.Constants;

import lombok.SneakyThrows;

/**
 * @author federico
 *
 */
public class DlgAltaModificacionTiposParticulaListener extends ListenerSupport implements ActionListener {

	private DlgAltaModificacionTiposParticula dlgAltaModificacionTiposParticula;

	public DlgAltaModificacionTiposParticulaListener(DlgAltaModificacionTiposParticula dlgAltaModificacionTiposParticula) {
		super();
		this.dlgAltaModificacionTiposParticula = dlgAltaModificacionTiposParticula;
	}

	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@SneakyThrows
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_ALTA_MODIFICACION_TIPOS_PARTICULA_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAltaModificacion();
		}

		if (Constants.DLG_ALTA_MODIFICACION_TIPOS_PARTICULA_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgAltaModificacionTiposParticula.dispose();
		}
	}

	@SneakyThrows
	private void eventBtnAltaModificacion() {
		try {
			AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
			TipoParticulaService tipoParticulaService = (TipoParticulaService) getService(Constants.TIPO_PARTICULA_SERVICE);

			TipoParticula tipoParticula = new TipoParticula();
			String descripcion = dlgAltaModificacionTiposParticula.getTxtDescripcion().getText();
			String codUsuario = (String) appGlobalSingleton.getProperty(Constants.COD_USR);
			String mcaProyecto = AppHelper.normalizeValueToCheck(dlgAltaModificacionTiposParticula.getChkDistingueProyecto().isSelected());
			String mcaSubproyecto = AppHelper.normalizeValueToCheck(dlgAltaModificacionTiposParticula.getChkDistingueSubproyecto().isSelected());
			
			tipoParticula.setDescripcionParticula(descripcion);
			tipoParticula.setCodigoUsuario(codUsuario);
			tipoParticula.setMcaProyecto(mcaProyecto);
			tipoParticula.setMcaSubProyecto(mcaSubproyecto);
			String msg = StringUtils.EMPTY;

			Integer response = UIHelper.showConfirm(literales.getLiteral("confirmacion.mensaje"),
					literales.getLiteral("confirmacion.titulo"));
			
			if (response == JOptionPane.YES_OPTION) {
				// Se van a guardar las modificaciones de un registro existente
				if (dlgAltaModificacionTiposParticula.getEditar()) {
					String sCodigo = dlgAltaModificacionTiposParticula.getTxtCodigo().getText();
					Long codigo = Long.valueOf(sCodigo);
					tipoParticula.setCodigoParticula(BigDecimal.valueOf(codigo));
					tipoParticulaService.modificarTipoParticula(tipoParticula);
	
					msg = literales.getLiteral("mensaje.guardar");
				} else {
					tipoParticulaService.altaTipoParticula(tipoParticula);
	
					msg = literales.getLiteral("mensaje.crear");
				}
	
				JOptionPane.showMessageDialog(dlgAltaModificacionTiposParticula.getParent(), msg);
	
				/**
				 * En este punto invocar un m??todo que informe a los observadores del patr??n
				 * observer para que invoquen a su m??todo de actualizaci??n
				 */
				updateObservers(Constants.DLG_ALTA_MODIFICACION_TIPOS_PARTICULA_BTN_ACEPTAR);
				dlgAltaModificacionTiposParticula.dispose();
			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(dlgAltaModificacionTiposParticula.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}
}
