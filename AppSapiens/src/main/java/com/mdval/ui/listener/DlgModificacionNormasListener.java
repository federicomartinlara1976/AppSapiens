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

import com.mdval.bussiness.service.NormaService;
import com.mdval.ui.normasnomenclatura.DlgModificacionNormas;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.Constants;

import lombok.SneakyThrows;

/**
 * @author federico
 *
 */
public class DlgModificacionNormasListener extends ListenerSupport implements ActionListener {

	private DlgModificacionNormas dlgModificacionNormas;

	public DlgModificacionNormasListener(DlgModificacionNormas dlgModificacionNormas) {
		super();
		this.dlgModificacionNormas = dlgModificacionNormas;
	}

	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@SneakyThrows
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.DLG_MODIFICACION_NORMAS_BTN_ALTA_ELEMENTO.equals(jButton.getActionCommand())) {
			
		}

		if (Constants.DLG_MODIFICACION_NORMAS_BTN_BAJA_ELEMENTO.equals(jButton.getActionCommand())) {
			
		}
		
		if (Constants.DLG_MODIFICACION_NORMAS_BTN_MODIFICACION_ELEMENTO.equals(jButton.getActionCommand())) {
			
		}

		if (Constants.DLG_MODIFICACION_NORMAS_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAltaModificacion();
		}

		if (Constants.DLG_MODIFICACION_NORMAS_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgModificacionNormas.dispose();
		}
	}

	@SneakyThrows
	private void eventBtnAltaModificacion() {
		try {
			NormaService normaService = (NormaService) getService(Constants.NORMA_SERVICE);

			String descripcion = dlgModificacionNormas.getTxtDescripcion().getText();
			String sCodigo = dlgModificacionNormas.getTxtCodigo().getText();
			String usuario = dlgModificacionNormas.getTxtUsuario().getText();
			String msg = StringUtils.EMPTY;
			
			Integer response = UIHelper.showConfirm(literales.getLiteral("confirmacion.mensaje"),
					literales.getLiteral("confirmacion.titulo"));
			
			if (response == JOptionPane.YES_OPTION) {

				// Se van a guardar las modificaciones de un registro existente
				if (dlgModificacionNormas.getEditar()) {
					BigDecimal codigoBigDecimal = new BigDecimal(Integer.parseInt(sCodigo));
					normaService.modificaNorma(codigoBigDecimal, descripcion, usuario);
	
					msg = literales.getLiteral("mensaje.guardar");
				} else {
					normaService.altaNorma(descripcion, usuario);
	
					msg = literales.getLiteral("mensaje.crear");
				}
	
				JOptionPane.showMessageDialog(dlgModificacionNormas.getParent(), msg);
	
				/**
				 * En este punto invocar un método que informe a los observadores del patrón
				 * observer para que invoquen a su método de actualización
				 */
				this.setChanged();
				this.notifyObservers();
			}
			
			dlgModificacionNormas.dispose();
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup((JFrame) dlgModificacionNormas.getParent(), Constants.CMD_ERROR, params);
		}
	}
}
