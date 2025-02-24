package org.mykhailomi.math.linear_algebra.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mykhailomi.math.linear_algebra.conf.AppConfiguration;
import org.mykhailomi.math.linear_algebra.matrix.MainMatrixOperations;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class App {
	private static final Logger LOGGER = LogManager.getLogger(App.class);
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
		MainMatrixOperations mainMatrixOperations = ctx.getBean("mainMatrixOperations", MainMatrixOperations.class);

		int[][] matrix = {{1, 2, 3}, {3, 2, 1}, {2, 1, 3}};

		LOGGER.info("det={}", mainMatrixOperations.det(matrix));
		
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
