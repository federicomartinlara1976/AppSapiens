package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.mdval.ui.glosarios.DlgAltaModificacionCampos;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.Constants;

public class DlgAltaModificacionCamposListener extends ListenerSupport implements ActionListener {

	private DlgAltaModificacionCampos dlgAltaModificacionCampos;

	public DlgAltaModificacionCamposListener(DlgAltaModificacionCampos dlgAltaModificacionCampos) {
		super();
		this.dlgAltaModificacionCampos = dlgAltaModificacionCampos;
	}
	
	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_ALTA_MODIFICACION_CAMPOS_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}

		if (Constants.DLG_ALTA_MODIFICACION_CAMPOS_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgAltaModificacionCampos.dispose();
		}
	}

	private void eventBtnAlta() {
		try {
//			GlosarioService glosarioService = (GlosarioService) getService(Constants.GLOSARIO_SERVICE);

//			String descripcion = dlgAltaModificacionGlosarios.getTxtDescripcion().getText();
			
//			String usuario = dlgAltaModificacionGlosarios.getTxtUsuario().getText();
			String msg = StringUtils.EMPTY;

			Integer response = UIHelper.showConfirm(literales.getLiteral("confirmacion.mensaje"),
					literales.getLiteral("confirmacion.titulo"));
			
			if (response == JOptionPane.YES_OPTION) {
				// Se van a guardar las modificaciones de un registro existente
				if (dlgAltaModificacionCampos.getEditar()) {
//					glosarioService.modificaGlosario(codigoBigDecimal, descripcion, usuario);
	
					msg = literales.getLiteral("mensaje.guardar");
				} else {
//					glosarioService.altaGlosario(descripcion, usuario);
	
					msg = literales.getLiteral("mensaje.crear");
				}
	
				JOptionPane.showMessageDialog(dlgAltaModificacionCampos.getParent(), msg);
	
				/**
				 * En este punto invocar un método que informe a los observadores del patrón
				 * observer para que invoquen a su método de actualización
				 */
				updateObservers();
			}
			dlgAltaModificacionCampos.dispose();
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup((JFrame) dlgAltaModificacionCampos.getParent(), Constants.CMD_ERROR, params);
		}
	}

}
