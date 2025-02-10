package org.mykhailomi.math.linearalgebra.matrix;

import org.springframework.stereotype.Component;

@Component("mainMatrixOperations")
public class MainMatrixOperationsImpl implements MainMatrixOperations {

	@Override
	public int det(int[][] matrix) {
		if (matrix.length == 2) {
			return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
		} else {
			int det = 0;
			
			for (int j = 0; j < matrix.length; j++) {
				det += matrix[0][j] * ((int) Math.pow(-1, (j + 2))) * det(minor(0, j, matrix));
			}
			
			return det;
		}
	}

	@Override
	public int[][] minor(int i, int j, int[][] matrix) {
		int[][] minor = new int[matrix.length - 1][matrix.length - 1];
		
		int row = 0;
		int column = 0;
		
		for (int minorI = 0; minorI < matrix.length; minorI++) {
			if (minorI != i) {
				for (int minorJ = 0; minorJ < matrix.length; minorJ++) {
					if (minorJ != j) {
						minor[row][column++] = matrix[minorI][minorJ];
					}
				}
				
				row++;
				column = 0;
			}
		}
		
		return minor;
	}

	@Override
	public int[][] adj(int[][] matrix) {
		int[][] adj = new int[matrix.length][matrix.length];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				adj[i][j] = ((int) Math.pow(-1, (i + j + 2))) * det(minor(i, j, matrix));
			}
		}
		
		return adj;
	}

	@Override
	public int[][] tran(int[][] matrix) {
		int[][] tran = new int[matrix.length][matrix.length];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				tran[i][j] = matrix[j][i];
			}
		}
		
		return tran;
	}

	@Override
	public double[][] inv(int[][] matrix) {
		double[][] inv = new double[matrix.length][matrix.length];
		
		double det = det(matrix);
		
		if (det == 0) {
			return new double[0][0];
		} else {
			det = 1 / det;
			
			int[][] tran = tran(adj(matrix));
			
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					inv[i][j] = det * tran[i][j];
				}
			}
			return inv;
		}
	}

}
