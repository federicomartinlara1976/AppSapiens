package com.mdval.ui.modelos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionListener;

import com.mdval.bussiness.entities.Glosario;
import com.mdval.bussiness.entities.Norma;
import com.mdval.bussiness.entities.SubProyecto;
import com.mdval.ui.listener.FrmDefinicionModelosListener;
import com.mdval.ui.listener.FrmMantenimientoModelosListener;
import com.mdval.ui.listener.tables.SubProyectoTableListener;
import com.mdval.ui.model.SiNoComboBoxModel;
import com.mdval.ui.model.SubProyectoTableModel;
import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.renderer.DateTimeRenderer;
import com.mdval.ui.renderer.NormaRenderer;
import com.mdval.ui.renderer.StringRenderer;
import com.mdval.ui.utils.FrameSupport;
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
public class FrmMantenimientoModelos extends FrameSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7038199523519052411L;
	
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnBuscarGlosario;
    private JButton btnAddSubmodelo;
    
    @Getter
    private JButton btnRemoveSubmodelo;
    
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel20;
    private JLabel jLabel21;
    
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    
    private JPanel panelTabla;
    
    @Getter
    private TableSupport tblSubproyectos;
    
    @Getter
    private JComboBox<String> cmbGeneraVariables;
    
    @Getter
    private JComboBox<String> cmbGrantAll;
    
    @Getter
    private JComboBox<String> cmbGrantPublic;
    
    @Getter
    private JComboBox<Norma> cmbNorma;
    
    @Getter
    private JComboBox<String> cmbVariablesConCapa;
    
    @Getter
    private JTextField txtCarpeta;
    
    @Getter
    private JTextField txtCodGlosario;
    
    @Getter
    private JTextField txtCodModelo;
    
    @Getter
    private JTextField txtCodigoSubmodelo;
    
    @Getter
    private JTextField txtDescGlosario;
    
    @Getter
    private JTextField txtDescripcionSubmodelo;
    
    @Getter
    private JTextField txtEsquema;
    
    @Getter
    private JTextField txtBD;
    
    @Getter
    private JTextField txtUsuario;
    
    @Getter
    private JTextField txtFecha;
    
    @Getter
    private JTextField txtGrupo;
    
    @Getter
    private JTextField txtHerramienta;
    
    @Getter
    private JTextField txtNombreModelo;
    
    @Getter
    private JTextField txtAplicacion;
    
    @Getter
    private JTextArea txtObservaciones;
    
    @Getter
    private FrmMantenimientoModelosListener frmMantenimientoModelosListener;
    
    @Getter
    @Setter
    private Glosario glosarioSeleccionado;
    
    @Getter
    @Setter
    private SubProyecto subProyectoSeleccionado;
    
    @Getter
    private Boolean editar;

    
    public FrmMantenimientoModelos(FrameSupport parent) {
        super(parent);
    }
    
    public FrmMantenimientoModelos(FrameSupport parent, Map<String, Object> params) {
        super(parent, params);
    }

    /**
     * 
     */
    protected void setupComponents() {

    	jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        txtCodModelo = new JTextField();
        txtNombreModelo = new JTextField();
        jLabel6 = new JLabel();
        cmbNorma = new JComboBox<>();
        cmbGrantAll = new JComboBox<>();
        panelTabla = new JPanel();
        jScrollPane1 = new JScrollPane();
        tblSubproyectos = new TableSupport(Boolean.FALSE);
        jLabel7 = new JLabel();
        txtCodigoSubmodelo = new JTextField();
        jLabel18 = new JLabel();
        txtDescripcionSubmodelo = new JTextField();
        btnAddSubmodelo = new JButton();
        btnRemoveSubmodelo = new JButton();
        btnAceptar = new JButton();
        btnCancelar = new JButton();
        jLabel4 = new JLabel();
        txtCodGlosario = new JTextField();
        txtDescGlosario = new JTextField();
        btnBuscarGlosario = new JButton();
        jLabel5 = new JLabel();
        txtEsquema = new JTextField();
        txtBD = new JTextField();
        jLabel8 = new JLabel();
        txtCarpeta = new JTextField();
        jLabel9 = new JLabel();
        txtGrupo = new JTextField();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        txtHerramienta = new JTextField();
        txtUsuario = new JTextField();
        jLabel12 = new JLabel();
        txtFecha = new JTextField();
        jLabel13 = new JLabel();
        cmbGrantPublic = new JComboBox<>();
        cmbGeneraVariables = new JComboBox<>();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        jLabel17 = new JLabel();
        jScrollPane2 = new JScrollPane();
        txtObservaciones = new JTextArea();
        jLabel19 = new JLabel();
        jLabel20 = new JLabel();
        txtAplicacion = new JTextField();
        jLabel21 = new JLabel();
        cmbVariablesConCapa = new JComboBox<>();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(1319, 712));

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
        
        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel2.setHorizontalTextPosition(SwingConstants.RIGHT);

        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        
        txtCodModelo.setPreferredSize(new Dimension(4, 27));

        txtNombreModelo.setMinimumSize(new Dimension(4, 27));
        txtNombreModelo.setPreferredSize(new Dimension(64, 27));

        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel6.setHorizontalTextPosition(SwingConstants.RIGHT);

        panelTabla.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        jScrollPane1.setViewportView(tblSubproyectos);

        jLabel7.setHorizontalAlignment(SwingConstants.RIGHT);
        
        txtCodigoSubmodelo.setPreferredSize(new Dimension(64, 27));

        jLabel18.setHorizontalAlignment(SwingConstants.RIGHT);
        
        txtDescripcionSubmodelo.setPreferredSize(new Dimension(64, 27));

        btnRemoveSubmodelo.setPreferredSize(new Dimension(41, 27));

        GroupLayout panelTablaLayout = new GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCodigoSubmodelo, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDescripcionSubmodelo, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddSubmodelo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemoveSubmodelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTablaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCodigoSubmodelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtDescripcionSubmodelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddSubmodelo)
                    .addComponent(btnRemoveSubmodelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnAceptar.setPreferredSize(new Dimension(130, 27));
        
        btnCancelar.setPreferredSize(new Dimension(130, 27));

        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel4.setHorizontalTextPosition(SwingConstants.RIGHT);

        txtCodGlosario.setMinimumSize(new Dimension(4, 27));
        txtCodGlosario.setPreferredSize(new Dimension(64, 27));
        
        txtDescGlosario.setMinimumSize(new Dimension(4, 27));
        txtDescGlosario.setPreferredSize(new Dimension(64, 27));
        
        btnBuscarGlosario.setIcon(new ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N

        jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel5.setHorizontalTextPosition(SwingConstants.RIGHT);

        txtEsquema.setPreferredSize(new Dimension(4, 27));
        
        txtBD.setPreferredSize(new Dimension(4, 27));
        
        jLabel8.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel8.setHorizontalTextPosition(SwingConstants.RIGHT);

        txtCarpeta.setPreferredSize(new Dimension(4, 27));
        
        jLabel9.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel9.setHorizontalTextPosition(SwingConstants.RIGHT);

        txtGrupo.setPreferredSize(new Dimension(4, 27));
        
        jLabel10.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel10.setHorizontalTextPosition(SwingConstants.RIGHT);

        jLabel11.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel11.setHorizontalTextPosition(SwingConstants.RIGHT);

        txtHerramienta.setPreferredSize(new Dimension(4, 27));
        
        txtUsuario.setEditable(false);
        txtUsuario.setEnabled(false);
        txtUsuario.setPreferredSize(new Dimension(4, 27));
        
        jLabel12.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel12.setHorizontalTextPosition(SwingConstants.RIGHT);

        txtFecha.setEditable(false);
        txtFecha.setEnabled(false);
        txtFecha.setPreferredSize(new Dimension(4, 27));
        
        jLabel13.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel13.setHorizontalTextPosition(SwingConstants.RIGHT);

        jLabel14.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel14.setHorizontalTextPosition(SwingConstants.RIGHT);

        jLabel15.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel15.setHorizontalTextPosition(SwingConstants.RIGHT);

        jLabel16.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel16.setHorizontalTextPosition(SwingConstants.RIGHT);

        jLabel17.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel17.setHorizontalTextPosition(SwingConstants.RIGHT);

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane2.setViewportView(txtObservaciones);

        jLabel19.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel19.setHorizontalTextPosition(SwingConstants.RIGHT);

        jLabel20.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel20.setHorizontalTextPosition(SwingConstants.RIGHT);

        txtAplicacion.setPreferredSize(new Dimension(4, 27));

        jLabel21.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel21.setHorizontalTextPosition(SwingConstants.RIGHT);

        cmbVariablesConCapa.setModel(new DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        cmbVariablesConCapa.setSelectedIndex(1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel11))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbGrantAll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbGrantPublic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbGeneraVariables, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbVariablesConCapa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(txtEsquema, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtHerramienta, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
                                        .addGap(60, 60, 60)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                            .addComponent(jLabel12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCodModelo, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreModelo, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBD, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbNorma, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCarpeta, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(txtGrupo, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtCodGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtDescGlosario, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnBuscarGlosario))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtAplicacion, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel17))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(panelTabla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane2))))))))
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
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtCodModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel4)
                        .addComponent(txtCodGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombreModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbNorma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDescGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarGlosario))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEsquema, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(txtCarpeta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtGrupo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtBD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtHerramienta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel20)
                    .addComponent(txtAplicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cmbGrantAll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(cmbGrantPublic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(cmbGeneraVariables, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(cmbVariablesConCapa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(panelTabla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }
    
    @Override
	protected void setupLiterals() {
    	setTitle(literales.getLiteral("dlgMantenimientoModelos.titulo"));
    	
    	jLabel1.setText(literales.getLiteral("dlgMantenimientoModelos.titulo"));
    	jLabel2.setText(literales.getLiteral("dlgMantenimientoModelos.codModelo"));
    	jLabel3.setText(literales.getLiteral("dlgMantenimientoModelos.nombreModelo"));
    	jLabel4.setText(literales.getLiteral("dlgMantenimientoModelos.glosario"));
        jLabel5.setText(literales.getLiteral("dlgMantenimientoModelos.esquema"));
    	jLabel6.setText(literales.getLiteral("dlgMantenimientoModelos.norma"));
    	jLabel7.setText(literales.getLiteral("dlgMantenimientoModelos.codigo"));
    	jLabel8.setText(literales.getLiteral("dlgMantenimientoModelos.baseDatos"));
        jLabel9.setText(literales.getLiteral("dlgMantenimientoModelos.carpeta"));
        jLabel10.setText(literales.getLiteral("dlgMantenimientoModelos.grupo"));
        jLabel11.setText(literales.getLiteral("dlgMantenimientoModelos.herramienta"));
        jLabel12.setText(literales.getLiteral("dlgMantenimientoModelos.usuario"));
        jLabel13.setText(literales.getLiteral("dlgMantenimientoModelos.fecha"));
        jLabel14.setText(literales.getLiteral("dlgMantenimientoModelos.grantAll"));
        jLabel15.setText(literales.getLiteral("dlgMantenimientoModelos.grantPublic"));
        jLabel16.setText(literales.getLiteral("dlgMantenimientoModelos.generaVariables"));
        jLabel17.setText(literales.getLiteral("dlgMantenimientoModelos.observaciones"));
    	jLabel18.setText(literales.getLiteral("dlgMantenimientoModelos.descripcion"));
    	jLabel19.setText(literales.getLiteral("dlgMantenimientoModelos.submodelos"));
    	jLabel20.setText(literales.getLiteral("dlgMantenimientoModelos.aplicacion"));
    	jLabel21.setText(literales.getLiteral("dlgMantenimientoModelos.variablesCapa"));
    	
    	btnAddSubmodelo.setText(literales.getLiteral("dlgMantenimientoModelos.mas"));
        btnRemoveSubmodelo.setText(literales.getLiteral("dlgMantenimientoModelos.menos"));
        btnAceptar.setText(literales.getLiteral("dlgMantenimientoModelos.aceptar"));
        btnCancelar.setText(literales.getLiteral("dlgMantenimientoModelos.cancelar"));
	}

	@Override
	protected void initEvents() {
		FrmDefinicionModelos frmDefinicionModelos = (FrmDefinicionModelos) this.getParent();
		FrmDefinicionModelosListener frmDefinicionModelosListener = frmDefinicionModelos.getFrmDefinicionModelosListener();
		
		frmMantenimientoModelosListener = new FrmMantenimientoModelosListener(this);
		ListSelectionListener listSelectionListener = new SubProyectoTableListener(this);
		
		frmMantenimientoModelosListener.addObservador(frmDefinicionModelosListener);
		
		btnBuscarGlosario.setActionCommand(Constants.FRM_MANTENIMIENTO_MODELOS_BTN_BUSCAR_GLOSARIO);
		btnAddSubmodelo.setActionCommand(Constants.FRM_MANTENIMIENTO_MODELOS_BTN_ADD_SUBMODELO);
		btnRemoveSubmodelo.setActionCommand(Constants.FRM_MANTENIMIENTO_MODELOS_BTN_REMOVE_SUBMODELO);
		btnAceptar.setActionCommand(Constants.FRM_MANTENIMIENTO_MODELOS_BTN_ACEPTAR);
		btnCancelar.setActionCommand(Constants.FRM_MANTENIMIENTO_MODELOS_BTN_CANCELAR);
		
		btnBuscarGlosario.addActionListener(frmMantenimientoModelosListener);
		btnAddSubmodelo.addActionListener(frmMantenimientoModelosListener);
		btnRemoveSubmodelo.addActionListener(frmMantenimientoModelosListener);
		btnAceptar.addActionListener(frmMantenimientoModelosListener);
		btnCancelar.addActionListener(frmMantenimientoModelosListener);
		
		ListSelectionModel rowSM = tblSubproyectos.getSelectionModel();
		rowSM.addListSelectionListener(listSelectionListener);
		
		this.addOnLoadListener(frmMantenimientoModelosListener);
	}

	@Override
	protected void initialState() {
		AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
		
		txtUsuario.setEnabled(Boolean.FALSE);
        txtUsuario.setEditable(Boolean.FALSE);
        txtFecha.setEnabled(Boolean.FALSE);
        txtFecha.setEditable(Boolean.FALSE);
        btnRemoveSubmodelo.setEnabled(Boolean.FALSE);
		
		if (!Objects.isNull(params)) {
			editar = Boolean.TRUE;
		}
		else {
			cmbGrantAll.setSelectedItem(Constants.NO);
	        cmbGrantPublic.setSelectedItem(Constants.NO);
	        cmbGeneraVariables.setSelectedItem(Constants.SI);
	        cmbVariablesConCapa.setSelectedItem(Constants.SI);
	        
	        String cod_usr = (String) appGlobalSingleton.getProperty(Constants.COD_USR);
			txtUsuario.setText(cod_usr);
	        
	        editar = Boolean.FALSE;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void initModels() {
		tblSubproyectos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblSubproyectos.setDefaultRenderer(Date.class, new DateTimeRenderer());
		tblSubproyectos.setDefaultRenderer(String.class, new StringRenderer());
		
		cmbGrantAll.setModel(new SiNoComboBoxModel());
        cmbGrantPublic.setModel(new SiNoComboBoxModel());
        cmbGeneraVariables.setModel(new SiNoComboBoxModel());
        cmbVariablesConCapa.setModel(new SiNoComboBoxModel());
        
        cmbNorma.setRenderer(new NormaRenderer());
        
        Cabecera cabecera = UIHelper.createCabeceraTabla(Constants.FRM_MANTENIMIENTO_MODELOS_SUBPROYECTO_TABLA_CABECERA);
        tblSubproyectos.setModel(new SubProyectoTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
	}
}
