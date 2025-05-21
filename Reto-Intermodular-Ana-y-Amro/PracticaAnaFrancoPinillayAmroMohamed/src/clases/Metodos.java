package clases;
public class Metodos {

	public static int aleatorio(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}

}
