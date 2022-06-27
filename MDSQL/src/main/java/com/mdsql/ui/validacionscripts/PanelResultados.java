package com.mdsql.ui.validacionscripts;

import java.awt.Dimension;
import java.math.BigDecimal;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;

import com.mdsql.bussiness.entities.DetValidacion;
import com.mdsql.ui.listener.PanelResultadosListener;
import com.mdsql.ui.model.DetalleValidacionTableModel;
import com.mdsql.ui.model.cabeceras.Cabecera;
import com.mdsql.ui.renderer.BigDecimalRenderer;
import com.mdsql.ui.renderer.StringRenderer;
import com.mdsql.ui.utils.PanelSupport;
import com.mdsql.ui.utils.TableSupport;
import com.mdsql.ui.utils.UIHelper;
import com.mdsql.utils.Constants;

import lombok.Getter;
import lombok.Setter;

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
	
	@Getter
	@Setter
	private transient DetValidacion seleccionado;
	
	@Getter
	private transient PanelPrincipal panelPrincipal;
	
	@Getter
	private transient PanelResultadosListener panelResultadosListener;

	/**
	 * Creates new form PanelResultados
	 */
	public PanelResultados() {
		super();
	}
	
	/**
	 * Creates new form PanelResultados
	 */
	public PanelResultados(PanelPrincipal panelPrincipal) {
		super();
		this.panelPrincipal = panelPrincipal;
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
		panelResultadosListener = new PanelResultadosListener(this);
		
		btnMarcarExcepcion.setActionCommand(Constants.PANEL_RESULTADOS_BTN_MARCAR_EXCEPCION);
		btnAddGlosario.setActionCommand(Constants.PANEL_RESULTADOS_BTN_ADD_GLOSARIO);
		btnAddTodosGlosario.setActionCommand(Constants.PANEL_RESULTADOS_BTN_ADD_TODOS_GLOSARIO);
		btnGenerarLog.setActionCommand(Constants.PANEL_RESULTADOS_BTN_GENERAR_LOG);

		btnMarcarExcepcion.addActionListener(panelResultadosListener);
		btnAddGlosario.addActionListener(panelResultadosListener);
		btnAddTodosGlosario.addActionListener(panelResultadosListener);
		btnGenerarLog.addActionListener(panelResultadosListener);
	}

	/**
	 *
	 */
	@Override
	protected void initialState() {
		btnMarcarExcepcion.setEnabled(Boolean.FALSE);
		btnAddGlosario.setEnabled(Boolean.FALSE);
		btnAddTodosGlosario.setEnabled(Boolean.FALSE);
		btnGenerarLog.setEnabled(Boolean.FALSE);
	}

	@Override
	protected void initModels() {
		Cabecera cabecera = UIHelper.createCabeceraTabla(Constants.DETALLE_VALIDACION_TABLA_CABECERA);
		tblResultados.setModel(new DetalleValidacionTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
		
		tblResultados.setDefaultRenderer(BigDecimal.class, new BigDecimalRenderer());
		tblResultados.setDefaultRenderer(String.class, new StringRenderer());
		tblResultados.setColumnWidths(cabecera);
	}
	
	/**
	 * 
	 */
	public void reset() {
		initialState();
		
		DetalleValidacionTableModel model = (DetalleValidacionTableModel) tblResultados.getModel();
		model.clearData();
	}
}
