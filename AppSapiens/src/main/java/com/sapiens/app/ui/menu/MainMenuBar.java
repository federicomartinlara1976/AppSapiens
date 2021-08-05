/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sapiens.app.ui.menu;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.sapiens.app.ui.listener.MenuListener;
import com.sapiens.app.utils.Constants;

/**
 *
 * @author federico
 */
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
        initialize();
        initEvents();
    }

	private void initialize() {
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
        
        mnuConfiguracion.setText("Configuración");

        mnuGlosarios.setText("Glosarios");

        mnuDefinicionGlosarios.setText("Definición de Glosarios");
        mnuDefinicionGlosarios.setName(Constants.MNU_DEF_GLOSARIOS); // NOI18N
        mnuGlosarios.add(mnuDefinicionGlosarios);

        mnuDatosGlosarioCampos.setText("Datos de Glosario Campos");
        mnuDatosGlosarioCampos.setName(Constants.MNU_DATOS_GLOSARIO_CAMPOS); // NOI18N
        mnuGlosarios.add(mnuDatosGlosarioCampos);

        mnuConfiguracion.add(mnuGlosarios);

        mnuNormasNomenclatura.setText("Normas de nomenclatura");

        mnuDefinicionNormas.setText("Definición de normas");
        mnuDefinicionNormas.setName(Constants.MNU_DEF_NORMAS); // NOI18N
        mnuNormasNomenclatura.add(mnuDefinicionNormas);

        mnuDefinicionElementos.setText("Definición de elementos");
        mnuDefinicionElementos.setName(Constants.MNU_DEF_ELEMENTOS); // NOI18N
        mnuNormasNomenclatura.add(mnuDefinicionElementos);

        mnuDefinicionElementosNorma.setText("Definición de elementos por Norma");
        mnuDefinicionElementosNorma.setName(Constants.MNU_DEF_ELEMENTOS_NORMA); // NOI18N
        mnuNormasNomenclatura.add(mnuDefinicionElementosNorma);

        mnuDefinicionTiposParticulas.setText("Definición de Tipos de Partículas");
        mnuDefinicionTiposParticulas.setName(Constants.MNU_DEF_TIPOS_PARTICULAS); // NOI18N
        mnuNormasNomenclatura.add(mnuDefinicionTiposParticulas);

        mnuDefinicionParticulasNormaElemento.setText("Definición de Partículas por Norma/Elemento");
        mnuDefinicionParticulasNormaElemento.setName(Constants.MNU_DEF_PARTICULAS_NORMA_ELEMENTO); // NOI18N
        mnuNormasNomenclatura.add(mnuDefinicionParticulasNormaElemento);

        mnuValoresParticulas.setText("Valores de las Partículas");
        mnuValoresParticulas.setName(Constants.MNU_VALORES_PARTICULAS); // NOI18N
        mnuNormasNomenclatura.add(mnuValoresParticulas);

        mnuConfiguracion.add(mnuNormasNomenclatura);

        mnuConsultas.setText("Consultas");

        mnuComprobarNombreElemento.setText("Comprobar un Nombre de Elemento");
        mnuComprobarNombreElemento.setName(Constants.MNU_COMPROBAR_NOMBRE_ELEMENTO); // NOI18N
        mnuConsultas.add(mnuComprobarNombreElemento);

        mnuConfiguracion.add(mnuConsultas);

        mnuModelos.setText("Modelos");
        mnuModelos.setName(Constants.MNU_MODELOS); // NOI18N
        mnuConfiguracion.add(mnuModelos);

        add(mnuConfiguracion);
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
        mnuConsultas.addActionListener(actionListener);
        mnuComprobarNombreElemento.addActionListener(actionListener);
        mnuModelos.addActionListener(actionListener);
	}
}
