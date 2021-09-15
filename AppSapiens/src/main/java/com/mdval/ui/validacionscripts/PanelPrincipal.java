package com.mdval.ui.validacionscripts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.ChangeListener;

import com.mdval.bussiness.entities.SubProyecto;
import com.mdval.ui.PanelLogotipo;
import com.mdval.ui.listener.PanelPrincipalActionListener;
import com.mdval.ui.listener.PanelPrincipalChangeListener;
import com.mdval.ui.renderer.SubProyectoRenderer;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.ui.utils.PanelSupport;
import com.mdval.utils.Constants;

import lombok.Getter;

/**
 *
 * @author federico
 */
public class PanelPrincipal extends PanelSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3533639441146450519L;

    private JButton btnBuscarGlosario;
    private JButton btnLimpiarTodo;
    private JButton btnLimpiarValidacion;
    private JButton btnLoadScript;
    private JButton btnValidar;
    
    private JLabel jLabel1;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    
    private JScrollPane jScrollPane1;
    
    @Getter
    private JTabbedPane jTabbedPane1;
    
    private JPanel panelBotones;
    private JPanel panelCabecera;
    private JPanel panelContenido;
    
    @Getter
    private JComboBox<SubProyecto> cmbSubmodelo;
    
    @Getter
    private JTextField txtDescGlosario;
    
    @Getter
    private JTextField txtDescNorma;
    
    @Getter
    private JTextField txtArchivoScript;
    
    @Getter
    private JTextField txtCodGlosario;
    
    @Getter
    private JTextField txtCodNorma;
    
    @Getter
    private JTextField txtIM;
    
    @Getter
    private JTextField txtModeloProyecto;
    
    @Getter
    private JTextField txtSD;
    
    @Getter
    private JTextArea txtScript;

	/**
	 * Creates new form PanelPrincipal
	 */
	public PanelPrincipal(FrameSupport frameParent) {
		super(frameParent);
	}

	/**
	 * 
	 */
	protected void initComponents() {
		
		PanelLogotipo panelLogotipo = getFrameParent().getPanelLogo();

		panelCabecera = new JPanel();
        jLabel1 = new JLabel();
        panelContenido = new JPanel();
        jLabel11 = new JLabel();
        txtModeloProyecto = new JTextField();
        btnBuscarGlosario = new JButton();
        jLabel12 = new JLabel();
        txtCodGlosario = new JTextField();
        txtDescGlosario = new JTextField();
        jLabel2 = new JLabel();
        cmbSubmodelo = new JComboBox<>();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        txtIM = new JTextField();
        txtSD = new JTextField();
        jLabel5 = new JLabel();
        txtArchivoScript = new JTextField();
        btnLoadScript = new JButton();
        jLabel6 = new JLabel();
        jScrollPane1 = new JScrollPane();
        txtScript = new JTextArea();
        btnValidar = new JButton();
        jLabel7 = new JLabel();
        jTabbedPane1 = new JTabbedPane();
        txtCodNorma = new JTextField();
        txtDescNorma = new JTextField();
        jLabel13 = new JLabel();
        panelBotones = new JPanel();
        btnLimpiarValidacion = new JButton();
        btnLimpiarTodo = new JButton();

        setLayout(new BorderLayout());

        panelLogotipo.setPreferredSize(new Dimension(286, 63));

        GroupLayout panelLogotipoLayout = new GroupLayout(panelLogotipo);
        panelLogotipo.setLayout(panelLogotipoLayout);
        panelLogotipoLayout.setHorizontalGroup(
            panelLogotipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );
        panelLogotipoLayout.setVerticalGroup(
            panelLogotipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        jLabel1.setFont(new Font("Dialog", 1, 18)); // NOI18N
        
        GroupLayout panelCabeceraLayout = new GroupLayout(panelCabecera);
        panelCabecera.setLayout(panelCabeceraLayout);
        panelCabeceraLayout.setHorizontalGroup(
            panelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLogotipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        panelCabeceraLayout.setVerticalGroup(
            panelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(panelLogotipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        );

        add(panelCabecera, BorderLayout.PAGE_START);

        panelContenido.setMinimumSize(new Dimension(1366, 724));

        txtModeloProyecto.setMinimumSize(new Dimension(4, 27));
        txtModeloProyecto.setPreferredSize(new Dimension(64, 27));

        btnBuscarGlosario.setIcon(new ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N

        txtCodGlosario.setEditable(false);
        txtCodGlosario.setEnabled(false);
        txtCodGlosario.setPreferredSize(new Dimension(71, 27));

        txtDescGlosario.setEditable(false);
        txtDescGlosario.setEnabled(false);
        txtDescGlosario.setPreferredSize(new Dimension(64, 27));

        txtIM.setPreferredSize(new Dimension(64, 27));

        txtSD.setPreferredSize(new Dimension(64, 27));

        txtArchivoScript.setEditable(false);
        txtArchivoScript.setEnabled(false);
        txtArchivoScript.setPreferredSize(new Dimension(64, 27));

        btnLoadScript.setIcon(new ImageIcon(getClass().getResource("/folder.png"))); // NOI18N

        txtScript.setEditable(false);
        txtScript.setColumns(20);
        txtScript.setRows(5);
        txtScript.setEnabled(false);
        jScrollPane1.setViewportView(txtScript);

        jTabbedPane1.setBorder(BorderFactory.createEtchedBorder());

        txtCodNorma.setEditable(false);
        txtCodNorma.setEnabled(false);
        txtCodNorma.setPreferredSize(new Dimension(71, 27));

        txtDescNorma.setEditable(false);
        txtDescNorma.setEnabled(false);
        txtDescNorma.setPreferredSize(new Dimension(64, 27));

        GroupLayout panelContenidoLayout = new GroupLayout(panelContenido);
        panelContenido.setLayout(panelContenidoLayout);
        panelContenidoLayout.setHorizontalGroup(
            panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelContenidoLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel11)))
                        .addComponent(jLabel5)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenidoLayout.createSequentialGroup()
                        .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtArchivoScript, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.LEADING, panelContenidoLayout.createSequentialGroup()
                                .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(GroupLayout.Alignment.LEADING, panelContenidoLayout.createSequentialGroup()
                                        .addComponent(txtCodGlosario, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDescGlosario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtModeloProyecto, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelContenidoLayout.createSequentialGroup()
                                        .addComponent(btnBuscarGlosario)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2))
                                    .addComponent(jLabel13))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelContenidoLayout.createSequentialGroup()
                                        .addComponent(txtCodNorma, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDescNorma, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cmbSubmodelo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(36, 36, 36)
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIM, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSD, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(btnLoadScript)
                            .addComponent(btnValidar)))
                    .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 1259, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelContenidoLayout.setVerticalGroup(
            panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(btnValidar)
                    .addGroup(panelContenidoLayout.createSequentialGroup()
                        .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarGlosario)
                            .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(txtModeloProyecto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(cmbSubmodelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(txtIM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(txtCodGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDescGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCodNorma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDescNorma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txtArchivoScript, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btnLoadScript, GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(panelContenido, BorderLayout.CENTER);

        panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        panelBotones.add(btnLimpiarValidacion);

        btnLimpiarTodo.setPreferredSize(new Dimension(146, 27));
        panelBotones.add(btnLimpiarTodo);

        add(panelBotones, BorderLayout.PAGE_END);
    }
	
    /**
     *
     */
    protected void setupLiterals() {
    	jLabel1.setText(literales.getLiteral("panelPrincipal.titulo"));
    	jLabel2.setText(literales.getLiteral("panelPrincipal.submodelo"));
    	jLabel3.setText(literales.getLiteral("panelPrincipal.im"));
        jLabel4.setText(literales.getLiteral("panelPrincipal.sd"));
        jLabel5.setText(literales.getLiteral("panelPrincipal.archivoScript"));
        jLabel6.setText(literales.getLiteral("panelPrincipal.script"));
        jLabel7.setText(literales.getLiteral("panelPrincipal.resultadoValidacion"));
        jLabel11.setText(literales.getLiteral("panelPrincipal.modeloProyecto"));
    	jLabel12.setText(literales.getLiteral("panelPrincipal.glosario"));
    	jLabel13.setText(literales.getLiteral("panelPrincipal.norma"));
        
        btnValidar.setText(literales.getLiteral("panelPrincipal.validar"));
        btnLimpiarValidacion.setText(literales.getLiteral("panelPrincipal.limpiarValidacion"));
        btnLimpiarTodo.setText(literales.getLiteral("panelPrincipal.limpiarTodo"));
	}
    
	/**
	 * 
	 */
	protected void initEvents() {
		ActionListener actionListener = new PanelPrincipalActionListener(this);
		ChangeListener changeListener = new PanelPrincipalChangeListener(this);
		
		btnValidar.setActionCommand(Constants.PANEL_PRINCIPAL_BTN_VALIDAR);
		btnBuscarGlosario.setActionCommand(Constants.PANEL_PRINCIPAL_BTN_SEARCH);
		btnLoadScript.setActionCommand(Constants.PANEL_PRINCIPAL_BTN_LOAD_SCRIPT);
		btnLimpiarTodo.setActionCommand(Constants.PANEL_PRINCIPAL_BTN_LIMPIAR_TODO);
		btnLimpiarValidacion.setActionCommand(Constants.PANEL_PRINCIPAL_BTN_LIMPIAR_VALIDACION);

		btnValidar.addActionListener(actionListener);
		btnBuscarGlosario.addActionListener(actionListener);
		btnLoadScript.addActionListener(actionListener);
		btnLimpiarTodo.addActionListener(actionListener);
		btnLimpiarValidacion.addActionListener(actionListener);

		jTabbedPane1.addChangeListener(changeListener);
	}
	
	/**
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void initModels() {
		cmbSubmodelo.setRenderer(new SubProyectoRenderer());
	}
	
	/**
	 * 
	 */
	protected void initialState() {
		loadResultados();
	}
	
	private void loadResultados() {
		PanelResultados panelElementosValidar = new PanelResultados();
        PanelResultados panelElementosCorrectos = new PanelResultados();
        PanelResultados panelNoEstanEnGlosario = new PanelResultados();
        PanelResultados panelConErrores = new PanelResultados();
        PanelResultados panelExcepciones = new PanelResultados();

        jTabbedPane1.addTab(literales.getLiteral("panelResultados.elementosValidar"), panelElementosValidar);
        jTabbedPane1.addTab(literales.getLiteral("panelResultados.elementosCorrectos"), panelElementosCorrectos);
        jTabbedPane1.addTab(literales.getLiteral("panelResultados.elementosNoEstanGlosario"), panelNoEstanEnGlosario);
        jTabbedPane1.addTab(literales.getLiteral("panelResultados.elementosErrores"), panelConErrores);
        jTabbedPane1.addTab(literales.getLiteral("panelResultados.excepciones"), panelExcepciones);
	}
}
