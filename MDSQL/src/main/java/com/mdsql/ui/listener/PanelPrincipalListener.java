package com.mdsql.ui.listener;

import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.validacionscripts.PanelPrincipal;

public abstract class PanelPrincipalListener extends ListenerSupport {
	
	protected PanelPrincipal panelPrincipal;
	
	public PanelPrincipalListener(PanelPrincipal panelPrincipal) {
		super();
		this.panelPrincipal = panelPrincipal;
	}
}
