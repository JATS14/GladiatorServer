package server;

import java.io.IOException;

import org.json.*;

public class Main {

	public static void main(String[] args) throws IOException {
		JSONObject obj = JSONUtils.getJSONObjectFromFile("Gladiador.json");
		String[] names = JSONObject.getNames(obj);
		for(String string : names) {
			System.out.println(string + ": " + obj.get(string));
			}
		System.out.println("\n");
		
		//Sirve para solo revisar datos especificos
		//En este caso son los datos de un array
		
		ServerDirector a = new ServerDirector();
		System.out.println(a.getGeneracionCero());
		
		String entrada = "NGG {Nombre: jis,Vida: 1,fuerza: 10,x: 0,y: 0}";
		String[] accion = entrada.split(" ");
		String r = "";
		for(int i = 1; i < accion.length; i++) {
			r = r + accion[i];
		}
		System.out.println(r);
		System.out.println("\n");
		JSONObject obj2 = JSONUtils.getJSONObjectFromJSON(r);
		String[] nombres = JSONObject.getNames(obj2);
		for(String string2 : nombres) {
			System.out.println(string2 + ": " + obj2.get(string2));
		}
		
		ServerDirector sd = new ServerDirector();
		Gladiador gla = new Gladiador("hola",1,2,3,4,5,6,7,8,9);
		sd.serializarGladiador(gla);
		
		Torreta tor = new Torreta("Fuego" , 2 , 7);
		sd.serializarTorreta(tor);
		
		System.out.println(sd.getGeneracionCero());
		
	}

}
//Cuando viene un String, solo hay que pasarlo en la clase de utils