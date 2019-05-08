package server;

public class ServerDirector {

	int cantidadGladiadores;
	int cantidadTorretas;
	int generacion;
	List<Gladiador> ListaActualGladiadores;
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
		ListaActualGladiadores = genCeroG;
		for ( int i = 0; i < (genCeroG.length()-2); i++) {
			generacion0Gladiadores = generacion0Gladiadores + serializarGladiador(genCeroG.getData(i))+ "," ;
		}
		generacion0Gladiadores = generacion0Gladiadores + serializarGladiador(genCeroG.getData(genCeroG.length()-1));
		String generacion0Torretas = "Generacion 0 Torretas";
		
		return generacion0Gladiadores + "-" + generacion0Torretas;
	}
	
	public String obtenerNuevaGeneracionGladiadores(String generacionG) {
		List<Gladiador> l1 = deserializarG(generacionG);
		List<Gladiador> nuevaL = cg.algoritmoGenetico(l1);
		String nueva = serializarListaG(nuevaL);
		return nueva;
	}
	
	public String obtenerNuevaGeneracionTorretas(String generacionT) {
		return "Nueva Generacion Torretas";
	}
	
	public String getstadoTorretas() {
		return "Estado Torretas";
	}
	
	public String getestadoGladiadores() {
		return cg.FitnessString(ListaActualGladiadores);
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
	public String serializarListaG(List<Gladiador> list) {
		String generacion0Gladiadores = "";
		List<Gladiador> genCeroG = list;
		for ( int i = 0; i < (genCeroG.length()-2); i++) {
			generacion0Gladiadores = generacion0Gladiadores + serializarGladiador(genCeroG.getData(i))+ "," ;
		}
		generacion0Gladiadores = generacion0Gladiadores + serializarGladiador(genCeroG.getData(genCeroG.length()-1));		
		return generacion0Gladiadores;
	}
	public List<Gladiador> deserializarG(String s){
		List<Gladiador> n = new List<Gladiador>();
		
		
		return n;
	}
	
	// SETTERS y GETTERS
	

}
