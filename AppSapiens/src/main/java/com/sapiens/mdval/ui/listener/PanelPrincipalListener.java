package com.sapiens.mdval.ui.listener;

import com.sapiens.mdval.ui.utils.ListenerSupport;
import com.sapiens.mdval.ui.validacionscripts.PanelPrincipal;

public abstract class PanelPrincipalListener extends ListenerSupport {
	
	protected PanelPrincipal panelPrincipal;
	
	public PanelPrincipalListener(PanelPrincipal panelPrincipal) {
		super();
		this.panelPrincipal = panelPrincipal;
	}
}
