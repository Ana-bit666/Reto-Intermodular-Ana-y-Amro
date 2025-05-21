package clases;

import java.util.ArrayList;
import java.util.Random;

public class Juego {

	public static String[] nombresEnemigos = { "Scarlett the Killer", "Rubi the Vampire", "Ophelia the Psychic",
			"Logan the Cannibal" };

	private ArrayList<Enemigo> enemigos;
	private Personaje jugador;
	private int nRondas;
	private int ronda;

	public Juego() {
		enemigos = new ArrayList<Enemigo>();
	}

	public static String nombreAleatorio(Enemigo enemigo) {
		Random r = new Random();
		return nombresEnemigos[r.nextInt(nombresEnemigos.length)];
	}

	public void iniciarJuego() {
		if (enemigos.isEmpty()) {
			for (int i = 0; i < nRondas; i++) {
				Enemigo nuevo = new Enemigo();
				enemigos.add(nuevo);
			}
			ronda = 0;
		}
	}

	public Enemigo getSiguiente() {
		if (!enemigos.isEmpty()) {
			return enemigos.get(0);
		}
		return null;
	}

	public boolean terminarRonda() {
		if (enemigos.get(0).muerto(nRondas)) {
			enemigos.remove(0);
			return true;
		}
		return false;
	}

	public void nuevoGuerrero(String nombre) {
		int vidaInicial = Metodos.aleatorio(100, 200);
		this.jugador = new Guerrero(vidaInicial, nombre);
	}

	public void nuevoMago(String nombre) {
		int vidaInicial = Metodos.aleatorio(50, 150);
		this.jugador = new Mago(vidaInicial, nombre);
	}

	public boolean finalJuego() {
		if (enemigos.isEmpty()) {
			return true;
		}
		return false;

	}

	public Personaje getJugador() {
		return jugador;
	}

	public void setJugador(Personaje jugador) {
		this.jugador = jugador;
	}

	public int getnRondas() {
		return nRondas;
	}

	public void setnRondas(int nRondas) {
		this.nRondas = nRondas;
	}

	public int getRonda() {
		return ronda;
	}

	public void setRonda(int ronda) {
		this.ronda = ronda;
	}

}
