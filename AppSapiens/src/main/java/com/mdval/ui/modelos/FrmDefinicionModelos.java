package com.mdval.ui.modelos;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Map;
import java.util.Objects;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionListener;

import com.mdval.bussiness.entities.Modelo;
import com.mdval.bussiness.entities.Norma;
import com.mdval.ui.listener.FrmDefinicionModelosListener;
import com.mdval.ui.listener.tables.FrmDefinicionModelosTableListener;
import com.mdval.ui.model.DefinicionModelosTableModel;
import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.renderer.NormaRenderer;
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
public class FrmDefinicionModelos extends FrameSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8935938403733592308L;
	
	private JButton btnBuscar;
	private JButton btnAlta;
	
	@Getter
    private JButton btnBaja;
    
	@Getter
	private JButton btnModificacion;
    private JButton btnSeleccionar;
    
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    
    private JScrollPane jScrollPane1;
    
    @Getter
    private TableSupport tblModelos;
    
    @Getter
    private JComboBox<Norma> cmbNorma;
    
    @Getter
    private JTextField txtBaseDatos;
    
    @Getter
    private JTextField txtCodModelo;
    
    @Getter
    private JTextField txtEsquema;
    
    @Getter
    private JFormattedTextField txtGlosario;
    
    @Getter
    private JTextField txtNombreModelo;
    
    @Getter
    private FrmDefinicionModelosListener frmDefinicionModelosListener;
    
    @Getter
    @Setter
    private Modelo seleccionado;

    /**
     * 
     */
    public FrmDefinicionModelos() {
        super();
    }
    
    /**
	 * @param params
	 */
	public FrmDefinicionModelos(Map<String, Object> params) {
        super(params);
    }
	
	/**
	 * Creates new form
	 */
	public FrmDefinicionModelos(FrameSupport parent, Map<String, Object> params) {
		super(parent, params);
	}

    /**
     * 
     */
    protected void setupComponents() {

    	txtCodModelo = new JTextField();
        jLabel1 = new JLabel();
        btnBuscar = new JButton();
        btnBaja = new JButton();
        btnModificacion = new JButton();
        btnSeleccionar = new JButton();
        jLabel2 = new JLabel();
        jScrollPane1 = new JScrollPane();
        tblModelos = new TableSupport(Boolean.FALSE);
        btnAlta = new JButton();
        jLabel3 = new JLabel();
        txtGlosario = UIHelper.createIntegerField();
        jLabel4 = new JLabel();
        txtNombreModelo = new JTextField();
        jLabel5 = new JLabel();
        txtEsquema = new JTextField();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        txtBaseDatos = new JTextField();
        cmbNorma = new JComboBox<>();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(961, 609));

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

        txtCodModelo.setMinimumSize(new Dimension(4, 27));
        txtCodModelo.setPreferredSize(new Dimension(300, 27));

        jLabel1.setFont(new Font("Dialog", 1, 18)); // NOI18N
        btnBaja.setPreferredSize(new Dimension(130, 27));

        btnSeleccionar.setPreferredSize(new Dimension(130, 27));

        jScrollPane1.setViewportView(tblModelos);

        btnAlta.setPreferredSize(new Dimension(130, 27));

        txtGlosario.setMinimumSize(new Dimension(4, 27));
        txtGlosario.setPreferredSize(new Dimension(300, 27));

        txtNombreModelo.setMinimumSize(new Dimension(4, 27));
        txtNombreModelo.setPreferredSize(new Dimension(300, 27));
        txtEsquema.setMinimumSize(new Dimension(4, 27));
        txtEsquema.setPreferredSize(new Dimension(300, 27));
        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel7.setHorizontalAlignment(SwingConstants.RIGHT);
        txtBaseDatos.setMinimumSize(new Dimension(4, 27));
        txtBaseDatos.setPreferredSize(new Dimension(300, 27));
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBaja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificacion)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel1))
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(42, 42, 42)))
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(txtGlosario, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCodModelo, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEsquema, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                .addComponent(txtNombreModelo, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbNorma, 0, 166, Short.MAX_VALUE)
                                .addComponent(txtBaseDatos, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnBuscar))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(txtNombreModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNorma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEsquema, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel6)
                    .addComponent(txtBaseDatos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBaja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificacion)
                    .addComponent(btnSeleccionar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }
    
    @Override
	protected void setupLiterals() {
    	setTitle(literales.getLiteral("frmDefinicionModelos.titulo"));
    	
    	jLabel1.setText(literales.getLiteral("frmDefinicionModelos.titulo"));
        jLabel2.setText(literales.getLiteral("frmDefinicionModelos.codModelo"));
        jLabel3.setText(literales.getLiteral("frmDefinicionModelos.glosario"));
        jLabel4.setText(literales.getLiteral("frmDefinicionModelos.nombreModelo"));
        jLabel5.setText(literales.getLiteral("frmDefinicionModelos.esquema"));
        jLabel6.setText(literales.getLiteral("frmDefinicionModelos.baseDatos"));
        jLabel7.setText(literales.getLiteral("frmDefinicionModelos.norma"));
        
        btnBuscar.setText(literales.getLiteral("frmDefinicionModelos.buscar"));
        btnAlta.setText(literales.getLiteral("frmDefinicionModelos.alta"));
        btnBaja.setText(literales.getLiteral("frmDefinicionModelos.baja"));
        btnModificacion.setText(literales.getLiteral("frmDefinicionModelos.modificacion"));
        btnSeleccionar.setText(literales.getLiteral("frmDefinicionModelos.seleccionar"));
	}

	@Override
	protected void initEvents() {
		frmDefinicionModelosListener = new FrmDefinicionModelosListener(this);
		ListSelectionListener listSelectionListener = new FrmDefinicionModelosTableListener(this);
		
		btnBuscar.setActionCommand(Constants.FRM_DEFINICION_MODELOS_BTN_BUSCAR);
		btnAlta.setActionCommand(Constants.FRM_DEFINICION_MODELOS_BTN_ALTA);
		btnBaja.setActionCommand(Constants.FRM_DEFINICION_MODELOS_BTN_BAJA);
		btnModificacion.setActionCommand(Constants.FRM_DEFINICION_MODELOS_BTN_MODIFICACION);
		
		btnBuscar.addActionListener(frmDefinicionModelosListener);
		btnAlta.addActionListener(frmDefinicionModelosListener);
		btnBaja.addActionListener(frmDefinicionModelosListener);
		btnModificacion.addActionListener(frmDefinicionModelosListener);
		
		ListSelectionModel rowSM = tblModelos.getSelectionModel();
		rowSM.addListSelectionListener(listSelectionListener);
	
		this.addOnLoadListener(frmDefinicionModelosListener);
	}

	@Override
	protected void initialState() {
		Boolean fromMenu = Boolean.TRUE;
		if (!Objects.isNull(params)) {
			fromMenu = (Boolean) params.get("fromMenu");
		}
		
		btnBaja.setEnabled(Boolean.FALSE);
		btnModificacion.setEnabled(Boolean.FALSE);
		btnSeleccionar.setEnabled(Boolean.FALSE);
		
		if (fromMenu) {
			btnSeleccionar.setVisible(Boolean.FALSE);
		}
		else {
			btnAlta.setVisible(Boolean.FALSE);
			btnBaja.setVisible(Boolean.FALSE);
			btnModificacion.setVisible(Boolean.FALSE);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void initModels() {
		Cabecera cabecera = UIHelper.createCabeceraTabla(Constants.FRM_DEFINICION_MODELOS_TABLA_CABECERA);
		tblModelos.setModel(new DefinicionModelosTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
		
		cmbNorma.setRenderer(new NormaRenderer());
	}
}
