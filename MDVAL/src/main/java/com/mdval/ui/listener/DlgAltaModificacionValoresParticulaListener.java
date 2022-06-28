package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.entities.TipoParticula;
import com.mdval.bussiness.entities.ValorParticula;
import com.mdval.bussiness.service.ValorParticulaService;
import com.mdval.ui.normasnomenclatura.DlgMantenimientoValoresParticulas;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.ui.utils.observer.Observer;
import com.mdval.utils.AppGlobalSingleton;
import com.mdval.utils.Constants;

import lombok.SneakyThrows;

/**
 * @author federico
 *
 */
public class DlgAltaModificacionValoresParticulaListener extends ListenerSupport implements ActionListener {

	private DlgMantenimientoValoresParticulas dlgMantenimientoValoresParticulas;

	public DlgAltaModificacionValoresParticulaListener(DlgMantenimientoValoresParticulas dlgMantenimientoValoresParticulas) {
		super();
		this.dlgMantenimientoValoresParticulas = dlgMantenimientoValoresParticulas;
	}

	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@SneakyThrows
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_ALTA_MODIFICACION_VALORES_PARTICULA_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAltaModificacion();
		}

		if (Constants.DLG_ALTA_MODIFICACION_VALORES_PARTICULA_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgMantenimientoValoresParticulas.dispose();
		}
	}

	@SneakyThrows
	private void eventBtnAltaModificacion() {
		try {
			AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
			ValorParticulaService valorParticulaService = (ValorParticulaService) getService(Constants.VALOR_PARTICULA_SERVICE);

			String codUsuario = (String) appGlobalSingleton.getProperty(Constants.COD_USR);
			TipoParticula tipoParticula = dlgMantenimientoValoresParticulas.getTipoParticula();
			String sValorParticula = dlgMantenimientoValoresParticulas.getTxtValor().getText();
			String sDescripcionValor = dlgMantenimientoValoresParticulas.getTxtDescripcionValor().getText();
			String sProyecto = dlgMantenimientoValoresParticulas.getTxtProyecto().getText();
			String sSubproyecto = dlgMantenimientoValoresParticulas.getTxtSubproyecto().getText();
			String sPartPadre = dlgMantenimientoValoresParticulas.getTxtPartPadre().getText();
			
			
			ValorParticula newValorParticula = new ValorParticula();
			newValorParticula.setCodigoParticula(tipoParticula.getCodigoParticula());
			newValorParticula.setValor(sValorParticula);
			newValorParticula.setDescripcionValorParticula(sDescripcionValor);
			newValorParticula.setCodigoProyecto(sProyecto);
			newValorParticula.setCodigoSubProyecto(sSubproyecto);
			newValorParticula.setValorParticulaPadre(sPartPadre);
			newValorParticula.setCodigoUsuario(codUsuario);
			
			String msg = StringUtils.EMPTY;

			Integer response = UIHelper.showConfirm(literales.getLiteral("confirmacion.mensaje"),
					literales.getLiteral("confirmacion.titulo"));
			
			if (response == JOptionPane.YES_OPTION) {
				// Se van a guardar las modificaciones de un registro existente
				if (dlgMantenimientoValoresParticulas.getEditar()) {
					ValorParticula oldValorParticula = dlgMantenimientoValoresParticulas.getValorParticula();
					valorParticulaService.modificarValorParticula(oldValorParticula, newValorParticula);
					
					msg = literales.getLiteral("mensaje.guardar");
				} else {
					valorParticulaService.altaValorParticula(newValorParticula);
	
					msg = literales.getLiteral("mensaje.crear");
				}
	
				JOptionPane.showMessageDialog(dlgMantenimientoValoresParticulas.getParent(), msg);
	
				/**
				 * En este punto invocar un método que informe a los observadores del patrón
				 * observer para que invoquen a su método de actualización
				 */
				updateObservers(Constants.DLG_ALTA_MODIFICACION_VALORES_PARTICULA_BTN_ACEPTAR);
				dlgMantenimientoValoresParticulas.dispose();
			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(dlgMantenimientoValoresParticulas.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}
}
