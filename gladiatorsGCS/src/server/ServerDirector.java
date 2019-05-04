package server;

public class ServerDirector {

	int cantidadGladiadores;
	int cantidadTorretas;
	int generacion;
	ControladorGladiadores cg = new ControladorGladiadores();
	ControladorTorretas ct = new ControladorTorretas();
	
	public ServerDirector() {
		this.cantidadGladiadores = 500;
		this.cantidadTorretas = 5;
		this.generacion = 0;
	}
	
	
	public String getGeneracionCero() {
		String generacion0Gladiadores = "";
		List<Gladiador> genCeroG = cg.primeraGeneracionG();
		for ( int i = 0; i < (genCeroG.length()-2); i++) {
			generacion0Gladiadores = generacion0Gladiadores + serializarGladiador(genCeroG.getData(i))+ "," ;
		}
		generacion0Gladiadores = generacion0Gladiadores + serializarGladiador(genCeroG.getData(genCeroG.length()-1));
		String generacion0Torretas = "Generacion 0 Torretas";
		
		return generacion0Gladiadores + "-" + generacion0Torretas;
	}
	
	public String obtenerNuevaGeneracionGladiadores(String generacionG) {
		//String nuevaGen = "Prueba1";
		//return nuevaGen;
		return "Nueva Generacion Gladiadores";
	}
	
	public String obtenerNuevaGeneracionTorretas(String generacionT) {
		
		return "Nueva Generacion Torretas";
	}
	
	public String getstadoTorretas() {
		return "Estado Torretas";
	}
	
	public String getestadoGladiadores() {
		return "Estado Gladiadores";
	}

	
	public String serializarGladiador(Gladiador gla) {
		String string = 
				"{\"name\": " + "\"" + gla.name + "\"" + "," +
				"\"edad\": " + Integer.toString(gla.edad) + "," +
				"\"probSupervivencia\": " + Integer.toString(gla.probSupervivencia) + "," + 
				"\"generaciones\": " + Integer.toString(gla.generaciones) + "," +
				"\"inteligenciaEmocional\": " + Integer.toString(gla.inteligenciaEmocional) + "," +
				"\"condFisica\": " + Integer.toString(gla.condFisica) + "," +
				"\"fuerzaSuperior\": " + Integer.toString(gla.fuerzaSuperior) + "," +
				"\"fuerzaInferior\": " + Integer.toString(gla.fuerzaInferior) + "," +
				"\"x\": " + Integer.toString(gla.x) + "," +
				"\"y\": " + Integer.toString(gla.y) + "}";
		return string;
	}
	public String serializarTorreta(Torreta tor) {
		String string = 
			"{\"tipo\": " + "\"" + tor.tipo + "\"" + "," +
			"\"ataque\": " + Integer.toString(tor.ataque) + "," +
			"\"alcance\": " + Integer.toString(tor.alcance) + "}";		
		return string;
	}
	
	
	// SETTERS y GETTERS
	

}
