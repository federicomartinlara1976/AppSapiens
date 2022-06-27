package com.mdsql.ui.glosarios;

import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionListener;

import com.mdsql.bussiness.entities.CampoGlosario;
import com.mdsql.bussiness.entities.Glosario;
import com.mdsql.ui.listener.FrmGlosarioCamposListener;
import com.mdsql.ui.listener.tables.FrmGlosarioCamposTableListener;
import com.mdsql.ui.model.DefinicionCamposGlosarioTableCamposModel;
import com.mdsql.ui.model.DefinicionCamposGlosarioTableModelosModel;
import com.mdsql.ui.model.SiNoComboBoxModel;
import com.mdsql.ui.model.TipoDatoComboBoxModel;
import com.mdsql.ui.model.cabeceras.Cabecera;
import com.mdsql.ui.renderer.BigDecimalRenderer;
import com.mdsql.ui.renderer.DateTimeRenderer;
import com.mdsql.ui.renderer.IntegerRenderer;
import com.mdsql.ui.renderer.StringRenderer;
import com.mdsql.ui.utils.FrameSupport;
import com.mdsql.ui.utils.MaestrasSupport;
import com.mdsql.ui.utils.UIHelper;
import com.mdsql.utils.Constants;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author federico
 */
public class FrmGlosarioCampos extends FrameSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3506678199253519307L;
	
	private JButton btnBuscarGlosario;
	
	@Getter
    private JButton btnBuscar;
	
	@Getter
	private JButton btnAlta;
    
	@Getter
	private JButton btnBaja;
	
	@Getter
    private JButton btnModificacion;
	
	@Getter
    private JButton btnImprimir;
    
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    
    @Getter
    private JTable tblCampos;
    
    @Getter
    private JTable tblModelos;
    
    @Getter
    private JComboBox<String> cmbMostrarExcepciones;
    
    @Getter
    private JComboBox<String> cmbTipoDato;
    
    @Getter
    private JTextField txtCodigoGlosario;
    
    @Getter
    private JTextField txtGlosario;
    
    @Getter
    private JTextField txtNombreColumna;
    
    @Getter
    private FrmGlosarioCamposListener frmGlosarioCamposListener;
    
    @Getter
    @Setter
    private CampoGlosario campoSeleccionado;
    
    @Getter
    @Setter
    private Glosario glosarioSeleccionado;
    
    
	/**
     * Creates new form DlgGlosarioCampos
     */
    public FrmGlosarioCampos() {
        super();
    }

    protected void setupComponents() {

    	jLabel6 = new JLabel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        txtCodigoGlosario = new JTextField();
        txtGlosario = new JTextField();
        btnBuscarGlosario = new JButton();
        txtNombreColumna = new JTextField();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        cmbTipoDato = new JComboBox<>();
        cmbMostrarExcepciones = new JComboBox<>();
        btnBuscar = new JButton();
        jScrollPane2 = new JScrollPane();
        tblCampos = new JTable();
        jScrollPane1 = new JScrollPane();
        tblModelos = new JTable();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        btnAlta = new JButton();
        btnBaja = new JButton();
        btnModificacion = new JButton();
        btnImprimir = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(1022, 690));

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

        jLabel6.setFont(new Font("Dialog", 1, 18)); // NOI18N

        txtCodigoGlosario.setPreferredSize(new Dimension(64, 27));

        txtGlosario.setPreferredSize(new Dimension(64, 27));

        btnBuscarGlosario.setIcon(new ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N

        txtNombreColumna.setPreferredSize(new Dimension(4, 27));

        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        
        jScrollPane2.setViewportView(tblCampos);

        jScrollPane1.setViewportView(tblModelos);

        btnAlta.setPreferredSize(new Dimension(150, 27));

        btnBaja.setPreferredSize(new Dimension(150, 27));

        btnModificacion.setPreferredSize(new Dimension(150, 27));

        btnImprimir.setPreferredSize(new Dimension(150, 27));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBaja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtCodigoGlosario, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtGlosario, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtNombreColumna, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscarGlosario, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbTipoDato, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbMostrarExcepciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscar)))
                                .addGap(0, 173, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCodigoGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBuscarGlosario)))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbTipoDato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreColumna, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(cmbMostrarExcepciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBaja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
    }
    
    /**
     * @throws IOException
     */
    protected void setupLiterals() {
		setTitle(literales.getLiteral("frmGlosarioCampos.titulo"));
        
		jLabel1.setText(literales.getLiteral("frmGlosarioCampos.glosario"));
        jLabel2.setText(literales.getLiteral("frmGlosarioCampos.nombreColumna"));
        jLabel3.setText(literales.getLiteral("frmGlosarioCampos.tipoDato"));
        jLabel4.setText(literales.getLiteral("frmGlosarioCampos.mostrarExcepciones"));
        jLabel6.setText(literales.getLiteral("frmGlosarioCampos.titulo"));
        jLabel7.setText(literales.getLiteral("frmGlosarioCampos.campos"));
        jLabel8.setText(literales.getLiteral("frmGlosarioCampos.modelos"));
        
        btnBuscar.setText(literales.getLiteral("frmGlosarioCampos.buscar"));
        btnAlta.setText(literales.getLiteral("frmGlosarioCampos.alta"));
        btnBaja.setText(literales.getLiteral("frmGlosarioCampos.baja"));
        btnModificacion.setText(literales.getLiteral("frmGlosarioCampos.modificacion"));
        btnImprimir.setText(literales.getLiteral("frmGlosarioCampos.imprimir"));
    }
	
	/**
	 * 
	 */
	protected void initEvents() {
		frmGlosarioCamposListener = new FrmGlosarioCamposListener(this);
		ListSelectionListener listSelectionListener = new FrmGlosarioCamposTableListener(this);
		
		btnBuscarGlosario.setActionCommand(Constants.FRM_GLOSARIO_CAMPOS_BTN_BUSCAR_GLOSARIO);
		btnBuscar.setActionCommand(Constants.FRM_GLOSARIO_CAMPOS_BTN_BUSCAR);
		btnAlta.setActionCommand(Constants.FRM_GLOSARIO_CAMPOS_BTN_ALTA);
		btnBaja.setActionCommand(Constants.FRM_GLOSARIO_CAMPOS_BTN_BAJA);
		btnModificacion.setActionCommand(Constants.FRM_GLOSARIO_CAMPOS_BTN_MODIFICACION);
		btnImprimir.setActionCommand(Constants.FRM_GLOSARIO_CAMPOS_BTN_IMPRIMIR);
		
		btnBuscarGlosario.addActionListener(frmGlosarioCamposListener);
		btnBuscar.addActionListener(frmGlosarioCamposListener);
		btnAlta.addActionListener(frmGlosarioCamposListener);
		btnBaja.addActionListener(frmGlosarioCamposListener);
		btnModificacion.addActionListener(frmGlosarioCamposListener);
		btnImprimir.addActionListener(frmGlosarioCamposListener);
		
		ListSelectionModel rowSM = tblCampos.getSelectionModel();
		rowSM.addListSelectionListener(listSelectionListener);
	}
	
	/**
	 * 
	 */
	protected void initialState() {
		txtCodigoGlosario.setEnabled(Boolean.FALSE);
		txtGlosario.setEnabled(Boolean.FALSE);
		cmbTipoDato.setSelectedIndex(0);
		cmbMostrarExcepciones.setSelectedItem(Constants.SI);
		btnBuscar.setEnabled(Boolean.FALSE);
		btnAlta.setEnabled(Boolean.FALSE);
		btnBaja.setEnabled(Boolean.FALSE);
		btnModificacion.setEnabled(Boolean.FALSE);
		btnImprimir.setEnabled(Boolean.FALSE);
	}

	@Override
	protected void initModels() {
		TipoDatoComboBoxModel cmbTipoDatoModel = MaestrasSupport.getTipoDatoCmbModel(); 
		cmbTipoDato.setModel(cmbTipoDatoModel);

		Cabecera cabeceraCampos = UIHelper.createCabeceraTabla(Constants.FRM_GLOSARIO_CAMPOS_TABLA_CAMPO_CABECERA);
		tblCampos.setModel(new DefinicionCamposGlosarioTableCamposModel(cabeceraCampos.getColumnIdentifiers(), cabeceraCampos.getColumnClasses()));
		tblCampos.setDefaultRenderer(Date.class, new DateTimeRenderer());
		tblCampos.setDefaultRenderer(String.class, new StringRenderer());
		tblCampos.setDefaultRenderer(Integer.class, new IntegerRenderer());
		tblCampos.setDefaultRenderer(BigDecimal.class, new BigDecimalRenderer());
		
		Cabecera cabeceraModelos = UIHelper.createCabeceraTabla(Constants.FRM_GLOSARIO_CAMPOS_TABLA_MODELO_CABECERA);
		tblModelos.setModel(new DefinicionCamposGlosarioTableModelosModel(cabeceraModelos.getColumnIdentifiers(), cabeceraModelos.getColumnClasses()));
		tblModelos.setDefaultRenderer(Date.class, new DateTimeRenderer());
		tblModelos.setDefaultRenderer(String.class, new StringRenderer());
		tblModelos.setDefaultRenderer(Integer.class, new IntegerRenderer());
		tblModelos.setDefaultRenderer(BigDecimal.class, new BigDecimalRenderer());
		
		cmbMostrarExcepciones.setModel(new SiNoComboBoxModel());
	}
}
