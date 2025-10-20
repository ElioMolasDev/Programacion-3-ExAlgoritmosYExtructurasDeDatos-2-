package modelo;

import java.util.HashSet;
import java.util.Set;

public class Grafo {
	private int[][] A;

	public Grafo(int vertices) {
		A = new int[vertices][vertices];
		iniciarValoresAristas();
	}

	private void iniciarValoresAristas(){
		for(int v =0; v < this.tamanio(); v++) {
			for(int u = v+1; u<this.tamanio(); u++) {
				A[v][u] = -1;
				A[u][v] = -1;
			}
		}
		
	}

	public void agregarArista(int i, int j, int similaridad) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		verificarValorArista(similaridad);

		A[i][j] = similaridad;
		A[j][i] = similaridad;
	}

	public void eliminarArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		A[i][j] = -1;
		A[j][i] = -1;
	}

	public boolean existeArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		return A[i][j] > -1;
	}

	public int tamanio() {
		return A.length;
	}

	public Set<Integer> vecinos(int i) {
		verificarVertice(i);

		Set<Integer> ret = new HashSet<Integer>();
		for (int j = 0; j < this.tamanio(); ++j)
			if (i != j) {
				if (this.existeArista(i, j))
					ret.add(j);
			}

		return ret;
	}
	
	public int obtenerArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		
		return this.A[i][j];
	}

	private void verificarVertice(int i) {
		if (i < 0)
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);

		if (i >= A.length)
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
	}

	private void verificarDistintos(int i, int j) {
		if (i == j)
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}
	
	private void verificarValorArista(int similaridad) {
		if (similaridad < 0)
			throw new IllegalArgumentException("La arista de similaridad no puede ser menora 0: " + similaridad);
	}
}
