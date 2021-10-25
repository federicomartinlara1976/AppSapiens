package com.mdval.ui.normasnomenclatura;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Map;
import java.util.Objects;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.mdval.bussiness.entities.TipoParticula;
import com.mdval.ui.listener.DlgAltaModificacionTiposParticulaListener;
import com.mdval.ui.listener.FrmDefinicionTiposParticulaListener;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.utils.AppGlobalSingleton;
import com.mdval.utils.AppHelper;
import com.mdval.utils.Constants;

import lombok.Getter;

/**
 *
 * @author federico
 */
public class DlgAltaModificacionTiposParticula extends DialogSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 69380158124292971L;

	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	
	@Getter
	private JCheckBox chkDistingueProyecto;
	
	@Getter
	private JCheckBox chkDistingueSubproyecto;
	
	@Getter
	private JTextField txtCodigo;
	
	@Getter
	private JTextField txtDescripcion;
	
	@Getter
	private JTextField txtFecha;
	
	@Getter
	private JTextField txtUsuario;
	
	@Getter
    private Boolean editar;

    
    public DlgAltaModificacionTiposParticula(FrameSupport parent, boolean modal) {
        super(parent, modal);
    }
    
    public DlgAltaModificacionTiposParticula(FrameSupport parent, boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }

	/**
	 *
	 */
	protected void setupComponents() {

		jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        txtCodigo = new JTextField();
        jLabel3 = new JLabel();
        txtDescripcion = new JTextField();
        jLabel4 = new JLabel();
        txtUsuario = new JTextField();
        jLabel5 = new JLabel();
        txtFecha = new JTextField();
        btnAceptar = new JButton();
        btnCancelar = new JButton();
        jLabel6 = new JLabel();
        chkDistingueProyecto = new JCheckBox();
        jLabel7 = new JLabel();
        chkDistingueSubproyecto = new JCheckBox();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        panelLogo.setPreferredSize(new Dimension(286, 63));

        GroupLayout panelLogoLayout = new GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        jLabel1.setFont(new Font("Dialog", 1, 18)); // NOI18N
        
        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel2.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel2.setPreferredSize(new Dimension(150, 17));

        txtCodigo.setEditable(false);
        txtCodigo.setEnabled(false);
        txtCodigo.setMinimumSize(new Dimension(4, 27));
        txtCodigo.setPreferredSize(new Dimension(80, 27));

        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel3.setPreferredSize(new Dimension(150, 17));

        txtDescripcion.setPreferredSize(new Dimension(400, 27));

        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel4.setPreferredSize(new Dimension(150, 17));

        txtUsuario.setEditable(false);
        txtUsuario.setEnabled(false);
        txtUsuario.setPreferredSize(new Dimension(150, 27));

        jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel5.setPreferredSize(new Dimension(150, 17));

        txtFecha.setEditable(false);
        txtFecha.setEnabled(false);
        txtFecha.setPreferredSize(new Dimension(150, 27));

        btnAceptar.setPreferredSize(new Dimension(98, 27));

        chkDistingueProyecto.setPreferredSize(new Dimension(27, 27));

        chkDistingueSubproyecto.setPreferredSize(new Dimension(27, 27));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 566, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chkDistingueProyecto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chkDistingueSubproyecto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(chkDistingueProyecto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkDistingueSubproyecto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
	}

	@Override
	protected void setupLiterals() {
		setTitle(literales.getLiteral("dlgAltaModificacionTiposParticula.titulo"));
		
		jLabel1.setText(literales.getLiteral("dlgAltaModificacionTiposParticula.titulo"));
		jLabel2.setText(literales.getLiteral("dlgAltaModificacionTiposParticula.codigo"));
		jLabel3.setText(literales.getLiteral("dlgAltaModificacionTiposParticula.descripcion"));
		jLabel4.setText(literales.getLiteral("dlgAltaModificacionTiposParticula.usuario"));
		jLabel5.setText(literales.getLiteral("dlgAltaModificacionTiposParticula.fecha"));
		jLabel6.setText(literales.getLiteral("dlgAltaModificacionTiposParticula.distingueProyecto"));
		jLabel7.setText(literales.getLiteral("dlgAltaModificacionTiposParticula.distingueSubproyecto"));
		
		btnAceptar.setText(literales.getLiteral("dlgAltaModificacionTiposParticula.aceptar"));
		btnCancelar.setText(literales.getLiteral("dlgAltaModificacionTiposParticula.cancelar"));
	}
	
	@Override
	protected void initEvents() {
		FrmDefinicionTiposParticula parent = (FrmDefinicionTiposParticula) this.getParent();
		FrmDefinicionTiposParticulaListener frmDefinicionTiposParticulaListener = parent.getFrmDefinicionTiposParticulaListener();
		
		DlgAltaModificacionTiposParticulaListener actionListener = new DlgAltaModificacionTiposParticulaListener(this);
		actionListener.addObservador(frmDefinicionTiposParticulaListener);
		
		btnAceptar.setActionCommand(Constants.DLG_ALTA_MODIFICACION_TIPOS_PARTICULA_BTN_ACEPTAR);
		btnCancelar.setActionCommand(Constants.DLG_ALTA_MODIFICACION_TIPOS_PARTICULA_BTN_CANCELAR);
		
		btnAceptar.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);
	}

	@Override
	protected void initialState() {
		AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
		
		// Se trata de la edición de un registro
		if (!Objects.isNull(params)) {
			TipoParticula tipoParticula = (TipoParticula) params.get(Constants.FRM_DEFINICION_TIPOS_PARTICULA_SELECCIONADO);
			
			txtCodigo.setText(tipoParticula.getCodigoParticula().toString());
			txtDescripcion.setText(tipoParticula.getDescripcionParticula());
			txtUsuario.setText(tipoParticula.getCodigoUsuario());
			
			String mcaProyecto = tipoParticula.getMcaProyecto();
			chkDistingueProyecto.setSelected(AppHelper.normalizeCheckValue(mcaProyecto));
			
			String mcaSubproyecto = tipoParticula.getMcaSubProyecto();
			chkDistingueSubproyecto.setSelected(AppHelper.normalizeCheckValue(mcaSubproyecto));
			
			txtFecha.setText(dateFormatter.dateToString(tipoParticula.getFechaActualizacion()));
			
			editar = Boolean.TRUE;
		}
		else {
			String cod_usr = (String) appGlobalSingleton.getProperty(Constants.COD_USR);
			txtUsuario.setText(cod_usr);
			
			editar = Boolean.FALSE;
		}
	}

	@Override
	protected void initModels() {}
}
