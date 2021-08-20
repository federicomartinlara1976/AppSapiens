package com.sapiens.mdval.ui.modelos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.sapiens.mdval.ui.model.SiNoComboBoxModel;
import com.sapiens.mdval.ui.utils.FrameSupport;

import lombok.Getter;

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
    
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    
    private JPanel panelTabla;
    private JTable tblValoresPosibles;
    
    @Getter
    private JComboBox<String> cmbGeneraVariables;
    
    @Getter
    private JComboBox<String> cmbGrantAll;
    
    @Getter
    private JComboBox<String> cmbGrantPublic;
    
    @Getter
    private JComboBox<String> cmbNorma;
    
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
    private JTextArea txtObservaciones;
	
	/**
     * Creates new form DlgModificacionNormas
     */
    public FrmMantenimientoModelos() {
        super();
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
        tblValoresPosibles = new JTable();
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

        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel2.setHorizontalTextPosition(SwingConstants.RIGHT);

        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        
        txtCodModelo.setPreferredSize(new Dimension(4, 27));
        
        txtNombreModelo.setMinimumSize(new Dimension(4, 27));
        txtNombreModelo.setPreferredSize(new Dimension(64, 27));
        
        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel6.setHorizontalTextPosition(SwingConstants.RIGHT);

        cmbNorma.setModel(new DefaultComboBoxModel<>(new String[] { "Norma 1", "Norma 2", "Norma 3", "Norma 4" }));

        panelTabla.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        tblValoresPosibles.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "COD", "DESCRIPCIÓN", "COD_USR", "FEC_ACTU"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblValoresPosibles);

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

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodModelo, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtEsquema, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtHerramienta, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
                                .addGap(84, 84, 84))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbGrantAll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbGrantPublic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNombreModelo, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtBD, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbNorma, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCarpeta, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10))
                                    .addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCodGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDescGlosario, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscarGlosario))
                                    .addComponent(txtGrupo, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cmbGeneraVariables, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
                                            .addComponent(jScrollPane2)
                                            .addComponent(panelTabla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
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
                    .addComponent(txtCodModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmbNorma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtCodGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarGlosario))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEsquema, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtBD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtCarpeta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtGrupo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtHerramienta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGrantAll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(cmbGrantPublic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(cmbGeneraVariables, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
    	setTitle("Definición de Modelos");
    	
    	jLabel1.setText("Definición de Modelos");
    	jLabel2.setText("Cod. Modelo");
    	jLabel3.setText("Nombre Modelo");
    	jLabel4.setText("Glosario");
        jLabel5.setText("Esquema");
    	jLabel6.setText("Norma");
    	jLabel7.setText("Código");
    	jLabel8.setText("Base de Datos");
        jLabel9.setText("Carpeta");
        jLabel10.setText("Grupo");
        jLabel11.setText("Herramienta");
        jLabel12.setText("Usuario");
        jLabel13.setText("Fecha");
        jLabel14.setText("Grant ALL");
        jLabel15.setText("Grant Public");
        jLabel16.setText("Genera Variables");
        jLabel17.setText("Observaciones");
    	jLabel18.setText("Descripción");
    	jLabel19.setText("Submodelos");
    	
    	btnAddSubmodelo.setText("+");
        btnRemoveSubmodelo.setText("-");
        btnAceptar.setText("ACEPTAR");
        btnCancelar.setText("CANCELAR");
	}

	@Override
	protected void initEvents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialState() {
		cmbGrantAll.setSelectedIndex(1);
        cmbGrantPublic.setSelectedIndex(1);
        cmbGeneraVariables.setSelectedIndex(1);
	}

	@Override
	protected void initModels() {
		cmbGrantAll.setModel(new SiNoComboBoxModel());
        cmbGrantPublic.setModel(new SiNoComboBoxModel());
        cmbGeneraVariables.setModel(new SiNoComboBoxModel());
	}
}
