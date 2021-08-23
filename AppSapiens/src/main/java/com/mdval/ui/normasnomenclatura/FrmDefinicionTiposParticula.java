package com.mdval.ui.normasnomenclatura;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.mdval.ui.listener.FrmDefinicionTiposParticulaListener;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.utils.Constants;

import lombok.Getter;

/**
 *
 * @author federico
 */
public class FrmDefinicionTiposParticula extends FrameSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3021149793159654449L;

	private JButton btnAlta;
	private JButton btnBuscar;
	private JButton btnModificacion;
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	
	private JScrollPane jScrollPane1;
	
	private JTable tblTiposParticula;
	
	@Getter
	private JTextField txtTipoParticula;

	/**
	 * Creates new form DlgDefinicionNormas
	 */
	public FrmDefinicionTiposParticula() {
		super();
	}

	/**
	 *
	 */
	protected void setupComponents() {

		jLabel1 = new JLabel();
		txtTipoParticula = new JTextField();
		jLabel2 = new JLabel();
		btnBuscar = new JButton();
		jScrollPane1 = new JScrollPane();
		tblTiposParticula = new JTable();
		btnAlta = new JButton();
		btnModificacion = new JButton();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		panelLogo.setPreferredSize(new Dimension(286, 63));

		GroupLayout panelLogoLayout = new GroupLayout(panelLogo);
		panelLogo.setLayout(panelLogoLayout);
		panelLogoLayout.setHorizontalGroup(
				panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 286, Short.MAX_VALUE));
		panelLogoLayout.setVerticalGroup(
				panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 63, Short.MAX_VALUE));

		jLabel1.setFont(new Font("Dialog", 1, 18)); // NOI18N

		txtTipoParticula.setPreferredSize(new Dimension(64, 27));

		tblTiposParticula.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null } },
				new String[] { "COD_PARTICULA", "DES_PARTICULA", "MCA_PROYECTO", "COD_USR", "FEC_ACTU" }) {
			Class[] types = new Class[] { java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.Object.class };
			boolean[] canEdit = new boolean[] { false, false, true, false, false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(tblTiposParticula);

		btnAlta.setPreferredSize(new Dimension(130, 27));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jScrollPane1)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addComponent(panelLogo, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jLabel1))
												.addGroup(layout.createSequentialGroup().addGap(64, 64, 64)
														.addComponent(jLabel2)
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(txtTipoParticula, GroupLayout.PREFERRED_SIZE, 280,
																GroupLayout.PREFERRED_SIZE)))
										.addGap(0, 428, Short.MAX_VALUE))
								.addGroup(GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
												.addComponent(btnAlta, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnModificacion)))
						.addContainerGap())
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addContainerGap(916, Short.MAX_VALUE)
								.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel1))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(
						txtTipoParticula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE).addGap(45, 45, 45))
				.addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(btnAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnModificacion))
								.addContainerGap())
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(81, 81, 81).addComponent(btnBuscar)
								.addContainerGap(428, Short.MAX_VALUE))));
	}
	
	@Override
	protected void setupLiterals() {
		setTitle("Definición de Tipos de Partícula");
		
		jLabel1.setText("Definición de Tipos de Partícula");
		jLabel2.setText("Tipo de Partícula");

		btnBuscar.setText("BUSCAR");
		btnAlta.setText("ALTA");
		btnModificacion.setText("MODIFICACION");
	}

	@Override
	protected void initEvents() {
		ActionListener listener = new FrmDefinicionTiposParticulaListener(this);
		
		btnAlta.setName(Constants.DLG_DEFINICION_TIPOS_PARTICULA_BTN_ALTA);
		btnModificacion.setName(Constants.DLG_DEFINICION_TIPOS_PARTICULA_BTN_MODIFICACION);
		
		btnAlta.addActionListener(listener);
		btnModificacion.addActionListener(listener);
	}

	@Override
	protected void initialState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initModels() {
		// TODO Auto-generated method stub
		
	}
}