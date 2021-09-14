package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.entities.TipoElemento;
import com.mdval.bussiness.service.TipoElementoService;
import com.mdval.ui.consultas.FrmComprobacionNombreElemento;
import com.mdval.ui.model.TipoElementoComboBoxModel;
import com.mdval.ui.modelos.FrmDefinicionModelos;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.Constants;

/**
 * @author federico
 *
 */
public class FrmComprobacionNombreElementoListener extends ListenerSupport implements ActionListener, OnLoadListener, Observer {

	private FrmComprobacionNombreElemento frmComprobacionNombreElemento;
	
	private FrmDefinicionModelos frmDefinicionModelos;

	public FrmComprobacionNombreElementoListener(FrmComprobacionNombreElemento frmComprobacionNombreElemento) {
		super();
		this.frmComprobacionNombreElemento = frmComprobacionNombreElemento;
	}
	
	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.FRM_COMPROBACION_NOMBRE_ELEMENTO_BTN_BUSCAR.equals(jButton.getActionCommand())) {
			eventBtnBuscarModelo();
		}
		
		if (Constants.FRM_COMPROBACION_NOMBRE_ELEMENTO_BTN_COMPROBAR.equals(jButton.getActionCommand())) {
			eventBtnComprobar();
		}
	}

	private void eventBtnBuscarModelo() {
		Map<String, Object> params = new HashMap<>();
		params.put("fromMenu", Boolean.FALSE);
		
		frmDefinicionModelos = (FrmDefinicionModelos) UIHelper.createFrame(Constants.CMD_BUSCAR_MODELOS, params);
		UIHelper.show(frmDefinicionModelos);

		frmDefinicionModelos.getFrmDefinicionModelosListener().addObservador(this);
	}

	/**
	 * 
	 */
	private void eventBtnComprobar() {
		
	}

	/**
	 *
	 */
	@Override
	public void onLoad() {
		TipoElementoService tipoElementoService = (TipoElementoService) getService(Constants.TIPO_ELEMENTO_SERVICE);
		
		List<TipoElemento> elementos = tipoElementoService.consultarTiposElementos(StringUtils.EMPTY);
		
		TipoElementoComboBoxModel modelElementos = new TipoElementoComboBoxModel(elementos);
		frmComprobacionNombreElemento.getCmbElemento().setModel(modelElementos);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
