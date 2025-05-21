package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Personaje;

public class PersonajeTest {

	private static final int ATAQUE_Y_DEFENSA_RESTA = 4;
	static Personaje personaje;

	@BeforeAll
	static void crearPersonaje() {
		personaje = new Personaje(120, 7, 4, "Jugador") {
		};
	}

	@Test
	void iniciarJugador() {
		assertEquals("Jugador", personaje.getNombre());
		assertEquals(120, personaje.getVida());
		assertEquals(7, personaje.getAtaque());
		assertEquals(4, personaje.getDefensa());
	}

	@Test
	void atacar() {
		Personaje enemigo = new Personaje(70, 7, 2, "Enemigo") {
		};
		Personaje jugador = new Personaje(120, 5, 3, "Jugador") {
		};
		int vidaInicial = jugador.getVida();
		enemigo.atacar(jugador);
		assertEquals(vidaInicial - ATAQUE_Y_DEFENSA_RESTA, jugador.getVida());
	}

	@BeforeEach
	void resetear() {
		personaje.setVidaInicial(120);
		personaje.setVida(120);
	}

	@Test
	void muerto() {
		assertFalse(personaje.muerto(0));
		assertTrue(personaje.muerto(1));
	}

	@Test
	void getVida() {
		personaje = new Personaje(120, 7, 4, "Jugador") {
		};
		assertEquals(120, personaje.getVida());
	}

	@Test
	void setVida() {
		personaje = new Personaje(120, 7, 4, "Jugador") {
		};
		personaje.setVida(30);
		assertEquals(30, personaje.getVida());

	}

	@Test
	void getNombre() {
		personaje = new Personaje(120, 7, 4, "Jugador") {
		};
		assertEquals("Jugador", personaje.getNombre());
	}

	@Test
	void setNombre() {
		personaje = new Personaje(120, 7, 4, "Jugador") {
		};
		personaje.setNombre("Mago");
		assertEquals("Mago", personaje.getNombre());
	}

	@Test
	void getAtaque() {
		personaje = new Personaje(120, 7, 4, "Jugador") {
		};
		assertEquals(7, personaje.getAtaque());
	}

	@Test
	void setAtaque() {
		personaje = new Personaje(120, 7, 4, "Jugador") {
		};
		personaje.setAtaque(10);
		assertEquals(10, personaje.getAtaque());
	}

	@Test
	void getDefensa() {
		personaje = new Personaje(120, 7, 4, "Jugador") {
		};
		assertEquals(4, personaje.getDefensa());
	}

	@Test
	void setDefensa() {
		personaje = new Personaje(120, 7, 4, "Jugador") {
		};
		personaje.setDefensa(8);
		assertEquals(8, personaje.getDefensa());
	}
}
