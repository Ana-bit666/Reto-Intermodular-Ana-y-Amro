package clases;

public class Enemigo extends Personaje {

	public Enemigo() {
	}

	public void iniciarEnemigo(String nombre) {
		setNombre(nombre);
		setVida(Metodos.aleatorio(20, 100));
		setVidaInicial(getVida());
		setAtaque(Metodos.aleatorio(2, 10));
		setDefensa(Metodos.aleatorio(1, 3));
	}

}
