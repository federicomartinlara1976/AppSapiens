package com.sapiens.app.ui.listener;

import com.sapiens.app.ui.validacionscripts.PanelPrincipal;

public abstract class PanelPrincipalListener extends ListenerSupport {
	
	protected PanelPrincipal panelPrincipal;
	
	public PanelPrincipalListener(PanelPrincipal panelPrincipal) {
		super();
		this.panelPrincipal = panelPrincipal;
	}
}
