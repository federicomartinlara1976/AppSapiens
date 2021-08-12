/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sapiens.app.ui.glosarios;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.sapiens.app.ui.PanelLogotipo;
import com.sapiens.app.ui.listener.DlgGlosarioCamposListener;
import com.sapiens.app.utils.Constants;
import com.sapiens.app.utils.LiteralesSingleton;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

/**
 *
 * @author federico
 */
@Log4j
public class DlgGlosarioCampos extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3506678199253519307L;
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnAlta;
    private JButton btnBaja;
    private JButton btnBuscar;
    private JButton btnBuscarGlosario;
    private JButton btnImprimir;
    private JButton btnModificacion;
    private JComboBox<String> cmbMostrarExcepciones;
    private JComboBox<String> cmbTipoDato;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JPanel panelContent;
    private JPanel panelFooter;
    private JPanel panelHeader;
    private PanelLogotipo panelLogo;
    private JPanel panelOpciones;
    private JPanel panelTitulo;
    private JTable tblCampos;
    private JTable tblModelos;
    private JTextField txtCodigoGlosario;
    private JTextField txtCodigoNorma;
    private JTextField txtGlosario;
    private JTextField txtNombreColumna;
    private JTextField txtNorma;
    // End of variables declaration//GEN-END:variables
    
    @Getter
    private JFrame frameParent;
    
	/**
     * Creates new form DlgGlosarioCampos
     */
    public DlgGlosarioCampos(JFrame parent, boolean modal) {
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

        panelHeader = new JPanel();
        panelTitulo = new JPanel();
        panelLogo = new PanelLogotipo("logotipo.png");
        jLabel6 = new JLabel();
        panelOpciones = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        txtCodigoGlosario = new JTextField();
        txtGlosario = new JTextField();
        btnBuscarGlosario = new JButton();
        btnBuscarGlosario.setName(Constants.DLG_GLOSARIO_CAMPOS_BTN_BUSCAR_GLOSARIO);
        txtNombreColumna = new JTextField();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        cmbTipoDato = new JComboBox<>();
        cmbMostrarExcepciones = new JComboBox<>();
        jLabel5 = new JLabel();
        txtCodigoNorma = new JTextField();
        txtNorma = new JTextField();
        btnBuscar = new JButton();
        btnBuscar.setName(Constants.DLG_GLOSARIO_CAMPOS_BTN_BUSCAR);
        panelContent = new JPanel();
        jScrollPane2 = new JScrollPane();
        tblCampos = new JTable();
        jScrollPane1 = new JScrollPane();
        tblModelos = new JTable();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        panelFooter = new JPanel();
        btnAlta = new JButton();
        btnAlta.setName(Constants.DLG_GLOSARIO_CAMPOS_BTN_ALTA);
        btnBaja = new JButton();
        btnBaja.setName(Constants.DLG_GLOSARIO_CAMPOS_BTN_BAJA);
        btnModificacion = new JButton();
        btnModificacion.setName(Constants.DLG_GLOSARIO_CAMPOS_BTN_MODIFICACION);
        btnImprimir = new JButton();
        btnImprimir.setName(Constants.DLG_GLOSARIO_CAMPOS_BTN_IMPRIMIR);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        panelHeader.setLayout(new BorderLayout());

        panelLogo.setPreferredSize(new Dimension(286, 63));

        GroupLayout panelLogoLayout = new GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        jLabel6.setFont(new Font("Dialog", 1, 14)); // NOI18N
        

        GroupLayout panelTituloLayout = new GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(0, 748, Short.MAX_VALUE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelHeader.add(panelTitulo, BorderLayout.NORTH);

        panelOpciones.setPreferredSize(new Dimension(940, 100));

        txtCodigoGlosario.setPreferredSize(new Dimension(64, 27));

        txtGlosario.setPreferredSize(new Dimension(64, 27));

        btnBuscarGlosario.setIcon(new ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N

        txtNombreColumna.setPreferredSize(new Dimension(4, 27));

        cmbTipoDato.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbMostrarExcepciones.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtCodigoNorma.setPreferredSize(new Dimension(64, 27));

        txtNorma.setPreferredSize(new Dimension(64, 27));

        GroupLayout panelOpcionesLayout = new GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOpcionesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombreColumna, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                        .addComponent(txtCodigoGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGlosario, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelOpcionesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel4))
                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarGlosario, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                        .addComponent(cmbTipoDato, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoNorma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNorma, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                        .addComponent(cmbMostrarExcepciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar)))
                .addGap(27, 27, 27))
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelOpcionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtCodigoGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarGlosario)
                    .addGroup(panelOpcionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cmbTipoDato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtCodigoNorma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNorma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)))
                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnBuscar))
                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreColumna, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMostrarExcepciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panelHeader.add(panelOpciones, BorderLayout.CENTER);

        getContentPane().add(panelHeader, BorderLayout.NORTH);

        panelContent.setPreferredSize(new Dimension(940, 382));

        tblCampos.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblCampos);

        tblModelos.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblModelos);

        GroupLayout panelContentLayout = new GroupLayout(panelContent);
        panelContent.setLayout(panelContentLayout);
        panelContentLayout.setHorizontalGroup(
            panelContentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContentLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 1148, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelContentLayout.setVerticalGroup(
            panelContentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelContentLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panelContent, BorderLayout.CENTER);

        panelFooter.setPreferredSize(new Dimension(940, 57));

        btnAlta.setPreferredSize(new Dimension(150, 27));

        btnBaja.setPreferredSize(new Dimension(150, 27));

        btnModificacion.setPreferredSize(new Dimension(150, 27));

        btnImprimir.setPreferredSize(new Dimension(150, 27));

        GroupLayout panelFooterLayout = new GroupLayout(panelFooter);
        panelFooter.setLayout(panelFooterLayout);
        panelFooterLayout.setHorizontalGroup(
            panelFooterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBaja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 526, Short.MAX_VALUE)
                .addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        panelFooterLayout.setVerticalGroup(
            panelFooterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelFooterLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(panelFooterLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBaja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        getContentPane().add(panelFooter, BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @throws IOException
     */
    private void initLiterals() throws IOException {
		LiteralesSingleton literales = LiteralesSingleton.getInstance();
		
		setTitle(literales.getLiteral("dlgGlosarioCampos.titulo"));
		jLabel6.setText(literales.getLiteral("dlgGlosarioCampos.titulo"));
		jLabel1.setText(literales.getLiteral("dlgGlosarioCampos.glosario"));
        jLabel2.setText(literales.getLiteral("dlgGlosarioCampos.nombreColumna"));
        jLabel3.setText(literales.getLiteral("dlgGlosarioCampos.tipoDato"));
        jLabel4.setText(literales.getLiteral("dlgGlosarioCampos.mostrarExcepciones"));
        jLabel5.setText(literales.getLiteral("dlgGlosarioCampos.norma"));
        btnBuscar.setText(literales.getLiteral("dlgGlosarioCampos.buscar"));
        jLabel7.setText(literales.getLiteral("dlgGlosarioCampos.campos"));
        jLabel8.setText(literales.getLiteral("dlgGlosarioCampos.modelos"));
        btnAlta.setText(literales.getLiteral("dlgGlosarioCampos.alta"));
        btnBaja.setText(literales.getLiteral("dlgGlosarioCampos.baja"));
        btnModificacion.setText(literales.getLiteral("dlgGlosarioCampos.modificacion"));
        btnImprimir.setText(literales.getLiteral("dlgGlosarioCampos.imprimir"));
	}
	
	/**
	 * 
	 */
	private void initEvents() {
		ActionListener actionListener = new DlgGlosarioCamposListener(this);
		
		btnBuscarGlosario.addActionListener(actionListener);
		btnBuscar.addActionListener(actionListener);
		btnAlta.addActionListener(actionListener);
		btnBaja.addActionListener(actionListener);
		btnModificacion.addActionListener(actionListener);
		btnImprimir.addActionListener(actionListener);
	}
	
	/**
	 * 
	 */
	private void initialState() {
		// TODO Auto-generated method stub
		
	}
}