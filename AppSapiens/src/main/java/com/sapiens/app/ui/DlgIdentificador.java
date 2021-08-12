/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sapiens.app.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.sapiens.app.ui.listener.DlgIdentificadorListener;
import com.sapiens.app.ui.listener.DlgIdentificadorWindowListener;
import com.sapiens.app.utils.Constants;
import com.sapiens.app.utils.LiteralesSingleton;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

/**
 *
 * @author federico
 */
@Log4j
public class DlgIdentificador extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8834696671228315839L;
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnAceptar;
    private JLabel lblIdentificador;
    private JPanel panelBotones;
    private JPanel panelLabel;
    private JPanel panelPrincipal;
    private JPanel panelTxtField;
    
    @Getter
    private JTextField txtIdentificador;
    // End of variables declaration//GEN-END:variables
    
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
        
        try {
			initComponents();
			initLiterals();
			initEvents();
		} catch (IOException e) {
			log.warn("ERROR:", e);
		}
    }

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        
		pack();
    }// </editor-fold>//GEN-END:initComponents

	private void initLiterals() throws IOException {
		LiteralesSingleton literales = LiteralesSingleton.getInstance();
		
		lblIdentificador.setText(literales.getLiteral("dlgIdentificador.identificador"));
		btnAceptar.setText(literales.getLiteral("dlgIdentificador.aceptar"));
	}
	
	private void initEvents() {
		ActionListener actionListener = new DlgIdentificadorListener(this);
		WindowListener windowListener = new DlgIdentificadorWindowListener(this);
		
		btnAceptar.addActionListener(actionListener);
		
		addWindowListener(windowListener);
	}
}