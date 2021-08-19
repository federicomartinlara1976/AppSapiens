package com.sapiens.mdval.ui.glosarios;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.sapiens.mdval.ui.listener.FrmAltaModificacionCamposListener;
import com.sapiens.mdval.ui.model.SiNoComboBoxModel;
import com.sapiens.mdval.ui.utils.FrameSupport;
import com.sapiens.mdval.utils.Constants;

import lombok.Getter;

/**
 *
 * @author federico
 */
public class FrmAltaModificacionCampos extends FrameSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4170711147258972713L;

	private JButton btnAceptar;
	private JButton btnCancelar;
	
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
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	
	@Getter
	private JComboBox<String> cmbExcepcion;
	
	@Getter
	private JComboBox<String> cmbTipoDato;
	
	@Getter
	private JTextField txtDecimales;
	
	@Getter
	private JTextArea txtDescripcionExcepcion;
	
	@Getter
	private JTextField txtModificacion;
	
	@Getter
	private JTextField txtNombre;
	
	@Getter
	private JTextArea txtObservaciones;
	
	@Getter
	private JTextField txtTamanio;
	
	@Getter
	private JTextField txtUsuario;

	
	private Map<String, Object> params;

	/**
	 * Creates new form DlgAltaModificacionCampos
	 */
	public FrmAltaModificacionCampos() {
		super();
	}

	/**
	 * @param params
	 */
	public FrmAltaModificacionCampos(Map<String, Object> params) {
		super();
		this.params = params;
	}

	protected void setupComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        txtNombre = new JTextField();
        cmbTipoDato = new JComboBox<>();
        txtTamanio = new JTextField();
        txtDecimales = new JTextField();
        cmbExcepcion = new JComboBox<>();
        jScrollPane1 = new JScrollPane();
        txtDescripcionExcepcion = new JTextArea();
        jScrollPane2 = new JScrollPane();
        txtObservaciones = new JTextArea();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        txtUsuario = new JTextField();
        txtModificacion = new JTextField();
        btnCancelar = new JButton();
        btnAceptar = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        panelLogo.setPreferredSize(new Dimension(286, 63));

        GroupLayout panelLogoLayout = new GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        jLabel1.setFont(new Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel7.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel7.setHorizontalTextPosition(SwingConstants.RIGHT);

        jLabel8.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel8.setHorizontalTextPosition(SwingConstants.RIGHT);

        txtNombre.setPreferredSize(new Dimension(64, 27));

        cmbTipoDato.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtTamanio.setPreferredSize(new Dimension(64, 27));

        txtDecimales.setPreferredSize(new Dimension(64, 27));
        
        txtDescripcionExcepcion.setColumns(20);
        txtDescripcionExcepcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcionExcepcion);

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane2.setViewportView(txtObservaciones);

        jLabel9.setHorizontalAlignment(SwingConstants.RIGHT);

        txtUsuario.setPreferredSize(new Dimension(64, 27));
        
        txtModificacion.setPreferredSize(new Dimension(64, 27));

        btnCancelar.setPreferredSize(new Dimension(130, 27));
        btnAceptar.setPreferredSize(new Dimension(130, 27));
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbTipoDato, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTamanio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDecimales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbExcepcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel10)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtModificacion, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 270, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoDato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTamanio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtDecimales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(cmbExcepcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel8))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtModificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }

	/**
	 * @throws IOException
	 */
	protected void setupLiterals() {
		setTitle(literales.getLiteral("dlgAltaModificacionCampos.titulo"));
		
		jLabel1.setText("Alta / Modificación de Campos");
		jLabel2.setText("Nombre");
		jLabel3.setText("Tipo de Dato:");
		jLabel4.setText("Tamaño");
		jLabel5.setText("Decimales");
        jLabel6.setText("Es excepción");
        jLabel7.setText("Descripción Excepción");
        jLabel8.setText("Observaciones");
        jLabel9.setText("Usuario:");
        jLabel10.setText("Modificación");
        
        btnCancelar.setText("CANCELAR");
        btnAceptar.setText("ACEPTAR");
	}

	/**
	 * 
	 */
	protected void initEvents() {
		ActionListener actionListener = new FrmAltaModificacionCamposListener(this);

		btnAceptar.setName(Constants.DLG_ALTA_MODIFICACION_CAMPOS_BTN_ACEPTAR);
		btnCancelar.setName(Constants.DLG_ALTA_MODIFICACION_CAMPOS_BTN_CANCELAR);

		btnAceptar.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);
	}

	/**
	 * 
	 */
	protected void initialState() {
		cmbExcepcion.setModel(new SiNoComboBoxModel());
		cmbExcepcion.setSelectedIndex(1);
	}
}