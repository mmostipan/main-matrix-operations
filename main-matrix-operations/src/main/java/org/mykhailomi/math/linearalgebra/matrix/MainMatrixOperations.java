package org.mykhailomi.math.linearalgebra.matrix;

public interface MainMatrixOperations {
	
	int det(int[][] matrix);
	
	int[][] minor(int i, int j, int[][] matrix);
	
	int[][] adj(int[][] matrix);
	
	int[][] tran(int[][] matrix);
	
	double[][] inv(int[][] matrix);

}
