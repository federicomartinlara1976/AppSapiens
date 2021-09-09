package com.mdval.ui.normasnomenclatura;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionListener;

import com.mdval.bussiness.entities.TipoParticula;
import com.mdval.bussiness.entities.ValorParticula;
import com.mdval.ui.listener.FrmMantenimientoParticulasListener;
import com.mdval.ui.listener.FrmValoresParticulasListener;
import com.mdval.ui.listener.tables.FrmMantenimientoParticulasTableValoresListener;
import com.mdval.ui.model.SiNoComboBoxModel;
import com.mdval.ui.model.ValoresParticulaTableModel;
import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.renderer.BigDecimalRenderer;
import com.mdval.ui.renderer.DateRenderer;
import com.mdval.ui.renderer.StringRenderer;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.ui.utils.TableSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.AppHelper;
import com.mdval.utils.Constants;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author federico
 */
public class FrmMantenimientoParticulas extends FrameSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3576255765784636736L;

	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnAltaElemento;
	private JButton btnBajaElemento;
	
	@Getter
	private JButton btnModificacionElemento;
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	
	private JScrollPane jScrollPane1;
	
	private JPanel panelBotones;
	private JPanel panelTabla;
	
	@Getter
	private TableSupport tblValoresParticulas;
	
	@Getter
	private JComboBox<String> cmbProyecto;
	
	@Getter
	private JComboBox<String> cmbSubproyecto;
	
	@Getter
	private JTextField txtCodigo;
	
	@Getter
	private JTextField txtDescripcion;
	
	@Getter
    private Boolean editar;
	
	@Getter
	@Setter
	private TipoParticula seleccionada;
	
	@Getter
	@Setter
	private ValorParticula valorSeleccionado;
	
	@Getter
	private FrmMantenimientoParticulasListener frmMantenimientoParticulasListener;

	/**
	 * Creates new form
	 */
	public FrmMantenimientoParticulas() {
		super();
	}
	
	/**
	 * Creates new form
	 */
	public FrmMantenimientoParticulas(FrameSupport parent) {
		super(parent);
	}
	
	/**
	 * @param params
	 */
	public FrmMantenimientoParticulas(FrameSupport parent, Map<String, Object> params) {
        super(parent, params);
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
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        cmbProyecto = new JComboBox<>();
        jLabel7 = new JLabel();
        cmbSubproyecto = new JComboBox<>();
        panelTabla = new JPanel();
        jScrollPane1 = new JScrollPane();
        tblValoresParticulas = new TableSupport(Boolean.FALSE);
        panelBotones = new JPanel();
        btnAltaElemento = new JButton();
        btnBajaElemento = new JButton();
        btnModificacionElemento = new JButton();
        btnAceptar = new JButton();
        btnCancelar = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

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

        txtCodigo.setPreferredSize(new Dimension(4, 27));
        
        txtDescripcion.setMinimumSize(new Dimension(4, 27));
        txtDescripcion.setPreferredSize(new Dimension(64, 27));

        panelTabla.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        jScrollPane1.setViewportView(tblValoresParticulas);

        btnAltaElemento.setPreferredSize(new Dimension(130, 27));
        panelBotones.add(btnAltaElemento);

        btnBajaElemento.setPreferredSize(new Dimension(130, 27));
        panelBotones.add(btnBajaElemento);

        panelBotones.add(btnModificacionElemento);

        GroupLayout panelTablaLayout = new GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTablaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(panelBotones, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBotones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnAceptar.setPreferredSize(new Dimension(130, 27));
        btnCancelar.setPreferredSize(new Dimension(130, 27));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(panelTabla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbProyecto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbSubproyecto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel5))
                        .addGap(0, 605, Short.MAX_VALUE)))
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
                    .addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbProyecto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cmbSubproyecto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }
	
	@Override
	protected void setupLiterals() {
		setTitle(literales.getLiteral("frmMantenimientoParticulas.titulo"));
		
		jLabel1.setText(literales.getLiteral("frmMantenimientoParticulas.titulo"));
        jLabel2.setText(literales.getLiteral("frmMantenimientoParticulas.codigo"));
        jLabel3.setText(literales.getLiteral("frmMantenimientoParticulas.descripcion"));
        jLabel5.setText(literales.getLiteral("frmMantenimientoParticulas.valoresPosibles"));
        jLabel6.setText(literales.getLiteral("frmMantenimientoParticulas.proyecto"));
        jLabel7.setText(literales.getLiteral("frmMantenimientoParticulas.subproyecto"));
        
        btnAltaElemento.setText(literales.getLiteral("frmMantenimientoParticulas.alta"));
        btnBajaElemento.setText(literales.getLiteral("frmMantenimientoParticulas.baja"));
        btnModificacionElemento.setText(literales.getLiteral("frmMantenimientoParticulas.modificacion"));
        btnAceptar.setText(literales.getLiteral("frmMantenimientoParticulas.aceptar"));
        btnCancelar.setText(literales.getLiteral("frmMantenimientoParticulas.cancelar"));
	}

	@Override
	protected void initEvents() {
		FrmValoresParticulas parent = (FrmValoresParticulas) this.getParent();
		FrmValoresParticulasListener frmValoresParticulasListener = parent.getFrmValoresParticulasListener();
		
		frmMantenimientoParticulasListener = new FrmMantenimientoParticulasListener(this);
		frmMantenimientoParticulasListener.addObservador(frmValoresParticulasListener);
		
		ListSelectionListener listSelectionListener = new FrmMantenimientoParticulasTableValoresListener(this);
		
		btnAltaElemento.setActionCommand(Constants.FRM_MANTENIMIENTO_PARTICULAS_BTN_ALTA);
		btnBajaElemento.setActionCommand(Constants.FRM_MANTENIMIENTO_PARTICULAS_BTN_BAJA);
		btnModificacionElemento.setActionCommand(Constants.FRM_MANTENIMIENTO_PARTICULAS_BTN_MODIFICACION);
		btnAceptar.setActionCommand(Constants.FRM_MANTENIMIENTO_PARTICULAS_BTN_ACEPTAR);
		btnCancelar.setActionCommand(Constants.FRM_MANTENIMIENTO_PARTICULAS_BTN_CANCELAR);
		
		btnAltaElemento.addActionListener(frmMantenimientoParticulasListener);
		btnBajaElemento.addActionListener(frmMantenimientoParticulasListener);
		btnModificacionElemento.addActionListener(frmMantenimientoParticulasListener);
		btnAceptar.addActionListener(frmMantenimientoParticulasListener);
		btnCancelar.addActionListener(frmMantenimientoParticulasListener);
		
		ListSelectionModel rowSM = tblValoresParticulas.getSelectionModel();
		rowSM.addListSelectionListener(listSelectionListener);
		
		this.addOnLoadListener(frmMantenimientoParticulasListener);
	}

	@Override
	protected void initialState() {
		txtCodigo.setEnabled(Boolean.FALSE);
		txtCodigo.setEditable(Boolean.FALSE);
		btnBajaElemento.setEnabled(Boolean.FALSE);
		
		// Se trata de la edición de un registro
		if (!Objects.isNull(params)) {
			TipoParticula tipoParticula = (TipoParticula) params.get(Constants.FRM_VALORES_PARTICULAS_SELECCIONADA);
			txtCodigo.setText(tipoParticula.getCodigoParticula().toString());
			txtDescripcion.setText(tipoParticula.getDescripcionParticula());
			cmbProyecto.setSelectedItem(AppHelper.normalizeSiNoValueToCmb(tipoParticula.getMcaProyecto()));
			cmbSubproyecto.setSelectedItem(AppHelper.normalizeSiNoValueToCmb(tipoParticula.getMcaSubProyecto()));
			
			btnAltaElemento.setEnabled(Boolean.TRUE);
			btnModificacionElemento.setEnabled(Boolean.FALSE);
			
			seleccionada = tipoParticula;
			
			editar = Boolean.TRUE;
		}
		else {
			cmbProyecto.setSelectedItem(Constants.NO);
			cmbSubproyecto.setSelectedItem(Constants.NO);
			
			btnAltaElemento.setEnabled(Boolean.FALSE);
			btnModificacionElemento.setEnabled(Boolean.FALSE);
		
			editar = Boolean.FALSE;
		}
	}

	@Override
	protected void initModels() {
		tblValoresParticulas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblValoresParticulas.setDefaultRenderer(Date.class, new DateRenderer());
		tblValoresParticulas.setDefaultRenderer(BigDecimal.class, new BigDecimalRenderer());
		tblValoresParticulas.setDefaultRenderer(String.class, new StringRenderer());
		
		Cabecera cabeceraValoresParticula = UIHelper.createCabeceraTabla(Constants.FRM_VALORES_PARTICULAS_CABECERA);
		tblValoresParticulas.setModel(new ValoresParticulaTableModel(cabeceraValoresParticula.getColumnIdentifiers(), cabeceraValoresParticula.getColumnClasses()));
		
		cmbProyecto.setModel(new SiNoComboBoxModel());
		cmbSubproyecto.setModel(new SiNoComboBoxModel());	
	}
}
