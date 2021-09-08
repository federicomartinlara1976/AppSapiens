package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.entities.TipoParticula;
import com.mdval.bussiness.service.TipoParticulaService;
import com.mdval.ui.normasnomenclatura.FrmMantenimientoParticulas;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.AppGlobalSingleton;
import com.mdval.utils.AppHelper;
import com.mdval.utils.Constants;

/**
 * @author federico
 *
 */
public class FrmMantenimientoParticulasListener extends ListenerSupport implements ActionListener {

	private FrmMantenimientoParticulas frmMantenimientoParticulas;

	public FrmMantenimientoParticulasListener(FrmMantenimientoParticulas frmMantenimientoParticulas) {
		super();
		this.frmMantenimientoParticulas = frmMantenimientoParticulas;
	}
	
	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.FRM_MANTENIMIENTO_PARTICULAS_BTN_ALTA.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}
		
		if (Constants.FRM_MANTENIMIENTO_PARTICULAS_BTN_BAJA.equals(jButton.getActionCommand())) {
			eventBtnBaja();
		}
		
		if (Constants.FRM_MANTENIMIENTO_PARTICULAS_BTN_MODIFICACION.equals(jButton.getActionCommand())) {
			eventBtnModificacion();
		}
		
		if (Constants.FRM_MANTENIMIENTO_PARTICULAS_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAceptar();
		}
		
		if (Constants.FRM_MANTENIMIENTO_PARTICULAS_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			frmMantenimientoParticulas.dispose();
		}
	}
	
	private void eventBtnAceptar() {
		try {
			AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
			TipoParticulaService tipoParticulaService = (TipoParticulaService) getService(Constants.TIPO_PARTICULA_SERVICE);

			TipoParticula tipoParticula = new TipoParticula();
			String descripcion = frmMantenimientoParticulas.getTxtDescripcion().getText();
			String codUsuario = (String) appGlobalSingleton.getProperty(Constants.COD_USR);
			String mcaProyecto = AppHelper.normalizeCmbSiNoValue((String) frmMantenimientoParticulas.getCmbProyecto().getSelectedItem());
			String mcaSubproyecto = AppHelper.normalizeCmbSiNoValue((String) frmMantenimientoParticulas.getCmbSubproyecto().getSelectedItem());
			
			tipoParticula.setDescripcionParticula(descripcion);
			tipoParticula.setCodigoUsuario(codUsuario);
			tipoParticula.setMcaProyecto(mcaProyecto);
			tipoParticula.setMcaSubProyecto(mcaSubproyecto);
			String msg = StringUtils.EMPTY;

			Integer response = UIHelper.showConfirm(literales.getLiteral("confirmacion.mensaje"),
					literales.getLiteral("confirmacion.titulo"));
			
			if (response == JOptionPane.YES_OPTION) {
				// Se van a guardar las modificaciones de un registro existente
				if (frmMantenimientoParticulas.getEditar()) {
					String sCodigo = frmMantenimientoParticulas.getTxtCodigo().getText();
					Long codigo = Long.valueOf(sCodigo);
					tipoParticula.setCodigoParticula(BigDecimal.valueOf(codigo));
					tipoParticulaService.modificarTipoParticula(tipoParticula);
	
					msg = literales.getLiteral("mensaje.guardar");
				} else {
					tipoParticulaService.altaTipoParticula(tipoParticula);
	
					msg = literales.getLiteral("mensaje.crear");
				}
	
				JOptionPane.showMessageDialog(frmMantenimientoParticulas.getParent(), msg);
	
				/**
				 * En este punto invocar un método que informe a los observadores del patrón
				 * observer para que invoquen a su método de actualización
				 */
				updateObservers(Constants.DLG_ALTA_MODIFICACION_TIPOS_PARTICULA_BTN_ACEPTAR);
				frmMantenimientoParticulas.dispose();
			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup((JFrame) frmMantenimientoParticulas.getParent(), Constants.CMD_ERROR, params);
		}
	}

	/**
	 * 
	 */
	private void eventBtnAlta() {
		showPopup(frmMantenimientoParticulas, Constants.CMD_ALTA_MANTENIMIENTO_PARTICULAS);
	}
	
	/**
	 * 
	 */
	private void eventBtnBaja() {
	}
	
	/**
	 * 
	 */
	private void eventBtnModificacion() {
		showPopup(frmMantenimientoParticulas, Constants.CMD_MODIFICACION_MANTENIMIENTO_PARTICULAS);
	}
}
