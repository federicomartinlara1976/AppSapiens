/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sapiens.app.ui.validacionscripts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;

import com.sapiens.app.ui.listener.PanelPrincipalActionListener;
import com.sapiens.app.ui.listener.PanelPrincipalChangeListener;
import com.sapiens.app.utils.Constants;

import lombok.Getter;

/**
 *
 * @author federico
 */
public class PanelPrincipal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3533639441146450519L;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JButton btnLimpiarTodo;
	private JButton btnLimpiarValidacion;
	private JButton btnLoadScript;
	private JButton btnValidar;
	private JButton btnSearch;
	
	@Getter
	private JComboBox<String> cmbSubModelo;
	
	
	private JLabel jLabel1;
	private JLabel jLabel10;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JPanel jPanel1;
	private JPanel jPanel10;
	private JPanel jPanel11;
	private JPanel jPanel12;
	private JPanel jPanel13;
	private JPanel jPanel14;
	private JPanel jPanel15;
	private JPanel jPanel16;
	private JPanel jPanel17;
	private JPanel jPanel18;
	private JPanel jPanel19;
	private JPanel jPanel2;
	private JPanel jPanel20;
	private JPanel jPanel21;
	private JPanel jPanel22;
	private JPanel jPanel23;
	private JPanel jPanel24;
	private JPanel jPanel25;
	private JPanel jPanel26;
	private JPanel jPanel27;
	private JPanel jPanel3;
	private JPanel jPanel4;
	private JPanel jPanel5;
	private JPanel jPanel6;
	private JPanel jPanel7;
	private JPanel jPanel8;
	private JPanel jPanel9;
	private JScrollPane jScrollPane1;
	
	@Getter
	private JTabbedPane jTabbedPane1;
	
	@Getter
	private JTextArea txtScript;
	
	@Getter
	private JTextField txtArchivoScript;
	
	@Getter
	private JTextField txtModuloProyecto;
	
	@Getter
	private JTextField txtIdGlosario;
	
	@Getter
	private JTextField txtGlosario;
	
	@Getter
	private JTextField txtIdNorma;
	
	@Getter
	private JTextField txtNorma;
	
	@Getter
	private JTextField txtIM;
	
	@Getter
	private JTextField txtSD;
	
	private JPanel panelBotones;
	private JPanel panelCabecera;
	private JPanel panelContenido;
	private JPanel panelLogotipo;
	private JPanel panelOpciones;
	private JPanel panelResultado;
	// End of variables declaration//GEN-END:variables
	
	@Getter
	private JFrame frameParent;

	/**
	 * Creates new form PanelPrincipal
	 */
	public PanelPrincipal(JFrame frameParent) {
		this.frameParent = frameParent;
		initComponents();
		initEvents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		GridBagConstraints gridBagConstraints;

		panelCabecera = new JPanel();
		panelLogotipo = new PanelLogotipo("logotipo.png");
		jLabel1 = new JLabel();
		panelContenido = new JPanel();
		panelOpciones = new JPanel();
		jPanel9 = new JPanel();
		jPanel13 = new JPanel();
		jLabel5 = new JLabel();
		jPanel14 = new JPanel();
		txtModuloProyecto = new JTextField();
		jPanel15 = new JPanel();
		btnSearch = new JButton();
		jPanel16 = new JPanel();
		jLabel6 = new JLabel();
		jPanel17 = new JPanel();
		txtIdGlosario = new JTextField();
		jPanel18 = new JPanel();
		txtGlosario = new JTextField();
		jPanel2 = new JPanel();
		jPanel19 = new JPanel();
		jLabel7 = new JLabel();
		jPanel20 = new JPanel();
		cmbSubModelo = new JComboBox<>();
		jPanel21 = new JPanel();
		jLabel8 = new JLabel();
		jPanel22 = new JPanel();
		txtIdNorma = new JTextField();
		jPanel23 = new JPanel();
		txtNorma = new JTextField();
		jPanel3 = new JPanel();
		jLabel9 = new JLabel();
		txtIM = new JTextField();
		jLabel10 = new JLabel();
		txtSD = new JTextField();
		jPanel4 = new JPanel();
		jPanel12 = new JPanel();
		jLabel4 = new JLabel();
		jPanel10 = new JPanel();
		txtArchivoScript = new JTextField();
		jPanel11 = new JPanel();
		btnLoadScript = new JButton();
		jPanel5 = new JPanel();
		jPanel6 = new JPanel();
		jLabel3 = new JLabel();
		jPanel7 = new JPanel();
		jScrollPane1 = new JScrollPane();
		txtScript = new JTextArea();
		jPanel8 = new JPanel();
		btnValidar = new JButton();
		panelResultado = new JPanel();
		jTabbedPane1 = new JTabbedPane();
		jPanel1 = new JPanel();
		jPanel24 = new JPanel();
		jPanel25 = new JPanel();
		jPanel26 = new JPanel();
		jPanel27 = new JPanel();
		jLabel2 = new JLabel();
		panelBotones = new JPanel();
		btnLimpiarValidacion = new JButton();
		btnLimpiarTodo = new JButton();

		setLayout(new BorderLayout());

		panelCabecera.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));

		panelLogotipo.setPreferredSize(new Dimension(286, 63));

		GroupLayout panelLogotipoLayout = new GroupLayout(panelLogotipo);
		panelLogotipo.setLayout(panelLogotipoLayout);
		panelLogotipoLayout.setHorizontalGroup(
				panelLogotipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 286, Short.MAX_VALUE));
		panelLogotipoLayout.setVerticalGroup(
				panelLogotipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 63, Short.MAX_VALUE));

		panelCabecera.add(panelLogotipo);

		jLabel1.setFont(new Font("Dialog", 1, 24)); // NOI18N
		jLabel1.setText("Validador de scripts");
		panelCabecera.add(jLabel1);

		add(panelCabecera, BorderLayout.PAGE_START);

		panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.PAGE_AXIS));

		panelOpciones.setLayout(new GridBagLayout());

		jPanel9.setLayout(new GridBagLayout());

		jLabel5.setText("Módulo o Proyecto");
		jPanel13.add(jLabel5);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		jPanel9.add(jPanel13, gridBagConstraints);

		jPanel14.setLayout(new BorderLayout());
		jPanel14.add(txtModuloProyecto, BorderLayout.CENTER);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.weightx = 80.0;
		jPanel9.add(jPanel14, gridBagConstraints);

		btnSearch.setName(Constants.PANEL_PRINCIPAL_BTN_SEARCH);
		btnSearch.setIcon(new ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
		jPanel15.add(btnSearch);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		jPanel9.add(jPanel15, gridBagConstraints);

		jPanel16.setLayout(new FlowLayout(FlowLayout.RIGHT));

		jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel6.setText("Glosario");
		jPanel16.add(jLabel6);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		jPanel9.add(jPanel16, gridBagConstraints);

		jPanel17.setLayout(new BorderLayout());

		txtIdGlosario.setPreferredSize(new Dimension(45, 21));
		jPanel17.add(txtIdGlosario, BorderLayout.CENTER);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		jPanel9.add(jPanel17, gridBagConstraints);

		jPanel18.setLayout(new BorderLayout());
		jPanel18.add(txtGlosario, BorderLayout.CENTER);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.weightx = 60.0;
		jPanel9.add(jPanel18, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.weightx = 80.0;
		panelOpciones.add(jPanel9, gridBagConstraints);

		jPanel2.setLayout(new GridBagLayout());

		jLabel7.setText("Submodelo");
		jPanel19.add(jLabel7);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		jPanel2.add(jPanel19, gridBagConstraints);

		jPanel20.setPreferredSize(new Dimension(150, 26));
		jPanel20.setLayout(new BorderLayout());

		cmbSubModelo.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		cmbSubModelo.setMinimumSize(new Dimension(150, 26));
		cmbSubModelo.setPreferredSize(new Dimension(150, 26));
		jPanel20.add(cmbSubModelo, BorderLayout.CENTER);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 60.0;
		jPanel2.add(jPanel20, gridBagConstraints);

		jLabel8.setText("Norma");
		jPanel21.add(jLabel8);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		jPanel2.add(jPanel21, gridBagConstraints);

		jPanel22.setLayout(new BorderLayout());

		txtIdNorma.setPreferredSize(new Dimension(45, 21));
		jPanel22.add(txtIdNorma, BorderLayout.CENTER);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		jPanel2.add(jPanel22, gridBagConstraints);

		jPanel23.setLayout(new BorderLayout());
		jPanel23.add(txtNorma, BorderLayout.CENTER);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		jPanel2.add(jPanel23, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.weightx = 50.0;
		panelOpciones.add(jPanel2, gridBagConstraints);

		jLabel9.setText("IM");
		jLabel9.setHorizontalTextPosition(SwingConstants.RIGHT);
		jPanel3.add(jLabel9);

		txtIM.setPreferredSize(new Dimension(100, 21));
		jPanel3.add(txtIM);

		jLabel10.setText("SD");
		jLabel10.setHorizontalTextPosition(SwingConstants.RIGHT);
		jPanel3.add(jLabel10);

		txtSD.setPreferredSize(new Dimension(100, 21));
		jPanel3.add(txtSD);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.ipadx = 50;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.weightx = 33.0;
		panelOpciones.add(jPanel3, gridBagConstraints);

		jPanel4.setLayout(new BorderLayout());

		jLabel4.setText("Archivo con el script");
		jPanel12.add(jLabel4);

		jPanel4.add(jPanel12, BorderLayout.WEST);

		jPanel10.setLayout(new BorderLayout());
		jPanel10.add(txtArchivoScript, BorderLayout.PAGE_START);

		jPanel4.add(jPanel10, BorderLayout.CENTER);

		btnLoadScript.setName(Constants.PANEL_PRINCIPAL_BTN_LOAD_SCRIPT);
		btnLoadScript.setIcon(new ImageIcon(getClass().getResource("/folder.png"))); // NOI18N
		btnLoadScript.setPreferredSize(new Dimension(32, 32));
		jPanel11.add(btnLoadScript);

		jPanel4.add(jPanel11, BorderLayout.EAST);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		panelOpciones.add(jPanel4, gridBagConstraints);

		jPanel5.setLayout(new GridBagLayout());

		jLabel3.setText("Script");
		jPanel6.add(jLabel3);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 3.0;
		jPanel5.add(jPanel6, gridBagConstraints);

		jPanel7.setLayout(new BorderLayout());

		txtScript.setColumns(20);
		txtScript.setRows(5);
		jScrollPane1.setViewportView(txtScript);

		jPanel7.add(jScrollPane1, BorderLayout.CENTER);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridheight = 3;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 60.0;
		jPanel5.add(jPanel7, gridBagConstraints);

		btnValidar.setName(Constants.PANEL_PRINCIPAL_BTN_VALIDAR);
		btnValidar.setText("Validar");
		btnValidar.setHorizontalAlignment(SwingConstants.LEFT);
		btnValidar.setPreferredSize(new Dimension(77, 20));
		jPanel8.add(btnValidar);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = GridBagConstraints.PAGE_END;
		gridBagConstraints.weightx = 1.0;
		jPanel5.add(jPanel8, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 99.0;
		panelOpciones.add(jPanel5, gridBagConstraints);

		panelContenido.add(panelOpciones);

		panelResultado.setLayout(new BorderLayout());

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1015, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 374, Short.MAX_VALUE));

		jTabbedPane1.addTab("Elementos a Validar", jPanel1);

		GroupLayout jPanel24Layout = new GroupLayout(jPanel24);
		jPanel24.setLayout(jPanel24Layout);
		jPanel24Layout.setHorizontalGroup(
				jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1015, Short.MAX_VALUE));
		jPanel24Layout.setVerticalGroup(
				jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 374, Short.MAX_VALUE));

		jTabbedPane1.addTab("Elementos Correctos", jPanel24);

		GroupLayout jPanel25Layout = new GroupLayout(jPanel25);
		jPanel25.setLayout(jPanel25Layout);
		jPanel25Layout.setHorizontalGroup(
				jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1015, Short.MAX_VALUE));
		jPanel25Layout.setVerticalGroup(
				jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 374, Short.MAX_VALUE));

		jTabbedPane1.addTab("Elementos que No Están en Glosario", jPanel25);

		GroupLayout jPanel26Layout = new GroupLayout(jPanel26);
		jPanel26.setLayout(jPanel26Layout);
		jPanel26Layout.setHorizontalGroup(
				jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1015, Short.MAX_VALUE));
		jPanel26Layout.setVerticalGroup(
				jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 374, Short.MAX_VALUE));

		jTabbedPane1.addTab("Elementos con Errores", jPanel26);

		GroupLayout jPanel27Layout = new GroupLayout(jPanel27);
		jPanel27.setLayout(jPanel27Layout);
		jPanel27Layout.setHorizontalGroup(
				jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1015, Short.MAX_VALUE));
		jPanel27Layout.setVerticalGroup(
				jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 374, Short.MAX_VALUE));

		jTabbedPane1.addTab("Excepciones", jPanel27);

		panelResultado.add(jTabbedPane1, BorderLayout.CENTER);

		jLabel2.setText("Resultado validación");
		panelResultado.add(jLabel2, BorderLayout.PAGE_START);

		panelContenido.add(panelResultado);

		add(panelContenido, BorderLayout.CENTER);

		panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		btnLimpiarValidacion.setName(Constants.PANEL_PRINCIPAL_BTN_LIMPIAR_VALIDACION);
		btnLimpiarValidacion.setText("Limpiar validación");
		panelBotones.add(btnLimpiarValidacion);

		btnLimpiarTodo.setName(Constants.PANEL_PRINCIPAL_BTN_LIMPIAR_TODO);
		btnLimpiarTodo.setText("Limpiar todo");
		btnLimpiarTodo.setPreferredSize(new Dimension(146, 27));
		panelBotones.add(btnLimpiarTodo);

		add(panelBotones, BorderLayout.PAGE_END);
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * 
	 */
	private void initEvents() {
		ActionListener actionListener = new PanelPrincipalActionListener(this);
		ChangeListener changeListener = new PanelPrincipalChangeListener(this);
		
		btnSearch.addActionListener(actionListener);
		btnLoadScript.addActionListener(actionListener);
		btnSearch.addActionListener(actionListener);
		btnLimpiarTodo.addActionListener(actionListener);
		btnLimpiarValidacion.addActionListener(actionListener);
		
//		jComboBox1.addItemListener(new ItemListener() {
//		    public void itemStateChanged(ItemEvent event) {
//		    	String item = (String) event.getItem();
//		    	LogWrapper.debug(log, "%s", item);
//		    }
//		});

		jTabbedPane1.addChangeListener(changeListener);
	}
}
