package programa;

import java.util.Scanner;
import clases.Enemigo;
import clases.Juego;
import clases.Jugable;
import clases.Puntuacion;

public class Programa {

	public static void main(String[] args) {
		Juego juego = new Juego();
		Scanner entrada = new Scanner(System.in);
		int acciones;
		char respuesta = 0;
		
		Puntuacion.mostrarPuntuacion();
		
		do {
			System.out.println("Bienvenido al juego: ");
			System.out.print("¿Cuántas rondas quieres jugar?: ");
			int rondas = entrada.nextInt();
			juego.setnRondas(rondas);
			entrada.nextLine();
			System.out.print("Introduce tu nombre: ");
			String nombre = entrada.nextLine().toLowerCase();
			System.out.println("Elige tu clase:\r\n" + "1. Mago\r\n" + "2. Guerrero");
			System.out.print("Elige: ");
			int clase = entrada.nextInt();
			entrada.nextLine();

			if (clase == 1) {
				juego.nuevoMago(nombre);
			} else {
				juego.nuevoGuerrero(nombre);
			}
			juego.iniciarJuego();

			while (!juego.finalJuego()) {
				Enemigo enemigo = new Enemigo();
				String nombreEnemigo = Juego.nombreAleatorio(enemigo);
				enemigo.iniciarEnemigo(nombreEnemigo);
				while (enemigo.getVida() > 0 && juego.getJugador().getVida() > 0) {
					System.out.println("Ronda: " + (juego.getRonda() + 1) + "/" + rondas);
					System.out.println("Estas luchando contra: " + enemigo);
					System.out.println("Eres: " + juego.getJugador());
					System.out.println("Acciones:\r\n" + "1. Atacar\r\n" + "2. Curar");
					System.out.print("Elige: ");
					acciones = entrada.nextInt();
					entrada.nextLine();
					
					switch(acciones) {
					case 1:
						System.out.println(nombre + " ataca a " + enemigo.getNombre());
						juego.getJugador().atacar(enemigo);
						if (enemigo.getVida() <= 0) {
							System.out.println("Enemigo vencido!!");
							juego.terminarRonda();
						} else {
							enemigo.atacar(juego.getJugador());
							System.out.println(enemigo.getNombre() + " ataca a " + nombre);
						}
						break;
					case 2:
						System.out.println(nombre + " se cura");
						if(juego.getJugador() instanceof Jugable) {
							((Jugable)juego.getJugador()).curar();
						}
						break;
					default:
							System.out.println("Opcion invalida");
					}
				}
				
				if (juego.getJugador().getVida() < 0) {
					System.out.println("Has perdido");
					System.out.println("¿Volver a jugar?[s/n]");
					respuesta = entrada.nextLine().toLowerCase().charAt(0);
					break;
				}
				
				juego.setRonda(juego.getRonda() + 1);
				
				if (juego.finalJuego() && juego.getJugador().getVida() > 0) {
					int mejor = Puntuacion.obtenerRondasMaximas();
					if (juego.getnRondas() > mejor) {
						System.out.println("Has batido el record de rondas");
						Puntuacion.guardarPuntuacion(nombre, juego.getnRondas());
					}
				}
			}

		} while (respuesta == 's');

		entrada.close();
	}

}
