package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.mdsql.bussiness.service.GlosarioService;
import com.mdsql.ui.glosarios.DlgAltaModificacionGlosarios;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.UIHelper;
import com.mdsql.utils.AppGlobalSingleton;
import com.mdsql.utils.Constants;

import lombok.SneakyThrows;

/**
 * @author federico
 *
 */
public class DlgAltaModificacionGlosariosListener extends ListenerSupport implements ActionListener {

	private DlgAltaModificacionGlosarios dlgAltaModificacionGlosarios;

	public DlgAltaModificacionGlosariosListener(DlgAltaModificacionGlosarios dlgAltaModificacionGlosarios) {
		super();
		this.dlgAltaModificacionGlosarios = dlgAltaModificacionGlosarios;
	}

	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@SneakyThrows
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAltaModificacion();
		}

		if (Constants.DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgAltaModificacionGlosarios.dispose();
		}
	}

	@SneakyThrows
	private void eventBtnAltaModificacion() {
		try {
			AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
			GlosarioService glosarioService = (GlosarioService) getService(Constants.GLOSARIO_SERVICE);

			String descripcion = dlgAltaModificacionGlosarios.getTxtDescripcion().getText();
			String sCodigo = dlgAltaModificacionGlosarios.getTxtCodigo().getText();
			String usuario = (String) appGlobalSingleton.getProperty(Constants.COD_USR);
			String msg = StringUtils.EMPTY;

			Integer response = UIHelper.showConfirm(literales.getLiteral("confirmacion.mensaje"),
					literales.getLiteral("confirmacion.titulo"));
			
			if (response == JOptionPane.YES_OPTION) {
				// Se van a guardar las modificaciones de un registro existente
				if (dlgAltaModificacionGlosarios.getEditar()) {
					BigDecimal codigoBigDecimal = new BigDecimal(Integer.parseInt(sCodigo));
					glosarioService.modificaGlosario(codigoBigDecimal, descripcion, usuario);
	
					msg = literales.getLiteral("mensaje.guardar");
				} else {
					glosarioService.altaGlosario(descripcion, usuario);
	
					msg = literales.getLiteral("mensaje.crear");
				}
	
				JOptionPane.showMessageDialog(dlgAltaModificacionGlosarios.getParent(), msg);
	
				/**
				 * En este punto invocar un m??todo que informe a los observadores del patr??n
				 * observer para que invoquen a su m??todo de actualizaci??n
				 */
				updateObservers(Constants.DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_ACEPTAR);
				dlgAltaModificacionGlosarios.dispose();
			}
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(dlgAltaModificacionGlosarios.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}
}
