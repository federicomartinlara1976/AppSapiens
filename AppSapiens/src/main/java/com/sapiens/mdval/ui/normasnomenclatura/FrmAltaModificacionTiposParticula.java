package com.sapiens.mdval.ui.normasnomenclatura;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.sapiens.mdval.ui.utils.FrameSupport;

import lombok.Getter;

/**
 *
 * @author federico
 */
public class FrmAltaModificacionTiposParticula extends FrameSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 69380158124292971L;

	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	
	@Getter
	private JCheckBox chkDistingueProyecto;
	
	@Getter
	private JTextField txtCodigo;
	
	@Getter
	private JTextField txtDescripcion;
	
	@Getter
	private JTextField txtFecha;
	
	@Getter
	private JTextField txtUsuario;
	
	
	private Map<String, Object> params;

	/**
	 * Creates new form DlgAltaModificacionGlosarios
	 */
	public FrmAltaModificacionTiposParticula() {
		super();
	}
	
	/**
	 * @param params
	 */
	public FrmAltaModificacionTiposParticula(Map<String, Object> params) {
        super();
        this.params = params;
    }

	/**
	 *
	 */
	protected void setupComponents() {

		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		txtCodigo = new JTextField();
		jLabel3 = new JLabel();
		txtDescripcion = new JTextField();
		jLabel4 = new JLabel();
		txtUsuario = new JTextField();
		jLabel5 = new JLabel();
		txtFecha = new JTextField();
		btnAceptar = new JButton();
		btnCancelar = new JButton();
		jLabel6 = new JLabel();
		chkDistingueProyecto = new JCheckBox();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		panelLogo.setPreferredSize(new Dimension(286, 63));

		GroupLayout panelLogoLayout = new GroupLayout(panelLogo);
		panelLogo.setLayout(panelLogoLayout);
		panelLogoLayout.setHorizontalGroup(
				panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 274, Short.MAX_VALUE));
		panelLogoLayout.setVerticalGroup(
				panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 63, Short.MAX_VALUE));

		jLabel1.setFont(new Font("Dialog", 1, 18)); // NOI18N
		
		jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel2.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabel2.setPreferredSize(new Dimension(150, 17));

		txtCodigo.setEditable(false);
		txtCodigo.setEnabled(false);
		txtCodigo.setMinimumSize(new Dimension(4, 27));
		txtCodigo.setPreferredSize(new Dimension(80, 27));

		jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel3.setPreferredSize(new Dimension(150, 17));

		txtDescripcion.setPreferredSize(new Dimension(400, 27));

		jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel4.setPreferredSize(new Dimension(150, 17));

		txtUsuario.setEditable(false);
		txtUsuario.setEnabled(false);
		txtUsuario.setPreferredSize(new Dimension(150, 27));

		jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel5.setPreferredSize(new Dimension(150, 17));

		txtFecha.setEditable(false);
		txtFecha.setEnabled(false);
		txtFecha.setPreferredSize(new Dimension(150, 27));

		btnAceptar.setPreferredSize(new Dimension(98, 27));
		
		chkDistingueProyecto.setPreferredSize(new Dimension(27, 27));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
												.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnCancelar))
								.addGroup(layout.createSequentialGroup().addGroup(layout
										.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, 274,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jLabel1))
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 78,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel6))
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 566,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(chkDistingueProyecto, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(layout.createSequentialGroup()
												.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 200,
														GroupLayout.PREFERRED_SIZE)
												.addGap(44, 44, 44)
												.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 40,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, 200,
														GroupLayout.PREFERRED_SIZE)))
										.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel1))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel6).addComponent(
						chkDistingueProyecto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(41, 41, 41)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
				.addGroup(layout
						.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnAceptar,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar))
				.addContainerGap()));
	}

	@Override
	protected void setupLiterals() {
		setTitle("Alta/Modificación de Tipos de Partícula");
		
		jLabel1.setText("Alta/Modificación de Tipos de Partícula");
		jLabel2.setText("Código:");
		jLabel3.setText("Descripción:");
		jLabel4.setText("Usuario:");
		jLabel5.setText("Fecha:");
		jLabel6.setText("Distingue por Proyecto:");
		
		btnAceptar.setText("ACEPTAR");
		btnCancelar.setText("CANCELAR");
	}
	
	@Override
	protected void initEvents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialState() {
		// TODO Auto-generated method stub
		
	}
}
