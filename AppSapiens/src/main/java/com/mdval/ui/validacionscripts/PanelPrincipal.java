package com.mdval.ui.validacionscripts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
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

import com.mdval.ui.listener.PanelPrincipalActionListener;
import com.mdval.ui.listener.PanelPrincipalChangeListener;
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
    private JComboBox<String> cmbSubModelo;
    
    @Getter
    private JTextField txtDescGlosario;
    
    @Getter
    private JTextField txtArchivoScript;
    
    @Getter
    private JTextField txtCodGlosario;
    
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

		panelCabecera = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelContenido = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtModeloProyecto = new javax.swing.JTextField();
        btnBuscarGlosario = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtCodGlosario = new javax.swing.JTextField();
        txtDescGlosario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbSubModelo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIM = new javax.swing.JTextField();
        txtSD = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtArchivoScript = new javax.swing.JTextField();
        btnLoadScript = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtScript = new javax.swing.JTextArea();
        btnValidar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelBotones = new javax.swing.JPanel();
        btnLimpiarValidacion = new javax.swing.JButton();
        btnLimpiarTodo = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        frameParent.getPanelLogo().setPreferredSize(new java.awt.Dimension(286, 63));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        
        javax.swing.GroupLayout panelCabeceraLayout = new javax.swing.GroupLayout(panelCabecera);
        panelCabecera.setLayout(panelCabeceraLayout);
        panelCabeceraLayout.setHorizontalGroup(
            panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(frameParent.getPanelLogo(), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        panelCabeceraLayout.setVerticalGroup(
            panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(frameParent.getPanelLogo(), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        add(panelCabecera, java.awt.BorderLayout.PAGE_START);

        panelContenido.setMinimumSize(new java.awt.Dimension(1366, 724));
    
        txtModeloProyecto.setMinimumSize(new java.awt.Dimension(4, 27));
        txtModeloProyecto.setPreferredSize(new java.awt.Dimension(64, 27));

        btnBuscarGlosario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N

        txtCodGlosario.setEditable(false);
        txtCodGlosario.setEnabled(false);
        txtCodGlosario.setPreferredSize(new java.awt.Dimension(71, 27));

        txtDescGlosario.setEditable(false);
        txtDescGlosario.setEnabled(false);
        txtDescGlosario.setPreferredSize(new java.awt.Dimension(64, 27));

        txtIM.setPreferredSize(new java.awt.Dimension(64, 27));

        txtSD.setPreferredSize(new java.awt.Dimension(64, 27));

        txtArchivoScript.setEditable(false);
        txtArchivoScript.setEnabled(false);
        txtArchivoScript.setPreferredSize(new java.awt.Dimension(64, 27));

        btnLoadScript.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder.png"))); // NOI18N

        txtScript.setEditable(false);
        txtScript.setColumns(20);
        txtScript.setRows(5);
        txtScript.setEnabled(false);
        jScrollPane1.setViewportView(txtScript);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelContenidoLayout = new javax.swing.GroupLayout(panelContenido);
        panelContenido.setLayout(panelContenidoLayout);
        panelContenidoLayout.setHorizontalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelContenidoLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel11)))
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenidoLayout.createSequentialGroup()
                        .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtArchivoScript, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelContenidoLayout.createSequentialGroup()
                                .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelContenidoLayout.createSequentialGroup()
                                        .addComponent(txtCodGlosario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDescGlosario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtModeloProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarGlosario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSubModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIM, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSD, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLoadScript)
                            .addComponent(btnValidar)))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        panelContenidoLayout.setVerticalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnValidar)
                    .addGroup(panelContenidoLayout.createSequentialGroup()
                        .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtModeloProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(cmbSubModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(txtIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarGlosario)
                            .addComponent(txtSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtCodGlosario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescGlosario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtArchivoScript, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btnLoadScript, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(panelContenido, java.awt.BorderLayout.CENTER);

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));

        panelBotones.add(btnLimpiarValidacion);

        btnLimpiarTodo.setPreferredSize(new java.awt.Dimension(146, 27));
        panelBotones.add(btnLimpiarTodo);

        add(panelBotones, java.awt.BorderLayout.PAGE_END);
    }
	
    /**
     *
     */
    protected void setupLiterals() {
    	jLabel1.setText("Validador de scripts");
    	jLabel2.setText("Submodelo");
    	jLabel3.setText("IM");
        jLabel4.setText("SD");
        jLabel5.setText("Archivo con el Script");
        jLabel6.setText("Script");
        jLabel7.setText("Resultado Validación");
        jLabel11.setText("Modelo o Proyecto");
    	jLabel12.setText("Glosario");
        
        btnValidar.setText("Validar");
        btnLimpiarValidacion.setText("Limpiar validación");
        btnLimpiarTodo.setText("Limpiar todo");
	}
    
	/**
	 * 
	 */
	protected void initEvents() {
		ActionListener actionListener = new PanelPrincipalActionListener(this);
		ChangeListener changeListener = new PanelPrincipalChangeListener(this);
		
		btnValidar.setName(Constants.PANEL_PRINCIPAL_BTN_VALIDAR);
		btnBuscarGlosario.setName(Constants.PANEL_PRINCIPAL_BTN_SEARCH);
		btnLoadScript.setName(Constants.PANEL_PRINCIPAL_BTN_LOAD_SCRIPT);
		btnLimpiarTodo.setName(Constants.PANEL_PRINCIPAL_BTN_LIMPIAR_TODO);
		btnLimpiarValidacion.setName(Constants.PANEL_PRINCIPAL_BTN_LIMPIAR_VALIDACION);

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
	@Override
	protected void initModels() {
		cmbSubModelo.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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

        jTabbedPane1.addTab("Elementos a Validar", panelElementosValidar);
        jTabbedPane1.addTab("Elementos Correctos", panelElementosCorrectos);
        jTabbedPane1.addTab("Elementos que No Están en Glosario", panelNoEstanEnGlosario);
        jTabbedPane1.addTab("Elementos con Errores", panelConErrores);
        jTabbedPane1.addTab("Excepciones", panelExcepciones);
	}
}
