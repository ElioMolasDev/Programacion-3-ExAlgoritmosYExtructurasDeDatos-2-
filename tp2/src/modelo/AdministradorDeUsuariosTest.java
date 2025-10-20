package modelo;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;

public class AdministradorDeUsuariosTest {

    private AdministradorDeUsuarios admin;

    @Before
    public void setUp() {
        admin = new AdministradorDeUsuarios();
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarUsuarioNullTest() {
        admin.agregarUsuario(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarUsuarioDuplicadoTest() {
        Usuario u1 = new Usuario("A", 5, 3, 4, 2);
        Usuario u2 = new Usuario("A", 2, 5, 3, 4);
        admin.agregarUsuario(u1);
        admin.agregarUsuario(u2);
    }

    @Test
    public void agregarUsuariosDistintosTest() {
        admin.agregarUsuario(new Usuario("A", 5, 2, 3, 4));
        admin.agregarUsuario(new Usuario("b", 3, 4, 2, 5));

        assertEquals(2, admin.getCantidadUsuarios());
    }

    @Test(expected = IllegalStateException.class)
    public void generarGruposConMenosDeDosUsuariosTest() {
        admin.agregarUsuario(new Usuario("a", 3, 3, 3, 3));
        admin.generarGrupos();
    }

    @Test
    public void generarDosGruposConUsuariosTest() {
        inicializarUsuariosBasicos();
        List<Set<Integer>> grupos = admin.generarGrupos();
        assertEquals(2, grupos.size());
    }

    @Test
    public void usuariosPresentesEnLosGruposTest() {
    	inicializarUsuariosBasicos();
        List<Set<Integer>> grupos = admin.generarGrupos();
        Set<Integer> union = new HashSet<>(grupos.get(0));
        union.addAll(grupos.get(1));
        assertEquals(admin.getCantidadUsuarios(), union.size());
    }
    
    @Test
    public void usuariosNORepetidosEnGruposTest() {
        inicializarUsuariosBasicos();
        List<Set<Integer>> grupos = admin.generarGrupos();
        Set<Integer> interseccion = new HashSet<>(grupos.get(0));
        interseccion.retainAll(grupos.get(1));
        assertTrue(interseccion.isEmpty());
    }


    @Test
    public void generarGruposDeUsuariosTest() {
        listaDeUsuariosConInteresesSimilares();
        List<Set<Integer>> grupos = admin.generarGrupos();
        boolean grupo1 = verificarIndiceDeUsuariosDeGrupo1(grupos.get(0));
        boolean grupo2 = verificarIndiceDeUsuariosDeGrupo2(grupos.get(1));

        assertTrue(grupo1 && grupo2);
    }
	private boolean verificarIndiceDeUsuariosDeGrupo1(Set<Integer> set) {
		if (set.contains(0) && set.contains(1)) { //primer y segundo usuario de la listaDeUsuariosConINteresesSimilares
			return true;
        }
		return false;
	}
	private boolean verificarIndiceDeUsuariosDeGrupo2(Set<Integer> set) {
		if (set.contains(2) && set.contains(3)) {  //tercer y cuarto usuario de la lista
			return true;
        }
		return false;
	}
	
    @Test
    public void calcularPromedioSimilaridadMinimaTest() {
        Usuario u1 = new Usuario("Max1", 5, 5, 5, 5); 
        Usuario u2 = new Usuario("Max2", 5, 5, 5, 5); 
        admin.agregarUsuario(u1); // Indice 0
        admin.agregarUsuario(u2); // Indice 1     
        Set<Integer> grupoMaxSim = new HashSet<>(Arrays.asList(0, 1));
        assertTrue(0 == admin.calcularPromedioSimilaridad(grupoMaxSim));
    }
    
    @Test
    public void calcularPromedioSimilaridadMaximaTest() {
        Usuario u1 = new Usuario("Min1", 1, 1, 1, 1); 
        Usuario u2 = new Usuario("Min2", 5, 5, 5, 5);
        admin.agregarUsuario(u1); 
        admin.agregarUsuario(u2); 
        Set<Integer> grupoMinSim = new HashSet<>(Arrays.asList(0, 1));
        assertTrue(16 == admin.calcularPromedioSimilaridad(grupoMinSim));
    }


	private void listaDeUsuariosConInteresesSimilares() {
		Usuario u1 = new Usuario("a", 5, 1, 5, 1); 
        Usuario u2 = new Usuario("b", 4, 1, 4, 2);
        Usuario u3 = new Usuario("c", 1, 5, 1, 5); 
        Usuario u4 = new Usuario("d", 2, 4, 1, 5);

        admin.agregarUsuario(u1);
        admin.agregarUsuario(u2);
        admin.agregarUsuario(u3);
        admin.agregarUsuario(u4);
	}


    private void inicializarUsuariosBasicos() {
        admin.agregarUsuario(new Usuario("a", 5, 3, 4, 2));
        admin.agregarUsuario(new Usuario("s", 2, 5, 3, 4));
        admin.agregarUsuario(new Usuario("d", 3, 4, 4, 3));
        admin.agregarUsuario(new Usuario("f", 1, 2, 5, 4));
    }
}
