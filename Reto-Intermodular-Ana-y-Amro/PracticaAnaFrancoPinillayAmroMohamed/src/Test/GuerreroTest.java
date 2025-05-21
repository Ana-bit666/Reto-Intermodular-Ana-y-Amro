package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Guerrero;

public class GuerreroTest {

	private static final int DECREMENTACION_POCIONES = 1;
	static Guerrero guerrero;

	@BeforeEach
	public void crearGuerrero() {
		guerrero = new Guerrero(100, "Amro");
	}

	@Test
	public void curar() {
		guerrero.setVida(70);
		int pocionesIniciales = guerrero.getPociones();
		guerrero.curar();
		assertEquals(guerrero.getVidaInicial(), guerrero.getVida());
		assertEquals(pocionesIniciales - DECREMENTACION_POCIONES, guerrero.getPociones());
	}

	@Test
	public void resetear() {
		guerrero.setVida(0);
		guerrero.resetear(guerrero);
		assertEquals(guerrero.getVidaInicial(), guerrero.getVida());
	}
}
