package com.mdval.ui.normasnomenclatura;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionListener;

import com.mdval.bussiness.entities.Norma;
import com.mdval.ui.listener.FrmDefinicionNormasListener;
import com.mdval.ui.listener.FrmDefinicionNormasTableListener;
import com.mdval.ui.model.DefinicionNormasTableModel;
import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.renderer.DateRenderer;
import com.mdval.ui.renderer.IntegerRenderer;
import com.mdval.ui.renderer.StringRenderer;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.Constants;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author federico
 */
public class FrmDefinicionNormas extends FrameSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2597426276424164862L;

	private JButton btnAlta;
	private JButton btnBuscar;
	
	@Getter
	private JButton btnModificacion;
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	
	private JScrollPane jScrollPane1;
	
	@Getter
	private JTable tblNormas;
	
	@Getter
	private JTextField txtNorma;
	
	@Getter
	@Setter
	private Norma seleccionada;

	/**
	 * Creates new form DlgDefinicionNormas
	 */
	public FrmDefinicionNormas() {
		super();
	}

	/**
	 *
	 */
	protected void setupComponents() {

		jLabel1 = new JLabel();
		txtNorma = new JTextField();
		jLabel2 = new JLabel();
		btnBuscar = new JButton();
		jScrollPane1 = new JScrollPane();
		tblNormas = new JTable();
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

		txtNorma.setPreferredSize(new Dimension(64, 27));

		jScrollPane1.setViewportView(tblNormas);

		btnAlta.setPreferredSize(new Dimension(130, 27));
		btnModificacion.setPreferredSize(new Dimension(130, 27));
		
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
												.addGroup(layout.createSequentialGroup().addGap(25, 25, 25)
														.addComponent(jLabel2)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(txtNorma, GroupLayout.PREFERRED_SIZE, 280,
																GroupLayout.PREFERRED_SIZE)))
										.addGap(0, 163, Short.MAX_VALUE))
								.addGroup(GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
												.addComponent(btnAlta, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnModificacion)))
						.addContainerGap())
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addContainerGap(565, Short.MAX_VALUE)
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
						txtNorma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
		setTitle(literales.getLiteral("frmDefinicionNormas.titulo"));
		
		jLabel1.setText(literales.getLiteral("frmDefinicionNormas.titulo"));
		jLabel2.setText(literales.getLiteral("frmDefinicionNormas.norma"));

		btnBuscar.setText(literales.getLiteral("frmDefinicionNormas.buscar"));
		btnAlta.setText(literales.getLiteral("frmDefinicionNormas.alta"));
		btnModificacion.setText(literales.getLiteral("frmDefinicionNormas.modificacion"));
	}

	@Override
	protected void initEvents() {
		ActionListener listener = new FrmDefinicionNormasListener(this);
		ListSelectionListener listSelectionListener = new FrmDefinicionNormasTableListener(this);
		
		btnBuscar.setActionCommand(Constants.FRM_DEFINICION_NORMAS_BTN_BUSCAR);
		btnAlta.setActionCommand(Constants.FRM_DEFINICION_NORMAS_BTN_ALTA);
		btnModificacion.setActionCommand(Constants.FRM_DEFINICION_NORMAS_BTN_MODIFICACION);
		
		btnBuscar.addActionListener(listener);
		btnAlta.addActionListener(listener);
		btnModificacion.addActionListener(listener);
		
		ListSelectionModel rowSM = tblNormas.getSelectionModel();
		rowSM.addListSelectionListener(listSelectionListener);
	}

	@Override
	protected void initialState() {
		tblNormas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblNormas.setDefaultRenderer(Date.class, new DateRenderer());
		tblNormas.setDefaultRenderer(String.class, new StringRenderer());
		
		Cabecera cabecera = UIHelper.createCabeceraTabla(Constants.FRM_DEFINICION_NORMAS_TABLA_NORMAS_CABECERA);
		tblNormas.setModel(new DefinicionNormasTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
	}

	@Override
	protected void initModels() {
		btnModificacion.setEnabled(Boolean.FALSE);
	}
}
