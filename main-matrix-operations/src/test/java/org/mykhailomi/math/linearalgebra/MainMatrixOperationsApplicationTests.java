package org.mykhailomi.math.linearalgebra;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.mykhailomi.main_matrix_operations.app.conf.AppConfiguration;
import org.mykhailomi.main_matrix_operations.matrix.MainMatrixOperations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class MainMatrixOperationsApplicationTests {
	private static final Logger LOGGER = LogManager.getLogger(MainMatrixOperationsApplicationTests.class);
	
	@Test
	void calDetTest() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
		MainMatrixOperations mainMatrixOperations = ctx.getBean("mainMatrixOperations", MainMatrixOperations.class);

		int[][] matrix = {{1, 2, 3}, {3, 2, 1}, {2, 1, 3}};
		
		int det = mainMatrixOperations.det(matrix);

		LOGGER.info("det={}", det);
		
		((ConfigurableApplicationContext) ctx).close();
		
		assertEquals(-12, det);
	}

}
