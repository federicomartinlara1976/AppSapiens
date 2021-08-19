package com.sapiens.mdval.ui.validacionscripts;

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

import com.sapiens.mdval.ui.listener.PanelPrincipalActionListener;
import com.sapiens.mdval.ui.listener.PanelPrincipalChangeListener;
import com.sapiens.mdval.ui.utils.FrameSupport;
import com.sapiens.mdval.ui.utils.PanelSupport;
import com.sapiens.mdval.utils.Constants;

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
        cmbSubModelo = new JComboBox<>();
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
        panelBotones = new JPanel();
        btnLimpiarValidacion = new JButton();
        btnLimpiarTodo = new JButton();

        setLayout(new BorderLayout());

        frameParent.getPanelLogo().setPreferredSize(new Dimension(286, 63));

        jLabel1.setFont(new Font("Dialog", 1, 18)); // NOI18N

        GroupLayout panelCabeceraLayout = new GroupLayout(panelCabecera);
        panelCabecera.setLayout(panelCabeceraLayout);
        panelCabeceraLayout.setHorizontalGroup(
            panelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(frameParent.getPanelLogo(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        panelCabeceraLayout.setVerticalGroup(
            panelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(frameParent.getPanelLogo(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        );

        add(panelCabecera, BorderLayout.PAGE_START);

        txtModeloProyecto.setMinimumSize(new Dimension(4, 27));
        txtModeloProyecto.setPreferredSize(new Dimension(64, 27));

        btnBuscarGlosario.setIcon(new ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N

        txtCodGlosario.setEditable(false);
        txtCodGlosario.setEnabled(false);
        txtCodGlosario.setPreferredSize(new Dimension(71, 27));

        txtDescGlosario.setEditable(false);
        txtDescGlosario.setEnabled(false);
        txtDescGlosario.setPreferredSize(new Dimension(64, 27));

        cmbSubModelo.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                        .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelContenidoLayout.createSequentialGroup()
                                .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelContenidoLayout.createSequentialGroup()
                                        .addComponent(txtCodGlosario, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDescGlosario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtModeloProyecto, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarGlosario)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSubModelo, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIM, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSD, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtArchivoScript, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1172, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(btnLoadScript)
                            .addComponent(btnValidar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        panelContenidoLayout.setVerticalGroup(
            panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(btnValidar)
                    .addGroup(panelContenidoLayout.createSequentialGroup()
                        .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(txtModeloProyecto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(cmbSubModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(txtIM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBuscarGlosario))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtCodGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txtArchivoScript, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLoadScript))
                            .addComponent(jLabel5))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
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
