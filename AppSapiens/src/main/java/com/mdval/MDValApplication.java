package com.mdval;

import java.awt.EventQueue;

import javax.sql.DataSource;
import javax.swing.JDialog;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.mdval.ui.FramePrincipal;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.AppGlobalSingleton;
import com.mdval.utils.Constants;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class MDValApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(MDValApplication.class);
		builder.headless(false);
		builder.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		String version = System.getProperty("java.version");
		LogWrapper.debug(log, "Java version: %s", version);

		setupSpringContext();
		setupUIEnvironment();
		displayApp();
	}

	/**
	 * Inicializa el contexto de Spring y lo pone a disposición del
	 * aplicativo visual en el almacenamiento global.
	 */
	private void setupSpringContext() {
		AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();

		LogWrapper.debug(log, "%s", applicationContext.getDisplayName());
		appGlobalSingleton.setProperty(Constants.SPRING_CONTEXT, applicationContext);

		LogWrapper.debug(log, "Connection Polling datasource: %s", dataSource);
	}

	/**
	 * 
	 */
	private void setupUIEnvironment() {
		// Enter para los botones que tengan el foco
		UIManager.put("Button.focusInputMap",
				new UIDefaults.LazyInputMap(new Object[] { "ENTER", "pressed", "released ENTER", "released" }));
	}

	/**
	 * 
	 */
	private void displayApp() {
		/* Create and display the form */
		EventQueue.invokeLater(() -> {
			FramePrincipal framePrincipal = new FramePrincipal();

			JDialog dialog = UIHelper.createDialog(framePrincipal, Constants.CMD_INICIAR_APP);
			UIHelper.show(dialog);
		});
	}
}
