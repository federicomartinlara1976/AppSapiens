package com.mdval.ui.glosarios;

import java.awt.Dimension;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.mdval.bussiness.entities.CampoGlosario;
import com.mdval.ui.listener.DlgBajaGlosarioCamposListener;
import com.mdval.ui.listener.FrmGlosarioCamposListener;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.utils.Constants;

import lombok.Getter;

/**
 *
 * @author federico
 */
public class DlgBajaGlosarioCampos extends DialogSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7642984919355315851L;

    private JButton btnAceptar;
    private JButton btnCancelar;
    
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    
    private JScrollPane jScrollPane1;
    
    @Getter
    private JTextArea txtComentario;
    
    @Getter
    private JTextField txtRF;
    
    @Getter
    private JTextField txtSD;
    
    @Getter
    private CampoGlosario campoSeleccionado;
    
    /**
     * Creates new form DlgBajaGlosarioCampos
     */
    public DlgBajaGlosarioCampos(FrameSupport parent, boolean modal) {
        super(parent, modal);
    }
    
    public DlgBajaGlosarioCampos(FrameSupport parent, boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }

    /**
     * 
     */
    protected void setupComponents() {

        jLabel1 = new JLabel();
        txtRF = new JTextField();
        jLabel2 = new JLabel();
        txtSD = new JTextField();
        jLabel3 = new JLabel();
        jScrollPane1 = new JScrollPane();
        txtComentario = new JTextArea();
        btnAceptar = new JButton();
        btnCancelar = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        txtRF.setPreferredSize(new Dimension(64, 27));

        txtSD.setPreferredSize(new Dimension(64, 27));

        txtComentario.setColumns(20);
        txtComentario.setRows(5);
        jScrollPane1.setViewportView(txtComentario);

        btnAceptar.setIcon(new ImageIcon(getClass().getResource("/checked.png"))); // NOI18N

        btnCancelar.setIcon(new ImageIcon(getClass().getResource("/close.png"))); // NOI18N

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRF, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSD, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtSD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );
    }
    
    /**
     * 
     */
    protected void setupLiterals() {
		jLabel1.setText(literales.getLiteral("dlgBajaGlosario.rf"));
		jLabel2.setText(literales.getLiteral("dlgBajaGlosario.sd"));
		jLabel3.setText(literales.getLiteral("dlgBajaGlosario.comentario"));
		
		btnAceptar.setText(literales.getLiteral("dlgBajaGlosario.aceptar"));
		btnCancelar.setText(literales.getLiteral("dlgBajaGlosario.cancelar"));
	}
	
	/**
	 * 
	 */
	protected void initEvents() {
		FrmGlosarioCampos frmGlosarioCampos = (FrmGlosarioCampos) this.getFrameParent();
		FrmGlosarioCamposListener frmGlosarioCamposListener = frmGlosarioCampos.getFrmGlosarioCamposListener();
		
		DlgBajaGlosarioCamposListener actionListener = new DlgBajaGlosarioCamposListener(this);
		actionListener.addObservador(frmGlosarioCamposListener);
		
		btnAceptar.setActionCommand(Constants.DLG_BAJA_CAMPO_GLOSARIO_BTN_ACEPTAR);
		btnCancelar.setActionCommand(Constants.DLG_BAJA_CAMPO_GLOSARIO_BTN_CANCELAR);
		
		btnAceptar.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);
	}

	@Override
	protected void initModels() {}

	@Override
	protected void initialState() {
		campoSeleccionado = (CampoGlosario) params.get(Constants.FRM_GLOSARIO_CAMPOS_CAMPO_SELECCIONADO);
	}
}
