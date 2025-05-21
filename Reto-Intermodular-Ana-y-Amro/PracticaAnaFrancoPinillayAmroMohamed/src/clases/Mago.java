package clases;

public class Mago extends Personaje implements Jugable{

	private static final int FUERZA_MAGIA = 20;
	private static final int FUERZA_SIN_MAGIA = 5;
	private static final int DEFENSA = 5;
	private static final int MAGIA = 10;

	private int magia;

	public Mago(int vida, String nombre) {
		super(vida, FUERZA_MAGIA, DEFENSA, nombre);
		this.magia = MAGIA;
	}

	@Override
	public void atacar(Personaje otro) {
		super.atacar(otro);
		if(magia > 0) {
			magia--;
		}
		if (magia == 0) {
			setAtaque(FUERZA_SIN_MAGIA);
		}
	}

	@Override
	public void curar() {
		if (magia > 0 && getVida() < getVidaInicial()) {
			setVida(getVidaInicial());
			setAtaque(FUERZA_MAGIA);
			magia--;
		}
	}

	@Override
	public void resetear(Personaje otro) {
		super.resetear(otro);
		this.magia = MAGIA;
	}

	@Override
	public String toString() {
		return getNombre() + "=>" + " Vida: " + getVida() + "/" + getVidaInicial() + ";" + " Magia: " + magia;
	}

	public int getMagia() {
		return magia;
	}

	public void setMagia(int magia) {
		this.magia = magia;
	}

}
