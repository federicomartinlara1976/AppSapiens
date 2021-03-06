/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdval.ui.menu;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.mdval.ui.listener.MenuListener;
import com.mdval.ui.utils.MenuSupport;
import com.mdval.utils.MDValConstants;

/**
 *
 * @author federico
 */
public class MainMenuBar extends MenuSupport {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -519829056044806094L;
	
	private JMenuItem mnuComprobarNombreElemento;
    private JMenu mnuConfiguracion;
    private JMenu mnuConsultas;
    private JMenuItem mnuDatosGlosarioCampos;
    private JMenuItem mnuDefinicionElementos;
    private JMenuItem mnuDefinicionElementosNorma;
    private JMenuItem mnuDefinicionGlosarios;
    private JMenuItem mnuDefinicionNormas;
    private JMenuItem mnuDefinicionParticulasNormaElemento;
    private JMenuItem mnuDefinicionTiposParticulas;
    private JMenu mnuGlosarios;
    private JMenuItem mnuModelos;
    private JMenu mnuNormasNomenclatura;
    private JMenuItem mnuValoresParticulas;
    
    public MainMenuBar() {
        super();
    }

	/**
	 *
	 */
	protected void initComponents() {
        mnuConfiguracion = new JMenu();
        mnuGlosarios = new JMenu();
        mnuDefinicionGlosarios = new JMenuItem();
        mnuDatosGlosarioCampos = new JMenuItem();
        mnuNormasNomenclatura = new JMenu();
        mnuDefinicionNormas = new JMenuItem();
        mnuDefinicionElementos = new JMenuItem();
        mnuDefinicionElementosNorma = new JMenuItem();
        mnuDefinicionTiposParticulas = new JMenuItem();
        mnuDefinicionParticulasNormaElemento = new JMenuItem();
        mnuValoresParticulas = new JMenuItem();
        mnuConsultas = new JMenu();
        mnuComprobarNombreElemento = new JMenuItem();
        mnuModelos = new JMenuItem(); 
        
        mnuDefinicionGlosarios.setActionCommand(MDValConstants.MNU_DEF_GLOSARIOS); // NOI18N
        mnuGlosarios.add(mnuDefinicionGlosarios);

        mnuDatosGlosarioCampos.setActionCommand(MDValConstants.MNU_DATOS_GLOSARIO_CAMPOS); // NOI18N
        mnuGlosarios.add(mnuDatosGlosarioCampos);

        mnuConfiguracion.add(mnuGlosarios);

        mnuDefinicionNormas.setActionCommand(MDValConstants.MNU_DEF_NORMAS); // NOI18N
        mnuNormasNomenclatura.add(mnuDefinicionNormas);

        mnuDefinicionElementos.setActionCommand(MDValConstants.MNU_DEF_ELEMENTOS); // NOI18N
        mnuNormasNomenclatura.add(mnuDefinicionElementos);

        mnuDefinicionElementosNorma.setActionCommand(MDValConstants.MNU_DEF_ELEMENTOS_NORMA); // NOI18N
        mnuNormasNomenclatura.add(mnuDefinicionElementosNorma);

        mnuDefinicionTiposParticulas.setActionCommand(MDValConstants.MNU_DEF_TIPOS_PARTICULAS); // NOI18N
        mnuNormasNomenclatura.add(mnuDefinicionTiposParticulas);

        mnuDefinicionParticulasNormaElemento.setActionCommand(MDValConstants.MNU_DEF_PARTICULAS_NORMA_ELEMENTO); // NOI18N
        mnuNormasNomenclatura.add(mnuDefinicionParticulasNormaElemento);

        mnuValoresParticulas.setActionCommand(MDValConstants.MNU_VALORES_PARTICULAS); // NOI18N
        mnuNormasNomenclatura.add(mnuValoresParticulas);

        mnuConfiguracion.add(mnuNormasNomenclatura);

        mnuComprobarNombreElemento.setActionCommand(MDValConstants.MNU_COMPROBAR_NOMBRE_ELEMENTO); // NOI18N
        mnuConsultas.add(mnuComprobarNombreElemento);

        mnuConfiguracion.add(mnuConsultas);

        mnuModelos.setActionCommand(MDValConstants.MNU_MODELOS); // NOI18N
        mnuConfiguracion.add(mnuModelos);

        add(mnuConfiguracion);
    }
	
	/**
	 *
	 */
	protected void setupLiterals() {
		mnuConfiguracion.setText(literales.getLiteral("menu.configuracion"));
        mnuGlosarios.setText(literales.getLiteral("menu.glosarios"));
        mnuDefinicionGlosarios.setText(literales.getLiteral("menu.glosarios.definicion"));
        mnuDatosGlosarioCampos.setText(literales.getLiteral("menu.glosarios.datos"));
        mnuNormasNomenclatura.setText(literales.getLiteral("menu.normas.nomenclatura"));
        mnuDefinicionNormas.setText(literales.getLiteral("menu.normas.definicion"));
        mnuDefinicionElementos.setText(literales.getLiteral("menu.normas.elementos"));
        mnuDefinicionElementosNorma.setText(literales.getLiteral("menu.normas.elementos.norma"));
        mnuDefinicionTiposParticulas.setText(literales.getLiteral("menu.normas.particulas"));
        mnuDefinicionParticulasNormaElemento.setText(literales.getLiteral("menu.normas.particulas.norma"));
        mnuValoresParticulas.setText(literales.getLiteral("menu.normas.valores"));
        mnuConsultas.setText(literales.getLiteral("menu.consultas"));
        mnuComprobarNombreElemento.setText(literales.getLiteral("menu.consultas.comprobar"));
        mnuModelos.setText(literales.getLiteral("menu.modelos"));
	}
	
	/**
	 *
	 */
	protected void initEvents() {
		ActionListener actionListener = new MenuListener();
		
		mnuDefinicionGlosarios.addActionListener(actionListener);
		mnuDatosGlosarioCampos.addActionListener(actionListener);
		mnuDefinicionNormas.addActionListener(actionListener);
		mnuDefinicionElementos.addActionListener(actionListener);
		mnuDefinicionElementosNorma.addActionListener(actionListener);
        mnuDefinicionTiposParticulas.addActionListener(actionListener);
        mnuDefinicionParticulasNormaElemento.addActionListener(actionListener);
        mnuValoresParticulas.addActionListener(actionListener);
        mnuComprobarNombreElemento.addActionListener(actionListener);
        mnuModelos.addActionListener(actionListener);
	}
}
