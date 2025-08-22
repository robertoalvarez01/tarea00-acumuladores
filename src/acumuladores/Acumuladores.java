package acumuladores;

public class Acumuladores {

	/**
	 * Dada una matriz de enteros y un número, verifica si existe alguna fila 
	 * donde todos sus elementos sean múltiplos del número recibido por 
	 * parámetro.
	 * 
	 * Si la matriz está vacía o si el número no es positivo, devuelve falso.
	 * 
	 * @param mat
	 * @param num
	 * @return
	 */
	public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) {
		if (mat.length == 0 || num <= 0) return false;
	
		for (int i = 0; i < mat.length; i++) {
			boolean filaValida = true;
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] % num != 0) {
					filaValida = false;
					break;
				}
			}
			if (filaValida) return true;
		}
		return false;
	}
	
	/**
	 * Dado 2 matrices se verifica si hay intersección entre las filas de cada
	 * matriz, fila a fila.
	 * 
	 * Si las matrices tienen distinta cantidad de filas o si alguna matriz 
	 * está vacía, devuelve falso.
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public boolean hayInterseccionPorFila(int[][] mat1, int[][] mat2) {
		if (mat1.length == 0 || mat2.length == 0 || mat1.length != mat2.length) return false;
	
		for (int i = 0; i < mat1.length; i++) {
			boolean hayInterseccion = false;
			for (int a : mat1[i]) {
				for (int b : mat2[i]) {
					if (a == b) {
						hayInterseccion = true;
						break;
					}
				}
				if (hayInterseccion) break;
			}
			if (!hayInterseccion) return false;
		}
		return true;
	}
	
	/**
	 * Dada una matriz y el índice de una columna, se verifica si existe alguna
	 * fila cuya suma de todos sus elementos sea mayor estricto que la suma de
	 * todos los elementos de la columna indicada por parámetro.
	 * 
	 * Si el índice de la columna es inválido o la matriz está vacía, devuelve 
	 * falso.
	 * 
	 * @param mat
	 * @param nColum
	 * @return
	 */
	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) {
		if (mat.length == 0 || mat[0].length <= nColum || nColum < 0) return false;
	
		int sumaColumna = 0;
		for (int i = 0; i < mat.length; i++) {
			sumaColumna += mat[i][nColum];
		}
	
		for (int i = 0; i < mat.length; i++) {
			int sumaFila = 0;
			for (int j = 0; j < mat[i].length; j++) {
				sumaFila += mat[i][j];
			}
			if (sumaFila > sumaColumna) return true;
		}
	
		return false;
	}
	
	/**
	 * Dadas 2 matrices, se verifica si hay intersección entre las columnas de
	 * cada matriz, columna a columna.
	 * 
	 * Si las matrices tienen distinta cantidad de columnas o alguna matriz 
	 * está vacía, devuelve falso. 
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public boolean hayInterseccionPorColumna(int[][] mat1, int[][] mat2) {
		if (mat1.length == 0 || mat2.length == 0 || mat1[0].length != mat2[0].length) return false;
	
		int columnas = mat1[0].length;
		for (int j = 0; j < columnas; j++) {
			boolean hayInterseccion = false;
			for (int i1 = 0; i1 < mat1.length; i1++) {
				for (int i2 = 0; i2 < mat2.length; i2++) {
					if (mat1[i1][j] == mat2[i2][j]) {
						hayInterseccion = true;
						break;
					}
				}
				if (hayInterseccion) break;
			}
			if (!hayInterseccion) return false;
		}
	
		return true;
	}
}
