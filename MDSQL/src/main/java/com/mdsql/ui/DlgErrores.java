/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdsql.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.mdsql.exceptions.ServiceException;
import com.mdsql.ui.utils.DialogSupport;
import com.mdsql.ui.utils.FrameSupport;
import com.mdsql.utils.Constants;

/**
 *
 * @author federico
 */
public class DlgErrores extends DialogSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3792975274329612636L;
	
    private JButton btnCerrar;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JTextArea txtErrors;

    /**
     * Creates new form DlgErrores
     */
    public DlgErrores(FrameSupport parent, boolean modal) {
        super(parent, modal);
    }
    
    /**
     * Creates new form DlgErrores
     */
    public DlgErrores(FrameSupport parent, boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }

	@Override
	protected void setupComponents() {
		jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        txtErrors = new JTextArea();
        jPanel3 = new JPanel();
        btnCerrar = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(400, 300));

        jPanel1.setLayout(new FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.LEFT);
        
        // Por defecto error
        String type = (String) params.get(Constants.TYPE);
        if (StringUtils.isNotBlank(type)) {
        	if (Constants.ERROR.equals(type)) {
        		jLabel1.setIcon(new ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        	}
        	if (Constants.WARN.equals(type)) {
        		jLabel1.setIcon(new ImageIcon(getClass().getResource("/warning.png"))); // NOI18N
        	}
        }
        else {
        	jLabel1.setIcon(new ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        }
        
        jLabel1.setIconTextGap(10);
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, BorderLayout.PAGE_START);

        jPanel2.setLayout(new BorderLayout());

        txtErrors.setColumns(20);
        txtErrors.setRows(5);
        txtErrors.setLineWrap(Boolean.TRUE);
        jScrollPane1.setViewportView(txtErrors);

        jPanel2.add(jScrollPane1, BorderLayout.CENTER);

        getContentPane().add(jPanel2, BorderLayout.CENTER);

        jPanel3.setLayout(new FlowLayout(FlowLayout.RIGHT));

        jPanel3.add(btnCerrar);

        getContentPane().add(jPanel3, BorderLayout.PAGE_END);
	}

	@Override
	protected void initEvents() {
		btnCerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	@Override
	protected void setupLiterals() {
		String type = (String) params.get(Constants.TYPE);
        if (StringUtils.isNotBlank(type)) {
        	if (Constants.ERROR.equals(type)) {
        		setTitle(literales.getLiteral("error.titulo"));
        		jLabel1.setText(literales.getLiteral("error.label"));
        	}
        	if (Constants.WARN.equals(type)) {
        		setTitle(literales.getLiteral("aviso.titulo"));
        		jLabel1.setText(literales.getLiteral("aviso.label"));
        	}
        }
        else {
        	setTitle(literales.getLiteral("error.titulo"));
    		jLabel1.setText(literales.getLiteral("error.label"));
        }
		
		btnCerrar.setText(literales.getLiteral("error.aceptar"));
	}

	@Override
	protected void initModels() {}

	@Override
	protected void initialState() {
		txtErrors.setEditable(Boolean.FALSE);
		
		if (!Objects.isNull(params)) {
			ServiceException serviceException = (ServiceException) params.get(Constants.SERVICE_ERROR);
			Exception exception = (Exception) params.get(Constants.ERROR);
			
			if (!Objects.isNull(serviceException)) {
				if (CollectionUtils.isNotEmpty(serviceException.getErrors())) {
					StringBuilder sb = new StringBuilder();
					for (Object[] cols : serviceException.getErrors()) {
						sb.append(cols[0]).append("\n");
					}
					
					txtErrors.setText(sb.toString());
				}
				else {
					txtErrors.setText(serviceException.getMessage());
				}
			}
			else {
				txtErrors.setText(exception.getMessage());
			}
		}
	}
}
