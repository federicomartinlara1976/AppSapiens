package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.apache.commons.lang3.StringUtils;

import com.sapiens.app.ui.DlgIdentificador;
import com.sapiens.app.ui.utils.UIHelper;
import com.sapiens.app.utils.AppGlobalSingleton;
import com.sapiens.app.utils.Constants;

public class DlgIdentificadorListener extends ListenerSupport implements ActionListener {

	private DlgIdentificador dlgIdentificador;

	public DlgIdentificadorListener(DlgIdentificador dlgIdentificador) {
		super();
		this.dlgIdentificador = dlgIdentificador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_IDENTIFICADOR_BTN_ACEPTAR.equals(jButton.getName())) {
			eventBtnAceptar();
		}
	}
	
	private void eventBtnAceptar() {
		String txtCodUsr = dlgIdentificador.getTxtIdentificador().getText();
		
		if (StringUtils.isNotBlank(txtCodUsr)) {
			AppGlobalSingleton.getInstance().setProperty(Constants.COD_USR, txtCodUsr);
		}
		
		dlgIdentificador.setIsTerminate(Boolean.FALSE);
		dlgIdentificador.dispose();
		
		UIHelper.showMaximized(dlgIdentificador.getFrameParent());
		dlgIdentificador.getFrameParent().setVisible(Boolean.TRUE);
	}

}
