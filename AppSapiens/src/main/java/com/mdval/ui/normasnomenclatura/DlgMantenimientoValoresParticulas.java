package com.mdval.ui.normasnomenclatura;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.mdval.ui.utils.DialogSupport;

import lombok.Getter;

/**
 *
 * @author federico
 */
public class DlgMantenimientoValoresParticulas extends DialogSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4629194932255693532L;

	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	
	@Getter
	private JTextField txtCodigo;
	
	@Getter
	private JTextField txtDescripcion;
	
	@Getter
	private JTextField txtDescripcionValor;
	
	@Getter
	private JTextField txtPartPadre;
	
	@Getter
	private JTextField txtProyecto;
	
	@Getter
	private JTextField txtSubproyecto;
	
	@Getter
	private JTextField txtValor;
	
    
    public DlgMantenimientoValoresParticulas(JFrame parent, boolean modal) {
        super(parent, modal);
    }
    
    public DlgMantenimientoValoresParticulas(JFrame parent, boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }

	/**
	 * Creates new form DlgAltaModificacionGlosarios
	 */
	public DlgMantenimientoValoresParticulas() {
		super();
	}
	
	/**
	 * @param params
	 */
	public DlgMantenimientoValoresParticulas(Map<String, Object> params) {
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
		btnAceptar = new JButton();
		btnCancelar = new JButton();
		jLabel6 = new JLabel();
		txtValor = new JTextField();
		jLabel4 = new JLabel();
		txtDescripcionValor = new JTextField();
		jLabel5 = new JLabel();
		txtProyecto = new JTextField();
		txtSubproyecto = new JTextField();
		jLabel7 = new JLabel();
		txtPartPadre = new JTextField();
		jLabel8 = new JLabel();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(900, 321));
		
		panelLogo.setPreferredSize(new Dimension(286, 63));

		GroupLayout panelLogoLayout = new GroupLayout(panelLogo);
		panelLogo.setLayout(panelLogoLayout);
		panelLogoLayout.setHorizontalGroup(
				panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 274, Short.MAX_VALUE));
		panelLogoLayout.setVerticalGroup(
				panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 63, Short.MAX_VALUE));

		jLabel1.setFont(new Font("Dialog", 1, 18)); // NOI18N

		jLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel2.setHorizontalTextPosition(SwingConstants.LEFT);
		jLabel2.setPreferredSize(new Dimension(150, 17));

		txtCodigo.setEditable(false);
		txtCodigo.setEnabled(false);
		txtCodigo.setMinimumSize(new Dimension(4, 27));
		txtCodigo.setPreferredSize(new Dimension(80, 27));

		jLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel3.setHorizontalTextPosition(SwingConstants.LEFT);
		jLabel3.setPreferredSize(new Dimension(150, 17));

		txtDescripcion.setEditable(false);
		txtDescripcion.setEnabled(false);
		txtDescripcion.setPreferredSize(new Dimension(400, 27));

		btnAceptar.setPreferredSize(new Dimension(98, 27));

		jLabel6.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel6.setHorizontalTextPosition(SwingConstants.LEFT);

		txtValor.setPreferredSize(new Dimension(4, 27));

		jLabel4.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel4.setHorizontalTextPosition(SwingConstants.LEFT);
		jLabel4.setPreferredSize(new Dimension(150, 17));

		txtDescripcionValor.setPreferredSize(new Dimension(64, 27));

		jLabel5.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel5.setHorizontalTextPosition(SwingConstants.LEFT);

		txtProyecto.setPreferredSize(new Dimension(4, 27));

		txtSubproyecto.setPreferredSize(new Dimension(64, 27));

		jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel7.setHorizontalTextPosition(SwingConstants.LEFT);
		jLabel7.setPreferredSize(new Dimension(150, 17));

		txtPartPadre.setPreferredSize(new Dimension(4, 27));

		jLabel8.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel8.setHorizontalTextPosition(SwingConstants.LEFT);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(
										layout.createSequentialGroup()
												.addGroup(
														layout.createParallelGroup(GroupLayout.Alignment.TRAILING,
																false)
																.addComponent(
																		panelLogo, GroupLayout.PREFERRED_SIZE, 274,
																		GroupLayout.PREFERRED_SIZE)
																.addGroup(GroupLayout.Alignment.LEADING,
																		layout.createSequentialGroup().addGroup(layout
																				.createParallelGroup(
																						GroupLayout.Alignment.LEADING)
																				.addComponent(jLabel2,
																						GroupLayout.PREFERRED_SIZE, 48,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(jLabel6)
																				.addComponent(jLabel5)
																				.addComponent(jLabel8))
																				.addGap(20, 20, 20)
																				.addGroup(layout.createParallelGroup(
																						GroupLayout.Alignment.LEADING)
																						.addComponent(txtCodigo,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								txtValor,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								txtProyecto,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addGroup(layout
																								.createSequentialGroup()
																								.addComponent(
																										txtPartPadre,
																										GroupLayout.PREFERRED_SIZE,
																										44,
																										GroupLayout.PREFERRED_SIZE)
																								.addGap(0, 0,
																										Short.MAX_VALUE)))))
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(layout
														.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 75,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(20, 20, 20).addComponent(
																		txtDescripcion, GroupLayout.PREFERRED_SIZE, 385,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(layout.createSequentialGroup().addGroup(layout
																.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addComponent(jLabel1)
																.addGroup(layout.createSequentialGroup()
																		.addComponent(jLabel7,
																				GroupLayout.PREFERRED_SIZE, 75,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(20, 20, 20).addComponent(txtSubproyecto,
																				GroupLayout.PREFERRED_SIZE, 179,
																				GroupLayout.PREFERRED_SIZE)))
																.addGap(0, 0, Short.MAX_VALUE))
														.addGroup(layout.createSequentialGroup()
																.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 75,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(20, 20, 20).addComponent(txtDescripcionValor,
																		GroupLayout.PREFERRED_SIZE, 385,
																		GroupLayout.PREFERRED_SIZE))))
								.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(
										btnAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnCancelar).addGap(12, 12, 12)));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup()
						.addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel6)
								.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(
										txtDescripcionValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
								.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(txtSubproyecto, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(btnCancelar).addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(txtProyecto, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel5))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(txtPartPadre, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel8))))));
	}
	
	@Override
	protected void setupLiterals() {
		setTitle(literales.getLiteral("dlgMantenimientoValoresParticulas.titulo"));
		
		jLabel1.setText(literales.getLiteral("dlgMantenimientoValoresParticulas.titulo"));
		jLabel2.setText(literales.getLiteral("dlgMantenimientoValoresParticulas.codigo"));
		jLabel3.setText(literales.getLiteral("dlgMantenimientoValoresParticulas.descripcion"));
		jLabel4.setText(literales.getLiteral("dlgMantenimientoValoresParticulas.descripcion"));
		jLabel5.setText(literales.getLiteral("dlgMantenimientoValoresParticulas.proyecto"));
		jLabel6.setText(literales.getLiteral("dlgMantenimientoValoresParticulas.valor"));
		jLabel7.setText(literales.getLiteral("dlgMantenimientoValoresParticulas.subproyecto"));
		jLabel8.setText(literales.getLiteral("dlgMantenimientoValoresParticulas.partPadre"));
		
		btnAceptar.setText(literales.getLiteral("dlgMantenimientoValoresParticulas.aceptar"));
		btnCancelar.setText(literales.getLiteral("dlgMantenimientoValoresParticulas.cancelar"));
	}

	@Override
	protected void initEvents() {
		// TODO Auto-generated method stub
		
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
