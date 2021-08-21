package com.sapiens.mdval.ui.glosarios;

import com.sapiens.mdval.ui.listener.FrmAltaModificacionGlosariosListener;
import com.sapiens.mdval.ui.utils.FrameSupport;
import com.sapiens.mdval.utils.AppGlobalSingleton;
import com.sapiens.mdval.utils.Constants;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;
import javax.swing.*;
import lombok.Getter;

/**
 *
 * @author federico
 */
public class FrmAltaModificacionGlosarios extends FrameSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3875273085343772714L;
	
	private JButton btnAceptar;
    private JButton btnCancelar;
    
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    
    @Getter
    private JTextField txtAlta;
    
    @Getter
    private JTextField txtCodigo;
    
    @Getter
    private JTextField txtDescripcion;
    
    @Getter
    private JTextField txtModificacion;
    
    @Getter
    private JTextField txtUsuario;
   
    
    private Map<String, Object> params;

    
    public FrmAltaModificacionGlosarios() {
        super();
    }
    
    public FrmAltaModificacionGlosarios(Map<String, Object> params) {
        super();
        this.params = params;
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
        txtAlta = new JTextField();
        jLabel6 = new JLabel();
        txtModificacion = new JTextField();
        btnAceptar = new JButton();
        btnCancelar = new JButton();

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

        txtAlta.setEditable(false);
        txtAlta.setEnabled(false);
        txtAlta.setPreferredSize(new Dimension(150, 27));

        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel6.setPreferredSize(new Dimension(150, 17));

        txtModificacion.setEditable(false);
        txtModificacion.setEnabled(false);
        txtModificacion.setPreferredSize(new Dimension(150, 27));

        btnAceptar.setPreferredSize(new Dimension(98, 27));

        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 566, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtModificacion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtAlta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))))
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
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );
    }
    
    /**
     * @throws IOException
     */
    protected void setupLiterals() {
    	setTitle(literales.getLiteral("dlgAltaGlosarios.titulo"));
    	
    	jLabel1.setText("Alta/Modificación de Glosario");
    	jLabel2.setText("Código:");
    	jLabel3.setText("Descripción:");
    	jLabel4.setText("Usuario:");
    	jLabel5.setText("Alta:");
    	jLabel6.setText("Modificación:");
    	
    	btnAceptar.setText("ACEPTAR");
    	btnCancelar.setText("CANCELAR");
	}

	/**
	 * 
	 */
	protected void initEvents() {
		ActionListener actionListener = new FrmAltaModificacionGlosariosListener(this);
		
		btnAceptar.setName(Constants.DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_ACEPTAR);
		btnCancelar.setName(Constants.DLG_ALTA_MODIFICACION_GLOSARIOS_BTN_CANCELAR);
		
		btnAceptar.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);
	}

	/**
	 * 
	 */
	protected void initialState() {
		AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
		
		String cod_usr = (String) appGlobalSingleton.getProperty(Constants.COD_USR);
		txtUsuario.setText(cod_usr);
		
		txtUsuario.setEnabled(Boolean.FALSE);

        txtCodigo.setEnabled(Boolean.FALSE);
        txtAlta.setEnabled(Boolean.FALSE);
        txtModificacion.setEnabled(Boolean.FALSE);
	}

	@Override
	protected void initModels() {
		// TODO Auto-generated method stub
		
	}
}
