package com.sapiens.app;

import java.awt.EventQueue;

import javax.sql.DataSource;
import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.sapiens.app.ui.FramePrincipal;
import com.sapiens.app.ui.utils.UIHelper;
import com.sapiens.app.utils.AppGlobalSingleton;
import com.sapiens.app.utils.Constants;
import com.sapiens.app.utils.LogWrapper;

import lombok.extern.log4j.Log4j;

@SpringBootApplication
@Log4j
public class AppSapiensApplication implements CommandLineRunner {
	
	@Autowired
    private ApplicationContext applicationContext;

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(AppSapiensApplication.class);
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
	 * Inicializa el contexto de Spring y lo pone a disposición de
	 * todo el aplicativo visual en el almacenamiento global.
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
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException ex) {
			LogWrapper.error(log, "FATAL:", ex);
		}
	}
	
	/**
	 * 
	 */
	private void displayApp() {
		/* Create and display the form */
		EventQueue.invokeLater(() -> {
			FramePrincipal framePrincipal = new FramePrincipal();
			
			JDialog dialog = UIHelper.createDialog(framePrincipal,
					Constants.CMD_INICIAR_APP);
			UIHelper.show(dialog);
		});
	}
}
