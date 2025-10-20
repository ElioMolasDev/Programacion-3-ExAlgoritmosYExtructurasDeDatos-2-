package modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ArbolGeneradorMinimo {
	private static int[] _padre;

    private static void inicializarUnionFind(int n) {
        _padre = new int[n];
        for (int i = 0; i < n; i++) {
            _padre[i] = i;
        }
    }

    private static int find(int i) {
        if (_padre[i] != i) {
            _padre[i] = find(_padre[i]);
        }
        return _padre[i];
    }

    private static void union(int i, int j) {
        int ri = find(i); 
        int rj = find(j); 
        if (ri == rj) {
            return; 
        }
        _padre[rj] = ri;
    }

    public static List<int[]> kruskal(Grafo grafo) {
        if (grafo == null) {
            throw new IllegalArgumentException("El grafo no puede ser nulo");
        }   
        int n = grafo.tamanio();
        inicializarUnionFind(n); 
        List<int[]> aristas = obtenerAristas(grafo, n);
        
        aristas.sort(Comparator.comparingInt(a -> a[2]));
        List<int[]> agm = armarAGM(n, aristas);
        return agm;
    }

	private static List<int[]> armarAGM(int n, List<int[]> aristas) {
		List<int[]> agm = new ArrayList<>(); 
        for (int[] a : aristas) {
            int u = a[0], v = a[1];
            if (find(u) != find(v)) {
                agm.add(a);
                union(u, v);
                if (agm.size() == n - 1)
                    return agm;
            }
        }
		return agm;
	}

	private static List<int[]> obtenerAristas(Grafo g, int n) {
		List<int[]> aristas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (g.existeArista(i, j)) {
                    int peso = g.obtenerArista(i, j);
                    aristas.add(new int[]{i, j, peso}); 
                }
            }
        }
		return aristas;
	}

}

