package clases;

public class Guerrero extends Personaje implements Jugable{

	private static final int FUERZA = 15;
	private static final int DEFENSA = 10;
	private static final int POCIONES = 2;

	private int pociones;

	public Guerrero(int vida, String nombre) {
		super(vida, FUERZA, DEFENSA, nombre);
		this.pociones = POCIONES;
	}

	public int getPociones() {
		return pociones;
	}

	public void setPociones(int pociones) {
		this.pociones = pociones;
	}

	@Override
	public void curar() {
		if (pociones > 0) {
			setVida(getVidaInicial());
			pociones--;
		}
	}

	@Override
	public void resetear(Personaje otro) {
		super.resetear(otro);
		this.pociones = POCIONES;
	}

	@Override
	public String toString() {
		return getNombre() + " Vida: " + getVida() + "/" + getVidaInicial() + "; " + "Pociones: " + pociones;
	}

}
