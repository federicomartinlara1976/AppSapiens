package com.mdval.ui.validacionscripts;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import com.mdval.ui.utils.PanelSupport;

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

		jScrollPane1.setViewportView(tblResultados);

		btnMarcarExcepcion.setMaximumSize(new Dimension(130, 27));
		btnMarcarExcepcion.setMinimumSize(new Dimension(130, 27));
		btnMarcarExcepcion.setPreferredSize(new Dimension(130, 27));

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(btnAddTodosGlosario, GroupLayout.Alignment.TRAILING,
										GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(btnAddGlosario, GroupLayout.Alignment.TRAILING,
										GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(btnMarcarExcepcion, GroupLayout.Alignment.TRAILING,
										GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnGenerarLog, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(btnMarcarExcepcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnAddGlosario)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnAddTodosGlosario)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnGenerarLog))
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
				.addContainerGap()));
	}

	/**
	 *
	 */
	@Override
	protected void setupLiterals() {
		btnMarcarExcepcion.setText("Marcar como Excepción");
		btnMarcarExcepcion.setToolTipText("Marcar como Excepción");
		btnAddGlosario.setText("Añadir a Glosario");
		btnAddGlosario.setToolTipText("Añadir a Glosario");
		btnAddTodosGlosario.setText("Añadir Todos a Glosario");
		btnAddTodosGlosario.setToolTipText("Añadir Todos a Glosario");
		btnGenerarLog.setText("Generar log para Incidencia");
		btnGenerarLog.setToolTipText("Generar log para Incidencia");
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
		btnMarcarExcepcion.setEnabled(false);
		btnAddGlosario.setEnabled(false);
		btnAddTodosGlosario.setEnabled(false);
		btnGenerarLog.setEnabled(false);
	}

	@Override
	protected void initModels() {
		tblResultados.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null } },
				new String[] { "Validación", "Tipo Elemento", "Nombre Elemento", "Tipo", "Longitud", "Decimales",
						"Resultado Validación", "Detalle Validación" }));
	}
}
