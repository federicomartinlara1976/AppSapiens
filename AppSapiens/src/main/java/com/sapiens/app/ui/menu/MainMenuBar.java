/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sapiens.app.ui.menu;

import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.sapiens.app.ui.listener.MenuListener;
import com.sapiens.app.utils.Constants;
import com.sapiens.app.utils.LiteralesSingleton;

import lombok.extern.log4j.Log4j;

/**
 *
 * @author federico
 */
@Log4j
public class MainMenuBar extends JMenuBar {
    
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
        
        try {
			initComponents();
			initLiterals();
			initEvents();
		} catch (IOException e) {
			log.warn("ERROR:", e);
		}
    }

	private void initComponents() {
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
        
        mnuDefinicionGlosarios.setName(Constants.MNU_DEF_GLOSARIOS); // NOI18N
        mnuGlosarios.add(mnuDefinicionGlosarios);

        mnuDatosGlosarioCampos.setName(Constants.MNU_DATOS_GLOSARIO_CAMPOS); // NOI18N
        mnuGlosarios.add(mnuDatosGlosarioCampos);

        mnuConfiguracion.add(mnuGlosarios);

        mnuDefinicionNormas.setName(Constants.MNU_DEF_NORMAS); // NOI18N
        mnuNormasNomenclatura.add(mnuDefinicionNormas);

        mnuDefinicionElementos.setName(Constants.MNU_DEF_ELEMENTOS); // NOI18N
        mnuNormasNomenclatura.add(mnuDefinicionElementos);

        mnuDefinicionElementosNorma.setName(Constants.MNU_DEF_ELEMENTOS_NORMA); // NOI18N
        mnuNormasNomenclatura.add(mnuDefinicionElementosNorma);

        mnuDefinicionTiposParticulas.setName(Constants.MNU_DEF_TIPOS_PARTICULAS); // NOI18N
        mnuNormasNomenclatura.add(mnuDefinicionTiposParticulas);

        mnuDefinicionParticulasNormaElemento.setName(Constants.MNU_DEF_PARTICULAS_NORMA_ELEMENTO); // NOI18N
        mnuNormasNomenclatura.add(mnuDefinicionParticulasNormaElemento);

        mnuValoresParticulas.setName(Constants.MNU_VALORES_PARTICULAS); // NOI18N
        mnuNormasNomenclatura.add(mnuValoresParticulas);

        mnuConfiguracion.add(mnuNormasNomenclatura);

        mnuComprobarNombreElemento.setName(Constants.MNU_COMPROBAR_NOMBRE_ELEMENTO); // NOI18N
        mnuConsultas.add(mnuComprobarNombreElemento);

        mnuConfiguracion.add(mnuConsultas);

        mnuModelos.setName(Constants.MNU_MODELOS); // NOI18N
        mnuConfiguracion.add(mnuModelos);

        add(mnuConfiguracion);
    }
	
	private void initLiterals() throws IOException {
		LiteralesSingleton literales = LiteralesSingleton.getInstance();
		
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
	
	private void initEvents() {
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
