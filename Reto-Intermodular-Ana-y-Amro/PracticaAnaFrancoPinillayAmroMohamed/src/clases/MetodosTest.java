package clases;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test; 
public class MetodosTest {

	@Test
	void aleatorio() {
		int min = 1;
		int max = 10;
		for (int i = 0; i < 100; i++) {
			int resultado = Metodos.aleatorio(min, max);
			assertTrue(resultado >= min && resultado <= max);
		}
	}
}
