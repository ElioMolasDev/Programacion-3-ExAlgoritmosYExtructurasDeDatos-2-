package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdministradorDeUsuarios {
	private List<Usuario> _usuarios;
	private Grafo _grafo;
	private List<Set<Integer>> _grupos;
	
	public AdministradorDeUsuarios() {
		_usuarios = new ArrayList<>();
		_grupos = new ArrayList<>();
	}
	
	public void agregarUsuario(Usuario usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("El usuario no puede ser nulo");
		}	
		for (Usuario u : _usuarios) {
			if (u.get_nombre().equals(usuario.get_nombre()))
				throw new IllegalArgumentException("Ya existe un usuario con el nombre: " + usuario.get_nombre());
		}
		_usuarios.add(usuario);
		
	}
	
	public List<Set<Integer>> generarGrupos() {
		if (_usuarios.size() < 2) {
			throw new IllegalStateException("Se necesitan al menos 2 usuarios para generar grupos.");
		}
		_grupos.clear();
		_grafo = construirGrafo();
		return dividirEnDosComponentes(_grafo);
	}

	private List<Set<Integer>> dividirEnDosComponentes(Grafo g) {
		List<int[]> agm = ArbolGeneradorMinimo.kruskal(g);
        if (agm.size() < g.tamanio() - 1) {
            throw new IllegalArgumentException("El grafo no es conexo ");
        }
        
        int[] aristaMayor = encontrarAristaDeMayorPeso(agm);
        int uMax = aristaMayor[0];
        int vMax = aristaMayor[1];
        agm.remove(aristaMayor);
        
        Grafo nuevoGrafo= crearGrafoNoConexo(g.tamanio(), agm);
        Set<Integer> componente1 = BFS.alcanzables(nuevoGrafo, uMax);
        Set<Integer> componente2 =  BFS.alcanzables(nuevoGrafo, vMax); 
        _grupos.add(componente1);
        _grupos.add(componente2);
        return _grupos;
	}

	private int[] encontrarAristaDeMayorPeso(List<int[]> agm) {
		int posicionPesoArista = 2;
        int[] aristaMaxima = null;
        int pesoMaximo = -1;
        
        for (int[] arista : agm) {
            int peso = arista[posicionPesoArista];    
            if (peso > pesoMaximo) {
                pesoMaximo = peso;
                aristaMaxima = arista;
            }
        }
        return aristaMaxima;
	}
	

	public double calcularPromedioSimilaridad(Set<Integer> indicesGrupo) {
		if (indicesGrupo.size() < 2) {
	        return 0.0; 
	    }
	    long sumaSimilaridad = 0;
	    int contadorPares = 0;
	    List<Integer> listaIndices = new ArrayList<>(indicesGrupo); 
	    _grafo = construirGrafo();

	    for (int i = 0; i < listaIndices.size(); i++) {
	        for (int j = i + 1; j < listaIndices.size(); j++) {
	            int u = listaIndices.get(i);
	            int v = listaIndices.get(j);
	            
	            if (_grafo.existeArista(u, v)) {
	                 sumaSimilaridad += _grafo.obtenerArista(u, v);
	            } else {
	                 sumaSimilaridad += _usuarios.get(u).calcularIndiceDeSimilaridad(_usuarios.get(v));
	            }
	            contadorPares++;
	        }
	    }

	    if (contadorPares == 0) {
	        return 0.0;
	    }

	    return (double) sumaSimilaridad / contadorPares;
	}

	public List<Usuario> obtenerUsuariosPorIndices(Set<Integer> indicesGrupo) {
		List<Usuario> grupo = new ArrayList<>();
	    for (int indice : indicesGrupo) {
	        if (indice >= 0 && indice < _usuarios.size()) 
	            grupo.add(_usuarios.get(indice));
	    }
	    
	    return grupo;
	}

	private Grafo crearGrafoNoConexo(int tamanio, List<int[]> agm) {
		Grafo g = new Grafo(tamanio);
		for(int[] arista : agm) {
			int verticeU= arista[0];
			int verticeV= arista[1];
			int pesoArista=arista[2];
			g.agregarArista(verticeU, verticeV, pesoArista);
		}
		return g;
	}
	
	private Grafo construirGrafo() {
		int cantUsuarios = _usuarios.size();
		Grafo grafo = new Grafo(cantUsuarios);
		
		for (int i = 0; i < cantUsuarios; i++) {
			for (int j = i + 1; j < cantUsuarios; j++) {
				Usuario u1 = _usuarios.get(i);
				Usuario u2 = _usuarios.get(j);
				int similaridad = u1.calcularIndiceDeSimilaridad(u2);
				grafo.agregarArista(i, j, similaridad);
			}
		}
		return grafo;
	}
	
	
	public int getCantidadUsuarios() {
		return _usuarios.size();
	}
	
	public List<Usuario> getUsuarios() {
		return _usuarios;
	}
	
	public String getNombreUsuario(int indice) {
		if (indice < 0 || indice >= _usuarios.size()) {
			throw new IndexOutOfBoundsException("Índice de usuario fuera de rango.");
		}
		return _usuarios.get(indice).get_nombre();
	}
	
	
}