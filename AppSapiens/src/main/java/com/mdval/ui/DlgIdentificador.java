package com.mdval.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.mdval.ui.listener.DlgIdentificadorListener;
import com.mdval.ui.listener.DlgIdentificadorWindowListener;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.utils.Constants;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author federico
 */
public class DlgIdentificador extends DialogSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8834696671228315839L;
    
	private JButton btnAceptar;
    
	private JLabel lblIdentificador;
    
	private JPanel panelBotones;
    
	private JPanel panelLabel;
    
	private JPanel panelPrincipal;
    
	private JPanel panelTxtField;
    
    @Getter
    private JTextField txtIdentificador;
    
    @Getter
    private JFrame frameParent;
    
    @Getter
    @Setter
    private Boolean isTerminate;

    /**
     * Creates new form dlgIdentificador
     * @param parent
     * @param modal
     */
    public DlgIdentificador(JFrame parent, boolean modal) {
    	super(parent, modal);
        this.frameParent = parent;
        this.isTerminate = Boolean.TRUE;
    }

	/**
	 *
	 */
	protected void setupComponents() {

        panelPrincipal = new JPanel();
        panelLabel = new JPanel();
        lblIdentificador = new JLabel();
        panelTxtField = new JPanel();
        txtIdentificador = new JTextField();
        panelBotones = new JPanel();
        btnAceptar = new JButton();
        btnAceptar.setName(Constants.DLG_IDENTIFICADOR_BTN_ACEPTAR);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());

        panelPrincipal.setLayout(new GridLayout(3, 0, 1, 5));

        panelLabel.add(lblIdentificador);

        panelPrincipal.add(panelLabel);

        panelTxtField.setLayout(new BorderLayout(5, 5));
        panelTxtField.add(txtIdentificador, BorderLayout.CENTER);

        panelPrincipal.add(panelTxtField);

        panelBotones.setLayout(new BorderLayout(5, 5));

        panelBotones.add(btnAceptar, BorderLayout.LINE_END);

        panelPrincipal.add(panelBotones);

        getContentPane().add(panelPrincipal);

        setResizable(Boolean.FALSE);
        setPreferredSize(new Dimension(337, 137));
    }

	/**
	 *
	 */
	protected void setupLiterals() {
		lblIdentificador.setText(literales.getLiteral("dlgIdentificador.identificador"));
		btnAceptar.setText(literales.getLiteral("dlgIdentificador.aceptar"));
	}
	
	/**
	 *
	 */
	protected void initEvents() {
		ActionListener actionListener = new DlgIdentificadorListener(this);
		WindowListener windowListener = new DlgIdentificadorWindowListener(this);
		
		btnAceptar.addActionListener(actionListener);
		
		addWindowListener(windowListener);
	}
}
