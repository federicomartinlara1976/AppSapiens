package com.sapiens.app;

import com.sapiens.app.ui.DlgIdentificador;
import com.sapiens.app.ui.FramePrincipal;
import com.sapiens.app.ui.utils.UIHelper;
import com.sapiens.app.utils.AppGlobalSingleton;
import com.sapiens.app.utils.Constants;
import com.sapiens.app.utils.LogWrapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import javax.swing.*;
import java.awt.*;

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
		setupSpringContext();
		setupUIEnvironment();
		displayApp();
		log.info("Connection Polling datasource : "+ dataSource);
	}

	/**
	 * Inicializa el contexto de Spring y lo pone a disposición de
	 * todo el aplicativo visual en el almacenamiento global.
	 */
	private void setupSpringContext() {
		AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
		
		LogWrapper.debug(log, "%s", applicationContext.getDisplayName());
		appGlobalSingleton.setProperty(Constants.SPRING_CONTEXT, applicationContext);
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
			
			DlgIdentificador  dlgIdentificador = new DlgIdentificador(framePrincipal, Boolean.TRUE);
			UIHelper.centerOnScreen(dlgIdentificador);
			dlgIdentificador.setVisible(Boolean.TRUE);
		});
	}
}
