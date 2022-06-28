package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.service.TipoElementoService;
import com.mdval.ui.normasnomenclatura.DlgAltaModificacionElementos;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.ui.utils.observer.Observer;
import com.mdval.utils.AppGlobalSingleton;
import com.mdval.utils.MDValConstants;

import lombok.SneakyThrows;

/**
 * @author federico
 *
 */
public class DlgAltaModificacionElementosListener extends ListenerSupport implements ActionListener {

	private DlgAltaModificacionElementos dlgAltaModificacionElementos;

	public DlgAltaModificacionElementosListener(DlgAltaModificacionElementos dlgAltaModificacionElementos) {
		super();
		this.dlgAltaModificacionElementos = dlgAltaModificacionElementos;
	}

	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@SneakyThrows
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (MDValConstants.DLG_ALTA_MODIFICACION_ELEMENTOS_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAltaModificacion();
		}

		if (MDValConstants.DLG_ALTA_MODIFICACION_ELEMENTOS_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgAltaModificacionElementos.dispose();
		}
	}

	@SneakyThrows
	private void eventBtnAltaModificacion() {
		try {
			AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
			TipoElementoService tipoElementoService = (TipoElementoService) getService(MDValConstants.TIPO_ELEMENTO_SERVICE);

			String descripcion = dlgAltaModificacionElementos.getTxtDescripcion().getText();
			String sCodigo = dlgAltaModificacionElementos.getTxtCodigo().getText();
			String usuario = (String) appGlobalSingleton.getProperty(MDValConstants.COD_USR);
			String msg = StringUtils.EMPTY;

			Integer response = UIHelper.showConfirm(literales.getLiteral("confirmacion.mensaje"),
					literales.getLiteral("confirmacion.titulo"));
			
			if (response == JOptionPane.YES_OPTION) {
				// Se van a guardar las modificaciones de un registro existente
				if (dlgAltaModificacionElementos.getEditar()) {
					BigDecimal codigoBigDecimal = new BigDecimal(Integer.parseInt(sCodigo));
					tipoElementoService.modificarTipoElemento(codigoBigDecimal, descripcion, usuario);
	
					msg = literales.getLiteral("mensaje.guardar");
				} else {
					tipoElementoService.altaTipoElemento(descripcion, usuario);
	
					msg = literales.getLiteral("mensaje.crear");
				}
	
				JOptionPane.showMessageDialog(dlgAltaModificacionElementos.getParent(), msg);
	
				/**
				 * En este punto invocar un método que informe a los observadores del patrón
				 * observer para que invoquen a su método de actualización
				 */
				updateObservers(MDValConstants.DLG_ALTA_MODIFICACION_ELEMENTOS_BTN_ACEPTAR);
				dlgAltaModificacionElementos.dispose();
			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(dlgAltaModificacionElementos.getFrameParent(), MDValConstants.CMD_ERROR, params);
		}
	}
}
