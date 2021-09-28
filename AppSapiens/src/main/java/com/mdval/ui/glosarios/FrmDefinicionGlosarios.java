package com.mdval.ui.glosarios;

import java.awt.Dimension;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionListener;

import com.mdval.bussiness.entities.Glosario;
import com.mdval.ui.listener.FrmDefinicionGlosariosListener;
import com.mdval.ui.listener.tables.FrmDefinicionGlosariosTableListener;
import com.mdval.ui.model.DefinicionGlosariosTableModel;
import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.renderer.BigDecimalRenderer;
import com.mdval.ui.renderer.DateTimeRenderer;
import com.mdval.ui.renderer.IntegerRenderer;
import com.mdval.ui.renderer.StringRenderer;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.ui.utils.TableSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.Constants;

import lombok.Getter;
import lombok.Setter;

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
	
	@Getter
	private JButton btnModificacion;
	
	@Getter
	private JButton btnSeleccionar;

	private JLabel jLabel1;
	private JLabel jLabel2;
	private JScrollPane jScrollPane1;

	@Getter
	private TableSupport tblGlosarios;

	@Getter
	private JTextField txtGlosario;

	@Getter
	private FrmDefinicionGlosariosListener frmDefinicionGlosariosListener;
	
	@Getter
	@Setter
	private Glosario seleccionado;

	/**
	 * Creates new form DlgDefinicionGlosarios
	 */
	public FrmDefinicionGlosarios() {
		super();
	}

	protected void setupComponents() {

		txtGlosario = new JTextField();
		jLabel1 = new JLabel();
		btnBuscar = new JButton();
		btnAlta = new JButton();
		btnModificacion = new JButton();
		btnSeleccionar = new JButton();
		jLabel2 = new JLabel();
		jScrollPane1 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tblGlosarios = new TableSupport();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

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
	}

	/**
	 * 
	 */
	protected void setupLiterals() {
		setTitle(literales.getLiteral("frmDefinicionGlosarios.titulo"));

		jLabel1.setText(literales.getLiteral("frmDefinicionGlosarios.titulo"));
		jLabel2.setText(literales.getLiteral("frmDefinicionGlosarios.glosario"));

		btnBuscar.setText(literales.getLiteral("frmDefinicionGlosarios.buscar"));
		btnAlta.setText(literales.getLiteral("frmDefinicionGlosarios.alta"));
		btnModificacion.setText(literales.getLiteral("frmDefinicionGlosarios.modificacion"));
		btnSeleccionar.setText(literales.getLiteral("frmDefinicionGlosarios.seleccionar"));
	}

	/**
	 * 
	 */
	protected void initEvents() {
		frmDefinicionGlosariosListener = new FrmDefinicionGlosariosListener(this);
		ListSelectionListener listSelectionListener = new FrmDefinicionGlosariosTableListener(this);
		
		btnBuscar.setActionCommand(Constants.FRM_DEFINICION_GLOSARIOS_BTN_BUSCAR);
		btnAlta.setActionCommand(Constants.FRM_DEFINICION_GLOSARIOS_BTN_ALTA);
		btnModificacion.setActionCommand(Constants.FRM_DEFINICION_GLOSARIOS_BTN_MODIFICACION);
		btnSeleccionar.setActionCommand(Constants.FRM_DEFINICION_GLOSARIOS_BTN_SELECCIONAR);

		btnBuscar.addActionListener(frmDefinicionGlosariosListener);
		btnAlta.addActionListener(frmDefinicionGlosariosListener);
		btnModificacion.addActionListener(frmDefinicionGlosariosListener);
		btnSeleccionar.addActionListener(frmDefinicionGlosariosListener);
		
		ListSelectionModel rowSM = tblGlosarios.getSelectionModel();
		rowSM.addListSelectionListener(listSelectionListener);
	}

	/**
	 * 
	 */
	protected void initialState() {
		btnModificacion.setEnabled(Boolean.FALSE);
		btnSeleccionar.setEnabled(Boolean.FALSE);
	}

	/**
	 *
	 */
	@Override
	protected void initModels() {
		tblGlosarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblGlosarios.setDefaultRenderer(Integer.class, new IntegerRenderer());
		tblGlosarios.setDefaultRenderer(Date.class, new DateTimeRenderer());
		tblGlosarios.setDefaultRenderer(BigDecimal.class, new BigDecimalRenderer());
		tblGlosarios.setDefaultRenderer(String.class, new StringRenderer());
		
		Cabecera cabecera = UIHelper.createCabeceraTabla(Constants.FRM_DEFINICION_GLOSARIOS_TABLA_GLOSARIOS_CABECERA);
		tblGlosarios.setModel(new DefinicionGlosariosTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
	}
}
