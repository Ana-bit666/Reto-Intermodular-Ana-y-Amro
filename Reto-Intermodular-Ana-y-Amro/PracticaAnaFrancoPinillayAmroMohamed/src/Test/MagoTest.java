package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Mago;
import clases.Personaje;

public class MagoTest {

	private static final int DECREMENTACION_MAGIA = 1;
	static Mago mago;

	@BeforeEach
	public void CrearMago() {
		mago = new Mago(80, "Ana");
	}

	@Test
	public void atacar() {
		Personaje enemigo = new Personaje(70, 7, 2, "Enemigo") {
		};
		Mago mago = new Mago(80, "Ana");
		int magiaInicial = mago.getMagia();
		mago.atacar(enemigo);
		assertEquals(magiaInicial - DECREMENTACION_MAGIA, mago.getMagia());
	}

	@Test
	public void curar() {
		mago.setVida(60);
		int magiaInicial = mago.getMagia();
		mago.curar();
		assertEquals(mago.getVidaInicial(), mago.getVida());
		assertEquals(magiaInicial - DECREMENTACION_MAGIA, mago.getMagia());
	}

}
