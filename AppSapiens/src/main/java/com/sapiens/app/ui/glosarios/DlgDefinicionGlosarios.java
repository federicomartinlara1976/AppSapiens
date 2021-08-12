/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sapiens.app.ui.glosarios;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.sapiens.app.ui.PanelLogotipo;
import com.sapiens.app.ui.listener.DlgDefinicionGlosariosListener;
import com.sapiens.app.utils.Constants;
import com.sapiens.app.utils.LiteralesSingleton;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

/**
 *
 * @author federico
 */
@Log4j
public class DlgDefinicionGlosarios extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2850927235862482216L;
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnAlta;
    private JButton btnBuscar;
    private JButton btnModificacion;
    private JButton btnSeleccionar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private PanelLogotipo panelLogo;
    
    @Getter
    private JTextField txtGlosario;
    // End of variables declaration//GEN-END:variables
    
    @Getter
    private JFrame frameParent;
    
	/**
     * Creates new form DlgDefinicionGlosarios
     */
    public DlgDefinicionGlosarios(JFrame parent, boolean modal) {
        super(parent, modal);
        this.frameParent = parent;
        
        try {
			initComponents();
			initLiterals();
			initEvents();
			
			initialState();
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

        jPanel1 = new JPanel();
        panelLogo = new PanelLogotipo("logotipo.png");
        jPanel5 = new JPanel();
        jLabel1 = new JLabel();
        jPanel8 = new JPanel();
        jLabel2 = new JLabel();
        txtGlosario = new JTextField();
        jPanel6 = new JPanel();
        btnBuscar = new JButton();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        btnAlta = new JButton();
        btnAlta.setName(Constants.DLG_DEFINICION_GLOSARIOS_BTN_ALTA);
        btnModificacion = new JButton();
        btnModificacion.setName(Constants.DLG_DEFINICION_GLOSARIOS_BTN_MODIFICACION);
        jPanel7 = new JPanel();
        btnSeleccionar = new JButton();
        btnSeleccionar.setName(Constants.DLG_DEFINICION_GLOSARIOS_BTN_SELECCIONAR);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new BorderLayout());

        panelLogo.setPreferredSize(new Dimension(286, 63));
        panelLogo.setLayout(new BorderLayout());
        jPanel1.add(panelLogo, BorderLayout.WEST);

        jPanel5.setLayout(new BorderLayout());

        
        jPanel5.add(jLabel1, BorderLayout.NORTH);

        jPanel8.setLayout(new FlowLayout(FlowLayout.LEFT));

        
        jPanel8.add(jLabel2);

        txtGlosario.setPreferredSize(new Dimension(300, 21));
        jPanel8.add(txtGlosario);

        jPanel5.add(jPanel8, BorderLayout.PAGE_END);

        jPanel1.add(jPanel5, BorderLayout.CENTER);

        btnBuscar.setText("BUSCAR");
        jPanel6.add(btnBuscar);

        jPanel1.add(jPanel6, BorderLayout.EAST);

        getContentPane().add(jPanel1, BorderLayout.PAGE_START);

        jPanel2.setLayout(new BorderLayout());
        getContentPane().add(jPanel2, BorderLayout.CENTER);

        jPanel3.setLayout(new BorderLayout());

        jPanel4.setLayout(new FlowLayout(FlowLayout.RIGHT));

        
        btnAlta.setPreferredSize(new Dimension(130, 27));
        jPanel4.add(btnAlta);

        
        jPanel4.add(btnModificacion);

        jPanel3.add(jPanel4, BorderLayout.CENTER);

        
        btnSeleccionar.setPreferredSize(new Dimension(130, 27));
        jPanel7.add(btnSeleccionar);

        jPanel3.add(jPanel7, BorderLayout.EAST);

        getContentPane().add(jPanel3, BorderLayout.PAGE_END);
       
        setPreferredSize(new Dimension(800, 600));
        
        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @throws IOException
     */
    private void initLiterals() throws IOException {
		LiteralesSingleton literales = LiteralesSingleton.getInstance();
		
		setTitle(literales.getLiteral("dlgDefinicionGlosarios.titulo"));
		jLabel1.setText(literales.getLiteral("dlgDefinicionGlosarios.titulo"));
		jLabel2.setText(literales.getLiteral("dlgDefinicionGlosarios.glosario"));
		btnAlta.setText(literales.getLiteral("dlgDefinicionGlosarios.alta"));
		btnModificacion.setText(literales.getLiteral("dlgDefinicionGlosarios.modificacion"));
		btnSeleccionar.setText(literales.getLiteral("dlgDefinicionGlosarios.seleccionar"));
	}
	
	/**
	 * 
	 */
	private void initEvents() {
		ActionListener actionListener = new DlgDefinicionGlosariosListener(this);
		
		btnAlta.addActionListener(actionListener);
		btnModificacion.addActionListener(actionListener);
		btnSeleccionar.addActionListener(actionListener);
	}
	
	/**
	 * 
	 */
	private void initialState() {
		// TODO Auto-generated method stub
		
	}
}