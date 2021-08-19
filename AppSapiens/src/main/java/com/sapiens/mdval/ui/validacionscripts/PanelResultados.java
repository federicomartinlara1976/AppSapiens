package com.sapiens.mdval.ui.validacionscripts;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import com.sapiens.mdval.ui.utils.PanelSupport;

/**
 *
 * @author federico
 */
public class PanelResultados extends PanelSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8717868648566455220L;
	
	private JButton btnAddGlosario;
    private JButton btnAddTodosGlosario;
    private JButton btnGenerarLog;
    private JButton btnMarcarExcepcion;
    
    private JScrollPane jScrollPane1;
    
    private JTable tblResultados;

    /**
     * Creates new form PanelResultados
     */
    public PanelResultados() {
        super();
    }

    /**
     *
     */
    protected void initComponents() {

        jScrollPane1 = new JScrollPane();
        tblResultados = new JTable();
        btnMarcarExcepcion = new JButton();
        btnAddGlosario = new JButton();
        btnAddTodosGlosario = new JButton();
        btnGenerarLog = new JButton();
        
        setBorder(BorderFactory.createEtchedBorder());

        tblResultados.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Validación", "Tipo Elemento", "Nombre Elemento", "Tipo", "Longitud", "Decimales", "Resultado Validación", "Detalle Validación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblResultados);

        btnMarcarExcepcion.setEnabled(false);
        btnAddGlosario.setEnabled(false);
        btnAddTodosGlosario.setEnabled(false);
        btnGenerarLog.setEnabled(false);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btnMarcarExcepcion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddGlosario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddTodosGlosario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGenerarLog, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMarcarExcepcion)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddGlosario)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddTodosGlosario)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerarLog))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
    }

    /**
     *
     */
    @Override
	protected void setupLiterals() {
    	btnMarcarExcepcion.setText("Marcar como Excepción");
    	btnAddGlosario.setText("Añadir a Glosario");
    	btnAddTodosGlosario.setText("Añadir Todos a Glosario");
    	btnGenerarLog.setText("Generar log para Incidencia");
    }
    
	/**
	 *
	 */
	@Override
	protected void initEvents() {
		// TODO Auto-generated method stub
		
	}

	/**
	 *
	 */
	@Override
	protected void initialState() {
		// TODO Auto-generated method stub
		
	}
}
