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

import com.mdval.bussiness.entities.CampoGlosario;
import com.mdval.bussiness.entities.Glosario;
import com.mdval.bussiness.service.CamposGlosarioService;
import com.mdval.ui.glosarios.DlgAltaModificacionCampos;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.AppGlobalSingleton;
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
			AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
			CamposGlosarioService camposGlosarioService = (CamposGlosarioService) getService(
					Constants.CAMPOS_GLOSARIO_SERVICE);
			Glosario glosarioSeleccionado = dlgAltaModificacionCampos.getGlosarioSeleccionado();
			String codUsuario = (String) appGlobalSingleton.getProperty(Constants.COD_USR);

			CampoGlosario oldCampoGlosario = dlgAltaModificacionCampos.getCampoGlosarioSeleccionado();
			CampoGlosario newCampoGlosario = new CampoGlosario();

			newCampoGlosario.setCodigoGlosario(glosarioSeleccionado.getCodigoGlosario());
			newCampoGlosario.setNombreColumna(dlgAltaModificacionCampos.getTxtNombre().getText());
			newCampoGlosario.setTipoDato((String) dlgAltaModificacionCampos.getCmbTipoDato().getSelectedItem());
			String sNumeroLongitud = dlgAltaModificacionCampos.getTxtTamanio().getText();
			String sDecimales = dlgAltaModificacionCampos.getTxtDecimales().getText();

			Integer longitud = StringUtils.isNotBlank(sNumeroLongitud) ? Integer.parseInt(sNumeroLongitud) : 0;
			Integer decimales = StringUtils.isNotBlank(sDecimales) ? Integer.parseInt(sDecimales) : 0;

			newCampoGlosario.setNumeroLongitud(new BigDecimal(longitud));
			newCampoGlosario.setNumeroDecimal(new BigDecimal(decimales));

			String mcaException = "SI".equals(((String) dlgAltaModificacionCampos.getCmbExcepcion().getSelectedItem()))
					? "S"
					: "N";

			newCampoGlosario.setMcaExcepcion(mcaException);
			newCampoGlosario.setTxtComentario(dlgAltaModificacionCampos.getTxtObservaciones().getText());
			newCampoGlosario.setTxtExcepcion(dlgAltaModificacionCampos.getTxtDescripcionExcepcion().getText());
			newCampoGlosario.setCodigoUsuario(codUsuario);

			String msg = StringUtils.EMPTY;

			Integer response = UIHelper.showConfirm(literales.getLiteral("confirmacion.mensaje"),
					literales.getLiteral("confirmacion.titulo"));

			if (response == JOptionPane.YES_OPTION) {
				// Se van a guardar las modificaciones de un registro existente
				if (dlgAltaModificacionCampos.getEditar()) {
					camposGlosarioService.modificarCampoGlosario(oldCampoGlosario, newCampoGlosario);

					msg = literales.getLiteral("mensaje.guardar");
				} else {
					camposGlosarioService.altaCampoGlosario(newCampoGlosario);

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
