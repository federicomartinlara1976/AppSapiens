package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.mdsql.bussiness.service.TipoElementoService;
import com.mdsql.ui.normasnomenclatura.DlgAltaModificacionElementos;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.UIHelper;
import com.mdsql.utils.AppGlobalSingleton;
import com.mdsql.utils.Constants;

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

		if (Constants.DLG_ALTA_MODIFICACION_ELEMENTOS_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAltaModificacion();
		}

		if (Constants.DLG_ALTA_MODIFICACION_ELEMENTOS_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgAltaModificacionElementos.dispose();
		}
	}

	@SneakyThrows
	private void eventBtnAltaModificacion() {
		try {
			AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
			TipoElementoService tipoElementoService = (TipoElementoService) getService(Constants.TIPO_ELEMENTO_SERVICE);

			String descripcion = dlgAltaModificacionElementos.getTxtDescripcion().getText();
			String sCodigo = dlgAltaModificacionElementos.getTxtCodigo().getText();
			String usuario = (String) appGlobalSingleton.getProperty(Constants.COD_USR);
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
				updateObservers(Constants.DLG_ALTA_MODIFICACION_ELEMENTOS_BTN_ACEPTAR);
				dlgAltaModificacionElementos.dispose();
			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(dlgAltaModificacionElementos.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}
}
