package com.mdval.ui.consultas;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.math.BigDecimal;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.entities.SubProyecto;
import com.mdval.bussiness.entities.TipoElemento;
import com.mdval.ui.listener.FrmComprobacionNombreElementoListener;
import com.mdval.ui.model.ValidaParticulaTableModel;
import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.renderer.BigDecimalRenderer;
import com.mdval.ui.renderer.StringRenderer;
import com.mdval.ui.renderer.SubProyectoRenderer;
import com.mdval.ui.renderer.TipoElementoRenderer;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.ui.utils.TableSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.Constants;

import lombok.Getter;

/**
 *
 * @author federico
 */
public class FrmComprobacionNombreElemento extends FrameSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2718727106396297482L;

	@Getter
	private JButton btnBuscar;
	
	@Getter
	private JButton btnComprobar;

	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JLabel jLabel10;

	private JPanel jPanel1;

	private JScrollPane jScrollPane1;
	
	@Getter
	private TableSupport tblValidaParticula;

	@Getter
	private JComboBox<TipoElemento> cmbElemento;

	@Getter
	private JComboBox<SubProyecto> cmbSubmodelo;

	@Getter
	private JTextField txtCodGlosario;

	@Getter
	private JTextField txtCodNorma;

	@Getter
	private JTextField txtDescGlosario;

	@Getter
	private JTextField txtDescNorma;

	@Getter
	private JTextField txtExpresionRegular;

	@Getter
	private JTextField txtModeloProyecto;

	@Getter
	private JTextField txtNombreComprobar;

	@Getter
	private JTextField txtTamMaximo;

	/**
	 * Creates new form DlgModificacionNormas
	 */
	public FrmComprobacionNombreElemento() {
		super();
	}

	/**
	 * 
	 */
	protected void setupComponents() {

		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		txtModeloProyecto = new JTextField();
		txtNombreComprobar = new JTextField();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		cmbSubmodelo = new JComboBox<>();
		jLabel7 = new JLabel();
		cmbElemento = new JComboBox<>();
		btnBuscar = new JButton();
		jLabel1 = new JLabel();
		jLabel4 = new JLabel();
		txtCodNorma = new JTextField();
		txtDescNorma = new JTextField();
		jLabel8 = new JLabel();
		txtCodGlosario = new JTextField();
		txtDescGlosario = new JTextField();
		jScrollPane1 = new JScrollPane();
		tblValidaParticula = new TableSupport(Boolean.FALSE);
		txtTamMaximo = new JTextField();
		txtExpresionRegular = new JTextField();
		jLabel9 = new JLabel();
		jLabel10 = new JLabel();
		jPanel1 = new JPanel();
		btnComprobar = new JButton();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(1366, 768));
		
		panelLogo.setPreferredSize(new Dimension(286, 63));

		GroupLayout panelLogoLayout = new GroupLayout(panelLogo);
		panelLogo.setLayout(panelLogoLayout);
		panelLogoLayout.setHorizontalGroup(
				panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 286, Short.MAX_VALUE));
		panelLogoLayout.setVerticalGroup(
				panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 67, Short.MAX_VALUE));

		txtModeloProyecto.setPreferredSize(new Dimension(4, 27));

		txtNombreComprobar.setMinimumSize(new Dimension(4, 27));
		txtNombreComprobar.setPreferredSize(new Dimension(64, 27));

		btnBuscar.setIcon(new ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N

		jLabel1.setFont(new Font("Dialog", 1, 18)); // NOI18N

		txtCodNorma.setEditable(false);
		txtCodNorma.setEnabled(false);
		txtCodNorma.setPreferredSize(new Dimension(4, 27));

		txtDescNorma.setEditable(false);
		txtDescNorma.setEnabled(false);
		txtDescNorma.setMinimumSize(new Dimension(4, 27));
		txtDescNorma.setPreferredSize(new Dimension(64, 27));

		txtCodGlosario.setEditable(false);
		txtCodGlosario.setEnabled(false);
		txtCodGlosario.setPreferredSize(new Dimension(4, 27));

		txtDescGlosario.setEditable(false);
		txtDescGlosario.setEnabled(false);
		txtDescGlosario.setMinimumSize(new Dimension(4, 27));
		txtDescGlosario.setPreferredSize(new Dimension(64, 27));

		jScrollPane1.setViewportView(tblValidaParticula);

		txtTamMaximo.setEditable(false);
		txtTamMaximo.setEnabled(false);
		txtTamMaximo.setPreferredSize(new Dimension(4, 27));

		txtExpresionRegular.setEditable(false);
		txtExpresionRegular.setEnabled(false);
		txtExpresionRegular.setMinimumSize(new Dimension(4, 27));
		txtExpresionRegular.setPreferredSize(new Dimension(64, 27));

		jPanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

		jPanel1.add(btnComprobar);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1))
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(panelLogo,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
										.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 418,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
														.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 722,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(layout.createSequentialGroup().addGroup(layout
																.createParallelGroup(GroupLayout.Alignment.TRAILING)
																.addComponent(jLabel7).addComponent(jLabel3)
																.addComponent(jLabel2).addComponent(jLabel4)
																.addComponent(jLabel8).addComponent(jLabel9)
																.addComponent(jLabel10))
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(layout
																		.createParallelGroup(
																				GroupLayout.Alignment.LEADING, false)
																		.addGroup(layout.createSequentialGroup()
																				.addComponent(txtModeloProyecto,
																						GroupLayout.PREFERRED_SIZE, 212,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						LayoutStyle.ComponentPlacement.UNRELATED)
																				.addComponent(btnBuscar)
																				.addPreferredGap(
																						LayoutStyle.ComponentPlacement.RELATED,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(jLabel6)
																				.addPreferredGap(
																						LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(cmbSubmodelo,
																						GroupLayout.PREFERRED_SIZE, 198,
																						GroupLayout.PREFERRED_SIZE))
																		.addComponent(cmbElemento, 0,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(txtNombreComprobar,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGroup(layout.createSequentialGroup()
																				.addComponent(txtCodNorma,
																						GroupLayout.PREFERRED_SIZE, 66,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						LayoutStyle.ComponentPlacement.UNRELATED)
																				.addComponent(txtDescNorma,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE))
																		.addGroup(layout.createSequentialGroup()
																				.addComponent(txtCodGlosario,
																						GroupLayout.PREFERRED_SIZE, 131,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						LayoutStyle.ComponentPlacement.UNRELATED)
																				.addComponent(txtDescGlosario,
																						GroupLayout.PREFERRED_SIZE, 435,
																						GroupLayout.PREFERRED_SIZE))
																		.addComponent(txtExpresionRegular,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(txtTamMaximo,
																				GroupLayout.PREFERRED_SIZE, 42,
																				GroupLayout.PREFERRED_SIZE))))
												.addGap(1, 1, 1))))
								.addGroup(layout.createSequentialGroup().addGap(35, 35, 35).addComponent(jLabel5)))
								.addGap(0, 0, Short.MAX_VALUE)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jLabel1)
						.addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
				.addGap(12, 12, 12)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(btnBuscar)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txtModeloProyecto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel6)
								.addComponent(cmbSubmodelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel7).addComponent(
						cmbElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombreComprobar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(26, 26, 26)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel4)
						.addComponent(txtCodNorma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDescNorma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel8)
						.addComponent(txtCodGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDescGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(txtTamMaximo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel9))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(txtExpresionRegular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel10))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel5)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE).addContainerGap()));
	}

	@Override
	protected void setupLiterals() {
		setTitle(literales.getLiteral("frmComprobacionNombreElemento.titulo"));

		jLabel1.setText(literales.getLiteral("frmComprobacionNombreElemento.titulo"));
		jLabel2.setText(literales.getLiteral("frmComprobacionNombreElemento.modeloProyecto"));
		jLabel3.setText(literales.getLiteral("frmComprobacionNombreElemento.nombreComprobar"));
		jLabel4.setText(literales.getLiteral("frmComprobacionNombreElemento.norma"));
		jLabel5.setText(literales.getLiteral("frmComprobacionNombreElemento.resultadoComprobacion"));
		jLabel6.setText(literales.getLiteral("frmComprobacionNombreElemento.submodelo"));
		jLabel7.setText(literales.getLiteral("frmComprobacionNombreElemento.elemento"));
		jLabel8.setText(literales.getLiteral("frmComprobacionNombreElemento.glosario"));
		jLabel9.setText(literales.getLiteral("frmComprobacionNombreElemento.tamMaximo"));
		jLabel10.setText(literales.getLiteral("frmComprobacionNombreElemento.expresionRegular"));

		btnComprobar.setText(literales.getLiteral("frmComprobacionNombreElemento.comprobar"));
	}

	@Override
	protected void initEvents() {
		FrmComprobacionNombreElementoListener listener = new FrmComprobacionNombreElementoListener(this);
		
		btnBuscar.setActionCommand(Constants.FRM_COMPROBACION_NOMBRE_ELEMENTO_BTN_BUSCAR);
		btnComprobar.setActionCommand(Constants.FRM_COMPROBACION_NOMBRE_ELEMENTO_BTN_COMPROBAR);

		btnBuscar.addActionListener(listener);
		btnComprobar.addActionListener(listener);
		
		this.addOnLoadListener(listener);
	}

	@Override
	protected void initialState() {
		txtNombreComprobar.setText(StringUtils.EMPTY);
	}

	@Override
	protected void initModels() {
		cmbSubmodelo.setRenderer(new SubProyectoRenderer());
		cmbElemento.setRenderer(new TipoElementoRenderer());
		
		Cabecera cabecera = UIHelper.createCabeceraTabla(Constants.FRM_COMPROBACION_NOMBRE_ELEMENTO_TABLA_CABECERA);
		tblValidaParticula.setModel(new ValidaParticulaTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
		tblValidaParticula.setDefaultRenderer(BigDecimal.class, new BigDecimalRenderer());
		tblValidaParticula.setDefaultRenderer(String.class, new StringRenderer());
		tblValidaParticula.setColumnWidths(cabecera);
	}
}
