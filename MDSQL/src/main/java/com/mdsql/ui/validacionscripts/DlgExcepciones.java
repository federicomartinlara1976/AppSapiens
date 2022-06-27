package com.mdsql.ui.validacionscripts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import com.mdsql.ui.listener.DlgExcepcionesListener;
import com.mdsql.ui.utils.DialogSupport;
import com.mdsql.ui.utils.FrameSupport;
import com.mdsql.utils.Constants;

import lombok.Getter;

/**
 *
 * @author federico
 */
public class DlgExcepciones extends DialogSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6665571236064538468L;
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel jLabel1;
	private JScrollPane jScrollPane1;
	private JPanel panelBotones;
	
	@Getter
	private JTextArea txtComentario;
	// End of variables declaration//GEN-END:variables

	/**
	 * Creates new form DlgExcepciones
	 */
	public DlgExcepciones(FrameSupport frame, boolean modal) {
		super(frame, modal);
	}

	@Override
	protected void setupComponents() {
		jLabel1 = new JLabel();
		jScrollPane1 = new JScrollPane();
		txtComentario = new JTextArea();
		panelBotones = new JPanel();
		btnAceptar = new JButton();
		btnCancelar = new JButton();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		getContentPane().add(jLabel1, BorderLayout.PAGE_START);

		txtComentario.setColumns(20);
		txtComentario.setRows(5);
		jScrollPane1.setViewportView(txtComentario);

		getContentPane().add(jScrollPane1, BorderLayout.CENTER);

		panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));

		btnAceptar.setIcon(new ImageIcon(getClass().getResource("/checked.png"))); // NOI18N
		btnAceptar.setActionCommand(Constants.DLG_EXCEPCIONES_BTN_ACEPTAR);
		panelBotones.add(btnAceptar);

		btnCancelar.setIcon(new ImageIcon(getClass().getResource("/close.png"))); // NOI18N
		btnCancelar.setActionCommand(Constants.DLG_EXCEPCIONES_BTN_CANCELAR);
		panelBotones.add(btnCancelar);

		getContentPane().add(panelBotones, BorderLayout.PAGE_END);

		setResizable(Boolean.FALSE);
		setPreferredSize(new Dimension(337, 237));
	}

	@Override
	protected void setupLiterals() {
		setTitle(literales.getLiteral("dlgExcepciones.titulo"));
		
		jLabel1.setText(literales.getLiteral("dlgExcepciones.comentario"));
		btnAceptar.setText(literales.getLiteral("dlgExcepciones.aceptar"));
		btnCancelar.setText(literales.getLiteral("dlgExcepciones.cancelar"));
	}
	
	/**
	 * 
	 */
	protected void initEvents() {
		ActionListener actionListener = new DlgExcepcionesListener(this);
		
		btnAceptar.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);
	}

	@Override
	protected void initModels() {}

	@Override
	protected void initialState() {}
}
