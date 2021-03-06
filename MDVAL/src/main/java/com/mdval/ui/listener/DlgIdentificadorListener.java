package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.mdval.ui.DlgIdentificador;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.AppGlobalSingleton;
import com.mdval.utils.MDValConstants;

public class DlgIdentificadorListener extends ListenerSupport implements ActionListener {

	private DlgIdentificador dlgIdentificador;

	public DlgIdentificadorListener(DlgIdentificador dlgIdentificador) {
		super();
		this.dlgIdentificador = dlgIdentificador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (MDValConstants.DLG_IDENTIFICADOR_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAceptar();
		}
	}

	private void eventBtnAceptar() {
		String txtCodUsr = dlgIdentificador.getTxtIdentificador().getText();

		if (StringUtils.isNotBlank(txtCodUsr)) {
			AppGlobalSingleton.getInstance().setProperty(MDValConstants.COD_USR, txtCodUsr);

			dlgIdentificador.setIsTerminate(Boolean.FALSE);
			dlgIdentificador.dispose();

			UIHelper.showMaximized((JFrame) dlgIdentificador.getParent());
			dlgIdentificador.getParent().setVisible(Boolean.TRUE);
		} else {
			JOptionPane.showMessageDialog(dlgIdentificador.getParent(),
					literales.getLiteral("dlgIdentificador.mensaje"));
		}
	}

}
