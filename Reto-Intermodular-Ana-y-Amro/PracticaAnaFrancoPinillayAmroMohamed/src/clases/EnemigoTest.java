package clases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnemigoTest {

	static Enemigo enemigo;

	@BeforeEach
	public void crearEnemigo() {
		enemigo = new Enemigo();
		enemigo.iniciarEnemigo("Scarlett");
	}

	@Test
	public void iniciarEnemigoComprobacion() {
		assertEquals("Scarlett", enemigo.getNombre());
		assertTrue(enemigo.getVida() > 0);
		assertTrue(enemigo.getAtaque() > 0);
		assertTrue(enemigo.getDefensa() > 0);
	}

}
