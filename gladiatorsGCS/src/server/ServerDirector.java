package server;


public class ServerDirector {

	int cantidadGladiadores;
	int cantidadTorretas;
	int generacion;
	List<Gladiador> ListaActualGladiadores;
	List<Torreta> ListaActualTorreta;
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
		//--------------------------------------------------------
		String generacion0Torretas = "";
		List<Torreta> genCeroT = ct.primeraGeneracionT();
		ListaActualTorreta = genCeroT;
		
		for ( int i = 0; i < (genCeroG.length()-2); i++) {
			generacion0Torretas = generacion0Torretas + serializarTorreta(genCeroT.getData(i))+ "," ;
		}
		generacion0Torretas = generacion0Torretas + serializarTorreta(genCeroT.getData(genCeroT.length()-1));
		
		
		return generacion0Gladiadores + "-" + generacion0Torretas;
	}
	
	public String obtenerNuevaGeneracionGladiadores(String generacionG) {
		List<Gladiador> l1 = deserializarG(generacionG);
		List<Gladiador> nuevaL = cg.algoritmoGenetico(l1);
		ListaActualGladiadores = nuevaL;
		String nueva = serializarListaG(nuevaL);
		return nueva;
	}
	
	public String obtenerNuevaGeneracionTorretas(String generacionT) {
		List<Torreta> l1 = deserializarT(generacionT);
		List<Torreta> nuevaL = ct.algoritmoGenetico(l1);
		ListaActualTorreta = nuevaL;
		String nueva = serializarListaT(nuevaL);
		return nueva;
	}
	
	public String getstadoTorretas() {
		return ct.FitnessString(ListaActualTorreta);
	}
	public String getstadoTorretas(List<Torreta> lista) {
		return ct.FitnessString(lista);
	}
	public String getestadoGladiadores() {
		return cg.FitnessString(ListaActualGladiadores);
	}
	public String getestadoGladiadores(List<Gladiador> Lista) {
		return cg.FitnessString(Lista);
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
				"\"resistencia\": " + Integer.toString(gla.resistencia) + "," +
				"\"x\": " + Integer.toString(gla.x) + "," +
				"\"y\": " + Integer.toString(gla.y) + "}";
		return string;
	}
	public String serializarTorreta(Torreta tor) {
		String string = 
				"{\"name\": " + "\"" + tor.nombre + "\"" + "," +
				"\"generaciones\": " + Integer.toString(tor.generaciones) + "," +
				"\"danoInferior\": " + Integer.toString(tor.danoInferior) + "," + 
				"\"danoSuperior\": " + Integer.toString(tor.danoSuperior) + "," +
				"\"potencia\": " + Integer.toString(tor.potencia) + "," +
				"\"tipobala\": " + Integer.toString(tor.tipobala) + "," +
				"\"fuerzalanzador\": " + Integer.toString(tor.fuerzalanzador) + "," +
				"\"velocidadlanzador\": " + Integer.toString(tor.velocidadlanzador) + "," +
				"\"altotorre\": " + Integer.toString(tor.altotorre) + "," +
				"\"dano\": " + Integer.toString(tor.dano) + "," +
				"\"alcance\": " + Integer.toString(tor.alcance) + "}";
		return string;
	}
	public String serializarListaG(List<Gladiador> list) {
		String generacion0Gladiadores = "";
		List<Gladiador> genCeroG = list;
		for ( int i = 0; i < (genCeroG.length()-1); i++) {
			generacion0Gladiadores = generacion0Gladiadores + serializarGladiador(genCeroG.getData(i))+ ";" ;
		}
		generacion0Gladiadores = generacion0Gladiadores + serializarGladiador(genCeroG.getData(genCeroG.length()-1));		
		return generacion0Gladiadores;
	}
	public List<Gladiador> deserializarG(String s){
		List<Gladiador> n = new List<Gladiador>();
		String na = "";
		int ed = 0; int ps = 0; int ge = 0;int ie = 0;
		int cf = 0;int fs = 0;int fi = 0;int x = 0;int y = 0;
		String[] accion = s.split(";");
		int cont = 1;
		for(int i = 0; i < accion.length; i++) {
			String r = accion[i];
			String[] gladiador = r.split(",");
			for(int j = 0; j < gladiador.length;j++ ){
				String h = gladiador[j];
				String[] parte = h.split(" ");
				if (cont == 1) {
					String div1 = ( parte[1]);
					String div2 = (parte[2]);
					String[] div1name = div1.split("\"");
					String[] div2name = div2.split("\"");
					na = div1name[1] + " " + div2name[0];	
				}
				if(cont == 2) {ed =  Integer.parseInt(parte[1]);}
				if(cont == 3) {ps = Integer.parseInt(parte[1]);}
				if(cont == 4) {ge = Integer.parseInt(parte[1]);}
				if(cont == 5) {ie = Integer.parseInt(parte[1]);}
				if(cont == 6) {cf = Integer.parseInt(parte[1]);}
				if(cont == 7) {fs = Integer.parseInt(parte[1]);}
				if(cont == 8) {fi = Integer.parseInt(parte[1]);}
				if(cont == 9) {}
				if(cont == 10) {y = Integer.parseInt(parte[1]);}
				if(cont == 11) {
					String u = parte[1];
					String[] o = u.split("}");
					y = Integer.parseInt(o[0]);
				}
				cont++;
			}
			Gladiador g = new Gladiador(na,ed,ps,ge,ie,cf,fs,fi,x,y);
			n.addLast(g);
			cont = 1;
		}
		return n;
	}
	public String serializarListaT(List<Torreta> list) {
		String generacion0Torreta = "";
		List<Torreta> genCeroT = list;
		for ( int i = 0; i < (genCeroT.length()-1); i++) {
			generacion0Torreta = generacion0Torreta + serializarTorreta(genCeroT.getData(i))+ ";" ;
		}
		generacion0Torreta = generacion0Torreta + serializarTorreta(genCeroT.getData(genCeroT.length()-1));		
		return generacion0Torreta;
	}
	public List<Torreta> deserializarT(String s){
		List<Torreta> n = new List<Torreta>();
		String na = "";
		int ge = 0; int di = 0; int ds = 0;int po = 0;
		int ti = 0;int fl = 0;int vl = 0;int at = 0;
		String[] accion = s.split(";");
		int cont = 1;
		for(int i = 0; i < accion.length; i++) {
			String r = accion[i];
			String[] torreta = r.split(",");
			for(int j = 0; j < torreta.length;j++ ){
				String h = torreta[j];
				String[] parte = h.split(" ");
				if (cont == 1) {
					String div1 = ( parte[1]);
					String div2 = (parte[2]);
					String[] div1name = div1.split("\"");
					String[] div2name = div2.split("\"");
					na = div1name[1] + " " + div2name[0];	
				}
				if(cont == 2) {ge =  Integer.parseInt(parte[1]);}
				if(cont == 3) {di = Integer.parseInt(parte[1]);}
				if(cont == 4) {ds = Integer.parseInt(parte[1]);}
				if(cont == 5) {po = Integer.parseInt(parte[1]);}
				if(cont == 6) {ti = Integer.parseInt(parte[1]);}
				if(cont == 7) {fl = Integer.parseInt(parte[1]);}
				if(cont == 8) {vl = Integer.parseInt(parte[1]);}
				if(cont == 9) {
					String u = parte[1];
					String[] o = u.split("}");
					at = Integer.parseInt(o[0]);
				}
				cont++;
			}
			Torreta g = new Torreta(na,ge,di,ds,po,ti,fl,vl,at);
			n.addLast(g);
			cont = 1;
		}
		return n;
	}
	
	
	// SETTERS y GETTERS
	
}
