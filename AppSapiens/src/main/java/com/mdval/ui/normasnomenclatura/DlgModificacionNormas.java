package com.mdval.ui.normasnomenclatura;

import java.awt.Dimension;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.mdval.bussiness.entities.ElementoNorma;
import com.mdval.bussiness.entities.Norma;
import com.mdval.ui.listener.DlgModificacionNormasListener;
import com.mdval.ui.listener.FrmDefinicionNormasListener;
import com.mdval.ui.listener.tables.DlgModificacionNormasElementoNormaTableListener;
import com.mdval.ui.model.AltaModificacionNormasElementoNormaTableModel;
import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.renderer.BigDecimalRenderer;
import com.mdval.ui.renderer.DateRenderer;
import com.mdval.ui.renderer.StringRenderer;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.TableSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.AppGlobalSingleton;
import com.mdval.utils.Constants;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author federico
 */
public class DlgModificacionNormas extends DialogSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7468072915163364659L;

	private JButton btnAltaElemento;
	private JButton btnBajaElemento;
	private JButton btnModificacionElemento;
	private JButton btnAceptar;
	private JButton btnCancelar;	
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	
	@Getter
	private TableSupport tblElementos;
	private JTable tblParticulas;
	
	@Getter
	private JTextField txtCodigo;
	
	@Getter
	private JTextField txtDescripcion;
	
	@Getter
	private JTextField txtFecha;
	
	@Getter
	private JTextField txtUsuario;
	
	@Getter
    private Boolean editar;
	
	@Getter
	private Norma normaSeleccionada;
	
	@Getter
	@Setter
	private ElementoNorma elementoSeleccionado;

    
    /**
     * @param parent
     * @param modal
     */
    public DlgModificacionNormas(JFrame parent, boolean modal) {
        super(parent, modal);
    }
    
    /**
     * @param parent
     * @param modal
     * @param params
     */
    public DlgModificacionNormas(JFrame parent, boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }

	/**
	 * 
	 */
	protected void setupComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        txtCodigo = new JTextField();
        txtDescripcion = new JTextField();
        jLabel4 = new JLabel();
        btnAltaElemento = new JButton();
        btnBajaElemento = new JButton();
        btnModificacionElemento = new JButton();
        jScrollPane1 = new JScrollPane();
        tblElementos = new TableSupport(Boolean.FALSE);
        jLabel5 = new JLabel();
        jScrollPane2 = new JScrollPane();
        tblParticulas = new JTable();
        jLabel6 = new JLabel();
        txtUsuario = new JTextField();
        jLabel7 = new JLabel();
        txtFecha = new JTextField();
        btnAceptar = new JButton();
        btnCancelar = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(1337, 530));
        
        panelLogo.setPreferredSize(new Dimension(286, 63));

        GroupLayout panelLogoLayout = new GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );

        jLabel1.setFont(new Font("Dialog", 1, 18)); // NOI18N

        txtCodigo.setEditable(false);
        txtCodigo.setEnabled(false);
        txtCodigo.setPreferredSize(new Dimension(4, 27));
        
        txtDescripcion.setMinimumSize(new Dimension(4, 27));
        txtDescripcion.setPreferredSize(new Dimension(64, 27));
        
        btnAltaElemento.setPreferredSize(new Dimension(130, 27));

        btnBajaElemento.setPreferredSize(new Dimension(130, 27));

        jScrollPane1.setViewportView(tblElementos);

        tblParticulas.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblParticulas);

        txtUsuario.setPreferredSize(new Dimension(64, 27));

        txtFecha.setPreferredSize(new Dimension(64, 27));
        
        btnAceptar.setPreferredSize(new Dimension(98, 27));
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(573, 679, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel6)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 610, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAltaElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBajaElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificacionElemento)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnAltaElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBajaElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificacionElemento)
                    .addComponent(jLabel5))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }
	
	@Override
	protected void setupLiterals() {
		setTitle(literales.getLiteral("dlgModificacionNormas.titulo"));
		
		jLabel1.setText(literales.getLiteral("dlgModificacionNormas.titulo"));
        jLabel2.setText(literales.getLiteral("dlgModificacionNormas.codigo"));
        jLabel3.setText(literales.getLiteral("dlgModificacionNormas.descripcion"));
        jLabel4.setText(literales.getLiteral("dlgModificacionNormas.elementos"));
        jLabel5.setText(literales.getLiteral("dlgModificacionNormas.particulas"));
        jLabel6.setText(literales.getLiteral("dlgModificacionNormas.usuario"));
        jLabel7.setText(literales.getLiteral("dlgModificacionNormas.fecha"));

        btnAltaElemento.setText(literales.getLiteral("dlgModificacionNormas.alta"));
        btnBajaElemento.setText(literales.getLiteral("dlgModificacionNormas.baja"));
        btnModificacionElemento.setText(literales.getLiteral("dlgModificacionNormas.modificacion"));
        btnAceptar.setText(literales.getLiteral("dlgModificacionNormas.aceptar"));
        btnCancelar.setText(literales.getLiteral("dlgModificacionNormas.cancelar"));
	}

	@Override
	protected void initEvents() {
		/** 
		 * En este punto cargar la norma seleccionada (para el disparador onLoad).
		 * Esto podría ser un indicio de acoplamiento secuencial
		 */
		if (!Objects.isNull(params)) {
			normaSeleccionada = (Norma) params.get(Constants.FRM_DEFINICION_NORMAS_SELECCIONADA);
		}
		
		FrmDefinicionNormas parent = (FrmDefinicionNormas) this.getParent();
		FrmDefinicionNormasListener frmDefinicionNormasListener = parent.getFrmDefinicionNormasListener();
		
		DlgModificacionNormasListener dlgModificacionNormasListener = new DlgModificacionNormasListener(this);
		dlgModificacionNormasListener.addObservador(frmDefinicionNormasListener);
		
		ListSelectionListener listSelectionListener = new DlgModificacionNormasElementoNormaTableListener(this);
		
		btnAltaElemento.setActionCommand(Constants.DLG_MODIFICACION_NORMAS_BTN_ALTA_ELEMENTO);
        btnBajaElemento.setActionCommand(Constants.DLG_MODIFICACION_NORMAS_BTN_BAJA_ELEMENTO);
        btnModificacionElemento.setActionCommand(Constants.DLG_MODIFICACION_NORMAS_BTN_MODIFICACION_ELEMENTO);
        btnAceptar.setActionCommand(Constants.DLG_MODIFICACION_NORMAS_BTN_ACEPTAR);
        btnCancelar.setActionCommand(Constants.DLG_MODIFICACION_NORMAS_BTN_CANCELAR);
		
		btnAltaElemento.addActionListener(dlgModificacionNormasListener);
        btnBajaElemento.addActionListener(dlgModificacionNormasListener);
        btnModificacionElemento.addActionListener(dlgModificacionNormasListener);
        btnAceptar.addActionListener(dlgModificacionNormasListener);
        btnCancelar.addActionListener(dlgModificacionNormasListener);
        
        ListSelectionModel rowSM = tblElementos.getSelectionModel();
		rowSM.addListSelectionListener(listSelectionListener);
        
        this.addOnLoadListener(dlgModificacionNormasListener);
	}

	@Override
	protected void initialState() {
		AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
		
		txtUsuario.setEnabled(Boolean.FALSE);
		txtUsuario.setEditable(Boolean.FALSE);
		txtFecha.setEnabled(Boolean.FALSE);
		txtFecha.setEditable(Boolean.FALSE);
		
		// La carga se hará a través del método onLoad.
		if (!Objects.isNull(normaSeleccionada)) {
			editar = Boolean.TRUE;
		}
		else {
			String cod_usr = (String) appGlobalSingleton.getProperty(Constants.COD_USR);
			txtUsuario.setText(cod_usr);
			
			editar = Boolean.FALSE;
		}
	}

	@Override
	protected void initModels() {
		tblElementos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblElementos.setDefaultRenderer(Date.class, new DateRenderer());
		tblElementos.setDefaultRenderer(BigDecimal.class, new BigDecimalRenderer());
		tblElementos.setDefaultRenderer(String.class, new StringRenderer());
		
		Cabecera cabecera = UIHelper.createCabeceraTabla(Constants.DLG_MODIFICACION_NORMAS_TABLA_ELEMENTOS_CABECERA);
		tblElementos.setModel(new AltaModificacionNormasElementoNormaTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
	}
}
