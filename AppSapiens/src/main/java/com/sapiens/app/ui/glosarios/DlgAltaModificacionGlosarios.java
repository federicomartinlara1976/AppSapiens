/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sapiens.app.ui.glosarios;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.sapiens.app.ui.PanelLogotipo;
import com.sapiens.app.ui.listener.DlgAltaModificacionGlosariosListener;
import com.sapiens.app.utils.AppGlobalSingleton;
import com.sapiens.app.utils.Constants;
import com.sapiens.app.utils.LiteralesSingleton;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

/**
 *
 * @author federico
 */
@Log4j
public class DlgAltaModificacionGlosarios extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3875273085343772714L;
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
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
    private JTextField txtAlta;
    
    @Getter
    private JTextField txtCodigo;
    
    @Getter
    private JTextField txtDescripcion;
    
    @Getter
    private JTextField txtModificacion;
    
    @Getter
    private JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    
    @Getter
    private JFrame frameParent;
    
    private Map<String, Object> params;

    
    /**
     * @param parent
     * @param modal
     */
    public DlgAltaModificacionGlosarios(JFrame parent, boolean modal) {
        super(parent, modal);
        this.frameParent = parent;
        
        initialize();
    }
    
    public DlgAltaModificacionGlosarios(JFrame parent, boolean modal, Map<String, Object> params) {
        super(parent, modal);
        this.frameParent = parent;
        this.params = params;
        
        initialize();
    }
    
    /**
     * 
     */
    private void initialize() {
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
        jLabel1 = new JLabel();
        jPanel2 = new JPanel();
        jPanel4 = new JPanel();
        jLabel2 = new JLabel();
        txtCodigo = new JTextField();
        jPanel5 = new JPanel();
        jLabel3 = new JLabel();
        txtDescripcion = new JTextField();
        jPanel6 = new JPanel();
        jLabel4 = new JLabel();
        txtUsuario = new JTextField();
        jPanel7 = new JPanel();
        jLabel5 = new JLabel();
        txtAlta = new JTextField();
        jPanel8 = new JPanel();
        jLabel6 = new JLabel();
        txtModificacion = new JTextField();
        jPanel3 = new JPanel();
        btnAceptar = new JButton();
        btnAceptar.setName(Constants.DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_ACEPTAR);
        btnCancelar = new JButton();
        btnCancelar.setName(Constants.DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_CANCELAR);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new BorderLayout());

        panelLogo.setPreferredSize(new Dimension(286, 63));

        jPanel1.add(panelLogo, BorderLayout.WEST);

        jLabel1.setFont(new Font("Dialog", 1, 18)); // NOI18N
        
        jPanel1.add(jLabel1, BorderLayout.CENTER);

        getContentPane().add(jPanel1, BorderLayout.NORTH);

        jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.PAGE_AXIS));

        jPanel4.setLayout(new FlowLayout(FlowLayout.LEFT));

        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        
        jLabel2.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel2.setPreferredSize(new Dimension(150, 17));
        jPanel4.add(jLabel2);

        txtCodigo.setPreferredSize(new Dimension(80, 21));
        jPanel4.add(txtCodigo);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new FlowLayout(FlowLayout.LEFT));

        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        
        jLabel3.setPreferredSize(new Dimension(150, 17));
        jPanel5.add(jLabel3);

        txtDescripcion.setPreferredSize(new Dimension(400, 21));
        jPanel5.add(txtDescripcion);

        jPanel2.add(jPanel5);

        jPanel6.setLayout(new FlowLayout(FlowLayout.LEFT));

        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
        
        jLabel4.setPreferredSize(new Dimension(150, 17));
        jPanel6.add(jLabel4);

        txtUsuario.setPreferredSize(new Dimension(150, 21));
        jPanel6.add(txtUsuario);

        jPanel2.add(jPanel6);

        jPanel7.setLayout(new FlowLayout(FlowLayout.LEFT));

        jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
        
        jLabel5.setPreferredSize(new Dimension(150, 17));
        jPanel7.add(jLabel5);

        txtAlta.setPreferredSize(new Dimension(150, 21));
        jPanel7.add(txtAlta);

        jPanel2.add(jPanel7);

        jPanel8.setLayout(new FlowLayout(FlowLayout.LEFT));

        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
        
        jLabel6.setPreferredSize(new Dimension(150, 17));
        jPanel8.add(jLabel6);

        txtModificacion.setPreferredSize(new Dimension(150, 21));
        jPanel8.add(txtModificacion);

        jPanel2.add(jPanel8);

        getContentPane().add(jPanel2, BorderLayout.CENTER);

        jPanel3.setLayout(new FlowLayout(FlowLayout.RIGHT));

        
        btnAceptar.setPreferredSize(new Dimension(98, 27));
        jPanel3.add(btnAceptar);

        
        jPanel3.add(btnCancelar);

        getContentPane().add(jPanel3, BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @throws IOException
     */
    private void initLiterals() throws IOException {
    	LiteralesSingleton literales = LiteralesSingleton.getInstance();
		
		setTitle(literales.getLiteral("dlgAltaGlosarios.titulo"));
    	jLabel1.setText(literales.getLiteral("dlgAltaGlosarios.titulo"));
    	jLabel2.setText(literales.getLiteral("dlgAltaGlosarios.codigo"));
    	jLabel3.setText(literales.getLiteral("dlgAltaGlosarios.descripcion"));
    	jLabel4.setText(literales.getLiteral("dlgAltaGlosarios.usuario"));
    	jLabel5.setText(literales.getLiteral("dlgAltaGlosarios.alta"));
    	jLabel6.setText(literales.getLiteral("dlgAltaGlosarios.modificacion"));
    	btnAceptar.setText(literales.getLiteral("dlgAltaGlosarios.aceptar"));
    	btnCancelar.setText(literales.getLiteral("dlgAltaGlosarios.cancelar"));
	}

	/**
	 * 
	 */
	private void initEvents() {
		ActionListener actionListener = new DlgAltaModificacionGlosariosListener(this);
		
		btnAceptar.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);
	}

	/**
	 * 
	 */
	private void initialState() {
		AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
		
		String cod_usr = (String) appGlobalSingleton.getProperty(Constants.COD_USR);
		txtUsuario.setText(cod_usr);
		
		txtUsuario.setEnabled(Boolean.FALSE);
	}
}