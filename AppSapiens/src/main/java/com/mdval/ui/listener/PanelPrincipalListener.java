package com.mdval.ui.listener;

import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.validacionscripts.PanelPrincipal;

public abstract class PanelPrincipalListener extends ListenerSupport {
	
	protected PanelPrincipal panelPrincipal;
	
	public PanelPrincipalListener(PanelPrincipal panelPrincipal) {
		super();
		this.panelPrincipal = panelPrincipal;
	}
}
