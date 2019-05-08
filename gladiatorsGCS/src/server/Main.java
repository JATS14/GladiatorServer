package server;

import java.io.IOException;
public class Main {

	public static void main(String[] args) throws IOException {
		
		ServerDirector sd = new ServerDirector();
		System.out.println(sd.getGeneracionCero());
		
		System.out.println("\n");
		
		List<Gladiador> l1 = sd.cg.primeraGeneracionG();
		System.out.println("Generacion antes de genetico");
		System.out.println(l1.length());
		System.out.println(sd.serializarListaG(l1));
		sd.cg.printFitness(l1);
		
		l1 = sd.cg.algoritmoGenetico(l1);
		System.out.println("Generacion despues de genetico");
		System.out.println(sd.serializarListaG(l1));
		sd.cg.printFitness(l1);
	}

}
//Cuando viene un String, solo hay que pasarlo en la clase de utils