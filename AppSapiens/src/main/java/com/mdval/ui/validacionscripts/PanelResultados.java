package com.mdval.ui.validacionscripts;

import java.awt.Dimension;
import java.math.BigDecimal;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;

import com.mdval.ui.model.DetalleValidacionTableModel;
import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.renderer.BigDecimalRenderer;
import com.mdval.ui.renderer.StringRenderer;
import com.mdval.ui.utils.PanelSupport;
import com.mdval.ui.utils.TableSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.Constants;

import lombok.Getter;

/**
 *
 * @author federico
 */
public class PanelResultados extends PanelSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8717868648566455220L;

	@Getter
	private JButton btnAddGlosario;
	
	@Getter
	private JButton btnAddTodosGlosario;
	
	@Getter
	private JButton btnGenerarLog;
	
	@Getter
	private JButton btnMarcarExcepcion;

	private JScrollPane jScrollPane1;

	@Getter
	private TableSupport tblResultados;

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
		tblResultados = new TableSupport(Boolean.FALSE);
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
		btnMarcarExcepcion.setText(literales.getLiteral("panelResultados.marcarExcepcion"));
		btnMarcarExcepcion.setToolTipText(literales.getLiteral("panelResultados.marcarExcepcion"));
		btnAddGlosario.setText(literales.getLiteral("panelResultados.addGlosario"));
		btnAddGlosario.setToolTipText(literales.getLiteral("panelResultados.addGlosario"));
		btnAddTodosGlosario.setText(literales.getLiteral("panelResultados.addTodos"));
		btnAddTodosGlosario.setToolTipText(literales.getLiteral("panelResultados.addTodos"));
		btnGenerarLog.setText(literales.getLiteral("panelResultados.generarLogIncidencia"));
		btnGenerarLog.setToolTipText(literales.getLiteral("panelResultados.generarLogIncidencia"));
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
		Cabecera cabecera = UIHelper.createCabeceraTabla(Constants.DETALLE_VALIDACION_TABLA_CABECERA);
		tblResultados.setModel(new DetalleValidacionTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
		
		tblResultados.setDefaultRenderer(BigDecimal.class, new BigDecimalRenderer());
		tblResultados.setDefaultRenderer(String.class, new StringRenderer());
	}
}
