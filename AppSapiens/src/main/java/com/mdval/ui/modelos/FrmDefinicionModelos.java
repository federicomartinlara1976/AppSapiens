package com.mdval.ui.modelos;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.mdval.ui.listener.FrmDefinicionModelosListener;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.utils.Constants;

import lombok.Getter;

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
    private JButton btnBaja;
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
    
    private JTable tblGlosarios;
    
    @Getter
    private JComboBox<String> cmbNorma;
    
    @Getter
    private JTextField txtBaseDatos;
    
    @Getter
    private JTextField txtCodModelo;
    
    @Getter
    private JTextField txtEsquema;
    
    @Getter
    private JTextField txtGlosario;
    
    @Getter
    private JTextField txtNombreModelo;

    /**
     * 
     */
    public FrmDefinicionModelos() {
        super();
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
        tblGlosarios = new JTable();
        btnAlta = new JButton();
        jLabel3 = new JLabel();
        txtGlosario = new JTextField();
        jLabel4 = new JLabel();
        txtNombreModelo = new JTextField();
        jLabel5 = new JLabel();
        txtEsquema = new JTextField();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        txtBaseDatos = new JTextField();
        cmbNorma = new JComboBox<>();

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

        txtCodModelo.setMinimumSize(new Dimension(4, 27));
        txtCodModelo.setPreferredSize(new Dimension(300, 27));
        
        jLabel1.setFont(new Font("Dialog", 1, 18)); // NOI18N
        
        btnBaja.setPreferredSize(new Dimension(130, 27));
   
        btnSeleccionar.setPreferredSize(new Dimension(130, 27));

        tblGlosarios.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "COD_PROYECTO", "NOM_MODELO", "DES_NORMA", "DES_GLOSARIO", "NOM_ESQUEMA", "NOM_BBDD", "COD_USR", "FEC_ACTU"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblGlosarios);

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
        
        cmbNorma.setModel(new DefaultComboBoxModel<>(new String[] { "Norma 1", "Norma 2", "Norma 3", "Norma 4" }));
        
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
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtGlosario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtNombreModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtEsquema, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBaseDatos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbNorma, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)))
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
                    .addComponent(txtNombreModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
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
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
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
    	setTitle("Definición de Modelos");
    	
    	jLabel1.setText("Definición de Modelos");
        jLabel2.setText("Cod. Modelo:");
        jLabel3.setText("Glosario:");
        jLabel4.setText("Nombre Modelo:");
        jLabel5.setText("Esquema:");
        jLabel6.setText("Base de Datos:");
        jLabel7.setText("Norma:");
        
        btnBuscar.setText("BUSCAR");
        btnAlta.setText("ALTA");
        btnBaja.setText("BAJA");
        btnModificacion.setText("MODIFICACION");
        btnSeleccionar.setText("SELECCIONAR");
	}

	@Override
	protected void initEvents() {
		ActionListener listener = new FrmDefinicionModelosListener(this);
		
		btnAlta.setName(Constants.DLG_DEFINICION_MODELOS_BTN_ALTA);
		btnModificacion.setName(Constants.DLG_DEFINICION_MODELOS_BTN_MODIFICACION);
		
		btnAlta.addActionListener(listener);
		btnModificacion.addActionListener(listener);
		
	}

	@Override
	protected void initialState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initModels() {
		// TODO Auto-generated method stub
		
	}
}
