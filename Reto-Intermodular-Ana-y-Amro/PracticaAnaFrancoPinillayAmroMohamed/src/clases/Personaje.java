package clases;

public abstract class Personaje {

	private int vida;
	private int vidaInicial;
	private int ataque;
	private int defensa;
	private String nombre;

	public Personaje() {
	}

	public Personaje(int vida, int ataque, int defensa, String nombre) {
		this.vida = vida;
		this.vidaInicial = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.nombre = nombre;
	}

	public void atacar(Personaje otro) {
		otro.vida -= (this.ataque - otro.defensa) < 0 ? 0 : (this.ataque - otro.defensa);
	}

	public void resetear(Personaje otro) {
		this.vida = this.vidaInicial;
	}

	public boolean muerto(int vida) {
		if (vida == 0) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nombre + "=>" + " Vida: " + vida + "/" + vidaInicial;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getVidaInicial() {
		return vidaInicial;
	}

	public void setVidaInicial(int vidaInicial) {
		this.vidaInicial = vidaInicial;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
