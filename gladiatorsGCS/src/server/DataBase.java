package server;

public final class DataBase {
	
	static List<Gladiador> ListaGladiadores;
	static List<Torreta> ListaTorreta;
	
	private static DataBase single_instance = null; 
	
	private DataBase() {
		
	}
	
	public static DataBase getInstance(){ 
        if (single_instance == null) 
            single_instance = new DataBase(); 
        return single_instance; 
    } 
	
	
	static void changeLAG(List<Gladiador> LAG) {
		ListaGladiadores = LAG;
	}
	static void changeLAT(List<Torreta> LAT) {
		ListaTorreta = LAT;
	}
	
	static List<Gladiador> getLAG() {
		return ListaGladiadores;
	}
	static List<Torreta> getLAT() {
		return ListaTorreta;
	}
	
	
}
