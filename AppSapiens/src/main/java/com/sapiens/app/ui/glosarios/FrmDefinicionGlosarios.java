/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sapiens.app.ui.glosarios;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.sapiens.app.ui.listener.FrmDefinicionGlosariosListener;
import com.sapiens.app.ui.utils.FrameSupport;
import com.sapiens.app.utils.Constants;

import lombok.Getter;

/**
 *
 * @author federico
 */
public class FrmDefinicionGlosarios extends FrameSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2850927235862482216L;

	private JButton btnAlta;
	private JButton btnBuscar;
	private JButton btnModificacion;
	private JButton btnSeleccionar;
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JScrollPane jScrollPane1;
	
	@Getter
	private JTable tblGlosarios;
	
	@Getter
	private JTextField txtGlosario;
	
	@Getter
	private JFrame frameParent;

	/**
	 * Creates new form DlgDefinicionGlosarios
	 */
	public FrmDefinicionGlosarios() {
		super();
	}

	protected void initComponents() {

		txtGlosario = new JTextField();
		jLabel1 = new JLabel();
		btnBuscar = new JButton();
		btnAlta = new JButton();
		btnModificacion = new JButton();
		btnSeleccionar = new JButton();
		jLabel2 = new JLabel();
		jScrollPane1 = new JScrollPane();
		tblGlosarios = new JTable();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		panelLogo.setPreferredSize(new Dimension(286, 63));

		GroupLayout panelLogoLayout = new GroupLayout(panelLogo);
		panelLogo.setLayout(panelLogoLayout);
		panelLogoLayout.setHorizontalGroup(
				panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 286, Short.MAX_VALUE));
		panelLogoLayout.setVerticalGroup(
				panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 63, Short.MAX_VALUE));

		txtGlosario.setMinimumSize(new Dimension(4, 27));
		txtGlosario.setPreferredSize(new Dimension(300, 27));

		jLabel1.setFont(new Font("Dialog", 1, 18)); // NOI18N
		
		btnAlta.setPreferredSize(new Dimension(130, 27));
		btnSeleccionar.setPreferredSize(new Dimension(130, 27));

		tblGlosarios
				.setModel(new DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(tblGlosarios);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(jScrollPane1)
										.addGroup(GroupLayout.Alignment.LEADING,
												layout.createSequentialGroup()
														.addComponent(panelLogo, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jLabel1).addGap(0, 0, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
												.addComponent(btnAlta, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnModificacion).addGap(18, 18, 18)
												.addComponent(
														btnSeleccionar, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(GroupLayout.Alignment.LEADING,
												layout.createSequentialGroup().addGap(168, 168, 168)
														.addComponent(jLabel2)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(txtGlosario, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 516,
																Short.MAX_VALUE)
														.addComponent(btnBuscar)))
								.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txtGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2).addComponent(btnBuscar))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jScrollPane1)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btnSeleccionar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnModificacion).addComponent(btnAlta, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		pack();
	}

	/**
	 * @throws IOException
	 */
	protected void setupLiterals() {
		setTitle(literales.getLiteral("dlgDefinicionGlosarios.titulo"));
		
		jLabel1.setText("Definición de Glosarios");
		jLabel2.setText("Glosario:");
		
		btnBuscar.setText("BUSCAR");
		btnAlta.setText("ALTA");
		btnModificacion.setText("MODIFICACION");
		btnSeleccionar.setText("SELECCIONAR");
	}

	/**
	 * 
	 */
	protected void initEvents() {
		ActionListener actionListener = new FrmDefinicionGlosariosListener(this);

		btnAlta.setName(Constants.DLG_DEFINICION_GLOSARIOS_BTN_ALTA);
		btnModificacion.setName(Constants.DLG_DEFINICION_GLOSARIOS_BTN_MODIFICACION);
		btnSeleccionar.setName(Constants.DLG_DEFINICION_GLOSARIOS_BTN_SELECCIONAR);
		
		btnAlta.addActionListener(actionListener);
		btnModificacion.addActionListener(actionListener);
		btnSeleccionar.addActionListener(actionListener);
	}

	/**
	 * 
	 */
	protected void initialState() {
		// TODO Auto-generated method stub

	}
}
