package com.sapiens.mdval.ui.glosarios;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.sapiens.mdval.ui.listener.FrmGlosarioCamposListener;
import com.sapiens.mdval.ui.utils.FrameSupport;
import com.sapiens.mdval.utils.Constants;

import lombok.Getter;

/**
 *
 * @author federico
 */
public class FrmGlosarioCampos extends FrameSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3506678199253519307L;
	
	private JButton btnAlta;
    private JButton btnBaja;
    private JButton btnBuscar;
    private JButton btnBuscarGlosario;
    private JButton btnImprimir;
    private JButton btnModificacion;
    
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    
    private JTable tblCampos;
    private JTable tblModelos;
    
    @Getter
    private JComboBox<String> cmbMostrarExcepciones;
    
    @Getter
    private JComboBox<String> cmbTipoDato;
    
    @Getter
    private JTextField txtCodigoGlosario;
    
    @Getter
    private JTextField txtCodigoNorma;
    
    @Getter
    private JTextField txtGlosario;
    
    @Getter
    private JTextField txtNombreColumna;
    
    @Getter
    private JTextField txtNorma;
    
    
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
        jLabel5 = new JLabel();
        txtCodigoNorma = new JTextField();
        txtNorma = new JTextField();
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

        cmbTipoDato.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbMostrarExcepciones.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtCodigoNorma.setPreferredSize(new Dimension(64, 27));

        txtNorma.setPreferredSize(new Dimension(64, 27));

        tblCampos.setModel(new DefaultTableModel(
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
        jScrollPane2.setViewportView(tblCampos);

        tblModelos.setModel(new DefaultTableModel(
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
                        .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2)
                                        .addGap(22, 22, 22))
                                    .addComponent(jScrollPane1))
                                .addGap(91, 91, 91))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBaja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreColumna, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigoGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGlosario, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarGlosario, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbTipoDato, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                .addGap(162, 162, 162)
                                .addComponent(jLabel5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoNorma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNorma, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbMostrarExcepciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscar)))))
                .addContainerGap())
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
                        .addComponent(jLabel3)
                        .addComponent(txtNorma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCodigoNorma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
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
                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBaja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnModificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
    }
    
    /**
     * @throws IOException
     */
    protected void setupLiterals() {
		setTitle(literales.getLiteral("dlgGlosarioCampos.titulo"));
        
		jLabel1.setText("Glosario:");
        jLabel2.setText("Nombre de Columna:");
        jLabel3.setText("Tipo de Dato:");
        jLabel4.setText("Mostrar excepciones:");
        jLabel5.setText("Norma:");
        jLabel6.setText("Glosario de Campos");
        jLabel7.setText("Campos:");
        jLabel8.setText("Modelos:");
        
        btnBuscar.setText("BUSCAR");
        btnAlta.setText("ALTA");
        btnBaja.setText("BAJA");
        btnModificacion.setText("MODIFICACIÓN");
        btnImprimir.setText("IMPRIMIR");
    }
	
	/**
	 * 
	 */
	protected void initEvents() {
		ActionListener actionListener = new FrmGlosarioCamposListener(this);
		
		btnBuscarGlosario.setName(Constants.DLG_GLOSARIO_CAMPOS_BTN_BUSCAR_GLOSARIO);
		btnBuscar.setName(Constants.DLG_GLOSARIO_CAMPOS_BTN_BUSCAR);
		btnAlta.setName(Constants.DLG_GLOSARIO_CAMPOS_BTN_ALTA);
		btnBaja.setName(Constants.DLG_GLOSARIO_CAMPOS_BTN_BAJA);
		btnModificacion.setName(Constants.DLG_GLOSARIO_CAMPOS_BTN_MODIFICACION);
		btnImprimir.setName(Constants.DLG_GLOSARIO_CAMPOS_BTN_IMPRIMIR);
		
		btnBuscarGlosario.addActionListener(actionListener);
		btnBuscar.addActionListener(actionListener);
		btnAlta.addActionListener(actionListener);
		btnBaja.addActionListener(actionListener);
		btnModificacion.addActionListener(actionListener);
		btnImprimir.addActionListener(actionListener);
	}
	
	/**
	 * 
	 */
	protected void initialState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initModels() {
		// TODO Auto-generated method stub
		
	}
}
