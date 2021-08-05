package com.sapiens.app;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.sapiens.app.ui.FramePrincipal;

import lombok.extern.log4j.Log4j;

@SpringBootApplication
@Log4j
public class AppSapiensApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(AppSapiensApplication.class);

		builder.headless(false);

		ConfigurableApplicationContext context = builder.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException ex) {
			log.error("FATAL:", ex);
		}
		// </editor-fold>

		/* Create and display the form */
		EventQueue.invokeLater(() -> {
			new FramePrincipal().setVisible(true);
		});
	}
}
