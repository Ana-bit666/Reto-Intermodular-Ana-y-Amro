package clases;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Puntuacion {

	private static final String ARCHIVO = "mejorPuntuacion.txt";
	
	public static void mostrarPuntuacion() {
		File fichero = new File(ARCHIVO);
		if(fichero.exists()) {
			try(Scanner entrada = new Scanner(fichero)) {
				String nombre = entrada.nextLine();
				int rondas = entrada.nextInt();
				System.out.println("Mejor puntuación: " + nombre + " con " + rondas + " rondas.");
			} catch(Exception e) {
				System.out.println("Error al leer la mejor puntuación.");
			} finally {
				
			}
		}
	}
	
	public static int obtenerRondasMaximas() {
		File fichero = new File(ARCHIVO);
		if(fichero.exists()) {
			try(Scanner entrada = new Scanner(fichero)){
				entrada.nextLine();
				return entrada.nextInt();
			}catch(Exception e) {
				return 0;
			}
		}
		return 0;
	}
	
	public static void guardarPuntuacion(String nombre, int rondas) {
		try(FileWriter fw = new FileWriter(ARCHIVO)){
			fw.write(nombre + "\n" + rondas);
		}catch(IOException e) {
			System.out.println("Error al guardar la puntuación.");
		}
	}
}
