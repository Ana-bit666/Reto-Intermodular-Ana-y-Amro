package Test;

import static org.junit.Assert.assertEquals;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import clases.Puntuacion;

public class PuntuacionTest {

	private static final String ARCHIVO = "mejorPuntuacion.txt";

	@Test
	void mostrarPuntuacion() throws Exception {
		FileWriter fw = new FileWriter("mejorPuntuacion.txt");
		fw.write("Ana");
		fw.close();
		Puntuacion.mostrarPuntuacion();
	}

	@Test
	public void obtenerRondasMaximas() throws IOException {
		try (FileWriter fw = new FileWriter(ARCHIVO)) {
			fw.write("Ana\n3");
		}
		int rondas = Puntuacion.obtenerRondasMaximas();
		assertEquals(3, rondas);
	}

	@Test
	public void guardarPuntuacion() throws Exception {
		Puntuacion.guardarPuntuacion("Ana", 3);
		int maxRondas = Puntuacion.obtenerRondasMaximas();
		assertEquals(3, maxRondas);

	}
}
