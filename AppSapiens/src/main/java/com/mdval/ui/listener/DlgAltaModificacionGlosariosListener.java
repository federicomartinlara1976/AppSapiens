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

import com.mdval.bussiness.service.GlosarioService;
import com.mdval.ui.glosarios.DlgAltaModificacionGlosarios;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.Constants;

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
			GlosarioService glosarioService = (GlosarioService) getService(Constants.GLOSARIO_SERVICE);

			String descripcion = dlgAltaModificacionGlosarios.getTxtDescripcion().getText();
			String sCodigo = dlgAltaModificacionGlosarios.getTxtCodigo().getText();
			String usuario = dlgAltaModificacionGlosarios.getTxtUsuario().getText();
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
				 * En este punto invocar un método que informe a los observadores del patrón
				 * observer para que invoquen a su método de actualización
				 */
				updateObservers();
			}
			dlgAltaModificacionGlosarios.dispose();
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup((JFrame) dlgAltaModificacionGlosarios.getParent(), Constants.CMD_ERROR, params);
		}
	}
}
