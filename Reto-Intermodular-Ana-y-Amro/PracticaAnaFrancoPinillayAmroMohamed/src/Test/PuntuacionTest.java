package Test;

import static org.junit.Assert.assertEquals;
import java.io.File;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import clases.Puntuacion;

public class PuntuacionTest {

	@AfterEach
	public void mostrarPuntuacion() {
		File archivo = new File("mejorPuntuacion.txt");
		if (archivo.exists())
			archivo.delete();
	}

	@Test
	public void guardarPuntuacion() throws Exception {
		Puntuacion.guardarPuntuacion("tester", 5);
		int maxRondas = Puntuacion.obtenerRondasMaximas();
		assertEquals(5, maxRondas);
	}
}
