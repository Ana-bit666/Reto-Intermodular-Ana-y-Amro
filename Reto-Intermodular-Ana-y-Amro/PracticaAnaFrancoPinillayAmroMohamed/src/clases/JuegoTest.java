package clases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JuegoTest {

	static Juego juego;

	@BeforeEach
	public void crearRondas() {
		juego = new Juego();
		juego.setnRondas(3);
	}

	@Test
	void nombreAleatorio() {
		Enemigo enemigo = new Enemigo();
		String nombre = Juego.nombreAleatorio(enemigo);
		assertTrue(nombre.length() > 0);
	}

	@Test
	void iniciarJuego() {
		assertTrue(juego.finalJuego());
		juego.iniciarJuego();
		assertFalse(juego.finalJuego());
		assertEquals(3, juego.getnRondas());
	}

	@Test
	void getSiguiente() {
		juego.setnRondas(1);
		juego.iniciarJuego();
		Enemigo siguiente = juego.getSiguiente();
		assertNotNull(siguiente); 
	}

	@Test
	void terminarRonda() {
		ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();
		Enemigo enemigo = new Enemigo();
		enemigo.setVida(0);
		assertEquals(0, enemigo.getVida());
		assertEquals(0, enemigos.size());
	}

	@Test
	void nuevoGuerrero() {
		juego.nuevoGuerrero("Amro");
		Personaje jugador = juego.getJugador();
		assertNotNull(jugador);
		assertEquals("Amro", jugador.getNombre());
		assertTrue(jugador.getVida() >= 100 && jugador.getVida() <= 200);
	}

	@Test
	void nuevoMago() {
		juego.nuevoMago("Ana");
		Personaje jugador = juego.getJugador();
		assertNotNull(jugador);
		assertEquals("Ana", jugador.getNombre());
		assertTrue(jugador.getVida() >= 50 && jugador.getVida() <= 150);
	}

	@Test
	void testFinalJuego() {
		ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();
		assertEquals(0, enemigos.size());
	}

}
